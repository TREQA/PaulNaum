package PageObjects;

import AutomationFramework.Date;
import AutomationFramework.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class cceSTPPage extends BasePage {
    public cceSTPPage(WebDriver passedDriver) {
        super(passedDriver);
    }

    public By adminBtn = By.cssSelector("#topnav > li:nth-of-type(8) > a.head > span");
    public By masterTab = By.cssSelector("#topnav > li:nth-of-type(8) > div.sub > div.row > ul > li:nth-of-type(3) > a");
    public By stpTab = By.cssSelector("div > div:nth-of-type(3) > ul > li:nth-of-type(3) > a");
    public By editBtn = By.cssSelector("tbody > tr:nth-of-type(2) > td.actions > a:nth-of-type(1) > span.btn-edit");
    public By stpStatusOn = By.xpath("//SPAN[@class='icon-status-1']/self::SPAN");
    public By stpStatusOff = By.xpath("//SPAN[@class='icon-status-2']/self::SPAN");
    public By searchField = By.xpath("//*[@id=\"filterShipToPartyName\"]");

    public static WebElement stpStatus (WebDriver driver){
        return driver.findElement(By.cssSelector("tbody > tr:nth-of-type(2) > td:nth-of-type(10) > span"));
    }



    public void searchCustomerSTP(WebDriver driver){
        Wait.clickable(driver, searchField);
        driver.findElement(searchField).click();
        driver.findElement(searchField).sendKeys(Date.CustomerSTP);
        driver.findElement(searchField).sendKeys(Keys.ENTER);
    }

    public void navigateSTP(WebDriver driver) {
        Wait.clickable(driver, adminBtn);
        driver.findElement(adminBtn).click();
        driver.findElement(masterTab).click();
        driver.findElement(stpTab).click();
    }

    public void editSTP(WebDriver driver) {
        Wait.clickable(driver, editBtn).click();
    }



}
