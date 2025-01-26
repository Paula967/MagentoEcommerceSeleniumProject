package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CustomerLoginPage extends BasePage{

    //Constructor
    public CustomerLoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    //Locators
    @FindBy(xpath = "//input[@id='email']")
    WebElement Email_txt;

    @FindBy(xpath = "//input[@id='pass']")
    WebElement Password_txt;

    @FindBy(xpath = "//button[@id='send2']")
    WebElement Login_btn;

    //Actions
    public void LoginData(){

        Properties properties=new Properties();
        try {
            FileInputStream file = new FileInputStream("src/test/resources/config.properities");
            properties.load(file);
        } catch (IOException e) {
            e.printStackTrace();

        }

        Email_txt.sendKeys(properties.getProperty("dynamicEmail"));
        Password_txt.sendKeys(properties.getProperty("dynamicPassword"));
    }
    public MyAccount ClickOnLoginButton(){
        ClickOn(Login_btn);
        return new MyAccount(driver);
    }


}
