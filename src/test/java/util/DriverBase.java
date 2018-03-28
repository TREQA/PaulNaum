package util;

import config.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DriverBase {

    private static List<WebDriver> webDriverPool = Collections.synchronizedList(new ArrayList<WebDriver>());
    private ThreadLocal<DriverFactory> driverFactory;

//    @BeforeMethod
//    public void instantiateDriverObject() {
//        driverFactory = new ThreadLocal<DriverFactory>() {
//            @Override
//            protected DriverFactory initialValue() {
//                DriverFactory driverFactory = new DriverFactory();
//                webDriverThreadPool.add(driverFactory);
//                return driverFactory;
//            }
//        };
//    }

    public static WebDriver getDriver()  {
        DriverFactory driverFactory = new DriverFactory();
        WebDriver webDriver = driverFactory.getDriver();
        webDriverPool.add(webDriver);
        return webDriver;
    }

    @AfterMethod(alwaysRun = true)
    public static void clearCookies() throws Exception {
        getDriver().manage().deleteAllCookies();
    }

    @AfterSuite(alwaysRun = true)
    public static void closeDriverObjects() {
        for (WebDriver driver : webDriverPool) {
            driver.quit();
        }
    }
}
