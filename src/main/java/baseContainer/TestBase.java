package baseContainer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {
	
	public WebDriver driver;
	public Properties config = new Properties();  
	public Properties locator = new Properties();
	public FileInputStream file;
	String ProjectLocation = System.getProperty("user.dir");
	
	@BeforeTest
	public void Setup() {
		
		// Launching/Setups Browser
		ChromeOptions options = new ChromeOptions();
		driver = new ChromeDriver(options);
		
		//URL & Data file configuration Setup
		try {
			file = new FileInputStream(ProjectLocation+"/src/main/resources/propertyFiles/config.properties");
		}catch(FileNotFoundException FNFE) {
			FNFE.printStackTrace();
		}
		// Loading the file
		try {
			config.load(file);
		}catch(IOException FNIO) {
			FNIO.printStackTrace();
		}
		
		// Locator File configuration
		try {
			file = new FileInputStream(ProjectLocation+"/src/main/resources/propertyFiles/locators.properties");
		}catch(FileNotFoundException FNFE) {
			FNFE.printStackTrace();
		}
		// Loading the file
		try {
			locator.load(file);
		}catch(IOException FNIO) {
			FNIO.printStackTrace();
		}
		
		// Apllication Launching
		driver.get(config.getProperty("url"));
		driver.manage().window().maximize();
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
