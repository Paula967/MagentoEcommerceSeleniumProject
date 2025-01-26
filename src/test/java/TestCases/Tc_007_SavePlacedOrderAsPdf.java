package TestCases;

import PageObject.*;
import TestBase.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class
Tc_007_SavePlacedOrderAsPdf extends BaseClass {

    @Test
    public void TestCase7(){

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
    }
}
