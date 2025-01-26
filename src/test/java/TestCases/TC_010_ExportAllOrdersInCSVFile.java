package TestCases;

import PageObject.AdminLoginPage;
import PageObject.ManageCustomersPage;
import PageObject.OrdersMagentoAdminPage;
import TestBase.BaseClass;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_010_ExportAllOrdersInCSVFile extends BaseClass {

    @Parameters({"OS","browser"})
    @Override
    @BeforeClass
    public void setup(String OS,String browser){
        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println("Invalid Browser .....");
                return;
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        // Step 1
        driver.get("https://live.techpanda.org/index.php/backendlogin");
    }

    @Test
    public void TestCase10(){

        // Step 2 => Login The Credentials Provided
        AdminLoginPage alp=new AdminLoginPage(driver);
        alp.LoginAdminData("user01","guru99com");

        // Step 3=> Goto Orders
        ManageCustomersPage mcp=new ManageCustomersPage(driver);
        mcp.GotoOrdersPage();

        //Step 4=> Select CSV file
        OrdersMagentoAdminPage omap=new OrdersMagentoAdminPage(driver);
        omap.SelectCsvAndClickExport();
    }
}
