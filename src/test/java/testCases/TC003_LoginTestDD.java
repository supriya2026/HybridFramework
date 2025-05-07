package testCases;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import utilities.DataProviders;

public class TC003_LoginTestDD extends BasePageTest {
	
		@Test (dataProvider = "LoginData", dataProviderClass = DataProviders.class)
		public void LoginDDT_verify(String username, String password, String res) {
			try {
			   HomePage HP = new HomePage(driver);
			   LoginPage LP = new LoginPage(driver);
			   AccountPage AP = new AccountPage(driver);
			  //HomePage
			   HP.clickloginRegisterbtn();
			   //login 
			   LP.SetLogin(username);
			   LP.SetPswd(password);
			   LP.ClickLoginbtn();
			  String msg =  LP.Errormsgconf();
			   //account
			   boolean AccPageVerify = AP.isAccountPageExists();
			   if (res.equalsIgnoreCase("valid")) {
				   if(AccPageVerify == true) {
				   logger.info("**Start of test case for valid**");
				   AP.clickLogoutbtn();logger.info("logout");
				   String logouttext = AP.getConfmsg();
				   Assert.assertEquals(logouttext, "ACCOUNT LOGOUT");
				   AP.Continuebtn();
				   logger.info("Test case sucess for valid");
				   Assert.assertTrue(true);
		          }
		         else {
		    	  logger.info("Test case fail for valid");
		    	  Assert.assertTrue(false);
		       }
			 }
		    if(res.equalsIgnoreCase("invalid")) {
			  if(AccPageVerify == true) {
			    logger.info("**start of test case for invalid**");
			    AP.clickLogoutbtn();
				String logouttext = AP.getConfmsg();
				Assert.assertEquals(logouttext, "ACCOUNT LOGOUT");
				AP.Continuebtn();
				logger.info("test case fail for invalid");
				Assert.assertTrue(false);
			   }
		      else {
			   logger.info("test case sucess for invalid");
			   Assert.assertTrue(true);
			  }
		  }
			}catch(Exception e) {
				Assert.fail();
			}
		  finally{ logger.info("** Finished**");};
 }
}
