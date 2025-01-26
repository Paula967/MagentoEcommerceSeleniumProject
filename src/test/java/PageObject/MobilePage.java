package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class MobilePage extends BasePage{

    //Constructor
    public MobilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    //Locators
    @FindBy(xpath = "//h1[normalize-space()='Mobile']")
    WebElement title_MobilePage;

    @FindBy(xpath = "(//select[@title='Sort By'])[1]")
    WebElement SortBy_drpDown;

    @FindBy(xpath = "//ul[@class='products-grid products-grid--max-4-col first last odd']/li/div/h2/a")
    List<WebElement> ProductNames;

    @FindBy(xpath = "//span[contains(text(),'$100.00')]")
    WebElement SonyXperia_Price;

    @FindBy(xpath = "//a[@title='Sony Xperia']")
    WebElement SonyXperia_lnk;

    @FindBy(xpath = "(//button[@title='Add to Cart'])[1]")
    WebElement SonyXperia_AddToCart_btn;

    @FindBy(xpath = "(//a[@class='link-compare'][normalize-space()='Add to Compare'])[1]")
    WebElement AddToCompareSony;

    @FindBy(xpath = "(//a[@class='link-compare'][normalize-space()='Add to Compare'])[2]")
    WebElement AddToCompareIphone;

    @FindBy(xpath = "(//button[@title='Compare'])[1]")
    WebElement Compare_btn;

    @FindBy(xpath = "//div[@class=\"block-content\"]/ol/li/p/a")
    List<WebElement> ComparedPhonesInMobilePage;

    @FindBy(xpath = "(//button[@title='Add to Cart'])[2]")
    WebElement IPhoneAddToCart_btn;

    //Actions
    public String getMobilePageTitle(){
        return  title_MobilePage.getText();
    }

    public void SortedByNameInDropDown(){
        Select select=new Select(SortBy_drpDown);
        select.selectByIndex(1);
    }
    public List<String> GetProductNames(){
        List<String> productNames=new ArrayList<>();
        for(WebElement product:ProductNames)
        {
            productNames.add(product.getText().trim());

        }
        return productNames;
    }
    public DetailedPage ClickOnSonyXperiaLnk(){
        SonyXperia_lnk.click();
        return new DetailedPage(driver);
    }

    public String GetPriceInMobilePage(){
        return SonyXperia_Price.getText();
    }

    public ShoppingCartPage ClickOnSonyXperia_AddToCart_btn(){
        SonyXperia_AddToCart_btn.click();
        return new ShoppingCartPage(driver);
    }

    public MobilePage ClickOnAddToCompareTwoPhones(){
        AddToCompareSony.click();
        AddToCompareIphone.click();
        return this;
    }

    public CompareListPage ClickOnCompareBtn(){
        Compare_btn.click();
        return new CompareListPage(driver);
    }
    public List<String> GetComparedPhonesInMobilePage(){
        List<String>ComparePhonesNames=new ArrayList<>();
        for(WebElement Phones:ComparedPhonesInMobilePage){
            ComparePhonesNames.add(Phones.getText());
        }
        return ComparePhonesNames;
    }
    public ShoppingCartPage ClickOnAddToCartForIPhone(){
        IPhoneAddToCart_btn.click();
        return new ShoppingCartPage(driver);
    }
}
