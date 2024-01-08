package web.WebTests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.github.javafaker.Faker;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import web.WebUtilities.PersonalInfo;
import web.WebUtilities.WebUtilities;
import web.pageObjects.WebFunctions;
import web.reports.ExtentReport;

public class OrangeHrmTests {

    WebUtilities webUtilities = new WebUtilities();
    WebFunctions functions = new WebFunctions();
    PersonalInfo personalInfo = new PersonalInfo();
    Faker faker;
    ExtentReport report = new ExtentReport();
    ExtentReports reports = new ExtentReports();

    String sUrl, sBrowser;

    @BeforeClass
    @Parameters({"orangeUrl", "Browser"})
    public void init(String orangeUrl, String Browser){

        sUrl = orangeUrl;
        sBrowser = Browser;

        webUtilities.setWebDriver(webUtilities.initializeWebDriver(sBrowser));
        reports = report.initilizeExtentReporters("src/reports/report.html");

        //setup faker data
        faker = new Faker();

        personalInfo.setFirstName(faker.name().firstName());
        personalInfo.setMiddleName(faker.name().firstName());
        personalInfo.setLastName(faker.name().lastName());
        personalInfo.setUsername(faker.name().username());
        personalInfo.setPassword(faker.internet().password());


    }

    @Test
    public void runTests(){

        ExtentTest test = reports.createTest("OrangeHumanResourceManagement").assignAuthor("Tshifhiwa");
        ExtentTest node = test.createNode("Test Cases");

        try{
            webUtilities.navigate(sUrl);

            functions.logIn(webUtilities.getWebDriver(),
                    personalInfo.getCredentialUsername(),
                    personalInfo.getCredentialPassword(),
                    node);
            functions.personalInformationManagement(webUtilities.getWebDriver());
            functions.addEmployee(webUtilities.getWebDriver(),
                    personalInfo.getFirstName(),
                    personalInfo.getMiddleName(),
                    personalInfo.getLastName(),
                    personalInfo.getUsername(),
                    personalInfo.getPassword(),
                    personalInfo.getConfirmPassword());
            functions.logOut(webUtilities.getWebDriver());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @AfterClass
    public void tearDown(){
        try{
            Thread.sleep(5000);
            reports.flush();
            webUtilities.getWebDriver().close();
            webUtilities.getWebDriver().quit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
