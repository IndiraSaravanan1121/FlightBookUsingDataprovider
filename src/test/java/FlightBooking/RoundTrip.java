package FlightBooking;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RoundTrip extends BaseClass {

	@Test(priority = 0)
	public void roundTrip() throws Exception {

		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='reservation-form']/div/div/div/div[1]/div/ul/li[1]/div/label")).click();
		
	}
		@Test(dataProvider="getDetails",priority = 1)
		public void passengerDetails1(String fromCity,String toCity) throws Exception {
		driver.findElement(By.id("fromCity")).sendKeys(fromCity);
		Thread.sleep(1000);
		driver.findElement(By.id("fromCity")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("toCity")).sendKeys(toCity);
		Thread.sleep(1000);
		driver.findElement(By.id("toCity")).sendKeys(Keys.ENTER);

		}
			
			@DataProvider
			public Object[][] getDetails(){
			Object data[][]=UtilClass.ReadWriteExcel("TestData");
			return data;
			}

	}

