package HC.RAPO.POM.DoctorModule;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.webdriverUtility;

public class patientViewPage {

	WebDriver driver;
	webdriverUtility wutil = new webdriverUtility();

	public patientViewPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[@class='btn btn-primary waves-effect waves-light w-lg']")
	private WebElement addMedicalHistoryBtn;
	
	@FindBy(name = "bp")
	private WebElement bloodPressureTF;
	
	@FindBy(name = "bs")
	private WebElement bloodSugarTF;
	
	@FindBy(name = "weight")
	private WebElement weightTF;
	
	@FindBy(xpath = "//tbody/tr[4]/td/input[@placeholder=\"Blood Sugar\"]")
	private WebElement bodyTemperatureTF;
	
	@FindBy(xpath = "//tbody/tr[5]/td/textarea[@placeholder=\"Medical Prescription\"]")
	private WebElement prescriptionTF;
	
	@FindBy(name = "submit")
	private WebElement submitBtn;
	
	@FindBy(xpath = "//button[@class='btn btn-secondary']")
	private WebElement closeBtn;

	public WebElement getAddMedicalHistoryBtn() {
		return addMedicalHistoryBtn;
	}

	public WebElement getBloodPressureTF() {
		return bloodPressureTF;
	}

	public WebElement getBloodSugarTF() {
		return bloodSugarTF;
	}

	public WebElement getWeightTF() {
		return weightTF;
	}

	public WebElement getBodyTemperatureTF() {
		return bodyTemperatureTF;
	}

	public WebElement getPrescriptionTF() {
		return prescriptionTF;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public WebElement getCloseBtn() {
		return closeBtn;
	}
	
	public void addMedicalHistory(String BLOOD_PRESSURE,String BLOOD_SUGAR,String BODY_TEMPERATURE,String WEIGHT,String PRESCRIPTION  ) throws AWTException, InterruptedException {
		getBloodPressureTF().sendKeys(BLOOD_PRESSURE);
		getBloodSugarTF().sendKeys(BLOOD_SUGAR);
		getWeightTF().sendKeys(WEIGHT);
		getBodyTemperatureTF().sendKeys(BODY_TEMPERATURE);
		getPrescriptionTF().sendKeys(PRESCRIPTION);
		wutil.toZoomOut(driver);
		driver.findElement(By.xpath("//button[@name='submit']")).click();
		//getSubmitBtn().click();
		Thread.sleep(1000);
		wutil.toHandleAlertPopupByAccept(driver);
	}
	
	
     
	
	
}
