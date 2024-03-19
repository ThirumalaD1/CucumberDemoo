package Stepdefinitions;

import org.junit.Assert;

import Factory.Baseclass;
import Pageobjects.HomePage;
import Pageobjects.SearchPage;
import io.cucumber.java.en.Then;

public class Searchproduct {
	HomePage hp;

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
	  SearchPage sp = new SearchPage(Baseclass.getDriver());
	  boolean productex = sp.isProductExist("MacBook Pro");
	  
	  Assert.assertEquals(productex, true);
	}


	
}
