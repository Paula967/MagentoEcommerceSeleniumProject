package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class OrderPage extends BasePage{
    //Constructor
    public OrderPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    //Locators
    @FindBy(xpath = "//p[contains(text(),'Your order number is')]")
    WebElement OrderMessage;

    @FindBy(xpath = "//p[@data-role='order-numbers']/a")
    WebElement OrderNum;

    //Actions
    public String GetOrderMessage(){
        String orderMessage=OrderMessage.getText();
        return orderMessage.substring(0,orderMessage.lastIndexOf(" "));
    }
    public String GetOrderNum(){
        OrderID=OrderNum.getText();
        return OrderNum.getText();
    }


}
