package com.atmecs.FlightBooking.HelperClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.atmecs.FlightBooking.BaseClass.BaseClass;

public class HelperClass extends BaseClass {

	static WebElement element;

	public void geturl(String string) {
		driver.get(string);
	}

	public void ClickElement(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}

	public static void selectDropdown(String xpath, String visibleText) {
		element = driver.findElement(By.xpath(xpath));
		Select produts = new Select(element);
		produts.selectByVisibleText(visibleText);
	}

	public static void implicityWait() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static void explicitWait() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
	}
}
