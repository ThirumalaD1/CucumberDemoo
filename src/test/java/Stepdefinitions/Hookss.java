package Stepdefinitions;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.gherkin.model.Scenario;

import Factory.Baseclass;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;

public class Hookss {
	public WebDriver driver;
	Properties p;
	
	@Before
	public void setup() throws IOException {
	 driver = Baseclass.initializebrowser();
	 Properties p = Baseclass.getProperties();
	 driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
	}
		
	@After	
	public void teardown(io.cucumber.java.Scenario scenario) {
		
		driver.quit();
		
	}
	@AfterStep
	public void addscreencapture(io.cucumber.java.Scenario scenario) {
		if (scenario.isFailed()) {
			TakesScreenshot ts=(TakesScreenshot)driver;
			byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png",scenario.getName());
				
		}
		
	}
	
	
	
	
	}
	
	
	
	
	
	
	
	
	

