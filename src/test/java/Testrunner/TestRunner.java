package Testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions( 
					//features= {"C:\\Users\\justi\\eclipse-workspace\\CucumberDemoo\\src\\test\\java\\Featurefiles"}, 
					//features= {"C:\\Users\\justi\\eclipse-workspace\\CucumberDemoo\\src\\test\\java\\Featurefiles\\LoginDDT.feature"},
					//features= {"@target/rerun.txt"},
		            features= {"C:\\Users\\justi\\eclipse-workspace\\CucumberDemoo\\src\\test\\java\\Featurefiles\\Searchproduct.feature"},
					glue="Stepdefinitions",
					dryRun = false,
					//publish=true,
					monochrome=false,
					plugin = {"pretty","html:reports/cucureport.html",
							  "rerun:target/rerun.txt",
							  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
					//tags = "@regression" 
					
			    )
public class TestRunner {
	
}
