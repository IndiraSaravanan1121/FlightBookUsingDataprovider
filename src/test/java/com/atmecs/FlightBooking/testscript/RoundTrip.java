package com.atmecs.FlightBooking.testscript;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.atmecs.FlightBooking.BaseClass.BaseClass;
import com.atmecs.FlightBooking.Constants.Constants;
import com.atmecs.FlightBooking.UtilsClass.UtilsClass;
/**
 * scenario:Flight booking for round trip
 * @author indira.saravanan
 *
 */
public class RoundTrip extends BaseClass {
	
	Properties pro1=new Properties();
	static FileInputStream fis;

	@Test(priority = 0)
	public void roundTrip() throws Exception {

		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='reservation-form']/div/div/div/div[1]/div/ul/li[1]/div/label")).click();

	}

	@Test(dataProvider = "getDetails", priority = 1)
	public void passengerDetails1(String fromCity, String toCity) throws Exception {
		driver.findElement(By.id("fromCity")).sendKeys(fromCity);
		Thread.sleep(1000);
		driver.findElement(By.id("fromCity")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("toCity")).sendKeys(toCity);
		Thread.sleep(1000);
		driver.findElement(By.id("toCity")).sendKeys(Keys.ENTER);

	}

	@DataProvider
	public Object[][] getDetails() {
		Object data[][] = UtilsClass.ReadWriteExcel(Constants.testData_path);
		return data;
	}

	@Test(priority = 2)
	public void NoOfPassengerRoundTrip() throws Exception {

		driver.findElement(By.xpath("//*[@id='departureDate']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//th[@class='next available']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//td[@data-title='r0c6'])[1]")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//th[@class='next available']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//td[@data-title='r0c6'])[1]")).click();

		WebElement no_Of_Adults = driver.findElement(By.name("adults"));
		Select adults = new Select(no_Of_Adults);
		adults.selectByValue("1");
		WebElement cabinClass = driver.findElement(By.name("cabinClass"));
		Select cabclass = new Select(cabinClass);
		cabclass.selectByValue("b");
		driver.findElement(By.xpath("//*[@id=\"flights-tab\"]/div/div/div[3]/div[2]/div/button")).click();
	
	}
	
	@Test(priority=3)
	public void chooseFlight() throws Exception {
		
		JavascriptExecutor scroll1=(JavascriptExecutor)driver;
		scroll1.executeScript("scrollBy(0,4500)");
		
	    driver.findElement(By.xpath("//*[@id=\"result\"]/div[3]/div/label/article/div/div/div[1]/div")).click();
	    
	    JavascriptExecutor scroll2=(JavascriptExecutor)driver;
		scroll2.executeScript("scrollBy(0,4500)");
	    
	    driver.findElement(By.xpath("//*[@id=\"result1\"]/div[4]/div/label/article/div/div/div[1]/div/div[1]/span[1]")).click();
	
	    driver.findElement(By.xpath("/html/body/div[5]/div/div[3]/div/div[2]/span/span/a")).click();
	}
	
	@DataProvider
	public Object[][] getPassengerDetails() {
		Object data[][] = UtilsClass.ReadWriteExcel(Constants.testData_path);
		return data;
	}

	@Test(dataProvider = "getPassengerDetails", priority = 4)
	public void passengerDetails(String Email, String MobileNo, String FirstName, String LastName, String FirstName1,
			String LastName1) throws Exception {
		fis = new FileInputStream("/FlightBooking/src/main/resources/Locator/xpath.properties");
		pro1.load(fis);
	    JavascriptExecutor js=(JavascriptExecutor)driver;
	    js.executeScript("scrollBy(0,5000)");
		driver.findElement(By.xpath(pro1.getProperty("loc_email_txt"))).sendKeys(Email);
		driver.findElement(By.xpath(pro1.getProperty("loc_mobile_no_txt"))).sendKeys(MobileNo);
		WebElement selectGender = driver.findElement(By.xpath("//*[@id=\"genderA0\"]"));
		Select adultGender = new Select(selectGender);
		adultGender.selectByValue("Ms");
		driver.findElement(By.xpath(pro1.getProperty("loc_firstname_txt"))).sendKeys(FirstName);
		driver.findElement(By.xpath(pro1.getProperty("loc_lastname_txt"))).sendKeys(LastName);
		WebElement selectGender1 = driver.findElement(By.xpath("//*[@id=\"genderA0\"]"));
		Select childGender = new Select(selectGender1);
		childGender.selectByValue("Ms");
		driver.findElement(By.xpath(pro1.getProperty("loc_firstname1_txt"))).sendKeys(FirstName1);
		driver.findElement(By.xpath(pro1.getProperty("loc_lastname1_txt"))).sendKeys(LastName1);
		driver.findElement(By.xpath("//*[@id=\"cDOB0\"]")).click();
		WebElement selectMonth = driver
				.findElement(By.xpath("/html/body/div[12]/div[1]/div[2]/table/thead/tr[1]/th[2]/select[1]"));
		Select month = new Select(selectMonth);
		month.selectByValue("Nov");
		WebElement selectYear = driver
				.findElement(By.xpath("/html/body/div[12]/div[1]/div[2]/table/thead/tr[1]/th[2]/select[2]"));
		Select year = new Select(selectYear);
		year.selectByValue("2017");
		driver.findElement(By.xpath("/html/body/div[12]/div[1]/div[2]/table/tbody/tr[3]/td[5]")).click();
		driver.findElement(By.xpath("//button[@id=\"formpasssubmit\"]")).click();
	}

}
