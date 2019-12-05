package Utils;

import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class CommonUtils extends Driver {
    public void clickelement(WebElement element)
    {
        try
        {
          new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(element));
          element.click();
        }
        catch (WebDriverException e)
        {
            new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(element));
            element.click();
        }
    }

    public void clickinvisibleelement(WebElement element)
    {
            ((JavascriptExecutor)driver).executeScript("arguments[0].click",element);
    }
    public void pause(Integer sleepduration)
    {
        try
        {
            TimeUnit.MILLISECONDS.sleep(sleepduration);
        }
    catch (InterruptedException e)
    {
        e.printStackTrace();
    }
    }

    public static Map convertChildtableToMap(Table table)
    {
        System.out.println("Single row");
        Map<String,Object> tableAsmap=new HashMap<>();
        for (TableRow row:table.getTableRows()){
            for(String Col:table.getColumnNames()){
                tableAsmap.put(Col,row.getCell(Col));
            }
        }
        return tableAsmap;
    }

    public static Map converTabletoMap(Table table)
    {
        System.out.println("Multiple rows");
        Map<String,Object> tableAsmap=new HashMap<>();
        for (TableRow row:table.getTableRows()){
            tableAsmap.put(row.getCell("Key"),row.getCell("Value"));
        }
        return tableAsmap;
    }
}
