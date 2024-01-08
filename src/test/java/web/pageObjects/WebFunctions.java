package web.pageObjects;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import web.WebUtilities.WebActions;
import web.reports.ExtentReport;
import web.webPageObjects.AddEmployeePage;
import web.webPageObjects.LoginPage;
import web.webPageObjects.LogoutPage;
import web.webPageObjects.PersonalInformationManagementPage;

import java.time.Duration;

public class WebFunctions extends WebActions {

    ExtentReport report = new ExtentReport();

    public void logIn(WebDriver driver, String Username, String Password, ExtentTest node){

        LoginPage loginPage = new LoginPage(driver);

        try{
            passData(loginPage.username, driver, Username);
            passData(loginPage.password, driver, Password);
            clickObjects(loginPage.loginBtn, driver);

            Thread.sleep(3000);

            String filename = report.CaptureScreenShot(driver);

            //Validation
            if (loginPage.dashboard.isDisplayed()) {
                node.pass("Login was Successful", MediaEntityBuilder.createScreenCaptureFromBase64String(filename).build());
            } else {
                node.fail("Login was Unsuccessful", MediaEntityBuilder.createScreenCaptureFromBase64String(filename).build());
                Assert.fail("Login was Unsuccessful");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void personalInformationManagement(WebDriver driver){

        PersonalInformationManagementPage personalInformationManagementPage = new PersonalInformationManagementPage(driver);

        try{
            clickObjects(personalInformationManagementPage.PIM, driver);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void addEmployee(WebDriver driver, String Firstname,String MiddleName, String Lastname, String Username, String  Password, String ConfirmPassword){
        AddEmployeePage addEmployeePage = new AddEmployeePage(driver);

        try{
            clickObjects(addEmployeePage.addBtn, driver);
            passData(addEmployeePage.firstName, driver, Firstname);
            passData(addEmployeePage.middleName, driver, MiddleName);
            passData(addEmployeePage.lastName, driver, Lastname);
            Thread.sleep(1000);

            clickObjects(addEmployeePage.createLoginDetails, driver);
            passData(addEmployeePage.username, driver, Username);
            passData(addEmployeePage.password, driver, Password);
            passData(addEmployeePage.confirmPassword, driver, ConfirmPassword);
            clickObjects(addEmployeePage.saveBtn, driver);

            Thread.sleep(4000);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void logOut(WebDriver driver){
        LogoutPage logoutPage = new LogoutPage(driver);

        try{
            clickObjects(logoutPage.dropdown, driver);
            clickObjects(logoutPage.logoutBtn, driver);
            Thread.sleep(3000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
