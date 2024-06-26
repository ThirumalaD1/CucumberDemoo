package Testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions( 
					//features= {"C:\\Users\\justi\\eclipse-workspace\\CucumberDemoo\\src\\test\\java\\Featurefiles"}, 
					//features= {"C:\\Users\\justi\\eclipse-workspace\\CucumberDemoo\\src\\test\\java\\Featurefiles\\Login.feature"},
					//features= {"@target/rerun.txt"},
		              //features= {"C:\\Users\\justi\\eclipse-workspace\\CucumberDemoo\\src\\test\\java\\Featurefiles\\Productcompare.feature"},
		            //features= {"C:\\Users\\justi\\eclipse-workspace\\CucumberDemoo\\src\\test\\java\\Featurefiles\\Searchproduct.feature"},
					//features= {"C:\\Users\\justi\\eclipse-workspace\\CucumberDemoo\\src\\test\\java\\Featurefiles\\Addtocart.feature"},
		          //  features= {"C:\\Users\\justi\\eclipse-workspace\\CucumberDemoo\\src\\test\\java\\Featurefiles\\Searchproduct.feature"},
		            //features= {"C:\\Users\\justi\\eclipse-workspace\\CucumberDemoo\\src\\test\\java\\Featurefiles\\Wishlist.feature"},
		              //features= {"C:\\Users\\justi\\eclipse-workspace\\CucumberDemoo\\src\\test\\java\\Featurefiles\\Forgotpassword.feature"},              
		             features= {"C:\\Users\\justi\\eclipse-workspace\\CucumberDemoo\\src\\test\\java\\Featurefiles\\Myaccount.feature"},
		glue="Stepdefinitions",
					dryRun =false,
					//publish=false,
					monochrome=false,
					plugin = {"pretty","html:reports/cucureport.html",
							  "rerun:target/rerun.txt",
							  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
					//tags = "@regression" 
					
			    )

public class TestRunner {
	
}
