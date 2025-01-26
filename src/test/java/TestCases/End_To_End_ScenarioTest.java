package TestCases;

import PageObject.*;
import TestBase.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class End_To_End_ScenarioTest extends BaseClass {
    @Test(priority = 1)
    public void TC_001_VerifyITemInMobileListPageSortedByName() throws InterruptedException {

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
    @Test(priority = 2)
    public void TC_002_VerifyCostOfProductInListPageAndDetailedAreEqual(){

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
    @Test(priority = 3)
    public void TC_003_CannotAddMoreProductThanAvailableInTheStore(){

        //Step 2=> Click On Mobile Link
        //Step 3=> Click On AddToCart
        //Step 4=> Change The quantity and Click on update button
        ShoppingCartPage shoppingCartPage=homePage.clickOnMobile()
                .ClickOnSonyXperia_AddToCart_btn()
                .SetQuantity("1000").clickOnUpdateButton();

        //Step 5 => Verify The Error Message
        Assert.assertEquals(shoppingCartPage.Get_ErrorMessage(),
                "* The maximum quantity allowed for purchase is 500.");

        //Step 6=> Click on empty Cart
        shoppingCartPage.ClickOnEmptyCart();

        //Step 7=> Verify Cart is Empty
        Assert.assertEquals(shoppingCartPage.GetEmptyShoppingCart_Message().toUpperCase(),
                "SHOPPING CART IS EMPTY");
    }
    @Test(priority = 4)
    public void TC_004_CompareTwoProducts(){

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
    @Test(priority = 5)
    public void TC_005_CreateNewAccountAndShareWishlistToPeopleWithEmail(){

        // Step2 => Click on MyAccount Link
        homePage.ClickOnAccount();
        CreateNewCustomerPage Register=homePage.ClickOnRegister();

        // Step 3=> Fill The New Customer Data
        ArrayList<String> ReturnedData =Register.FillData();
        Register.updateConfigFile(ReturnedData.get(2), ReturnedData.get(3));

        // Step 4=> Click on Register Button
        MyAccount myAccount=Register.ClickOnRegister();

        // Step 5 => Verify Registration is done
        if(myAccount.GetMyAccountMessage()
                .contains(ReturnedData.get(0)+" "+ReturnedData.get(1))){
            Assert.assertTrue(true);
        }
        else {
            Assert.fail();
        }

        // Step 6 => Click on TV Link
        // Step 7 => Add your product in your wishlist
        // Step 8 => Click on WishList Button
        // Step 9 => Enter Email and Message and Click on Share WishList
        // Step 10 => Check WishList is Sharing
        Assert.assertEquals(myAccount.ClickOnTvLink()
                        .ClickOnLG_LCDAddToWishList()
                        .ClickOnShareWishList()
                        .FillTextArea()
                        .ClickOnWishListButton()
                        .GetWishListMessage()
                ,"Your Wishlist has been shared.");
        myAccount.ClickOnLogout();
    }
    @Test(dependsOnMethods = {"TC_005_CreateNewAccountAndShareWishlistToPeopleWithEmail"},priority = 6)
    public void TC_006_VerifyLoginFunctionallityAndPurchaseItem() throws InterruptedException {

        // Step 2 => Click on MyAccount Link
        MyAccount myAccount=homePage.ClickOnMyAccount();
        CustomerLoginPage Login=homePage.ClickOnLogin();

        // Step 3=> Login with Previous Registered Data
        Login.LoginData();
        Login.ClickOnLoginButton();

        // Step 4=> Click On My Wishlist link
        // Step 5=> AddToCartLink
        // Step 6 => Enter Shipping information
        myAccount.MyAccountlink();
        ShoppingCartPage shoppingCartPage=myAccount
                .ClickOnMyWishListLink()
                .ClickOnAddToCart()
                .FillShippingInfoInShoppingCart().ClickOnEstimateLink();

        // Step 8 => Verify Shipping Cost Generated
        // Step 8.1=> Sure for Flat Rate Message
        Assert.assertEquals("Flat Rate",shoppingCartPage.GetShoppingCostMessage());
        // Step 8.2=> Sure for Fixed - $5.00
        Assert.assertEquals("Fixed - $5.00",shoppingCartPage.GetFixed_FlatRate());

        // Step 9 => Select Shipping Cost , Update Total
        shoppingCartPage.SelectShippingCost();
        shoppingCartPage.ClickOnUpdateTotal();

        // Step 10=> Verify Shipping Cost is Added to total
        Assert.assertEquals("$5.00",shoppingCartPage.GetFlatRatePrice());

        // Step 11=> Click on CheckOut with Multiple Addresses
        // Step 12=> Fill Shipping Address Data
        // Step 13=> In Shipping Method , Click on continue
        // 14. In Billing Info Choose Check/Money order Radio Button , Click Continue
        // 15. Click Place Order Button
        // 16. Verify Order is generated
        Assert.assertEquals(
                shoppingCartPage.ClickOnCheckoutWithMultipleAddress()
                        .EnterShippingInfo()
                        .ClickOnSaveAddress()
                        .ClickOnContinueToShoppingInfo()
                        .ClickOnContinueToBillingInfo()
                        .ChooseRadioButton()
                        .ClickContinueButton()
                        .ClickOnPlaceOrder()
                        .GetOrderMessage(),
                "Your order number is");
        myAccount.ClickOnLogout();
    }
    @Test(priority = 7)
    public void Tc_007_SavePlacedOrderAsPdf(){

        // Step 2 => Click on MyAccount Link
        MyAccount myAccount=homePage.ClickOnMyAccount();
        CustomerLoginPage Login=homePage.ClickOnLogin();

        // Step 3=> Login with Previous Registered Data
        Login.LoginData();
        Login.ClickOnLoginButton();

        // Step 4=> Click on My orders Link
        myAccount.ClickOnMyOrders();

        // Step 5=> Verify The Previously Created Order is displayed and status is pending
        Assert.assertEquals(myAccount.GetOrderID(),myAccount.RetrieveOrderID());
        Assert.assertEquals(myAccount.GetStatusOFOrder(),"Pending");

        // Step 6=> Click on View orders Link
        // Step 7=> Click on Print Order
        myAccount.ClickOnViewOrder().ClickOnPrintOrder();
        // Step 8. Click 'Change...' link and a popup will be opened as 'Select a destination' , select 'Save as PDF' link.
        // note:  There is no "Change...." link

        // Step 9. Click on 'Save' button and save the file in some location.
        // note: unable to find this Save button

        // Step 10.Verify Order is saved as PDF
        // unable to perform any verification because there is no option to save as PDF
        myAccount.ClickOnLogout();
    }
    @Test(priority = 8)
    public void TC_008_ChangeOrReorderPreviouslyaddedProduct() throws InterruptedException {

        // Step 2 => Click on MyAccount Link
        MyAccount myAccount=homePage.ClickOnMyAccount();
        CustomerLoginPage Login=homePage.ClickOnLogin();

        // Step 3=> Login with Previous Registered Data
        // Step 4=> Click on Reorder Link
        Login.LoginData();
        ShoppingCartPage shoppingCartPage=Login.ClickOnLoginButton()
                .ClickOnReorderLink();

        // Change Quantity and Click on Update

        String First_total=shoppingCartPage.GetGrandTotalPrice();
        shoppingCartPage.SetQuantity("10");
        shoppingCartPage.clickOnUpdateButton();
        String Last_total= shoppingCartPage.GetGrandTotalPrice();

        // Step 5=> Verify Grand Total is Changed
        Assert.assertNotEquals(First_total,Last_total,"Total Is Not Changed");

        // Step 6=> Complete Billing and Shipping Information
        // Step 7=> Verify Order Is Generated
        Assert.assertEquals(
                shoppingCartPage
                        .FillShippingInfoInShoppingCart()
                        .ClickOnEstimateLink()
                        .SelectShippingCost()
                        .ClickOnUpdateTotal()
                        .ClickOnCheckoutWithMultipleAddress()
                        .ClickOnContinueToShoppingInfo()
                        .ClickOnContinueToBillingInfo()
                        .ChooseRadioButton()
                        .ClickContinueButton()
                        .ClickOnPlaceOrder()
                        .GetOrderMessage(),"Your order number is");
    }
    @Test(priority = 9)
    public void TC_009_VerifyDiscountCouponWorksCorrectly(){

        // Step 2 => Go to Mobile and Add IPhone To Cart
        // Step 3 => Enter Coupon Code => GURU50
        // Step 4 => Verify Discount is Generated
        String expected = "Coupon code " + "\"guru50\"".toUpperCase() + " was applied.";
        Assert.assertEquals( homePage.clickOnMobile()
                        .ClickOnAddToCartForIPhone()
                        .EnterCouponCode("GURU50")
                        .ClickOnApplyButton()
                        .GetDiscountMessage()
                , expected);
    }


}
