package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLoginPage extends BasePage{
    //Constructor
    public AdminLoginPage(WebDriver driver) {
        super(driver);
    }
    //Locators
    @FindBy(xpath = "//input[@id='username']")
    WebElement AdminUser_txt;

    @FindBy(xpath = "//input[@id='login']")
    WebElement AdminPass_txt;

    @FindBy(xpath = "//input[@title='Login']")
    WebElement AdminLogin_btn;

    //Actions
    public void LoginAdminData(String User,String Pass){
        AdminUser_txt.sendKeys(User);
        AdminPass_txt.sendKeys(Pass);
        AdminLogin_btn.click();
    }
}
