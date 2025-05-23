package NestedFrame_Model;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

public class FluentWait {

	@Test
	public void fluentWait() {
		
		WebDriver driver = new ChromeDriver();

		Wait<WebDriver> wait = new FluentWait<>(driver)
			    .withTimeout(Duration.ofSeconds(20))
			    .pollingEvery(Duration.ofSeconds(2))
			    .ignoring(NoSuchElementException.class);

			WebElement element = wait.until(driver -> driver.findElement(By.id("myElement")));


			

	}
	
}
