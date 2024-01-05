package web.webPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LogoutPage {

    protected WebDriver driver;

    public LogoutPage(WebDriver driver){

        this.driver = driver;

        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath = "//p[@class='oxd-userdropdown-name' and @data-v-bdd6d943='']\n")
    public WebElement dropdown;

    @FindBy(xpath = "//a[contains(text(), 'Logout')]")
    public WebElement logoutBtn;

}
