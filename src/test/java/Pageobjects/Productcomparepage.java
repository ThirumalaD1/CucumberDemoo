package Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Productcomparepage extends BasePage {
	WebDriver driver;
	
	public Productcomparepage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath="//a[normalize-space()='Product Comparison']") WebElement productComparison;

	@FindBy(xpath="//a[normalize-space()='Continue']") WebElement continue_btn;
	
	
	public boolean productcomparisionpagenavigated() {
	try {
		return productComparison.isDisplayed();
	} catch (Exception e) {
		return false;
	}
	}

	public void click_continuebtn() {
		continue_btn.click();
	}

}
