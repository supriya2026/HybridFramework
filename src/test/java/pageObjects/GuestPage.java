package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GuestPage extends BasePage {
	public GuestPage(WebDriver driver) {
		   super(driver);
	   }
	@FindBy(xpath="//input[@id='guestFrm_firstname']") WebElement txtFirstname;
	@FindBy(xpath="//input[@id='guestFrm_lastname']") WebElement txtLastname;
	@FindBy(xpath="//input[@id='guestFrm_email']") WebElement txtEmail;
	@FindBy(xpath="//input[@id='guestFrm_address_1']") WebElement txtAddress;
	@FindBy(xpath="//input[@id='guestFrm_city']") WebElement txtCity;
	@FindBy(xpath="//select[@id='guestFrm_zone_id']") WebElement RegionDropDown;
	@FindBy(xpath="//input[@id='guestFrm_postcode']") WebElement txtpostCode;
	@FindBy(xpath="//select[@id='guestFrm_country_id']") WebElement CountryDropDown;
	@FindBy(xpath="//button[@title='Continue']") WebElement Continuebtn;
	//@FindBy(xpath="//a[@title='Back']") WebElement backbtn;
	@FindBy(xpath="//button[@id='checkout_btn']") WebElement ConfirmOrderbtn;
	@FindBy(xpath="//span[text()=' Your Order Has Been Processed!']") WebElement Confirmationtxt;
	
	
	public void SetFirstname(String Firstname) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		WebElement element = wait.until(ExpectedConditions.visibilityOf(txtFirstname));
		txtFirstname.sendKeys(Firstname);
	}
	public void SetLastname(String Lastname) {
		txtLastname.sendKeys(Lastname);
	}
	public void SetEmail(String Email) {
		txtEmail.sendKeys(Email);
	}
	public void SetAddress(String Address) {
		txtAddress.sendKeys(Address);
	}
	public void SetCity(String city) {
		txtCity.sendKeys(city);
	}
	public void Region() {
		Select dp = new Select(RegionDropDown);
		dp.selectByIndex(2);
	}
	public void SetZipCode(String ZipCode) {
		txtpostCode.sendKeys(ZipCode);
	}
	public void Country() {
		Select dp = new Select(CountryDropDown);
		dp.selectByVisibleText("United Kingdom");
		
	}
	public void Continuebtn() {
    	Continuebtn.click();
	}
	public void ConfirmOrderbtn() {
		ConfirmOrderbtn.click();
	}
	public String getConfirmmsg() {
		try {
		return(Confirmationtxt.getText());
		}
		catch(Exception e) {
			return(e.getMessage());
		}
	}
	
	
	
	
	
	
}
