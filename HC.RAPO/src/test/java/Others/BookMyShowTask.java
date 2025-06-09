package Others;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BookMyShowTask {

	@Test
	public void BMS() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.get("https://in.bookmyshow.com/explore/home/bengaluru");
//		WebElement locFrame = driver.findElement(By.xpath("//span[contains(text(),'Popular Cities')]"));
//		driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='bwc__sc-1ihur1g-5 fIsZNV in-animation']")));
//		driver.findElement(By.xpath("//ul[@class='bwc__sc-ttnkwg-15 fFoiPE']/descendant::span[contains(text(),'Bengaluru')]")).click();
		driver.findElement(By.xpath("//img[@src=\"https://assets-in.bmscdn.com/discovery-catalog/events/tr:w-400,h-600,bg-CCCCCC:w-400.0,h-660.0,cm-pad_resize,bg-000000,fo-top:l-image,i-discovery-catalog@@icons@@like_202006280402.png,lx-24,ly-617,w-29,l-end:l-text,ie-NDEuOEsgTGlrZXM%3D,fs-29,co-FFFFFF,ly-612,lx-70,pa-8_0_0_0,l-end/et00445570-kzxmenqgnx-portrait.jpg\"]")).click();
//		driver.findElement(By.xpath("//span[contains(text(),'Search for Movies, Events, Plays, Sports and Activities')]")).click();
//		driver.findElement(By.xpath("//input[@placeholder=\"Search for Movies, Events, Plays, Sports and Activities\"]")).sendKeys("Ace",Keys.ENTER);
		driver.findElement(By.xpath("//div[@class='sc-qswwm9-8 fNtHgG']//span[contains(text(),'Book tickets')]")).click();
		driver.findElement(By.xpath("(//div[@class='sc-1k6uqqy-0 icKFjI']/descendant::span[contains(text(),'2D')])[1]")).click();
		driver.findElement(By.xpath("//div[@class='sc-9bxw9f-5 iterBd']/descendant::div[contains(text(),'25')]")).click();
	}
}
