package HC.RAPO.POM.AdminModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.webdriverUtility;

public class addDoctorPage {
	
	WebDriver driver;

	public addDoctorPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	webdriverUtility wutil = new webdriverUtility();
	
	@FindBy(name = "Doctorspecialization")
	private WebElement doctorSpecilizationDropDown;
	
	@FindBy(name = "docname")
	private WebElement doctorNameTF;
	
	@FindBy(name = "clinicaddress")
	private WebElement clinicAddressTF;
	
	@FindBy(name = "docfees")
	private WebElement doctorFeesTF;
	
	@FindBy(name = "docemail")
	private WebElement doctorEmailTF;
	
	@FindBy(name = "doccontact")
	private WebElement doctorContactTF;
	
	@FindBy(name = "npass")
	private WebElement passwordTF;
	
	@FindBy(name = "cfpass")
	private WebElement ConfirmPasswordTF;
	
	@FindBy(id = "submit")
	private WebElement submitBtn;
	
	public WebElement getDoctorSpecilizationDropDown() {
		return doctorSpecilizationDropDown;
	}

	public WebElement getDoctorNameTF() {
		return doctorNameTF;
	}

	public WebElement getClinicAddressTF() {
		return clinicAddressTF;
	}

	public WebElement getDoctorFeesTF() {
		return doctorFeesTF;
	}

	public WebElement getDoctorEmailTF() {
		return doctorEmailTF;
	}

	public WebElement getDoctorContactTF() {
		return doctorContactTF;
	}

	public WebElement getPasswordTF() {
		return passwordTF;
	}

	public WebElement getConfirmPasswordTF() {
		return ConfirmPasswordTF;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	

	public void createDoctor(String SPECIALIZATION,StringBuilder DOCTOR_NAME,StringBuilder CLINIC_ADDRESS,StringBuilder FEES,StringBuilder CONTACT_NO,String EMAIL,StringBuilder PASSWORD) throws InterruptedException {
		
		WebElement SpecDD = getDoctorSpecilizationDropDown();
		wutil.toHandleDropDown(SpecDD, SPECIALIZATION);
		getDoctorNameTF().sendKeys(DOCTOR_NAME);
		getClinicAddressTF().sendKeys(CLINIC_ADDRESS);
		getDoctorFeesTF().sendKeys(FEES);
		getDoctorContactTF().sendKeys(CONTACT_NO);
		getDoctorEmailTF().sendKeys(EMAIL);
		getPasswordTF().sendKeys(PASSWORD);
		getConfirmPasswordTF().sendKeys(PASSWORD);
		wutil.jse(driver);
		getSubmitBtn().click();
		Thread.sleep(1000);
		wutil.toHandleAlertPopupByAccept(driver);
	}
	
}
