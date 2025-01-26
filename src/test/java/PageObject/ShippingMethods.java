package PageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShippingMethods extends BasePage{

    //Constructor
    public ShippingMethods(WebDriver driver) {
        super(driver);

    }

    //Locators
    @FindBy(xpath = "//form[@id='shipping_method_form']/div[@class='buttons-set']/button")
    WebElement ContinueToBillingInfo_btn;

    //Actions
    public BillingInfoPage ClickOnContinueToBillingInfo() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(ContinueToBillingInfo_btn));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", button);
        return new BillingInfoPage(driver);
    }

}
