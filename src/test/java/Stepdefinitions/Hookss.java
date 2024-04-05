package Stepdefinitions;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.gherkin.model.Scenario;

import Factory.Baseclass;
import TestrailManager.Testrailm;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;

public class Hookss {
	public WebDriver driver;
	Properties p;
	public String testcaseid;
	
	@Before
	public void setup() throws IOException {
	 driver = Baseclass.initializebrowser();
	 Properties p = Baseclass.getProperties();
	 driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
	}
		
	@After	
	public void teardown(io.cucumber.java.Scenario scenario) {
		String testcaseid = "";
        System.out.println(scenario.getSourceTagNames());

        for (String s : scenario.getSourceTagNames()) {
            if (s.contains("testcaseid" )) {

                String[] res = s.split("(\\(.*?)" );

                testcaseid = res[1].substring(0, res[1].length() - 1); // Removing the last parenthesis
            }

		//driver.quit();
		if (!scenario.isFailed()) {
			Testrailm.addTestresultsforTC(testcaseid, Testrailm.Test_Rail_Pass_status, "");
		}else if (scenario.isFailed()) {
			
			Testrailm.addTestresultsforTC(testcaseid, Testrailm.Tes_Rail_Fail_status, "Failed");
			
		}
        }
		
	}
	@AfterStep
	public void addscreencapture(io.cucumber.java.Scenario scenario) {
		if (scenario.isFailed()) {
			TakesScreenshot ts=(TakesScreenshot)driver;
			byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png",scenario.getName());
				
		}
		
		
/*		private void logResultToTestRail(Scenario scenario) {
	        String caseId = "";
	        System.out.println(scenario.getSourceTagNames());

	        for (String s : scenario.getSourceTagNames()) {
	            if (s.contains("TestRail" )) {

	                String[] res = s.split("(\\(.*?)" );

	                caseId = res[1].substring(0, res[1].length() - 1); // Removing the last parenthesis
	            }
	        }

	        Map<String, Serializable> data = new HashMap<>();

	        if (!scenario.isFailed()) {
	            data.put("status_id", SUCCESS_STATE);
	            data.put("comment", SUCCESS_COMMENT);

	        } else {
	            data.put("status_id", FAIL_STATE);
	            data.put("comment", logError(scenario));
	        }

	        if (!caseId.equals("" )) {
	            try {

	                if (System.getenv("runIdTestRail" ) != null && System.getenv("runTestRailId" ).equals("" )) {
	                    runId = System.getenv("runIdTestRail" );
	                }

	                client = testRailApiClient();
	                client.sendPost("add_result_for_case/" + runId + "/" + caseId, data);
	            } catch (IOException | APIException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	//   As per https://stackoverflow.com/a/58506614/6654475
	    private static String logError(Scenario scenario) {
	        try {
	            Class clasz = ClassUtils.getClass("cucumber.runtime.java.JavaHookDefinition$ScenarioAdaptor" );
	            Field fieldScenario = FieldUtils.getField(clasz, "scenario", true);
	            if (fieldScenario != null) {

	                fieldScenario.setAccessible(true);
	                Object objectScenario = fieldScenario.get(scenario);

	                Field fieldStepResults = objectScenario.getClass().getDeclaredField("stepResults" );
	                fieldStepResults.setAccessible(true);

	                ArrayList<Result> results = (ArrayList<Result>) fieldStepResults.get(objectScenario);
	                for (Result result : results) {
	                    if (result.getError() != null) {
	                        return FAILED_COMMENT + "\n" + result.getErrorMessage();
	                    }
	                }
	            }

	            return FAILED_COMMENT;

	        } catch (IllegalAccessException | NoSuchFieldException | ClassNotFoundException e) {
	            return FAILED_COMMENT;
	        }
		
		
	}*/
	
	
	}
	
	}
	
	
	
	
	
	
	
	
	

