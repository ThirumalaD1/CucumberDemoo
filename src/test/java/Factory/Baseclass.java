package Factory;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Baseclass {
	public static WebDriver driver;
	public static Properties p;
	public static Logger logger;
	
	public static WebDriver initializebrowser() throws IOException {
		if (getProperties().getProperty("execution_env").equalsIgnoreCase("remote")) {
			
			DesiredCapabilities cap = new DesiredCapabilities();
			if (getProperties().getProperty("os").equalsIgnoreCase("windows")) {
				cap.setPlatform(Platform.WIN11);
			}
			else if (getProperties().getProperty("os").equalsIgnoreCase("Mac")) {
				cap.setPlatform(Platform.MAC);
				
			}
			else {
				System.out.println("NO PLATFORM MATCH FOUND");
			}
			
			switch (getProperties().getProperty("browser").toLowerCase()) {
			case "chrome": cap.setBrowserName("chrome"); break;
			case "edge": cap.setBrowserName("MicrosoftEdge"); break;	
			default: System.out.println("No matching browser");
			}
		      driver = new RemoteWebDriver(new URL("http://192.168.1.5:4444"),cap);
			}else if (getProperties().getProperty("execution_env").equalsIgnoreCase("Local")) {
				switch (getProperties().getProperty("browser").toLowerCase()) {
				case "chrome":  driver = new ChromeDriver();
				break;	
				case "edge": driver=new EdgeDriver();

				default: System.out.println("No matching browser found");
				
				}
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
			}
		return driver;
	}
	
	public static Logger getlogger() {
	Logger logger = LogManager.getLogger();	 
	return logger;
	}
	
	public static  Properties getProperties() throws IOException {
		FileReader filepath = new FileReader("C:\\Users\\justi\\eclipse-workspace\\CucumberDemoo\\src\\test\\resources\\config.properties");
		
		 p = new Properties();
		p.load(filepath);
		return p;
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
		
	
	public static String randomString() {
		String rans = RandomStringUtils.randomAlphabetic(8);
	return rans;
	}
	public static String randomNum() {
	String rann = RandomStringUtils.randomNumeric(9);
	return rann;
	}
	
	public static String randomalphanum() {
		String ranst = RandomStringUtils.randomAlphabetic(8);
		String rannu = RandomStringUtils.randomNumeric(9);
		return ranst+"@"+rannu;
		
	}
	public static void vd(){
	}	
	
	
}
