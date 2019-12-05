package pages;

import Utils.CommonUtils;
import Utils.Driver;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public class Homepage extends Driver {
CommonUtils commonUtils=new CommonUtils();
    @FindBy(xpath = "//div[@class='login-block-text login-signup-block']")
    WebElement signup;
    @FindBy(xpath="//button[@id='loginJoinButton']")
    WebElement createnewAccount;
    @FindBy(xpath = "//span[text()='Title']")
    WebElement title;
    @FindBy(xpath = "//input[@name='firstName']")
    WebElement FirstName;
    @FindBy(xpath = "//input[@name='emailAddress']")
    WebElement email;
    @FindBy(xpath = "//input[@name='lastName']")
    WebElement LastName;
public Homepage()
{
    PageFactory.initElements(this.driver,this);
}
public void openurl(String url)
{
    driver.get(url);
    Assert.assertTrue(driver.getTitle().contains("Book Flights"));
    Takesnapshot("pic1");
}

public void signup(Map<String , String> logindetails,String Lastname)
{
    commonUtils.clickelement(signup);
    commonUtils.clickelement(createnewAccount);
    ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,2000)");
    commonUtils.pause(1500);
    FirstName.sendKeys(logindetails.get("FirstName"));
    commonUtils.pause(2000);
    email.sendKeys(logindetails.get("Email"));
    commonUtils.pause(2000);
    LastName.sendKeys(Lastname);
    commonUtils.pause(2000);
}
}
