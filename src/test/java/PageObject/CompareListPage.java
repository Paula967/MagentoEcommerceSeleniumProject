package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CompareListPage extends BasePage{

    public CompareListPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//tr[@class='product-shop-row top first odd']/td/h2/a")
    List<WebElement> ComparingListPage;

    @FindBy(xpath="//h1[normalize-space()='Compare Products']")
    WebElement MessageOfListPage;

    @FindBy(xpath = "(//button[@title='Close Window'])[1]")
    WebElement CloseWindow_btn;

    //Actions
    public List<String> GetComparedPhonesInMobilePage(){
        List<String>ComparePhonesNames=new ArrayList<>();
        for(WebElement Phones:ComparingListPage){
            ComparePhonesNames.add(Phones.getText());
        }
        return ComparePhonesNames;
    }

    public String MessageInListPage()
    {
         return getMessage(MessageOfListPage).toUpperCase();
    }

    public void ClickOnCloseWindow_btn(){
        ClickOn(CloseWindow_btn);
    }
}
