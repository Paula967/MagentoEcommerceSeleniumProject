package TestBase;

import PageObject.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseClass {
    public WebDriver driver;
    public HomePage homePage;
    @Parameters({"OS","browser"})
    @BeforeClass
    public void setup(String OS,String browser) {
        if(driver == null) {
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
                    driver=new ChromeDriver();
                    break;
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            driver.get("http://live.techpanda.org/");
        }
            homePage=new HomePage(driver);
    }
   @AfterClass
    public void tearDown() {
        driver.close();
    }
}




