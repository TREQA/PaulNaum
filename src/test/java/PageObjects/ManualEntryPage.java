package PageObjects;

import AutomationFramework.Date;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ManualEntryPage extends BasePage {

    public ManualEntryPage(WebDriver passedDriver) {
        super(passedDriver);
    }

    By mPageTitle = By.cssSelector("#list_page_breadcrumb > h1");
    By mCustomer = By.id("s2id_customer_id");
    public static By mShipToParty = By.id("ship_to_party_id");
    By mRequestorName = By.id("BulkOrderRequesterId");
    By mBuyers = By.id("s2id_BuyerId");
    By mRBuyers = By.cssSelector("#select2-drop > ul > li.select2-results-dept-0.select2-result.select2-result-selectable.select2-highlighted");
    By mCustomerPO = By.id("BulkOrderPoNumber");
    By mOrderType = By.id("normal_check");
    By mCommandArticle = By.id("s2id_BulkOrderLine0ArticleId");
    By mCommandShade = By.id("s2id_BulkOrderLine0ShadeId");
    By mCommandQty = By.id("quantity0");
    By mCommandDate = By.id("required_date_0");
    By mPressNext = By.id("next");
    public By STPFLagged = By.xpath("//*[@id=\"ship_to_party_id\"]/option[8]");


    public static WebElement mCustomerSearchField(WebDriver driver) {
        new WebDriverWait(driver, 2)
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div:nth-of-type(5) > div > input")));
        return driver.findElement(By.cssSelector("body > div:nth-of-type(5) > div > input"));
    }

    public static WebElement mCustomerResultField(WebDriver driver) {
        new WebDriverWait(driver, 2)
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("#select2-drop > ul > li > div > span")));
        return driver.findElement(By.cssSelector("#select2-drop > ul > li > div > span"));
    }

    public static WebElement mShipToPartyOption(WebDriver driver, int row) {
        new WebDriverWait(driver, 4)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ship_to_party_id\"]/option[" + 2 + "]")));
        return driver.findElement(By.xpath("//*[@id=\"ship_to_party_id\"]/option[" + 2 + "]"));
    }

    public static WebElement mRequesterOption(WebDriver driver) {
        new WebDriverWait(driver, 2)
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("#BulkOrderRequesterId > option:nth-child(16)\n")));
        return driver.findElement(By.cssSelector("#BulkOrderRequesterId > option:nth-child(16)\n"));
    }

    public static WebElement mInsertCommandArticleField(WebDriver driver) {
        new WebDriverWait(driver, 2)
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("#select2-drop > div > input")));
        return driver.findElement(By.cssSelector("#select2-drop > div > input"));
    }

    public static WebElement mSelectCommandArticleField(WebDriver driver) {
        new WebDriverWait(driver, 2)
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("#select2-drop > ul > li.select2-results-dept-0.select2-result.select2-result-selectable.select2-highlighted > div")));
        return driver.findElement(By.cssSelector("#select2-drop > ul > li.select2-results-dept-0.select2-result.select2-result-selectable.select2-highlighted > div"));
    }

    public static WebElement mInsertCommandShadeField(WebDriver driver) {
        new WebDriverWait(driver, 2)
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("#select2-drop > div > input")));
        return driver.findElement(By.cssSelector("#select2-drop > div > input"));
    }

    public static WebElement mSelectCommandShadeField(WebDriver driver) {
        new WebDriverWait(driver, 2)
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("#select2-drop > ul > li.select2-results-dept-0.select2-result.select2-result-selectable.select2-highlighted > div")));
        return driver.findElement(By.cssSelector("#select2-drop > ul > li.select2-results-dept-0.select2-result.select2-result-selectable.select2-highlighted > div"));
    }

    public static WebElement mPopup(WebDriver driver) {
        new WebDriverWait(driver, 2)
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("[name=\"Ok\"]")));
        return driver.findElement(By.cssSelector("[name=\"Ok\"]"));
    }

    public static WebElement mSubmitOrder(WebDriver driver) {
        new WebDriverWait(driver, 2)
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("[name=\"Yes\"]")));
        return driver.findElement(By.cssSelector("[name=\"Yes\"]"));
    }

    public void navManualEntry(){
        driver.findElement(orderTab).click();
        driver.findElement(orderManualEntry).click();
    }
    public void setProfileDetails() {
        setSearchField(mCustomer, Date.Customer);
        mShipToPartyOption(driver, 2).click();
        mRequesterOption(driver).click();
        driver.findElement(mBuyers).click();
        driver.findElement(mRBuyers).click();
        driver.findElement(mCustomerPO).sendKeys(Date.CustomerPO);
    }

    public void setProfileDisabledSTPDetails() {
        setSearchField(mCustomer, Date.Customer);
    }

    public void setSearchField(By fieldLocator, String customer) {
        driver.findElement(fieldLocator).click();
        mCustomerSearchField(driver).sendKeys(customer);
        mCustomerResultField(driver).click();
    }

    public void setCommandDetails() {
        driver.findElement(mCommandArticle).click();
        mInsertCommandArticleField(driver).sendKeys(Date.Article);
        mSelectCommandArticleField(driver).click();
        driver.findElement(mCommandShade).click();
        mInsertCommandShadeField(driver).sendKeys(Date.Shade);
        mSelectCommandShadeField(driver).click();
        driver.findElement(mCommandQty).sendKeys(Date.Qty);
        driver.findElement(mCommandDate).click();
        driver.findElement(mCommandDate).sendKeys(Keys.ENTER);
    }

    public void pressNext() {
        driver.findElement(mPressNext).click();
        mPopup(driver).click();
        mSubmitOrder(driver).click();
    }

    public boolean checkSTP(By Ship) {
        boolean g = false;
        Select dropdown = new Select(driver.findElement(mShipToParty));
        List<WebElement> options = dropdown.getOptions();
        //List<String> optionsValues = new ArrayList<String>();
        for (WebElement option : options) {
            //optionsValues.add(option.getText());
            if (option.getText().equals(Ship)) {
                g = true;
                return g;
            }
        }
        return g;
    }
}

