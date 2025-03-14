package HC.RAPO.POM.PatientModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class patientHomePage {

	public WebElement getProfileIcon() {
		return profileIcon;
	}

	WebDriver driver;

	public patientHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[contains(text(),'Book Appointment')]")
	private WebElement bookAppointmentLink;
	
	@FindBy(xpath = "//a[contains(text(),'View Appointment History')]")
	private WebElement myAppointmentHistoryLink;
	
	@FindBy(xpath = "//a[contains(text(),'Update Profile')]")
	private WebElement updateProfileLink;
	
	@FindBy(xpath = "//div[@class='item-inner']//span[normalize-space()='Book Appointment']")
	private WebElement bookAppointmentTab;
	
	@FindBy(xpath = "//span[normalize-space()='Appointment History']")
	private WebElement appointmentHistoryTab;
	
	@FindBy(xpath = "//div[@class='item-inner']//span[normalize-space()='Medical History']")
	private WebElement medicalHistoryTab;
	
	@FindBy(xpath = "//div[@class='item-inner']//span[normalize-space()='Dashboard']")
	private WebElement myDashBoardTab;
	
	@FindBy(xpath = "//img[@src='assets/images/images.jpg']")
	private WebElement profileIcon;
	
	@FindBy(xpath = "//a[contains(text(),'Log Out')]")
	private WebElement logOutLink;
	
	@FindBy(xpath = "//span[@class='username']")
	private WebElement userName;
	
	

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getLogOutLink() {
		return logOutLink;
	}

	public WebElement getAppointmentHistoryTab() {
		return appointmentHistoryTab;
	}

	public WebElement getBookAppointmentTab() {
		return bookAppointmentTab;
	}

	public WebElement getMedicalHistoryTab() {
		return medicalHistoryTab;
	}

	public WebElement getMyDashBoardTab() {
		return myDashBoardTab;
	}

	public WebElement getBookAppointmentLink() {
		return bookAppointmentLink;
	}

	public WebElement getMyAppointmentHistoryLink() {
		return myAppointmentHistoryLink;
	}

	public WebElement getUpdateProfileLink() {
		return updateProfileLink;
	}
	
	public void logoutAsPatient() {
		getProfileIcon().click();
		getLogOutLink().click();
	}
	
	
	
}
