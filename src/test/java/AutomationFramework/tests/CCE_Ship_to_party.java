package AutomationFramework.tests;

import AutomationFramework.Date;
import PageObjects.*;
import config.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import util.DriverBase;

public class CCE_Ship_to_party {

    @Test
    public void STPFlagDisable() throws InterruptedException {
        WebDriver driver = DriverBase.getDriver();

        driver.get(Date.URL);
        driver.manage().window().maximize();

        System.out.println("Logging in ...");
        LogInPage lip = new LogInPage(driver);
        lip.loginCoats(Date.userName, Date.userPass);


        System.out.println("Logged in, going to CCE...");
        lip.navigateCce();

        cceSTPPage stp = new cceSTPPage(driver);
        stp.navigateSTP(driver);
        System.out.println("Navigating to Ship To Party...");
        stp.searchCustomerSTP(driver);
        System.out.println("Searching Customer's Ship to Party");
        stp.editSTP(driver);
        cceEditSTPPage estp = new cceEditSTPPage(driver);
        estp.disableSTP(driver);
        stp.searchCustomerSTP(driver);
        AssertJUnit.assertEquals("icon-status-2", stp.stpStatus(driver).getAttribute("class"));
        System.out.println("Flag disabled.");
    }



    @Test
    public void STPFlagEnable()  {
        WebDriver driver = DriverBase.getDriver();
//        try {
//            driver = new DriverFactory().getDriver();
//        } catch (Exception e) {
//            e.printStackTrace();
//            driver = new ChromeDriver();
//        }

        driver.get(Date.URL);
        driver.manage().window().maximize();

        System.out.println("Logging in ...");
        LogInPage lip = new LogInPage(driver);
        lip.loginCoats(Date.userName, Date.userPass);

        System.out.println("Logged in, going to CCE...");
        lip.navigateCce();

        cceSTPPage stp = new cceSTPPage(driver);
        stp.navigateSTP(driver);
        System.out.println("Navigating to Ship To Party...");
        stp.searchCustomerSTP(driver);
        System.out.println("Searching Customer's Ship to Party");
        stp.editSTP(driver);
        cceEditSTPPage estp = new cceEditSTPPage(driver);
        estp.enableSTP(driver);
        stp.searchCustomerSTP(driver);
        AssertJUnit.assertEquals("icon-status-1", stp.stpStatus(driver).getAttribute("class"));
        System.out.println("Flag enabled.");
        driver.quit();
    }

    @Test
    public void STPDisabledFlagOrder() {
        WebDriver driver = DriverBase.getDriver();
//        try {
//            driver = new DriverFactory().getDriver();
//        } catch (Exception e) {
//            e.printStackTrace();
//            driver = new ChromeDriver();
//        }
        driver.get(Date.URL);
        driver.manage().window().maximize();

        System.out.println("Logging in...");
        LogInPage lip = new LogInPage(driver);
        lip.loginCoats(Date.userName, Date.userPass);

        System.out.println("Logged in, going to CCE...");
        lip.navigateCce();

        cceSTPPage stp = new cceSTPPage(driver);
        stp.navigateSTP(driver);
        System.out.println("Navigating to Ship To Party...");
        stp.searchCustomerSTP(driver);
        System.out.println("Searching Customer's Ship to Party");
        stp.editSTP(driver);
        cceEditSTPPage estp = new cceEditSTPPage(driver);
        estp.disableSTP(driver);

        System.out.println("Navigating to eComm...");
        BasePage bp = new BasePage(driver);
        bp.ChangeSite();

        System.out.println("Going to Manual Entry page...");
        ManualEntryPage mep = new ManualEntryPage(driver);
        mep.navManualEntry();
        mep.setProfileDisabledSTPDetails();
        System.out.println("Entering details...");
        AssertJUnit.assertEquals( false, mep.checkSTP(ManualEntryPage.mShipToParty));
        System.out.println("Wanted ship to party not found, as expected.");
        driver.quit();
    }


}

