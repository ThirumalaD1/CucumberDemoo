package Pageobjects;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage
{   
	WebDriver driver;
	

	
	public SearchPage(WebDriver driver)
	{
		super(driver);
		
	}	
	
		@FindBy(xpath="//*[@id='content']/div[3]//img")
		List<WebElement> searchProducts;
				
		@FindBy(xpath="//input[@id='input-quantity']")
		WebElement txtquantity;
		
		@FindBy(xpath="//button[@id='button-cart']")
		WebElement btnaddToCart;
		
		@FindBy(xpath="//div[contains(text(),'Success: You have added')]")
		WebElement cnfMsg;
		
		@FindBy(xpath="//div[@id='content']/*/div[2]/h1")
		WebElement productname;
		
		@FindBy(xpath="//div[@class='col-sm-4']//ul[1]//li[1]/a") WebElement productBrand;
		
		@FindBy(xpath="//li[normalize-space()='Product Code: product 11']") WebElement productcode;
        
		@FindBy(xpath="//input[@id='input-search']") WebElement searchCriteria;
		
		@FindBy(xpath="//input[@id='button-search']")  WebElement search_btn;
		
		@FindBy(xpath="//button[@class='btn btn-default']//i[@class='fa fa-exchange']") WebElement compareproduct;
		
		@FindBy(xpath="//div[@class='tooltip-inner']")  WebElement compareproducttooltip;
		
		@FindBy(xpath="//div/a[contains(text(),'product comparison')]") WebElement productcomptxt;
		
		
		
		public void setsearchcriteria(String searchcri)
		{
			
			searchCriteria.sendKeys(searchcri);
			
		}
		
		public void searchcri_btn() {
			search_btn.click();
		}
		
		public boolean isProductExist(String productName)
		{
			boolean flag=false;
			for(WebElement product:searchProducts)
			{				
				if(product.getAttribute("title").equals(productName))
				{
				flag=true;
				break;
				}
			}
			
			return flag;
		
		}
		
		public void selectProduct(String productName)
		{
			for(WebElement product:searchProducts)
			{				
				if(product.getAttribute("title").equals(productName))
				{
					product.click();
				}
			}
		
		}
		
		public void setQuantity(String qty)
		{
			txtquantity.clear();
			txtquantity.sendKeys(qty);
		}
		
		public void addToCart()
		{
			btnaddToCart.click();
		}
		
		public boolean checkConfMsg()
		{
			try
			{
			return cnfMsg.isDisplayed();
			}
			catch(Exception e)
			{
				return false;
			}
		}
		
		public boolean getproductname(String prodn) {
			if (productname.getText().equals(prodn)) {
				return true;
				//return productname.isDisplayed();
			} else {
              return false;
			}
		}
		
		public boolean getproductBrand(String prodb) {
			if (productBrand.getText().equals(prodb)) {
				return productBrand.isDisplayed();
			} else {
              return false;
			}
		}
		
		public boolean getproductcode(String prodc) {
			System.out.println(productcode.getText());
			if (productcode.getText().equals(prodc)) {
				return productcode.isDisplayed();
			} else {
              return false;
			}
		}
		
		public boolean searchcriteriaplaceholder() {
			try {
				
			
			if (searchCriteria.getAttribute("placeholder").equals("Keywords")) {
				return true;
				}
				else {
					return false;
				}
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		
		public boolean checkproductcomplink() {
			try {
			return	productcomptxt.isDisplayed();
			} catch (Exception e) {
		return false;
			}
			
		}
		
		public boolean chechcompareprodtooltip() {
			
			try {
				act.moveToElement(compareproduct).build().perform();
				return compareproducttooltip.isDisplayed();	
			} catch (Exception e) {
				return false;
			}
			
		}
		
		public void clickcomparebutton() {
			compareproduct.click();
		}
		
public void click_prodcomplink() {
	productcomptxt.click();
}
		
public void set() {
	
}



}
