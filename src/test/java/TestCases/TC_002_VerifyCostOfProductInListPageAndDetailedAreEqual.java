package TestCases;

import PageObject.DetailedPage;
import PageObject.HomePage;
import PageObject.MobilePage;
import TestBase.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_002_VerifyCostOfProductInListPageAndDetailedAreEqual extends BaseClass {

    @Test
    public void testCase2(){

        //Step 2=> Click On Mobile Link
        //Step 3=> Read Cost of SonyXperia Phone
        //Step 4=> Click on SonyXperia Phone link
        //Step 5 => Read Cost of Sony Xperia from Detailed Page
        //Step 6 => Compare step 5 and step 3
        Assert.assertEquals(homePage.clickOnMobile()
                        .ClickOnSonyXperiaLnk()
                        .GetPriceInDetailedPage()
                ,homePage.clickOnMobile().GetPriceInMobilePage()
                ,"No Matching Price");
    }
}
