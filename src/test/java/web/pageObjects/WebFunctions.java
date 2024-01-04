package web.pageObjects;

import org.openqa.selenium.WebDriver;
import web.WebUtilities.WebActions;
import web.webPageObjects.LoginPage;

public class WebFunctions extends WebActions {


    public void logIn(WebDriver driver, String Username, String Password){

        LoginPage loginPage = new LoginPage(driver);

        try{
            passData(loginPage.username, driver, Username);
            passData(loginPage.password, driver, Password);
            clickObjects(loginPage.loginBtn, driver);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
