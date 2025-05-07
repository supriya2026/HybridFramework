package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
    	super(driver);
    }
    @FindBy(xpath="//input[@id='loginFrm_loginname']") WebElement txtLogin;
    @FindBy(xpath="//input[@id='loginFrm_password']") WebElement txtPswd;
    @FindBy(xpath="//button[@title='Login']") WebElement Loginbtn;
    @FindBy(xpath="//div[@class='alert alert-error alert-danger']") WebElement errormsg;
    
  
  
   
  public void SetLogin(String login) {
   	 txtLogin.sendKeys(login);
    }
  public void SetPswd(String pswd) {
   	 txtPswd.sendKeys(pswd);
    }
  public void ClickLoginbtn() {
 	 Loginbtn.click();     }
  
 
  public String Errormsgconf() {
	try {
		return(errormsg.getText());
	}
	catch(Exception e) {
		return(e.getMessage());
	}
 }
}
