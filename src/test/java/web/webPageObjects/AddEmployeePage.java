package web.webPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class AddEmployeePage {

    protected WebDriver driver;

    public AddEmployeePage(WebDriver driver){

        this.driver = driver;

        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath = "//button[contains(., 'Add')]\n")
    public WebElement addBtn;

    @FindBy(xpath = "//input[@name='firstName']\n")
    public WebElement firstName;

    @FindBy(xpath = "//input[@name='middleName']\n")
    public WebElement middleName;

    @FindBy(xpath = "//input[@name='lastName']\n")
    public WebElement lastName;

    @FindBy(xpath = "//button[normalize-space() = 'Save']\n")
    public WebElement saveBtn;

    @FindBy(xpath = "//span[@class='oxd-switch-input oxd-switch-input--active --label-right'][@data-v-8e4757dc='']\n")
    public WebElement createLoginDetails;

    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'][@autocomplete='off'][@data-v-1f99f73c=''])[1]\n")
    public WebElement username;

    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'][@type='password'][@autocomplete='off'][@data-v-1f99f73c=''])[1]\n")
    public WebElement password;

    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'][@type='password'][@autocomplete='off'][@data-v-1f99f73c=''])[2]\n")
    public WebElement confirmPassword;



    //validation
    @FindBy(xpath = "")
    public WebElement d;
}
