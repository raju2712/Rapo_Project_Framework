package HC.RAPO.POM.DoctorModule;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.javaUtility;
import genericUtility.webdriverUtility;

public class addPatientPage {

	WebDriver driver;
	webdriverUtility wutil = new webdriverUtility();
	

	public addPatientPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "patname")
	private WebElement patientNameTF;
	
	@FindBy(name = "patcontact")
	private WebElement patientContactNoTF;
	
	@FindBy(name = "patemail")
	private WebElement patientEmailTF;
	
	@FindBy(name = "pataddress")
	private WebElement patientAddressTF;
	
	@FindBy(name = "patage")
	private WebElement patientAgeTF;
	
	@FindBy(name = "medhis")
	private WebElement medicalHistoryTF;
	
	@FindBy(xpath = "//label[@for='rg-female']")
	private WebElement femaleRadioBtn;
	
	@FindBy(xpath = "//label[@for='rg-male']")
	private WebElement maleRadioBtn;
	
	@FindBy(id = "submit")
	private WebElement addBtn;

	
	
public WebElement getPatientNameTF() {
		return patientNameTF;
	}



	public WebElement getPatientContactNoTF() {
		return patientContactNoTF;
	}



	public WebElement getPatientEmailTF() {
		return patientEmailTF;
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



	public WebElement getFemaleRadioBtn() {
		return femaleRadioBtn;
	}



	public WebElement getMaleRadioBtn() {
		return maleRadioBtn;
	}



	public WebElement getAddBtn() {
		return addBtn;
	}



public void addNewPatient(StringBuilder patientName,StringBuilder patientContactNo,String patientEmail,String patientAddress,String patientAge,String medicalHistory) throws InterruptedException{
	
	getPatientNameTF().sendKeys(patientName);
	getPatientContactNoTF().sendKeys(patientContactNo);
	getPatientEmailTF().sendKeys(patientEmail);
	getPatientAddressTF().sendKeys(patientAddress);
	getPatientAgeTF().sendKeys(patientAge);
	getMedicalHistoryTF().sendKeys(medicalHistory);
	getFemaleRadioBtn().click();
	getAddBtn().click();

	
	}
	
	
	
	
	
	
}
