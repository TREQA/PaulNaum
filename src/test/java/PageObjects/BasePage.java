package PageObjects;

import AutomationFramework.Date;
import AutomationFramework.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
   //setSearchField
   protected WebDriver driver;

   public BasePage(WebDriver passedDriver){
       driver = passedDriver;}

@FindBy
   static By btnLogout = By.cssSelector("span.logout > a");
   static By orderTab = By.cssSelector("#topnav > li:nth-of-type(1) > a.head");
   public static By orderManualEntry = By.cssSelector("#topnav > li:nth-of-type(1) > div.sub > div.row > ul > li:nth-of-type(1) > a");
   static By changeSite = By.id("access_type");

   public void ChangeSite(){
      Wait.clickable(driver, changeSite).click();
   }

   public void goToSubmenu(String mainMenuName,String subMenuName){
      int nrOfMenus = driver.findElements(By.cssSelector("#topnav > li")).size();
      // System.out.println(nrOfMenus + " menus found");

      for(int i=1; i<=nrOfMenus; i++){
         By mainMenu = By.cssSelector("#topnav > li:nth-child(" + i + ")");
         String menuText = driver.findElement(mainMenu).getText().trim();
         // System.out.println(menuText + " menu found.");

         if(menuText.equals(mainMenuName)){
            WebElement waitForMenu = new WebDriverWait(driver, Date.shortWait).until(ExpectedConditions.elementToBeClickable(mainMenu));
            Actions action = new Actions(driver);
            action.moveToElement(driver.findElement(mainMenu)).build().perform();
            // System.out.println(mainMenuName + " hovered");

            clickSubmenu(i,subMenuName);
            break;
         }
      }
   }


   public void clickSubmenu(int i,String subMenuName){
      int nrOfSubMenus = driver.findElements(By.cssSelector("#topnav > li:nth-child(" + i + ") > div > div > ul > li")).size();
      //System.out.println(nrOfSubMenus + " submenus found");

      for(int j=1; j<=nrOfSubMenus;j++){
         By subMenu = By.cssSelector("#topnav > li:nth-child(" + i + ") > div > div > ul > li:nth-child(" + j + ")");
         WebElement waitForSubMenuText = new WebDriverWait(driver,Date.shortWait).until(ExpectedConditions.elementToBeClickable(subMenu));
         String subMenuText = driver.findElement(subMenu).getText().trim();
         //  System.out.println(subMenuText + " submenu found.");

         if(subMenuText.equals(subMenuName)){
            driver.findElement(subMenu).click();
            //  System.out.println(subMenuName + " clicked");
            break;
         }
      }
   }


}
