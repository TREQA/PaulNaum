package util;

import PageObjects.BasePage;
import config.DriverFactory;
import config.DriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class DriverBase extends BasePage {

    public DriverBase(WebDriver passedDriver) {
        super(passedDriver);
    }
    private static List<DriverFactory> webDriverThreadPool = Collections.synchronizedList(new ArrayList<DriverFactory>());
    private static List<WebDriver> webDriverPool = Collections.synchronizedList(new ArrayList<WebDriver>());
    private ThreadLocal<DriverFactory> driverFactory;


    @BeforeMethod
    public void instantiateDriverObject() {
        driverFactory = new ThreadLocal<DriverFactory>() {
            @Override
            protected DriverFactory initialValue() {
                DriverFactory driverFactory = new DriverFactory();
                webDriverThreadPool.add(driverFactory);
                return driverFactory;
            }
        };
    }

    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) throws Exception{
        //Check if parameter passed from TestNG is 'firefox'
        if(browser.equalsIgnoreCase("firefox")){
            //create firefox instance
            System.setProperty("webdriver.firefox.marionette", ".\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        //Check if parameter passed as 'chrome'
        else if(browser.equalsIgnoreCase("chrome")){
            //set path to chromedriver.exe
            System.setProperty("webdriver.chrome.driver",".\\chromedriver.exe");
            //create chrome instance
            driver = new ChromeDriver();
        }

        else{
            //If no browser passed throw exception
            throw new Exception("Browser is not correct");
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static WebDriver getDriver()  {
        DriverFactory driverFactory = new DriverFactory();
        WebDriver webDriver = driverFactory.getDriver(null);
        webDriverPool.add(webDriver);
        return webDriver;
    }

    public static WebDriver getDriver(DriverType driverType){
        DriverFactory driverFactory = new DriverFactory();
        WebDriver webDriver = driverFactory.getDriver(driverType);
        webDriverPool.add(webDriver);
        return webDriver;
    }

    public static void closeDriverObjects() {
        for (WebDriver driver : webDriverPool) {
            driver.quit();
        }
    }
}
