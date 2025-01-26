package TestCases;

import PageObject.CompareListPage;
import PageObject.HomePage;
import PageObject.MobilePage;
import TestBase.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class TC_004_CompareTwoProducts extends BaseClass {
    @Test
    public void TestCase4(){


        //Step 2=> Click On Mobile Link
        //Step 3=>Click on Add To Compare for two phones
        MobilePage mobilePage=homePage.clickOnMobile().ClickOnAddToCompareTwoPhones();

        //Step 4=>Click on Compare button
        String ParentPage=driver.getWindowHandle();
        CompareListPage compareListPage= mobilePage.ClickOnCompareBtn();
        List<String> returnedNames =mobilePage.GetComparedPhonesInMobilePage();

        //Step 5=> Verify the Popup window and Check for Products
        Set<String> allWindows=driver.getWindowHandles();
        for(String windows:allWindows){
            if(!windows.equals(ParentPage))
            {
                driver.switchTo().window(windows);
                driver.manage().window().maximize();
                break;
            }
        }

        List<String> returnedNamesinListPage=compareListPage.GetComparedPhonesInMobilePage();
        if((returnedNamesinListPage.equals(returnedNames)) &&
                (compareListPage.MessageInListPage()
                        .equals("COMPARE PRODUCTS"))){
            Assert.assertTrue(true);
        }
        else {
            Assert.fail();
        }
        //Step 6=> Close the Popup Windows
        compareListPage.ClickOnCloseWindow_btn();

        // Step 7=> Let Driver Switch to Parent Page
        driver.switchTo().window(ParentPage);
    }
}
