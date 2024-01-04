package web.WebTests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import web.WebUtilities.WebUtilities;
import web.pageObjects.WebFunctions;

public class OrangeHrmTests {

    WebUtilities webUtilities = new WebUtilities();
    WebFunctions functions = new WebFunctions();

    String sUrl, sBrowser;

    @BeforeClass
    @Parameters({"orangeUrl", "Browser"})
    public void init(String orangeUrl, String Browser){

        sUrl = orangeUrl;
        sBrowser = Browser;

        webUtilities.setWebDriver(webUtilities.initializeWebDriver(sBrowser));
    }

    @Test
    public void runTests(){

        try{
            webUtilities.navigate(sUrl);

            functions.logIn(webUtilities.getWebDriver(), "Admin", "admin123");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @AfterClass
    public void tearDown(){
        try{
            Thread.sleep(5000);
            webUtilities.getWebDriver().close();
            webUtilities.getWebDriver().quit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
