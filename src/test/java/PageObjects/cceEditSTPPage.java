package PageObjects;

import AutomationFramework.Date;
import AutomationFramework.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public class cceEditSTPPage extends BasePage{

    public cceEditSTPPage(WebDriver passedDriver) {
        super(passedDriver);
    }
    By statusOn = By.xpath("//*[@id=\"ShipToPartyStatusId1\"]");
    By statusOff = By.xpath("//*[@id=\"ShipToPartyStatusId2\"]");
    By save = By.xpath("//*[@id=\"ShipToPartyEditForm\"]/div[3]/ul/li[1]/input");

    public void disableSTP(WebDriver driver){
        driver.findElement(statusOff).click();
        driver.findElement(save).click();
    }

    public void enableSTP(WebDriver driver){
        driver.findElement(statusOn).click();
        driver.findElement(save).click();
    }



}
