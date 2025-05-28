package NestedFrame_Model;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class phpTravels {

	@Test
	public void phpDemo() throws InterruptedException {
		
		String ExpectedTravelLoc = "BLR COS";
		String ExpectedTravelDate = "26-05-2025";
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		
		driver.get("https://www.phptravels.net/flights");
		driver.findElement(By.name("from")).sendKeys("BLR");
		driver.findElement(By.name("to")).sendKeys("cos",Keys.ENTER);
		
		String ActualTravelLoc = driver.findElement(By.xpath("//strong[contains(text(),'blr')]")).getText();
		Assert.assertEquals(ExpectedTravelLoc, ActualTravelLoc);
		
		String ActualtravelDate = driver.findElement(By.xpath("//span[@class='title__fetched-time']/small[contains(text(),'26-05-2025')]")).getText();
		Assert.assertEquals(ExpectedTravelDate, ActualtravelDate);
		
		WebElement twoStop = driver.findElement(By.xpath("//input[@value='2']"));
		twoStop.click();
		
		WebElement eve = driver.findElement(By.xpath("//label[@for=\"departure-evening\" and @class=\"nav-item form-check-label fs-14 w-100\"]/descendant::input[@type=\"radio\"]"));
		Actions a = new Actions(driver);
		a.scrollToElement(eve).perform();
		eve.click();
		
		List<WebElement> flights = driver.findElements(By.xpath("//div[@id=\"flight-list\"]/descendant::div[@class=\"lh-0 border-md border-end pe-3 w-100\"]"));
		for (WebElement list : flights) {
			System.out.println(list.getText());
		}
		
		driver.close();
	}
}
