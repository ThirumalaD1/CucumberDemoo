package Stepdefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

import Factory.Baseclass;
import Pageobjects.HomePage;
import Pageobjects.SearchPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Searchproduct {
	public HomePage hp;
	SearchPage sp;
	Map<String, String> datam;

	@Then("Click on the search button")
	public void click_on_the_search_button() {
		hp = new HomePage(Baseclass.getDriver());
		hp.clickSearch(); 
	}    
	
	@When("user set the quantity")
	public void user_set_the_quantity() {
		sp.setQuantity("2");
	    
	}
	@When("add the product to the cart")
	public void add_the_product_to_the_cart() {
	    sp.addToCart();
	}
	@Then("validate the confirmation message is displayed")
	public void validate_the_confirmation_message_is_displayed() {
	   Assert.assertEquals(sp.checkConfMsg(),true);
	   
	}
	

	@When("user enter product name in search criteria and click on search button")
	public void user_enter_product_name_in_search_criteria_and_click_on_search_button() {
		sp = new SearchPage(Baseclass.getDriver());
		sp.setsearchcriteria("mac");
		sp.searchcri_btn();
	}
	
	
	@When("user enter the below given product name in search criteria and click on search button")
	public void user_enter_the_below_given_product_name_in_search_criteria_and_click_on_search_button(io.cucumber.datatable.DataTable dataTable) {
	   datam = dataTable.asMap(String.class, String.class);
	   sp = new SearchPage(Baseclass.getDriver());
		sp.setsearchcriteria(datam.get("Productname"));
		sp.searchcri_btn();
	}


	@Then("check the product search field placeholder is displayed on the app when no text is entered")
	public void check_the_product_search_field_placeholder_is_displayed_on_the_app_when_no_text_is_entered() {
		hp = new HomePage(Baseclass.getDriver());
		Assert.assertEquals(hp.checksearchfieldplaceholdertext(),true);
	}
	@Then("check the search criteria field placeholder text is displayed on the app when no text is entered")
	public void check_the_search_criteria_field_placeholder_text_is_displayed_on_the_app_when_no_text_is_entered() {
		sp = new SearchPage(Baseclass.getDriver());
	    Assert.assertEquals(sp.searchcriteriaplaceholder(),true);
		
	}

	
	@When("user select the product to open")
	public void user_select_the_product_to_open() {
		if (sp.isProductExist("iPhone")) {
			sp.selectProduct("iPhone");
		}else {
			System.out.println("No matching found for product");
		}  
	  
	}
	@Then("user should see the below details of the product in the product details page")
	public void user_should_see_the_below_details_of_the_product_in_the_product_details_page(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
	     datam = dataTable.asMap(String.class,String.class);
	   // String ppn = datam.get("productname");
	    //System.out.println(ppn);
	    Thread.sleep(5000);
	     boolean st = sp.getproductname(datam.get("Productname"));
	    boolean pb = sp.getproductBrand(datam.get("Productbrand"));
	  boolean pc = sp.getproductcode(datam.get("Productcode"));
	  
	    try {
	Assert.assertEquals(st, true);	
	Assert.assertEquals(pb,true);
	Assert.assertEquals(pc,true);
	} catch (Exception e) {
		e.printStackTrace();
		Assert.fail();
		
	}	
	    
		
	}

	@Given("user enter the product name {string} in the search")
	public void user_enter_the_product_name_in_the_search(String pname) {
		 hp = new HomePage(Baseclass.getDriver());
			hp.enterProductName(pname);
  
	}
	@Then("user should see the product {string} in the result")
	public void user_should_see_the_product_in_the_result(String pname ) {
		sp = new SearchPage(Baseclass.getDriver());
		  boolean productex = sp.isProductExist(pname);
		  
		  Assert.assertEquals(productex, true); 
	}
	@When("user select the product {string} to open")
	public void user_select_the_product_to_open(String pname) {
		if (sp.isProductExist(pname)) {
			sp.selectProduct(pname);
		}else {
			System.out.println("No matching found for product");
		}  
	  
		
	}

	
	@When("Hover on the product compare and check product tooltip msg should display")
	public void hover_on_the_product_compare_and_check_product_tooltip_msg_should_display() {
		sp=new SearchPage(Baseclass.getDriver());
		
		Assert.assertEquals(sp.chechcompareprodtooltip(),true);
	}
	
	@Then("click on the product compare option")
	public void click_on_the_product_compare_option() {
	    sp.clickcomparebutton();
		
	}
	
	@Then("click on the comparision link")
	public void click_on_the_comparision_link() {
	    sp.click_prodcomplink();
	}



	
	
}
