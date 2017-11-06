package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConfirmPage extends BasePage{

    public ConfirmPage(WebDriver passedDriver){
        super(passedDriver);
    }
    public static WebElement cCustomerName(WebDriver driver){
        return driver.findElement(By.xpath("//LABEL[@for='BulkOrderCustomerName'][text()='Customer Name']/../..//TD[1]"));
    }

    public static WebElement cCustomerPO (WebDriver driver){
        return driver.findElement(By.id("po_number_0"));
    }

    public static WebElement cCustomerRequestor (WebDriver driver){
        return driver.findElement(By.xpath("//*[@id='requester_id_0']/option[@selected='selected']"));
    }

    public static WebElement cCustomerShipToParty (WebDriver driver){
        return driver.findElement(By.id("ship_to_party_id"));
    }

    public static WebElement cCommandArticle (WebDriver driver){
        return driver.findElement(By.cssSelector("#remove_0 > td:nth-child(5)"));
    }

    public static WebElement cCommandArticle (WebDriver driver,int line){
        return driver.findElement(By.cssSelector("#remove_" + ( line-1 ) + " > td:nth-child(5)"));
    }

    public static WebElement cCommandQty (WebDriver driver){
        return driver.findElement(By.cssSelector("#remove_0 > td:nth-child(11) > div"));
    }

    public static WebElement cCommandDate (WebDriver driver){
        return driver.findElement(By.cssSelector("#remove_0 > td:nth-child(12) > div > p"));
    }
    public static WebElement cPageTitle(WebDriver driver){
        return driver.findElement(By.cssSelector("#content > div > h1 > label"));
    }
}
