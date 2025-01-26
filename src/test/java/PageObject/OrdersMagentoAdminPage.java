package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrdersMagentoAdminPage extends BasePage{
    public OrdersMagentoAdminPage(WebDriver driver) {
        super(driver);

    }
    //Locators
    @FindBy(xpath = "//select[@id='sales_order_grid_export']")
    WebElement ExportTo_dropDown;

    @FindBy(xpath = "//button[@title='Export']")
    WebElement Export_btn;

    //Actions
    public void SelectCsvAndClickExport(){
        Select select=new Select(ExportTo_dropDown);
        select.selectByVisibleText("CSV");
        Export_btn.click();


    }
}
