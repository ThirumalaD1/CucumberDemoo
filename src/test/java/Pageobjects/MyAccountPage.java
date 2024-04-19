package Pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h2[text()='My Account']") // MyAccount Page heading
	WebElement msgHeading;
	
	@FindBy(xpath = "//div[@class='list-group']//a[text()='Logout']")
	WebElement lnkLogout;
	
    @FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']/li/a") List<WebElement> myaccdropoptions; 
	@FindBy(xpath = "//a[text()='Modify your address book entries']") WebElement modifyyouraddressbookentry;

	@FindBy(xpath="//h2[text()='Address Book Entries']") WebElement Addresspagetext; 
	public boolean isMyAccountPageExists()   // MyAccount Page heading display status
	{
		try {
			return (msgHeading.isDisplayed());
		} catch (Exception e) {
			return (false);
		}
	}
	
	public void clickMyaccountoption() {
		for (int i = 0; i < myaccdropoptions.size(); i++) {
			if (myaccdropoptions.get(i).getText().equals("My Account")) {
				myaccdropoptions.get(i).click();
			}
		}
	}
	public void click_modifyaddresslink() {
		modifyyouraddressbookentry.click();		
	}
	
	public void myaddresspageexists() {
		
	}

	public void clickLogout() {
		lnkLogout.click();

	}
	
}
