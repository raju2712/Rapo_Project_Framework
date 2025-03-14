package HC.RAPO.POM.DoctorModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class patientEditPage {

	
	WebDriver driver;

	public patientEditPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "patname")
	private WebElement patientNameTF;
	
	@FindBy(name = "patcontact")
	private WebElement patientContactNoTF;
	
	@FindBy(xpath = "//label[2]/input[1]")
	private WebElement maleRadioBtn;
	
	@FindBy(xpath = "//input[2]")
	private WebElement femaleRadioBtn;
	
	@FindBy(name = "pataddress")
	private WebElement patientAddressTF;
	
	@FindBy(name = "patage")
	private WebElement patientAgeTF;
	
	@FindBy(name = "medhis")
	private WebElement medicalHistoryTF;
	
	@FindBy(id = "submit")
	private WebElement updateBtn;
	
	public WebElement getPatientNameTF() {
		return patientNameTF;
	}

	public WebElement getPatientContactNoTF() {
		return patientContactNoTF;
	}

	public WebElement getMaleRadioBtn() {
		return maleRadioBtn;
	}

	public WebElement getFemaleRadioBtn() {
		return femaleRadioBtn;
	}

	public WebElement getPatientAddressTF() {
		return patientAddressTF;
	}

	public WebElement getPatientAgeTF() {
		return patientAgeTF;
	}

	public WebElement getMedicalHistoryTF() {
		return medicalHistoryTF;
	}

	public WebElement getUpdateBtn() {
		return updateBtn;
	}

	
	
}
