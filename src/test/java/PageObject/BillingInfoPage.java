package PageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BillingInfoPage extends BasePage{

    //Constructor
    public BillingInfoPage(WebDriver driver) {
        super(driver);

    }
    //Locators
    @FindBy(xpath = "//input[@title='Check / Money order']")
    WebElement Check_MoneyOrder_radio_btn;

    @FindBy(xpath = "//button[@id='payment-continue']")
    WebElement Continue_btn;

    @FindBy(xpath = "//button[@id='review-button']")
    WebElement Place_Order_btn;

    //Actions
    public BillingInfoPage ChooseRadioButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(Check_MoneyOrder_radio_btn));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", button);
        return this;
    }
    public BillingInfoPage ClickContinueButton(){
        ClickOn(Continue_btn);
        return this;
    }
    public OrderPage ClickOnPlaceOrder(){
        ClickOn(Place_Order_btn);
        return new OrderPage(driver);
    }

}
