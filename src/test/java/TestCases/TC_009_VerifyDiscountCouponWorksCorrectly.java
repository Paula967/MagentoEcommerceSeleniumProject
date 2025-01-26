package TestCases;

import PageObject.HomePage;
import PageObject.MobilePage;
import PageObject.ShoppingCartPage;
import TestBase.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_009_VerifyDiscountCouponWorksCorrectly extends BaseClass {

    @Test
    public void TestCase9(){

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
