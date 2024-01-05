package web.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import web.WebUtilities.WebActions;
import web.webPageObjects.AddEmployeePage;
import web.webPageObjects.LoginPage;
import web.webPageObjects.LogoutPage;
import web.webPageObjects.PersonalInformationManagementPage;

import java.time.Duration;

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

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement confirmPwdField = wait.until(ExpectedConditions.visibilityOf(addEmployeePage.confirmPassword));
            passData(confirmPwdField, driver, ConfirmPassword);


            //passData(addEmployeePage.confirmPassword, driver, ConfirmPassword);
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
