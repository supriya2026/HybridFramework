package pageObjects;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
	public HomePage(WebDriver driver) {
		   super(driver);
	   }
	@FindBy(xpath="//ul[@id='customer_menu_top']//li[.='Login or register']") WebElement LoginOrRegister;
	@FindBy(xpath="//ul[@class='nav language pull-left']") WebElement Currency;
	@FindBy(xpath="//ul[@class='dropdown-menu currency\']/li[1]") WebElement SelectCurrency;
	@FindBy(xpath="//ul[@class='nav-pills categorymenu']/li[3]") WebElement Makeup;
	@FindBy(xpath="//ul[@class='nav-pills categorymenu']/li[3]//li[4]") WebElement MakeupDropDownLips;
	@FindBy(xpath="//select[@id='sort']") WebElement SortByDropDown;
	@FindBy(xpath="//div[@class='thumbnails grid row list-inline']/div[1]") WebElement ItemSelection;
	@FindBy(xpath="//select[@id='option305']") WebElement ColorSelection;
	@FindBy(xpath="//ul[@class='productpagecart']//a") WebElement AddToCartbtn;
	@FindBy(xpath="//a[@id='cart_checkout2']") WebElement CheckOutbtn;
	@FindBy(xpath="//input[@id='accountFrm_accountguest']") WebElement GuestCheckOutbtn;
	@FindBy(xpath="//button[@title='Continue']") WebElement Continuebtn;
	
	public void clickloginRegisterbtn() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		WebElement element = wait.until(ExpectedConditions.visibilityOf(LoginOrRegister));
		element.click();
	}
	public void Currency() {
		Currency.click();
	}
	public void SelectCurrency() {
		SelectCurrency.click();
	}
	public void Makeup() {
		/*WebDriverWait wait = new WebDriverWait(Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.visibilityOf(Makeup))*/
		Actions ac = new Actions(driver);
		ac.moveToElement(Makeup).perform();
	}
	
	public void LipsFromDropDown() {
		
		MakeupDropDownLips.click();
	}
	public void SortByDropDown() {
		Select dp = new Select(SortByDropDown);
		dp.selectByVisibleText("Price Low > High");
	}
	public void ItemSelection() {
		ItemSelection.click();
	}
	public void Colorselection() {
		Select dp = new Select(SortByDropDown);
		dp.selectByVisibleText("Viva Glam II");
	}
	public void AddToCartbtn() {
		AddToCartbtn.click();
	}
	public void CheckOutbtn() {
		CheckOutbtn.click();
	}
	public void GuestCheckOutbtn() {
		GuestCheckOutbtn.click();
	}
	public void Continuebtn() {
    	Continuebtn.click();
	}
	
	
	
}

