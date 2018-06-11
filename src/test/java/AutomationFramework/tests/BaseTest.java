package AutomationFramework.tests;

import config.DriverType;
import org.testng.IMethodInstance;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.IParameterizable;
import util.DriverBase;

import java.lang.reflect.Method;

public class BaseTest {

    @DataProvider(parallel = true, name = "provideDrivers")
    public Object[][] provideDrivers() {
        return new Object[][]{
                {DriverBase.getDriver(DriverType.CHROME)},
                {DriverBase.getDriver(DriverType.FIREFOX)}
        };
    }

    @AfterSuite(alwaysRun = true)
    public static void closeDrivers(){
        DriverBase.closeDriverObjects();
    }
}
