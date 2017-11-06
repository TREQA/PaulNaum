package AutomationFramework.tests;

import AutomationFramework.Date;
import PageObjects.BasePage;
import PageObjects.LogInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;


public class LogIn {

    @Test
    public void LogInTest() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get(Date.URL);
        driver.manage().window().maximize();
        AssertJUnit.assertEquals("Coats Colour Express", driver.getTitle());
        System.out.println("Reached" + driver.getTitle());

        System.out.println("Logging in...");
        LogInPage lip = new LogInPage(driver);
        lip.loginCoats(Date.userName,Date.userPass);
        System.out.println("Navigating eComm...");
        lip.navigateEcomm();
        AssertJUnit.assertTrue(LogInPage.getHomePageTitle().isDisplayed());
        System.out.println("eComm reached.");

        System.out.println("Logging off..");
        lip.logoutCoats();
        driver.quit();

    }
}
