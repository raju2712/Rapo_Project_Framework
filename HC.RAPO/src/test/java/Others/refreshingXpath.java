package Others;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class refreshingXpath {

	@Test
	public void rpa() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		
		driver.get("https://rpachallenge.com/");
		
		driver.findElement(By.xpath("//input[@ng-reflect-name='labelLastName']")).sendKeys("ABC");
		//driver.findElement(By.xpath("//label[text()='Last Name']/following-sibling::input")).sendKeys("ABC");
		//driver.findElement(By.xpath("//div[contains(.,'Last Name')]/child::input")).sendKeys("ABC");
		//driver.findElement(By.xpath("//div[@class='ng-pristine ng-invalid ng-touched']/descendant::input[@class=\"ng-pristine ng-invalid ng-touched\"]")).sendKeys("ABC");
		//driver.findElement(By.xpath("//label[text()='Last Name']/parent::div/child::input")).sendKeys("ABC");
		
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@ng-reflect-name='labelLastName']")).sendKeys("XYZ");
		Thread.sleep(2000);
		driver.quit();
	}
}
