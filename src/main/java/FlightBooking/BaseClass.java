package FlightBooking;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;


public class BaseClass {

	static WebDriver driver = null;
	static FileInputStream fis;
	Properties obj = new Properties();
	
	@BeforeTest
	public void setup() throws Exception {

		fis = new FileInputStream(
				"C:\\Users\\indira.saravanan\\eclipse-workspace\\FlightBooking\\src\\main\\resources\\TestData\\Config.properties");
		Properties obj = new Properties();
		obj.load(fis);

	
		String browserName1 = obj.getProperty("browserName");
		String url = obj.getProperty("url");

		switch (obj.getProperty("browserName1")) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\indira.saravanan\\eclipse-workspace\\FlightBooking\\lib\\chromedriver.exe");
			driver = new ChromeDriver();
			break;

		case "firefox":
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\indira.saravanan\\eclipse-workspace\\FlightBooking\\lib\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;

		case "IEdriver":
			System.setProperty("webdriver.ie.driver",
					"C:\\Users\\indira.saravanan\\eclipse-workspace\\FlightBooking\\lib\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		}
		driver.get(url);
	}

	
	
	/*
	 * @AfterTest public void CloseBrowser() { driver.quit(); }
	 */
}
