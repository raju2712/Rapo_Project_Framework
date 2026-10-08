package simpleEnergy;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class multipleBooking {

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

		driver.findElement(By.id("phone")).sendKeys("9092191119");
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
		System.out.println("*****1st bike Pre-Booked successfully*****");

		// ---------------------------------------------------------------------------------------------

		driver.findElement(By.xpath("//button[text()='Book Another']")).click();

		driver.findElement(By.xpath("//div[@class='preBookLayout_locateMeBtn__QHbWk']")).click();

		WebElement venkatalaa = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(.,'venkatala')]")));
		venkatalaa.click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		System.out.println("*****Location set Successfully*****");
		// entering details
//		driver.findElement(By.xpath("//input[@aria-label='Full Name']")).sendKeys("ABCD");
//		driver.findElement(By.xpath("//input[@aria-label='Email ID']")).sendKeys("abcd@gmail.com");
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

		String prebookn = driver.getWindowHandle();
		driver.findElement(By.xpath("//button[.='Proceed to Pay']")).click();
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		Set<String> prebook22 = driver.getWindowHandles();

		for (String windowHandle : prebook22) {
			if (!windowHandle.equals(prebookn)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}

		driver.findElement(By.xpath("//input[@id='basic-otp']")).sendKeys("111000");
		driver.manage().window().maximize();

		JavascriptExecutor js2 = (JavascriptExecutor) driver;

		WebElement buttonSuccess2 = driver.findElement(By.xpath("//div[@data-status='SUCCESS']"));
		js2.executeScript("arguments[0].click();", buttonSuccess2);

		WebElement paymentSubmit2 = driver.findElement(By.xpath("//div[@role='status']"));
		js2.executeScript("arguments[0].click();", paymentSubmit2);
		System.out.println("*****Payment Successfull******");

		// switching back to parent window
		driver.switchTo().window(prebook);
		WebElement confirmMsg2 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[.='Pre-book Confirmed']")));
		driver.findElement(By.xpath("//a[contains(.,'Track Order')]")).click();
		System.out.println("*****2nd bike Pre-Booked successfully*****");

		// ---------------------------------------------------------------------------

		driver.findElement(By.xpath("//button[text()='Book Another']")).click();

		driver.findElement(By.xpath("//div[@class='preBookLayout_locateMeBtn__QHbWk']")).click();

		WebElement venkatalaaa = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(.,'venkatala')]")));
		venkatalaaa.click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		System.out.println("*****Location set Successfully*****");
		// entering details
//		driver.findElement(By.xpath("//input[@aria-label='Full Name']")).sendKeys("ABCD");
//		driver.findElement(By.xpath("//input[@aria-label='Email ID']")).sendKeys("abcd@gmail.com");
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

		String prebooknn = driver.getWindowHandle();
		driver.findElement(By.xpath("//button[.='Proceed to Pay']")).click();
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		Set<String> prebook3 = driver.getWindowHandles();

		for (String windowHandle : prebook3) {
			if (!windowHandle.equals(prebooknn)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}

		driver.findElement(By.xpath("//input[@id='basic-otp']")).sendKeys("111000");
		driver.manage().window().maximize();

		JavascriptExecutor js3 = (JavascriptExecutor) driver;

		WebElement buttonSuccess3 = driver.findElement(By.xpath("//div[@data-status='SUCCESS']"));
		js2.executeScript("arguments[0].click();", buttonSuccess3);

		WebElement paymentSubmit3 = driver.findElement(By.xpath("//div[@role='status']"));
		js2.executeScript("arguments[0].click();", paymentSubmit3);
		System.out.println("*****Payment Successfull******");

		// switching back to parent window
		driver.switchTo().window(prebook);
		WebElement confirmMsg3 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[.='Pre-book Confirmed']")));
		driver.findElement(By.xpath("//a[contains(.,'Track Order')]")).click();
		System.out.println("*****3rd bike Pre-Booked successfully*****");

		// ---------------------------------------------------------------------------

		driver.findElement(By.xpath("//button[text()='Book Another']")).click();

		WebElement errorMsg = driver.findElement(By.xpath("//div[.='Max orders reached!' and @role='status']"));
		Assert.assertFalse(errorMsg.isDisplayed());
		System.out.println("Error message displayed");

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
