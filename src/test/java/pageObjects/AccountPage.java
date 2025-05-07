package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage extends BasePage{
     public AccountPage(WebDriver driver) {
  	   super(driver);
     }
     @FindBy(xpath="//ul[@class='side_account_list']//li[10]") WebElement Logout;
     @FindBy(xpath="//span[.=' Account Logout']") WebElement Confirmationtxt;
     @FindBy(xpath="//a[@title='Continue']") WebElement Continuebtn;
    @FindBy(xpath="//span[starts-with(text(),' My Account')]") WebElement myaccountdisplay;
    @FindBy(xpath="//ul[@id='main_menu_top']/li[3]") WebElement cart;
  
    
   
     public void clickLogoutbtn() {
   	  Logout.click();
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
		public boolean isAccountPageExists() {
				//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
				//WebElement opt = wait.until(ExpectedConditions.visibilityOf(myaccountdisplay));
				try {
					return(myaccountdisplay.isDisplayed());
				}
				catch(Exception e) {
					return false;
				}
		}
		public void btn_cart() {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
			WebElement element = wait.until(ExpectedConditions.visibilityOf(cart));
			element.click();
		}
}
