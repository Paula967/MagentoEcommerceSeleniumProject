package TestCases;

import PageObject.*;
import TestBase.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_008_ChangeOrReorderPreviouslyaddedProduct extends BaseClass {
    @Test
    public void TestCase8() throws InterruptedException {

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
}
