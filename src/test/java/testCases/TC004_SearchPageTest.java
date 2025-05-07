package testCases;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.BasePage;
import pageObjects.GuestPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SearchPage;

public class TC004_SearchPageTest extends BasePageTest {
	
	@Test (priority=1)
	public void searchPage() {
		SearchPage SP = new SearchPage(driver);
		HomePage HP = new HomePage(driver);
		SP.search_bar("shoes");
		SP.select_color();
		HP.AddToCartbtn();
		//HP.CheckOutbtn();
		
		
	}
	 @Test (priority=2, dependsOnMethods= {"searchPage"})
	 public void login_item_in_cart() {
		   HomePage HP = new HomePage(driver);
		   LoginPage LP = new LoginPage(driver);
		   AccountPage AP = new AccountPage(driver);
		   GuestPage GP = new GuestPage(driver);
		  //HomePage
		   HP.clickloginRegisterbtn();
		   //login 
		   LP.SetLogin("kmiller_1");
		   LP.SetPswd("km123!");
		   LP.ClickLoginbtn();
		   AP.btn_cart();
		   HP.CheckOutbtn();
		   GP.ConfirmOrderbtn();
		   String text = GP.getConfirmmsg();
		   Assert.assertEquals(text, "YOUR ORDER HAS BEEN PROCESSED!");
		   
	 }
}
