package web.WebUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class WebActions {


    public void clickObjects(WebElement element, WebDriver driver){

        try{
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(5000))
                    .pollingEvery(Duration.ofMillis(1000))
                    .ignoring(WebDriverException.class);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();

        } catch (Exception e) {
            System.out.println("Not Found " + " " + e.getMessage());
        }
    }

    public void passData(WebElement element, WebDriver driver, String passValue){

        try{
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(5000))
                    .pollingEvery(Duration.ofMillis(1000))
                    .ignoring(WebDriverException.class);
            wait.until(ExpectedConditions.elementToBeClickable(element));

            element.clear();
            element.sendKeys(passValue);

        } catch (Exception e) {
            System.out.println("Not Found " + " " + e.getMessage());
        }
    }

    public void selectObjects(WebElement element, WebDriver driver, String selectMethod, Object passValue){

        Select select = new Select(element);

        try{
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(5000))
                    .pollingEvery(Duration.ofMillis(1000))
                    .ignoring(WebDriverException.class);
            wait.until(ExpectedConditions.elementToBeClickable(element));


            switch (selectMethod.toUpperCase()){

                case "SELECTBYVISIBLETEXT":
                    select.selectByVisibleText((String) passValue);
                    break;

                case "SELECTBYVALUE":
                    select.selectByValue((String) passValue);
                    break;

                case "SELECTBYINDEX":
                    select.selectByIndex((Integer) passValue);
                    break;
            }

        } catch (Exception e) {
            System.out.println("Not Found " + " " + e.getMessage());
        }
    }
}
