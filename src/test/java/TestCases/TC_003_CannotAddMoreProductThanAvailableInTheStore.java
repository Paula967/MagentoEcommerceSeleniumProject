package TestCases;

import PageObject.HomePage;
import PageObject.MobilePage;
import PageObject.ShoppingCartPage;
import TestBase.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_003_CannotAddMoreProductThanAvailableInTheStore extends BaseClass {

    @Test
    public void TestCase3(){

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
}
