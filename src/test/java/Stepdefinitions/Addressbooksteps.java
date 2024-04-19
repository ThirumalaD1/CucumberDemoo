package Stepdefinitions;

import org.junit.Assert;

import Factory.Baseclass;
import Pageobjects.HomePage;
import Pageobjects.MyAccountPage;
import io.cucumber.java.en.Then;


public class Addressbooksteps {
	HomePage hp;
	MyAccountPage mp;
	

	@Then("click on My account dropdown option")
	public void click_on_my_account_dropdown_option() {
	    hp = new HomePage(Baseclass.getDriver());
		hp.clickMyAccount();
	}
	@Then("click on the Myaccount option")
	public void click_on_the_myaccount_option() {
	   mp = new MyAccountPage(Baseclass.getDriver());
		mp.clickMyaccountoption();
	}
	
		
	@Then("click on the Modify your address book entries link")
	public void click_on_the_modify_your_address_book_entries_link() {
	    mp.click_modifyaddresslink();
		
	}
	@Then("verify user taken to the Addressbook entries page")
	public void verify_user_taken_to_the_addressbook_entries_page() {
	    
		
	}



}
