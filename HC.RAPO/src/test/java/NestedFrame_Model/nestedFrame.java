package NestedFrame_Model;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class nestedFrame {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();

		driver.get("https://demoapps.qspiders.com/ui/frames/nestedWithMultiple?sublist=3");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));

		String Email = driver.findElement(By.xpath("//p[contains(text(),'Admin@gmail.com')]")).getText();
		//System.out.println(Email);
		String Pass = driver.findElement(By.xpath("//p[contains(text(),'Admin@1234')]")).getText();
		//System.out.println(Pass);

		driver.switchTo().frame(0);

		driver.switchTo().frame(0);
		driver.findElement(By.id("email")).sendKeys(Email);
		// driver.findElement(By.id("email")).sendKeys("Admin@gmail.com");

		driver.switchTo().parentFrame();
		driver.switchTo().frame(1);
		driver.findElement(By.id("password")).sendKeys(Pass);

		driver.switchTo().parentFrame();
		driver.switchTo().frame(2);
		driver.findElement(By.id("confirm")).sendKeys(Pass);

		driver.switchTo().parentFrame();
		driver.switchTo().frame(3);
		driver.findElement(By.id("submitButton")).click();

	}
}
