package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.GuestPage;
import pageObjects.HomePage;
import pageObjects.SearchPage;
public class TC001_GuestPageTest extends BasePageTest {
	@Test (priority=1)
	public void HomePage() {
		
		HomePage HP = new HomePage(driver);
		HP.Currency();
		HP.SelectCurrency();
		HP.Makeup();
        HP.LipsFromDropDown();
		HP.SortByDropDown();
		HP.ItemSelection();
		HP.AddToCartbtn();
		HP.CheckOutbtn();
		HP.GuestCheckOutbtn();
		HP.Continuebtn();
	}
	@Test (priority=2, dependsOnMethods= {"HomePage"})
	public void GuestPage() {
		
		GuestPage GP = new GuestPage(driver);
		GP.SetFirstname("james");
		GP.SetLastname("smith");
		GP.SetEmail("abc@123.com");
		GP.SetAddress("mbjjhb jgkhj jg");
		GP.SetCity("city");
		GP.Region();
		GP.SetZipCode("123456");
		GP.Country();
		GP.Continuebtn();
		GP.ConfirmOrderbtn();
		String text = GP.getConfirmmsg();
		Assert.assertEquals(text, "YOUR ORDER HAS BEEN PROCESSED!");
		
		
		
	}
	
}


