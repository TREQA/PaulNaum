package AutomationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {


    public static WebElement clickable(WebDriver driver, By locator) {
        return new WebDriverWait(driver,Date.longWait).until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static WebElement visible(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Date.longWait).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

}
