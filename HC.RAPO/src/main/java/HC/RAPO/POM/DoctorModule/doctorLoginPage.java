package HC.RAPO.POM.DoctorModule;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import HC.RAPO.POM.WelcomePage.welcomePage;
import genericUtility.webdriverUtility;

public class doctorLoginPage {

	WebDriver driver;
	webdriverUtility wutil = new webdriverUtility();
	welcomePage wp = new welcomePage(driver); 

	public webdriverUtility getWutil() {
		return wutil;
	}

	public welcomePage getWp() {
		return wp;
	}

	public WebElement getUsernameTF() {
		return usernameTF;
	}

	public WebElement getPasswordTF() {
		return passwordTF;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public doctorLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "username")
	private WebElement usernameTF;
	
	@FindBy(name = "password")
	private WebElement passwordTF;
	
	@FindBy(name = "submit")
	private WebElement loginBtn;
	
	public void loginAsDoctor(String doctorUserName, String doctorPassword) {

		wutil.switchToTabOnUrl(driver, "hms/doctor/");
		getUsernameTF().sendKeys(doctorUserName);
		getPasswordTF().sendKeys(doctorPassword);
		getLoginBtn().click();
	}
	
}
