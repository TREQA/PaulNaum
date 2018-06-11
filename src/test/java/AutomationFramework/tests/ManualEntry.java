package AutomationFramework.tests;

import AutomationFramework.Date;
import PageObjects.BasePage;
import PageObjects.ConfirmPage;
import PageObjects.LogInPage;
import PageObjects.ManualEntryPage;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;


public class ManualEntry extends BaseTest {

    @Test(dataProvider = "provideDrivers")
    public void ManualEntryTest(WebDriver driver) throws InterruptedException {

        driver.get(Date.URL);
        driver.manage().window().maximize();

        System.out.println("Log in as admin...");
        LogInPage lip = new LogInPage(driver);
        lip.loginCoats(Date.userName, Date.userPass);

        System.out.println("Logged in. Navigating to eComm...");
        lip.navigateEcomm();

        System.out.println("Going to manual entry...");
        BasePage bp = new BasePage(driver);
        bp.goToSubmenu("Orders", "Manual Entry");
        ManualEntryPage mep = new ManualEntryPage(driver);
        System.out.println("Manual entry reached, entering details.");
        mep.setProfileDetails();
        mep.setCommandDetails();
        mep.pressNext();

        System.out.println("Checking product information!");

        AssertJUnit.assertTrue(ConfirmPage.cPageTitle(driver).isDisplayed());
        AssertJUnit.assertEquals(Date.Customer, ConfirmPage.cCustomerName(driver).getText());
        System.out.println("Actual Value: [Customer] - " + ConfirmPage.cCustomerName(driver).getText());
        AssertJUnit.assertEquals(Date.Requestor, ConfirmPage.cCustomerRequestor(driver).getText());
        System.out.println("Actual Value: [Requestor] - " + ConfirmPage.cCustomerRequestor(driver).getText());
        AssertJUnit.assertEquals(Date.CustomerPO, ConfirmPage.cCustomerPO(driver).getAttribute("value"));
        System.out.println("Actual Value: [Customer Po] - " + ConfirmPage.cCustomerPO(driver).getAttribute("value"));
        AssertJUnit.assertEquals(Date.Article + "-" + Date.Shade, ConfirmPage.cCommandArticle(driver).getText());
        System.out.println("Actual Value: [Article + Shade] - " + ConfirmPage.cCommandArticle(driver).getText());
        AssertJUnit.assertEquals(Date.Qty, ConfirmPage.cCommandQty(driver).getText());
        System.out.println("Actual Value: [Quantity] - " + ConfirmPage.cCommandQty(driver).getText());
        driver.quit();


    }
}