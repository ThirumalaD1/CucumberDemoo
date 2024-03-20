package Stepdefinitions;

import org.junit.Assert;

import Factory.Baseclass;
import Pageobjects.HomePage;
import Pageobjects.SearchPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Searchproduct {
	HomePage hp;
	SearchPage sp;
	@Then("user enter the product name in the search")
	public void user_enter_the_product_name_in_the_search() {
	  
		 hp = new HomePage(Baseclass.getDriver());
		hp.enterProductName("mac");
		
	}

	@Then("Click on the search button")
	public void click_on_the_search_button() {
		hp.clickSearch(); 
	}

	@Then("user should see the product in the result")
	public void user_should_see_the_product_in_the_result() {
	  sp = new SearchPage(Baseclass.getDriver());
	  boolean productex = sp.isProductExist("MacBook Pro");
	  
	  Assert.assertEquals(productex, true);
	}
	
	@Then("select the product to open")
	public void select_the_product_to_open() {
		if (sp.isProductExist("MacBook Pro")) {
			sp.selectProduct("MacBook Pro");
		}else {
			System.out.println("No matching found for product");
		}
	    
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




	
}
