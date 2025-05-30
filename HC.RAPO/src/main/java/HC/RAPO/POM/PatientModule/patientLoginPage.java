package HC.RAPO.POM.PatientModule;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.javaUtility;
import genericUtility.webdriverUtility;

public class patientLoginPage {

	WebDriver driver;
	webdriverUtility wutil = new webdriverUtility();

	public patientLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "username")
	private WebElement usernameTF;

	@FindBy(name = "password")
	private WebElement passwordTF;

	@FindBy(name = "submit")
	private WebElement loginBtn;

	@FindBy(xpath = "//a[contains(text(),'Create an account')]")
	private WebElement createAccountLink;

	public WebElement getUsernameTF() {
		return usernameTF;
	}

	public WebElement getPasswordTF() {
		return passwordTF;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public WebElement getCreateAccountLink() {
		return createAccountLink;
	}

	public void loginAsPatient(String patientUserName, String patientPassword) {

		wutil.switchWindowUsiingPartialUrl(driver, "user-login.php");
		getUsernameTF().sendKeys(patientUserName);
		getPasswordTF().sendKeys(patientPassword);
		getLoginBtn().click();
	}

}
