package testCases;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import pageObjects.BasePage;

public class BasePageTest {
	public static WebDriver driver; //because 2 driver created one here and one in extentreport as object (conflict so static)
	public Properties p;
	public Logger logger;
	@BeforeClass
	@Parameters ({"os","browser"})
	public void Setup(String os, String browser) throws IOException, URISyntaxException{
		logger=LogManager.getLogger(this.getClass());
		FileReader file = new FileReader("./src//test//resources/config.properties");
		p = new Properties();
		p.load(file);
		//if env is remote
		if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
			System.out.println("Hi");
			DesiredCapabilities  cap = new DesiredCapabilities();
			//os
			if(os.equalsIgnoreCase("windows")) {
				cap.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("Linux")){
				cap.setPlatform(Platform.LINUX);
			}
			else if(os.equalsIgnoreCase("MAC")){
				cap.setPlatform(Platform.MAC);
		    }
			else {
				System.out.println("No Matching OS");
				return;
			}
			//browser
			switch(browser.toLowerCase()) {
			case "chrome": cap.setBrowserName("chrome"); break;
			case "firefox": cap.setBrowserName("firefox"); break;
			case "edge": cap.setBrowserName("MicrosoftEdge"); break;
			default: System.out.println("No Matching Browser");
			return;
			}
			//driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
			//URI uri = "http://localhost:4444/wd/hub";
			URL url = new URI("http://localhost:4444/wd/hub").toURL();
			driver = new RemoteWebDriver(url,cap);
			}
			
		//env as local 
		if(p.getProperty("execution_env").equalsIgnoreCase("local")) {
			System.out.println("Hello");
		    switch(browser.toLowerCase()) {
		    case "chrome" : driver = new ChromeDriver(); break;
			case "firefox" : driver = new FirefoxDriver(); break;
			case "edge" : driver = new EdgeDriver(); break;
			default: System.out.println(" Invalid browser Name"); return;	}
			
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get("https://automationteststore.com/");
			//driver.get(p.getProperty("url"));
			driver.manage().window().maximize();
		}
	}
    @AfterClass
	public void TearDown() {
		driver.close();
	}
    
    
    
    public String captureScreen(String tname) throws IOException{
    	String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
    	TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
    	File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
    	
    	String targetFilePath=System.getProperty("user.dir") + "\\screenshots\\" + tname + "_"+ timeStamp+".png";
    	File targetFile = new File(targetFilePath);
    	sourceFile.renameTo(targetFile);
    	return targetFilePath;
    }
	
}
