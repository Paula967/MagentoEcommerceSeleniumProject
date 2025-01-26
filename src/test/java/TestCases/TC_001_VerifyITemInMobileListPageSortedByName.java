package TestCases;

import PageObject.HomePage;
import PageObject.MobilePage;
import TestBase.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TC_001_VerifyITemInMobileListPageSortedByName extends BaseClass {

    @Test
    public void TestCase_1() throws InterruptedException {

        //Step 2 => Verify The Title of The Home Page
        Assert.assertEquals(homePage.getHomePageTitle(),"This is demo site for   ".toUpperCase());
        //Step 3=> Click On Mobile Link
        MobilePage Mobilepage=homePage.clickOnMobile();
        //Step 4=> Verify Title OF MobilePage
        Assert.assertEquals(Mobilepage.getMobilePageTitle(),"mobile".toUpperCase());
        //Step 5=> Select (Sort By dropDown as 'Name')
        Mobilepage.SortedByNameInDropDown();
        //Step 6=> Verify All Products are sorted By name
        List<String> returnedProductsName=Mobilepage.GetProductNames();
        List<String> SortedProductNames=new ArrayList<>(returnedProductsName);
        Collections.sort(SortedProductNames);
        Assert.assertEquals(returnedProductsName,SortedProductNames);
    }
}
