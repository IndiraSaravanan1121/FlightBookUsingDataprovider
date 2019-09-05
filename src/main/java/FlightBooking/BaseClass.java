package FlightBooking;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;



public class BaseClass {

	static WebDriver driver = null;
	static FileInputStream fis;
	Properties obj = new Properties();

	@BeforeTest
	@Parameters("browser")
	public void setup(String brow) throws Exception {

		
		  fis = new FileInputStream(
		  "C:\\Users\\indira.saravanan\\eclipse-workspace\\FlightBooking\\src\\main\\resources\\TestData\\Config.properties"
		  ); Properties obj = new Properties(); obj.load(fis);
		  
		/* String browserName1 = obj.getProperty("browserName"); */ 
		  String url = obj.getProperty("url"); 
		  DesiredCapabilities cap = new DesiredCapabilities();
		 

		switch (brow){
		
		case "chrome":
			/*
			 * cap.setBrowserName(browserName1); cap.setPlatform(Platform.WIN10);
			 * 
			 * URL url1 = new URL("http://50.50.50.132:4444/wd/hub"); driver = new
			 * RemoteWebDriver(url1, cap);
			 */

			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\indira.saravanan\\eclipse-workspace\\FlightBooking\\lib\\chromedriver.exe");
			driver = new ChromeDriver();
			break;

		case "firefox":
			/*
			 * cap.setBrowserName(browserName1); cap.setPlatform(Platform.WIN10);
			 * 
			 * URL url2 = new URL("http://50.50.50.132:4444/wd/hub"); driver = new
			 * RemoteWebDriver(url2, cap);
			 */

			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\indira.saravanan\\eclipse-workspace\\FlightBooking\\lib\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;

		case "IEdriver":
			/*
			 * cap.setBrowserName(browserName1); cap.setPlatform(Platform.WIN10);
			 * 
			 * URL url3 = new URL("http://50.50.50.132:4444/wd/hub"); driver = new
			 * RemoteWebDriver(url3, cap);
			 */

			System.setProperty("webdriver.ie.driver",
					"C:\\Users\\indira.saravanan\\eclipse-workspace\\FlightBooking\\lib\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		}

		driver.get(url);
		/*
		 * TakesScreenshot ts = (TakesScreenshot) driver; try {
		 * FileHandler.copy(ts.getScreenshotAs(OutputType.FILE), new
		 * File("/FlightBooking/screenshot.png")); } catch (WebDriverException e) { }
		 */
	}
	
	@AfterTest
	public void closebrowser() {
		driver.quit();
	}
}
