package PageObjects;

import AutomationFramework.Date;
import AutomationFramework.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.io.IOException;


public class LogInPage extends BasePage {

    static By homePageTitle = By.cssSelector("#content > h2");
    static By btnLogin = By.className("loginbutton");
    static By userNameLocator = By.id("UserUsername");
    static By userPassLocator = By.id("UserPassword");
    static By pagMain = By.cssSelector("#wrapper > div:nth-child(4) > a:nth-child(1) > img");
    static By pagEcomm = By.cssSelector("[name=\"land\"] > area:nth-of-type(4)");
    static By pagCCE = By.cssSelector("[name=\"land\"] > area:nth-of-type(2)");

    public LogInPage(WebDriver passedDriver) {
        super(passedDriver);
    }

    public static WebElement getHomePageTitle() {
        return Wait.visible(driver, homePageTitle);
    }

    public void loginCoats(String username, String password) {
        WebElement usernameField = Wait.clickable(driver, userNameLocator);
        WebElement userpassField = Wait.clickable(driver, userPassLocator);
        usernameField.sendKeys(username);
        userpassField.sendKeys(password);
        Wait.clickable(driver, btnLogin).click();

    }

    public void navigateEcomm() {
        Wait.clickable(driver, pagMain).click();
        Wait.visible(driver, pagEcomm);
        WebElement element = driver.findElement(pagEcomm);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void navigateCce() {
        Wait.clickable(driver, pagMain).click();
        Wait.clickable(driver, pagCCE).click();
    }

    public void logoutCoats() {
        driver.findElement(btnLogout).click();
    }


}
