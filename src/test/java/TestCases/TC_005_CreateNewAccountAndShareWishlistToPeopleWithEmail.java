package TestCases;

import PageObject.*;
import TestBase.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class TC_005_CreateNewAccountAndShareWishlistToPeopleWithEmail extends BaseClass {
    @Test
    public void TestCase5(){

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
    }
}
