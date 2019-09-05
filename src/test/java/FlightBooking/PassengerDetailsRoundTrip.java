package FlightBooking;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PassengerDetailsRoundTrip extends ChooseFlight {
	Properties pro1 = new Properties();

	@DataProvider
	public Object[][] getPassengerDetails() {
		Object data[][] = UtilClass.ReadWriteExcel("Sheet1");
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
