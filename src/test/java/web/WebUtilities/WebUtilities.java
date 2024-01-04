package web.WebUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebUtilities {

    protected WebDriver driver;

    public WebDriver getWebDriver(){return driver;}

    public void setWebDriver(WebDriver DriverTest){this.driver = DriverTest;}

    public WebDriver initializeWebDriver(String sBrowser){

        switch (sBrowser.toUpperCase()){

            case "CHROME":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "MICROSOFTEDGE":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;

            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
        }

        driver.manage().window().maximize();
        return driver;
    }

    public void navigate(String sUrl) throws InterruptedException {

        Thread.sleep(2000);
        driver.get(sUrl);
    }
}
