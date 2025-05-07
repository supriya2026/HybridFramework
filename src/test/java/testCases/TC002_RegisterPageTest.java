package testCases;

import org.openqa.selenium.WebDriver;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.GuestPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;

//import pageObjects.RegisterLoginHomePage;
import pageObjects.RegisterPage;
import utilities.DataProviders;

public class TC002_RegisterPageTest extends BasePageTest{
   
   @Test (dataProvider = "RegisterData", dataProviderClass = DataProviders.class)
   public void Register(String FirstName, String LastName, String Email, String Address, String City,String State,String Zipcode,String Login_Name, String Password, String Pswdconf) {
	   try {
	   logger.info("**Starting TC002_RegisterPageTest**");
	   HomePage HP = new HomePage(driver);
	   RegisterPage RP = new RegisterPage(driver);
	   AccountPage AP = new AccountPage(driver);
	   //Home page
	   HP.clickloginRegisterbtn();
	   RP.ClickRegesiterContinuebtn();
	   //Registration Page
	   RP.SetFirstName(FirstName);
	   RP.SetLastName(LastName);
	   RP.SetEmail(Email);
	   RP.Country();
	   RP.SetAddress(Address);
	   RP.SetCity(City);
	   RP.Region(State);
	   RP.SetZipcode(Zipcode);
	   RP.SetLoginName(Login_Name);
	   RP.SetPassword(Password);
	   RP.SetConfPassword(Pswdconf);
	   RP.Subscriptionbtn();
	   RP.PolicyAgreebtn();
	   RP.RegContinuebtn();
	   boolean errormsg = RP.ConfErrorMsg();
	   if(errormsg == false) {
	   String msg = RP.getConfmsg();
	   Assert.assertEquals(msg,"YOUR ACCOUNT HAS BEEN CREATED!");
	   RP.Continuebtn();
	   AP.clickLogoutbtn();
	   String logouttext = AP.getConfmsg();
	   Assert.assertEquals(logouttext, "ACCOUNT LOGOUT");
	   AP.Continuebtn();
	   logger.info("Account created sucessfully");
	   logger.info("Test Case Passed");
	   Assert.assertTrue(true);
	   }
	   else if(errormsg == true) {
		   logger.info("Account not created");
		   logger.info("Test case passed");
		   Assert.assertTrue(true);
		  
	   }
	   else{
		   logger.info("Test case failed");
		   Assert.assertTrue(false); }
	   }
	   catch(Exception e) {
		   Assert.fail();
	   }
	   }
   
	
}
