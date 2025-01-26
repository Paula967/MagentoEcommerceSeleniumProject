package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    //Constructor
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    //Locators
    @FindBy(xpath = "//h2[1]")
    WebElement title_HomePage;

    @FindBy(xpath = "//a[normalize-space()='Mobile']")
    WebElement lnk_Mobile;

    @FindBy(xpath = "//a[@class='skip-link skip-account']")
    WebElement lnk_Account;

    @FindBy(xpath = "(//a[normalize-space()='Register'])[1]")
    WebElement lnk_Register;

    @FindBy(xpath = "//a[@class='skip-link skip-account']")
    WebElement lnk_MyAccount;

    @FindBy(xpath = "//a[normalize-space()='Log In']")
    WebElement lnk_Login;

    //Actions
    public MobilePage clickOnMobile(){
        lnk_Mobile.click();
        return new MobilePage(driver);
    }
    public String getHomePageTitle(){
        return title_HomePage.getText();
    }
    public void ClickOnAccount(){
        lnk_Account.click();
    }
    public CreateNewCustomerPage ClickOnRegister(){
        lnk_Register.click();
        return new CreateNewCustomerPage(driver);
    }
    public MyAccount ClickOnMyAccount(){lnk_MyAccount.click();
    return new MyAccount(driver);
    }
    public CustomerLoginPage ClickOnLogin(){
        lnk_Login.click();
        return new CustomerLoginPage(driver);
    }
}
