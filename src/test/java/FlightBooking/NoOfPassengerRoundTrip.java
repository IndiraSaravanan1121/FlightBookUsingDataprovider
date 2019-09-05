package FlightBooking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class NoOfPassengerRoundTrip extends RoundTrip {

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
		Thread.sleep(10000);
		

	}
}
