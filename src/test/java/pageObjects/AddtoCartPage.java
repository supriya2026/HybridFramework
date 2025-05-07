package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddtoCartPage extends BasePage {
     public AddtoCartPage(WebDriver driver) {
    	 super(driver);
     }
   
     @FindBy(xpath="//a[contains(.,'Continue')]") WebElement btn_continueshopping;
     @FindBy(xpath="//div[@class='thumbnails grid row list-inline']/div[2]") WebElement btn_itemselection;
     @FindBy(xpath="//h4[@class='heading4']//a") WebElement btn_editcart;
     @FindBy(xpath="(//a[@class='btn btn-sm btn-default'])[1]") WebElement btn_delete;
     @FindBy(xpath="//div[contains(text(),'empty')]") WebElement txt_cartempty;
     @FindBy(xpath="(//a[@title='Continue'])") WebElement btn_continue;
     @FindBy(xpath="(//h4[contains(text(),'Welcome to the Automation Test Store!')])[1]") WebElement txt_homeverf;
       
     public void continueshopping() {
    	 btn_continueshopping.click();
     }
     public void itemselection() {
    	 btn_itemselection.click();
     }
     public void editCart() {
    	 btn_editcart.click();
     }
     public void delete() {
    	 btn_delete.click();
     }
     
     public String emptycartverf() {
    	 // to extract only parent text not child text
           JavascriptExecutor js = (JavascriptExecutor) driver;
           String directtxt = (String) js.executeScript(
        		   "var element = arguments[0];"+
                   "var childNodes = element.childNodes;"+
        		   "var text = '';"+
                   "for(var i=0 ;i<childNodes.length;i++){"
                    + "if (childNodes[i].nodeType === Node.TEXT_NODE) {"+
                       "   text += childNodes[i].textContent;"+
                    " }"+
                       "}"+
                    "return text.trim();",txt_cartempty);
           
           return directtxt;
     
     }
     
     public void ctn_btn() {
    	 btn_continue.click();
     }
     
     public String homepageverf() {
    	 JavascriptExecutor js = (JavascriptExecutor) driver;
         String directtxt = (String) js.executeScript(
      		   "var element = arguments[0];"+
                 "var childNodes = element.childNodes;"+
      		      "for(var i=0 ;i<childNodes.length;i++){"
                  + "if (childNodes[i].nodeType === Node.TEXT_NODE) {"+
                  "     return childNodes[i].textContent.trim();"+
                  " }"+
                     "}"+
                  "return ' ';",txt_homeverf);
         
         return directtxt;
    	 /*try {
    		   WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
    			WebElement element = wait.until(ExpectedConditions.visibilityOf(txt_homeverf));
    			return(element.getText());
    			}
    			catch(Exception e) {
    				return(e.getMessage());
    			}*/
     }
     
}
