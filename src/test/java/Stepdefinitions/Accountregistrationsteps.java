package Stepdefinitions;

import java.util.Map;

import Factory.Baseclass;
import Pageobjects.AccountRegistrationPage;
import Pageobjects.BasePage;
import Pageobjects.HomePage;
import Pageobjects.MyAccountPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Data;
import junit.framework.Assert;

public class Accountregistrationsteps {
	HomePage hp;
	AccountRegistrationPage ac;
	MyAccountPage myac;
	
	@Given("the user navigates to Register Account page")
	public void the_user_navigates_to_register_account_page() {
		hp=new HomePage(Baseclass.getDriver());
		hp.clickMyAccount();
		hp.clickRegister();
	    
	}

	@When("the user enters the details into below fields")
	public void the_user_enters_the_details_into_below_fields(io.cucumber.datatable.DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
		ac = new AccountRegistrationPage(Baseclass.getDriver());
	  ac.setFirstName(dataMap.get("firstName"));
	  ac.setLastName(dataMap.get("lastName"));
	  ac.setEmail(Baseclass.randomString()+"@gmail.com");
	  ac.setTelephone(dataMap.get("telephone"));
	  ac.setPassword(dataMap.get("password"));
	  ac.setConfirmPassword(dataMap.get("password"));
	 
	 
	  
	}

	@When("the user selects Privacy Policy")
	public void the_user_selects_privacy_policy() {
		 ac.setPrivacyPolicy();
	}

	@When("the user clicks on Continue button")
	public void the_user_clicks_on_continue_button() {
		 ac.clickContinue();
	}

	@Then("the user account should get created successfully")
	public void the_user_account_should_get_created_successfully() { 
	org.junit.Assert.assertEquals(ac.getConfirmationMsg(), "Your Account Has Been Created!");
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
