package HC.RAPO.POM.DoctorModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.webdriverUtility;

public class doctorSpecializationPage {

	WebDriver driver;
	webdriverUtility wutil = new webdriverUtility();
	

	public doctorSpecializationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "doctorspecilization")
	private WebElement doctorSpecilizationTF;
	
	@FindBy(name = "submit")
	private WebElement submitBtn;


	public WebElement getDoctorSpecilizationTF() {
		return doctorSpecilizationTF;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
}
