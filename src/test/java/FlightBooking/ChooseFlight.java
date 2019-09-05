package FlightBooking;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class ChooseFlight extends NoOfPassengerRoundTrip {

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

	
}
