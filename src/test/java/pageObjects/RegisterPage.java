package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends BasePage {
   public RegisterPage(WebDriver driver) {
	   super(driver);
   }
   @FindBy(xpath="//button[@title='Continue']") WebElement Regbtn;
   @FindBy(xpath="//input[@id='AccountFrm_firstname']") WebElement txtFirstname;
	@FindBy(xpath="//input[@id='AccountFrm_lastname']") WebElement txtLastname;
	@FindBy(xpath="//input[@id='AccountFrm_email']") WebElement txtEmail;
	@FindBy(xpath="//input[@id='AccountFrm_address_1']") WebElement txtAddress;
	@FindBy(xpath="//input[@id='AccountFrm_city']") WebElement txtCity;
	@FindBy(xpath="//select[@id='AccountFrm_zone_id']") WebElement RegionDropDown;
	@FindBy(xpath="//input[@id='AccountFrm_postcode']") WebElement txtpostCode;
	@FindBy(xpath="//select[@id='AccountFrm_country_id']") WebElement CountryDropDown;
	@FindBy(xpath="//input[@id='AccountFrm_loginname']") WebElement txtLoginname;
	@FindBy(xpath="//input[@id='AccountFrm_password']") WebElement txtpswd;
	@FindBy(xpath="//input[@id='AccountFrm_confirm']") WebElement txtconfpswd;
	@FindBy(xpath="//input[@id='AccountFrm_newsletter0']") WebElement subscribebtn;
	@FindBy(xpath="//input[@id='AccountFrm_agree']") WebElement agreebtn;
	@FindBy(xpath="//button[@title='Continue']") WebElement RegContinuebtn;
	@FindBy(xpath="//span[.=' Your Account Has Been Created!']") WebElement Confirmationtxt;
	@FindBy(xpath="//a[@title=\"Continue\"]") WebElement Continuebtn;
	@FindBy(xpath="//div[@class='alert alert-error alert-danger']") WebElement ErrorMsg;
	
	
	
	
	public void ClickRegesiterContinuebtn() {
   	 Regbtn.click();  }
	public void SetFirstName(String firstname) {
		txtFirstname.sendKeys(firstname);
	}
	public void SetLastName(String lastname) {
		txtLastname.sendKeys(lastname);
	}
	
	public void SetEmail(String email) {
		txtEmail.sendKeys(email);
	}
	public void Country() {
		Select dp = new Select(CountryDropDown);
		dp.selectByVisibleText("United States");
		
	}
	public void SetAddress(String address) {
		txtAddress.sendKeys(address);
	}
	
	public void SetCity(String city) {
		txtCity.sendKeys(city);
	}
	public void Region(String state) {
		Select dp = new Select(RegionDropDown);
		List<WebElement> op = dp.getOptions();
		
		for(WebElement option:op) {
			
			String text = option.getText();
			System.out.println(text);
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
			List<WebElement> opt = wait.until(ExpectedConditions.visibilityOfAllElements(op));
			
			if(text.equals(state)){
				
		       dp.selectByContainsVisibleText(state);
		       }
			
			}
		
	}
	public void SetZipcode(String zipcode) {
		
		
		txtpostCode.sendKeys(zipcode);
	}
	/*public void Country() {
		Select dp = new Select(CountryDropDown);
		dp.selectByVisibleText("United States");
		
	}*/
	
	public void SetLoginName(String loginname) {
		txtLoginname.sendKeys(loginname);
	}
	
	public void SetPassword(String pswd) {
		 txtpswd.sendKeys(pswd);
	}
	
	public void SetConfPassword(String confpswd) {
		txtconfpswd.sendKeys(confpswd);
	}
	public void Subscriptionbtn() {
    	subscribebtn.click();
	}
	public void PolicyAgreebtn() {
    	agreebtn.click();
	}
	public void RegContinuebtn() {
    	RegContinuebtn.click();
	}
	public boolean ConfErrorMsg() {
		try{return (ErrorMsg.isDisplayed());}
		catch(Exception e){
			return (false);
		}
	}
	public String getConfmsg() {
		try {
			return(Confirmationtxt.getText());
		}
		catch(Exception e) {
			return(e.getMessage());
		}
	}
	public void Continuebtn() {
    	Continuebtn.click();
	}
	public String getFirstName() {
		return(txtFirstname.getText());
	}
	
	
	
	
}
