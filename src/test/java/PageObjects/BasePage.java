package PageObjects;

import AutomationFramework.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
   //setSearchField
   protected static WebDriver driver;

   public BasePage(WebDriver passedDriver){this.driver = passedDriver;}

@FindBy
   static By btnLogout = By.cssSelector("span.logout > a");
   static By orderTab = By.cssSelector("#topnav > li:nth-of-type(1) > a.head");
   static By orderManualEntry = By.cssSelector("#topnav > li:nth-of-type(1) > div.sub > div.row > ul > li:nth-of-type(1) > a");
   static By changeSite = By.id("access_type");

   public void ChangeSite(){
      Wait.clickable(driver, changeSite).click();
   }



}
