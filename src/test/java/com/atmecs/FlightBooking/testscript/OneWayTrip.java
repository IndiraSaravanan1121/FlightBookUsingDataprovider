package com.atmecs.FlightBooking.testscript;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.atmecs.FlightBooking.BaseClass.BaseClass;
import com.atmecs.FlightBooking.Constants.Constants;
import com.atmecs.FlightBooking.UtilsClass.UtilsClass;


public class OneWayTrip extends BaseClass {

	static FileInputStream fis;
	static Properties pro1 = new Properties();

	@Test(priority = 0)
	public void OneWayTrip() throws Exception {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"reservation-form\"]/div/div/div/div[1]/div/ul/li[2]/div/label")).click();
		Logger log = Logger.getLogger(OneWayTrip.class);
		pro1.load(new FileInputStream(Constants.log4j_path));
		PropertyConfigurator.configure(pro1);
	}
	
	@Test(dataProvider = "getDetails",priority = 1)
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
		Object data[][] = UtilsClass.ReadWriteExcel("TestData");
		return data;
	}

	@Test(priority = 2)
	public void noOfPassenger() throws InterruptedException {

		driver.findElement(By.xpath("(//input[@id='departureDate'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//th[@class='next available']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//td[@data-title='r0c6'])[1]")).click();
		WebElement no_Of_Adults = driver.findElement(By.name("adults"));
		Select adults = new Select(no_Of_Adults);
		adults.selectByValue("1");
		WebElement no_Of_Childs = driver.findElement(By.name("childs"));
		Select childs = new Select(no_Of_Childs);
		childs.selectByValue("1");
		WebElement no_Of_Infacts = driver.findElement(By.name("infants"));
		Select infacts = new Select(no_Of_Infacts);
		infacts.selectByValue("0");
		WebElement cabinClass = driver.findElement(By.name("cabinClass"));
		Select cabclass = new Select(cabinClass);
		cabclass.selectByValue("b");
		driver.findElement(By.xpath("//*[@id=\"flights-tab\"]/div/div/div[3]/div[2]/div/button")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//*[@id=\"flightDetails\"]/button)[2]")).click();

	}

	@DataProvider
	public Object[][] getPassengerDetails() {
		Object data[][] = UtilsClass.ReadWriteExcel("Sheet1");
		return data;
	}

	@Test(dataProvider = "getPassengerDetails", priority = 3)
	public void passengerDetails(String Email, String MobileNo, String FirstName, String LastName, String FirstName1,
			String LastName1) throws Exception {
		fis = new FileInputStream("/FlightBooking/src/main/resources/Locator/xpath.properties");
		pro1.load(fis);
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
		driver.findElement(By.xpath("//*[@id=\"formpasssubmit\"]")).click();
	}

}
