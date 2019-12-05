package Utils;

import com.thoughtworks.gauge.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.io.File;
import java.io.IOException;

public class Driver {
     public static WebDriver driver;
     public static EventFiringWebDriver edriver;
     public static WebEventListener eventlistener;
     @BeforeScenario()
     public static void initializedriver()
     {
      if(driver==null)
      {
          driver=DriverFactory.getDriver();
          edriver=new EventFiringWebDriver(driver);
          eventlistener=new WebEventListener();
          edriver.register(eventlistener);
          driver=edriver;
          driver.manage().window().maximize();
          driver.manage().deleteAllCookies();
          System.out.println("Before Scenario--------------");
      }
     }

     @AfterScenario()
    public static void closeDriver(){
      DriverFactory.closeDriver(driver);
         System.out.println("After Scenario--------------");
      driver=null;
     }

     @AfterSuite()
     public static void quitDriver(){
      DriverFactory.quitDriver(driver);
         System.out.println("After Suite--------------");
     }

     @AfterStep()
    public void screenshot(ExecutionContext context)
     {
         try
         {
         if(context.getCurrentStep().getIsFailing() | System.getenv("screenshot_for_all").equalsIgnoreCase("true")) {
             Thread.sleep(3000);
             Takesnapshot(String.valueOf(System.currentTimeMillis()));
         }
         }
         catch (Exception e)
         {
             e.printStackTrace();
         }
     }

     public void Takesnapshot(String PicName)
     {
         try {
            String fileName="images/"+PicName+".png";
            File file=new File(System.getenv("gauge_reports_dir")+"/html-report/"+fileName);
         if(file.exists())
         {
             file.delete();
         }
             File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
             FileUtils.copyFile(srcFile,file);
             Gauge.writeMessage("<a href='../"+fileName+"'><img src='../"+fileName+"'width='800' height='480'></a>");
         }
         catch (IOException e)
         {
             e.printStackTrace();
         }
     }
}
