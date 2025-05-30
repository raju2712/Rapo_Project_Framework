package HC.RAPO.POM.AdminModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import HC.RAPO.POM.WelcomePage.welcomePage;
import genericUtility.webdriverUtility;

public class adminLoginPage {

	WebDriver driver;
	webdriverUtility wutil = new webdriverUtility();
	welcomePage wp = new welcomePage(driver); 

	public adminLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "username")
	private WebElement usernameTF;
	
	@FindBy(name = "password")
	private WebElement passwordTF;
	
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

	@FindBy(name = "submit")
	private WebElement loginBtn;
	
	public void LoginAsAdmin(String adminUserName, String adminPassword) {
		//wp.getClickHereBtnOfAdmin().click();
		wutil.switchWindowUsiingPartialUrl(driver,"hms/admin/");	
		getUsernameTF().sendKeys(adminUserName);
		getPasswordTF().sendKeys(adminPassword);
        getLoginBtn().click();
	}
}
