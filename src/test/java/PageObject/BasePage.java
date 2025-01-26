package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public WebDriver driver;
    public String OrderID;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }
    public void ClickOn(WebElement element){
        element.click();
    }
    public void SendData(WebElement element,String data){
        element.sendKeys(data);
    }
    public String getMessage(WebElement element){
         return element.getText();
    }

}
