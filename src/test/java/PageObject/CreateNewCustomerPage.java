package PageObject;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class CreateNewCustomerPage extends BasePage{

    //Constructor
    public CreateNewCustomerPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    //Locators
    @FindBy(xpath = "//input[@id='firstname']")
    WebElement FirstName_txt;

    @FindBy(xpath = "//input[@id='lastname']")
    WebElement SecondName_txt;

    @FindBy(xpath = "//input[@id='email_address']")
    WebElement Email_txt;

    @FindBy(xpath = "//input[@id='password']")
    WebElement Password_txt;

    @FindBy(xpath = "//input[@id='confirmation']")
    WebElement ConfirmPassword_txt;

    @FindBy(xpath = "//button[@title='Register']")
    WebElement Register_btn;



    //Actions
    public ArrayList<String> FillData(){

        ArrayList<String> Data=new ArrayList<>();
        Faker faker=new Faker();
        String fname=faker.name().firstName();
        String lname=faker.name().lastName();
        String Email=faker.internet().emailAddress();
        String Password=faker.internet().password();
        FirstName_txt.sendKeys(fname);
        SecondName_txt.sendKeys(lname);
        Email_txt.sendKeys(Email);
        Password_txt.sendKeys(Password);
        ConfirmPassword_txt.sendKeys(Password);
        Data.add(0,fname);
        Data.add(1,lname);
        Data.add(2,Email);
        Data.add(3,Password);
        updateConfigFile(Email,Password);
        return Data;
    }
    public MyAccount ClickOnRegister(){
        Register_btn.click();
        return new MyAccount(driver);
    }
    public void updateConfigFile(String email, String password) {
        Properties properties = new Properties();

        try (FileOutputStream out = new FileOutputStream("src/test/resources/config.properities")) {

            properties.setProperty("dynamicEmail", email);
            properties.setProperty("dynamicPassword", password);

            properties.store(out, "Updated dynamic email and password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
