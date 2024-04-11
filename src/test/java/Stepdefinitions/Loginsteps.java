package Stepdefinitions;



import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Factory.Baseclass;
import Pageobjects.HomePage;
import Pageobjects.LoginPage;
import Pageobjects.MyAccountPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.DataReader;

public class Loginsteps {
	LoginPage lp;
	HomePage hp;
	MyAccountPage macc;
	boolean target;
	List<HashMap<String, String>> datamap;
	

	@Given("user navigate to the login page")
	public void user_navigate_to_the_login_page() throws IOException {
		Baseclass.getlogger().info("Nav to login page");
	   hp = new HomePage(Baseclass.getDriver());
	   hp.clickMyAccount();
	   hp.clickLogin();
	}

	@When("user entered valid username and password \\(username={string}, password={string}")
	public void user_entered_valid_username_and_password_username_password(String usernam, String pwd) {
		Baseclass.getlogger().info("Entering username and pass");
		lp = new LoginPage(Baseclass.getDriver());  
	 lp.setEmail(usernam);
	 lp.setPassword(pwd);
	}

	@When("click on the login button")
	public void click_on_the_login_button() {
		Baseclass.getlogger().info("Clicking on login button");
		lp.clickLogin();
	
	}

	@Then("user should see the Myaccountpage")
	public void user_should_see_the_myaccountpage() {
		Baseclass.getlogger().info("Checking myaccount page existense");
	 macc = new MyAccountPage(Baseclass.getDriver());
	Assert.assertEquals(macc.isMyAccountPageExists(), true);
		}

	
	

	

	
	@When("user entered valid username as {string} and password as {string}")
	public void user_entered_valid_username_as_and_password_as(String usernam, String pwd) {
		Baseclass.getlogger().info("Entering username and pass");
		lp = new LoginPage(Baseclass.getDriver());  
	 lp.setEmail(usernam);
	 lp.setPassword(pwd);
	}
	
    // Data driven login with excel	

	@Then("user redirecting to the Myaccount by passing email and password with excel row\"{int}\"")
	public void user_redirecting_to_the_myaccount_by_passing_email_and_password_with_excel_row(Integer rows) {
	    
		
		String path="C:\\Users\\justi\\eclipse-workspace\\CucumberDemoo\\test data\\Opencart_LoginData.xlsx";
	    datamap = DataReader.data(path, "Sheet1");
	    
	    int index = rows-1;
	   String email1 = datamap.get(index).get("username");
	    String pass1 = datamap.get(index).get("password");
	  String exp = datamap.get(index).get("res");
	    
	    lp=new LoginPage(Baseclass.getDriver());
	    lp.setEmail(email1);
	    lp.setPassword(pass1);
	    lp.clickLogin();
	    macc=new MyAccountPage(Baseclass.getDriver());
	    target = macc.isMyAccountPageExists();
	    
	    if (exp.equalsIgnoreCase("Valid")) {
			if (target==true) {
				macc.clickLogout();
				Assert.assertTrue(true);
			}else if (target==false) {
				Assert.fail();
			}
		
		}
	    if (exp.equalsIgnoreCase("Invalid")) {
	    	if (target==true) {
				macc.clickLogout();
				Assert.assertTrue(false);
			}else if (target==false) {
				Assert.assertTrue(true);;
			}
		}
	}
	    
	    @Given("click Forgotten Password link from Login page \\(Validate ER-{int})")
		public void click_forgotten_password_link_from_login_page_validate_er(Integer int1) {
		    
		}
		@Given("enter the email address of an existing account for which you have forgot the password")
		public void enter_the_email_address_of_an_existing_account_for_which_you_have_forgot_the_password() {
		    
		}
		@Given("Click on Continue button")
		public void click_on_continue_button() {
		    
		}
		@Given("Check the registered email address for which the password got reset")
		public void check_the_registered_email_address_for_which_the_password_got_reset() {
		    
		}
		@Given("Click on the link for resseting the password from the received email body")
		public void click_on_the_link_for_resseting_the_password_from_the_received_email_body() {
		    
		}
		@Given("Enter new password as {string} into the password and Confirm fields")
		public void enter_new_password_as_into_the_password_and_confirm_fields(String string) {
		    
		}
		@Given("Enter the email address into the E-Mail address field and the new resetted password into the Password field")
		public void enter_the_email_address_into_the_e_mail_address_field_and_the_new_resetted_password_into_the_password_field() {
		    		}
		@Given("Click on Login button")
		public void click_on_login_button() {
		    
		}

		
	
	}

	



		
		
	





	
	

