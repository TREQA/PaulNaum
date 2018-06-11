package AutomationFramework.tests;

import config.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import util.DriverBase;

public class BaseTest {

    @DataProvider(parallel = true, name = "provideDrivers")
    public Object[][] provideDrivers() {
        return new Object[][]{
                {DriverBase.getDriver(DriverType.CHROME)},
                {DriverBase.getDriver(DriverType.FIREFOX)}
        };
    }


    @AfterMethod(alwaysRun = true)
    public void destroyBrowser(ITestResult testResult) {
        Object[] params = testResult.getParameters();
        for (Object param : params) {
            if (param instanceof WebDriver) {
                ((WebDriver) param).quit();
            }
        }
    }


}
