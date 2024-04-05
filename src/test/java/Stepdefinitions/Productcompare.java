package Stepdefinitions;

import org.junit.Assert;

import Factory.Baseclass;
import Pageobjects.HomePage;
import Pageobjects.Productcomparepage;
import Pageobjects.ShowallDesktopcategorypage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Productcompare {

	HomePage hp;
	ShowallDesktopcategorypage sd;
	Productcomparepage pcp;
	
	@When("user Hover on the Desktop option")
	public void user_hover_on_the_desktop_option() throws InterruptedException {
	hp = new HomePage(Baseclass.getDriver());
	if (hp.isDesktopexist()) {
		Thread.sleep(2000);
		hp.hoverdesktopoptions();
	} else {
Assert.fail();
	}
	
	
	}
	@When("select the All desktop option")
	public void select_the_all_desktop_option() {
		hp.click_ShowallDsektops();    
	}
	@Then("verify user navigated to the desktop page")
	public void verify_user_navigated_to_the_desktop_page() {
	  sd = new ShowallDesktopcategorypage(Baseclass.getDriver());
	  Assert.assertEquals(sd.checkdesktopcategorypagenavigated(), true);
	}
	
	@Then("click on the product compare link")
	public void click_on_the_product_compare_link() {
	   sd.productcomparelink(); 
	}
	
	@Then("verify user redirecting to the Product comparision page")
	public void verify_user_redirecting_to_the_product_comparision_page() {
	  pcp = new Productcomparepage(Baseclass.getDriver());
	 Assert.assertEquals(pcp.productcomparisionpagenavigated(), true);
	}
	@Then("click on the continue button")
	public void click_on_the_continue_button() {
		pcp.click_continuebtn();
	}
	@Then("verify user redirected to the Homepage")
	public void verify_user_redirected_to_the_homepage() {
	    String Homepage_title = Baseclass.getDriver().getTitle();
	    Assert.assertEquals(Homepage_title,"Your Store");
	}
}
