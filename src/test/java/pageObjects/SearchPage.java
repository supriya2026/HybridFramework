package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {
     public SearchPage(WebDriver driver){
    	 super(driver);
     }
     @FindBy(id="filter_keyword") WebElement txt_search;
     @FindBy(id="option347765") WebElement btn_color;
     @FindBy(xpath="//ul[@id='search-category']/li[6]") WebElement search_fromdropdown;
   
     
     public void search_bar(String item){
    	 txt_search.sendKeys(item);
    	 Actions action = new Actions(driver);
    	 action.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
     }
     public void select_color() {
    	 btn_color.click();
     }
    /* public void search_dropdown_menu() {
    	 search_fromdropdown.click();
     }*/
}
