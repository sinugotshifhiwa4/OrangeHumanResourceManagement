package web.webPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PersonalInformationManagementPage {

    protected WebDriver driver;

    public PersonalInformationManagementPage(WebDriver driver){

        this.driver = driver;

        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name' and text()='PIM']\n")
    public WebElement PIM;



    //validation
    @FindBy(xpath = "")
    public WebElement d;
}
