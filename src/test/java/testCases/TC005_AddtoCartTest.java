package testCases;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.AddtoCartPage;
import pageObjects.GuestPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class TC005_AddtoCartTest extends BasePageTest{
	@Test (priority=1)
	public void AddtoCart() {
		AddtoCartPage ACP = new AddtoCartPage(driver);
		HomePage HP = new HomePage(driver);
		HP.Currency();
		HP.SelectCurrency();
		HP.Makeup();
        HP.LipsFromDropDown();
		HP.SortByDropDown();
		HP.ItemSelection();
		HP.AddToCartbtn();
		ACP.continueshopping();
		HP.Makeup();
        HP.LipsFromDropDown();
		HP.SortByDropDown();
		ACP.itemselection();
		HP.AddToCartbtn();
		
		}
	@Test (priority = 2)
	 public void login() {
		   HomePage HP = new HomePage(driver);
		   LoginPage LP = new LoginPage(driver);
		   AccountPage AP = new AccountPage(driver);
		   //HomePage
		   
		   HP.clickloginRegisterbtn();
		   //login 
		   LP.SetLogin("kmiller_1");
		   LP.SetPswd("km123!");
		   LP.ClickLoginbtn();
		   AP.btn_cart();
	}
	
	@Test (priority=3, dependsOnMethods= {"login"})
	 public void login_addtocart() {
		   HomePage HP = new HomePage(driver);
		   AddtoCartPage ACP = new AddtoCartPage(driver);
		   GuestPage GP = new GuestPage(driver);
		   //delete an item
		   ACP.delete();
		   HP.CheckOutbtn();
		   GP.ConfirmOrderbtn();
		   String text = GP.getConfirmmsg();
		   Assert.assertEquals(text, "YOUR ORDER HAS BEEN PROCESSED!");
		   logger.info("order processed validated");
		   ACP.ctn_btn();
		   }
	@Test (priority=4)
	 public void login_item_in_cart() {
		   AddtoCartPage ACP = new AddtoCartPage(driver);
		   AccountPage AP = new AccountPage(driver);
		   //empty cart after item deletion 
		   AP.btn_cart();
		   String text = ACP.emptycartverf();
		   Assert.assertEquals(text,"Your shopping cart is empty!");
		   logger.info("empty cart validated");
		   ACP.ctn_btn();
		   String txt = ACP.homepageverf();
		   Assert.assertEquals(txt,"Welcome to the Automation Test Store!");
		   logger.info("Home Page validated");}
}
