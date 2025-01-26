package TestCases;

import PageObject.*;
import TestBase.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_006_VerifyLoginFunctionallityAndPurchaseItem extends BaseClass {

    @Test
    public void TestCase6() throws InterruptedException {

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
    }
}
