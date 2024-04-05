package Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	WebDriver driver;
	
		public HomePage(WebDriver driver) {
		super(driver);
	}

	// Elements
	@FindBy(xpath = "//span[text()='My Account']")
	WebElement lnkMyaccount;

	@FindBy(linkText = "Register")
	WebElement lnkRegister;

	@FindBy(linkText = "Login")   // Login link added in step6
	WebElement linkLogin;
	
	@FindBy(xpath="//input[@placeholder='Search']")  //For Search Product Test
	WebElement txtSearchbox;
	
	@FindBy(xpath="//div[@id='search']//button[@type='button']") //For Search Product Test
	WebElement btnSearch;
	
	@FindBy(xpath="//a[normalize-space()='Desktops']") WebElement desktops;
	
	@FindBy(xpath="//a[normalize-space()='Show All Desktops']") WebElement showAllDesktops;

	@FindBy(xpath="//ul[@class='breadcrumb']//a[contains(text(),'Desktops')]") WebElement desktopslink;
	
	@FindBy(xpath="//a[@id='compare-total']") WebElement productComparelink;
	
	
	// Action Methods
	public void clickMyAccount() {
		lnkMyaccount.click();
	}

	public void clickRegister() {
		lnkRegister.click();
	}
	
	public void clickLogin()    // added in step6
	{
		linkLogin.click();
	}
	
	public void enterProductName(String pName)   //For Search Product Test
	{
		txtSearchbox.sendKeys(pName);
	}
	
	public void clickSearch()  //For Search Product Test
	{
		btnSearch.click();
	}
	
	public boolean checksearchfieldplaceholdertext() {
		try {
		if (txtSearchbox.getAttribute("placeholder").equals("Search")) {
			return true;
		}else {
			return false;
		}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}		
	}
	
	public boolean isDesktopexist() {
		try {
		return desktops.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public void hoverdesktopoptions() {
		try {
			act.moveToElement(desktops).perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void click_ShowallDsektops() {
		showAllDesktops.click();
	}
	
	
	
}
