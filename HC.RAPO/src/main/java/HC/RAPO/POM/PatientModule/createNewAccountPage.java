package HC.RAPO.POM.PatientModule;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.excelFileUtility;
import genericUtility.javaUtility;
import genericUtility.webdriverUtility;

public class createNewAccountPage {

	WebDriver driver;
	
	excelFileUtility eutil = new excelFileUtility();
	webdriverUtility wutil = new webdriverUtility();

	public createNewAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "full_name")
	private WebElement fullNameTF;
	
	@FindBy(name = "address")
	private WebElement addressTF;
	
	@FindBy(name = "city")
	private WebElement cityTF;
	
	@FindBy(id = "email")
	private WebElement emailTF;
	
	@FindBy(id = "password")
	private WebElement passwordTF;
	
	@FindBy(id = "password_again")
	private WebElement passwordAgainTF;
	
	@FindBy(xpath = "//label[@for='agree']")
	private WebElement agreeCheckBox;
	
	@FindBy(xpath = "//label[@for='rg-male']")
	private WebElement maleRadioBtn;
	
	@FindBy(xpath = "//label[@for='rg-female']")
	private WebElement femaleRadioBtn;
	
	@FindBy(id = "submit")
	private WebElement submitBtn;

	public WebElement getFullNameTF() {
		return fullNameTF;
	}

	public WebElement getAddressTF() {
		return addressTF;
	}

	public WebElement getCityTF() {
		return cityTF;
	}

	public WebElement getEmailTF() {
		return emailTF;
	}

	public WebElement getPasswordTF() {
		return passwordTF;
	}

	public WebElement getPasswordAgainTF() {
		return passwordAgainTF;
	}

	public WebElement getAgreeCheckBox() {
		return agreeCheckBox;
	}

	public WebElement getMaleRadioBtn() {
		return maleRadioBtn;
	}

	public WebElement getFemaleRadioBtn() {
		return femaleRadioBtn;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	public void createNewAccount(String FULL_NAME,String ADDRESS,String CITY,String PASSWORD) throws InterruptedException {
		
		javaUtility jutil = new javaUtility();
		getFullNameTF().sendKeys(FULL_NAME);
		getAddressTF().sendKeys(ADDRESS);
		getCityTF().sendKeys(CITY);
		getEmailTF().sendKeys("raju"+jutil.togetRandomNumber()+"@gmail.com");
		getPasswordTF().sendKeys(PASSWORD);
		getPasswordAgainTF().sendKeys(PASSWORD);
		//getAgreeCheckBox().click();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,500)");
		getSubmitBtn().click();
		Thread.sleep(2000);
		wutil.toHandleAlertPopupByAccept(driver);
	}
	
	
	
	
	
	
}
