package HC.RAPO.POM.DoctorModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.javaUtility;

public class managePatientPage {

	WebDriver driver;
	StringBuilder PATIENT_NAME;
	javaUtility jutil = new javaUtility();

	public managePatientPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[contains(text(),'Appointment History')]")
	private WebElement appointmentHistoryLink;

	public WebElement getAppointmentHistoryLink() {
		return appointmentHistoryLink;
	}
	
	
	
	
}
	
	
	
	

