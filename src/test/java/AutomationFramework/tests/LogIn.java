package AutomationFramework.tests;

import AutomationFramework.Date;
import AutomationFramework.Wait;
import PageObjects.BasePage;
import PageObjects.LogInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import util.DriverBase;


public class LogIn extends BaseTest {

    @Test(dataProvider = "provideDrivers")
    public void logInTest(WebDriver driver) throws InterruptedException {

        driver.get(Date.URL);
        driver.manage().window().maximize();
        AssertJUnit.assertEquals("Coats Colour Express", driver.getTitle());
        System.out.println("Reached" + driver.getTitle());

        System.out.println("Logging in...");
        LogInPage lip = new LogInPage(driver);
        lip.loginCoats(Date.userName, Date.userPass);
        System.out.println("Navigating eComm...");
        lip.navigateEcomm();
        AssertJUnit.assertTrue(lip.getHomePageTitle().isDisplayed());
        System.out.println("eComm reached.");

        System.out.println("Logging off..");
        lip.logoutCoats();

    }
}
