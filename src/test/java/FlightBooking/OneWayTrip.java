package FlightBooking;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OneWayTrip extends BaseClass {

	@BeforeMethod
	public void OneWayTrip() throws Exception {
		Thread.sleep(2000);
		// WebElement button=driver.findElement(By.id("roundTrip"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('onewayTrip').click();");

	}

	@DataProvider
	public Object[][] getDetails() {
		Object data[][] = UtilClass.ReadWriteExcel("TestData");
		return data;
	}

	@Test(dataProvider = "getDetails", priority = 1)
	public void passengerDetails(String fromCity, String toCity) throws InterruptedException {
		driver.findElement(By.id("fromCity")).sendKeys(fromCity);
		Thread.sleep(1000);
		driver.findElement(By.id("fromCity")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("toCity")).sendKeys(toCity);
		Thread.sleep(1000);
		driver.findElement(By.id("toCity")).sendKeys(Keys.ENTER);

	}
}
