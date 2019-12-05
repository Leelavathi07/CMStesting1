package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {
    public static WebDriver getDriver(){
    String browser=System.getenv("BROWSER");
    String IEdriverpath=System.getenv("IEDRIVERPATH");
    String chromedriverpath=System.getenv("CHROMEDRIVERPATH");
    String edgedriverpath=System.getenv("EDGEDRIVERPATH");
    switch (browser)
    {
        case "ie":
           System.setProperty("webdriver.ie.driver",IEdriverpath);
           return new InternetExplorerDriver();
        case "chrome":
            System.setProperty("webdriver.chrome.driver",chromedriverpath);
            return new ChromeDriver();
        case "edge":
            System.setProperty("webdriver.edge.driver",edgedriverpath);
            return new EdgeDriver();
    }
    return null;
    }

    public static void closeDriver(WebDriver driver)
    {
        if(driver!=null)
        {
            driver.close();
        }
    }

    public static void quitDriver(WebDriver driver)
    {
        if(driver!=null)
        {
            driver.quit();
        }
    }
}
