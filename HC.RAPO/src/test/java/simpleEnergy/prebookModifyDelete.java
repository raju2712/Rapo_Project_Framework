package simpleEnergy;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class prebookModifyDelete {

	public static void main(String[] args) throws InterruptedException {

		// Navigate to URL and Login
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		
		driver.get("https://admin:simple123@website-stage.simpleenergy.in/");
		System.out.println("*****Navigated to URL*****");
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		System.out.println("*****Clicked on Login button*****");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
		WebElement reject = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[.='Reject optional']")));
		reject.click();

		driver.findElement(By.id("phone")).sendKeys("9199191119");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		WebElement otp1 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='otpInput_otpContainer__6thbl']/input[1]")));

		// Enter OTP
		driver.findElement(By.xpath("//div[@class='otpInput_otpContainer__6thbl']/input[1]")).sendKeys("3");
		driver.findElement(By.xpath("//div[@class='otpInput_otpContainer__6thbl']/input[2]")).sendKeys("2");
		driver.findElement(By.xpath("//div[@class='otpInput_otpContainer__6thbl']/input[3]")).sendKeys("8");
		driver.findElement(By.xpath("//div[@class='otpInput_otpContainer__6thbl']/input[4]")).sendKeys("9");
		System.out.println("*****Successfully Signed-in*****");
		// Waiting for pincode popup and entering popup

		WebElement pincodeTF = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//input[@aria-label='Enter Area or Pincode']")));
		driver.findElement(By.xpath("//div[@class='preBookLayout_locateMeBtn__QHbWk']")).click();

		WebElement venkatala = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(.,'venkatala')]")));
		venkatala.click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		System.out.println("*****Location set Successfully*****");
		// entering details
		driver.findElement(By.xpath("//input[@aria-label='Full Name']")).sendKeys("ABCD");
		driver.findElement(By.xpath("//input[@aria-label='Email ID']")).sendKeys("abcd@gmail.com");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//button[.='Confirm & Pay']")).click();

		// switching to frame
		driver.switchTo().frame(driver.findElement(By.xpath(
				"//iframe[@name='eyJwYXJlbnROYW1lIjoiY2FzaGZyZWUtbW9kYWwtaWZyYW1lIiwiaXNXaW5kb3dPcGVuU3VwcG9ydGVkIjp0cnVlLCJwYXJlbnREb21haW4iOiJodHRwczovL3dlYnNpdGUtc3RhZ2Uuc2ltcGxlZW5lcmd5LmluIn0=']")));
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[.='Net Banking']")).click();
		driver.switchTo().parentFrame();

		driver.switchTo().frame(driver.findElement(By.xpath(
				"//iframe[@name='eyJwYXJlbnROYW1lIjoiY2FzaGZyZWUtbW9kYWwtaWZyYW1lIiwiaXNXaW5kb3dPcGVuU3VwcG9ydGVkIjp0cnVlLCJwYXJlbnREb21haW4iOiJodHRwczovL3dlYnNpdGUtc3RhZ2Uuc2ltcGxlZW5lcmd5LmluIn0=']")));

		driver.findElement(By.xpath("//div[@class='flex align-center']/img[@alt='ICICI Bank']")).click();

		String prebook = driver.getWindowHandle();
		driver.findElement(By.xpath("//button[.='Proceed to Pay']")).click();
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		Set<String> prebook2 = driver.getWindowHandles();

		for (String windowHandle : prebook2) {
			if (!windowHandle.equals(prebook)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}

		driver.findElement(By.xpath("//input[@id='basic-otp']")).sendKeys("111000");
		driver.manage().window().maximize();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement buttonSuccess = driver.findElement(By.xpath("//div[@data-status='SUCCESS']"));
		js.executeScript("arguments[0].click();", buttonSuccess);

		WebElement paymentSubmit = driver.findElement(By.xpath("//div[@role='status']"));
		js.executeScript("arguments[0].click();", paymentSubmit);
		System.out.println("*****Payment Successfull******");

		// switching back to parent window
		driver.switchTo().window(prebook);
		WebElement confirmMsg = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[.='Pre-book Confirmed']")));
		driver.findElement(By.xpath("//a[contains(.,'Track Order')]")).click();
		System.out.println("*****Pre-Booked successfully*****");

		// Modifying Pincode
		driver.findElement(By.xpath("//*[local-name()='svg' and @width='25']")).click();
		driver.findElement(By.xpath("(//div[@class='bookingStatusCard_iconContainer__ddht0'])[1]")).click();
		driver.findElement(By.xpath("//p[.='Modify']")).click();
		driver.findElement(By.xpath("//div[@class='bookingChooseLocation_closeIcon__9c5SE']")).click();
		driver.findElement(By.xpath("//input[@aria-label='Enter Pincode or City']")).sendKeys("515001");
		driver.findElement(By.xpath("//p[.='Test simple Andhra pradesh']")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//a[.='Done']")).click();
		System.out.println("*****Pre-Book details modified successfully*****");

		// Delete
		driver.findElement(By.xpath("//*[local-name()='svg' and @width='25']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='bookingStatusCard_iconContainer__ddht0'])[1]")).click();
		driver.findElement(By.xpath("//p[.='Cancel Booking']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(
				"//div[@class='cancelPreebook_reason__ek5sY']/descendant::p[.='I changed my Mind']/preceding-sibling::div"))
				.click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//a[.='Done']")).click();
		System.out.println("*****Pre-Book cancelled successfully*****");

		// Sign-Out
		driver.findElement(By.xpath("//*[local-name()='svg' and @width='24']")).click();
		driver.findElement(By.xpath("//span[.='Sign-out']")).click();
		driver.findElement(By.xpath("//button[.='Yes, sign out']")).click();
		System.out.println("*****Signned-Out successfully*****");

		WebElement closeIcon = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='closeIcon']")));
		closeIcon.click();

		driver.close();

	}

}
