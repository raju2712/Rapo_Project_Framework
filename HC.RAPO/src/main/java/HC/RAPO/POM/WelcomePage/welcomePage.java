package HC.RAPO.POM.WelcomePage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class welcomePage {
	
	WebDriver driver;

	public welcomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='menu']//ul//li//a[@href='#logins'][text()='Logins']")
	private WebElement loginsLink;
	
	@FindBy(xpath = "//a[text()='Book an Appointment']")
	private WebElement bookAppointmentButton;
	
	@FindBy(xpath = "//a[@href='hms/user-login.php']//button[@class='btn btn-success btn-sm']")
	private WebElement clickHereBtnOfPatient;
	
	@FindBy(xpath = "//a[@href='hms/doctor']")
	private WebElement clickHereBtnOfDoctor;
	
	@FindBy(xpath = "//a[@href='hms/admin']")
	private WebElement clickHereBtnOfAdmin;

	public WebElement getLoginLink() {
		return loginsLink;
	}

	public WebElement getBookAppointmentButton() {
		return bookAppointmentButton;
	}

	public WebElement getLoginsLink() {
		return loginsLink;
	}

	public WebElement getClickHereBtnOfPatient() {
		return clickHereBtnOfPatient;
	}

	public WebElement getClickHereBtnOfDoctor() {
		return clickHereBtnOfDoctor;
	}

	public WebElement getClickHereBtnOfAdmin() {
		return clickHereBtnOfAdmin;
	}
	
	public void toScrollDownToLoginAsPatient(WebDriver driver) {
		welcomePage wp = new welcomePage(driver);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		for (;;) {
			try {
				wp.getClickHereBtnOfPatient().click();
				break;
			} catch (Exception e) {
				jse.executeScript("window.scrollBy(0,100)");
			}
		}
		
	}
	
	public void toScrollDownToLoginAsDoctor(WebDriver driver) {
		welcomePage wp = new welcomePage(driver);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		for (;;) {
			try {
				wp.getClickHereBtnOfDoctor().click();
				break;
			} catch (Exception e) {
				jse.executeScript("window.scrollBy(0,100)");
			}
		}
		
	}
	
	public void toScrollDownToLoginAsAdmin(WebDriver driver) {
		welcomePage wp = new welcomePage(driver);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		for (;;) {
			try {
				wp.getClickHereBtnOfAdmin().click();
				break;
			} catch (Exception e) {
				jse.executeScript("window.scrollBy(0,100)");
			}
		}
		
	}
	
	
	
	
	
}
