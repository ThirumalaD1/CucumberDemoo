package Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShowallDesktopcategorypage extends BasePage {
	
	public ShowallDesktopcategorypage(WebDriver driver) {
		super(driver);
	}

	
@FindBy(xpath="//ul[@class='breadcrumb']//a[contains(text(),'Desktops')]") WebElement desktopslink;
	
@FindBy(xpath="//a[@id='compare-total']") WebElement productComparelink;

public boolean checkdesktopcategorypagenavigated() {
	try {
		 return desktopslink.isDisplayed();
	} catch (Exception e) {
		return false;
	}
}

public void productcomparelink() {
	productComparelink.click();
}
	
}
