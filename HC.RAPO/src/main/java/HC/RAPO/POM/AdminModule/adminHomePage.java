package HC.RAPO.POM.AdminModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class adminHomePage {

	WebDriver driver;

	public adminHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='item-inner']//span[normalize-space()='Dashboard']")
	private WebElement myDashBoardTab;
	
	@FindBy(xpath = "//div[@class='item-inner']//span[normalize-space()='Doctors']")
	private WebElement doctorsTab;
	
	@FindBy(xpath = "//a[@href='doctor-specilization.php']")
	private WebElement doctorSpecializationTab;
	
	@FindBy(xpath = "//a[@href='add-doctor.php']")
	private WebElement addDoctorTab;
	
	@FindBy(xpath = "//a[@href='Manage-doctors.php']")
	private WebElement manageDoctorTab;
	
	@FindBy(xpath = "//div[@class='item-inner']//span[normalize-space()='Users']")
	private WebElement usersTab;
	
	@FindBy(xpath = "//a[@href='manage-users.php']")
	private WebElement manageUsersTab;
	
	@FindBy(xpath = "//div[@class='item-inner']//span[normalize-space()='Patients']")
	private WebElement patientsTab;
	
	@FindBy(xpath = "//a[@href='manage-patient.php']")
	private WebElement managePatientsTab;
	
	@FindBy(xpath = "//div[@class='item-inner']//span[normalize-space()='Appointment History']")
	private WebElement appointmentHistoryTab;
	
	@FindBy(xpath = "//div[@class='item-inner']//span[normalize-space()='Doctor Session Logs']")
	private WebElement  doctorSessionLogsTab;
	
	@FindBy(xpath = "//div[@class='item-inner']//span[normalize-space()='User Session Logs']")
	private WebElement userSessionLogsTab;
	
	@FindBy(xpath = "//div[@class='item-inner']//span[normalize-space()='Reports']")
	private WebElement reportsTab;
	
	@FindBy(xpath = "//a[@href='between-dates-reports.php']")
	private WebElement betweenDatesReportsTab;
	
	@FindBy(xpath = "//div[@class='item-inner']//span[normalize-space()='Patient Search']")
	private WebElement patientSearchTab;
	
	@FindBy(xpath = "//img[@src='assets/images/images.jpg']")
	private WebElement profileIcon;
	
	@FindBy(xpath = "//a[contains(text(),'Log Out')]")
	private WebElement logOutLink;

	public WebElement getMyDashBoardTab() {
		return myDashBoardTab;
	}

	public WebElement getDoctorsTab() {
		return doctorsTab;
	}

	public WebElement getDoctorSpecializationTab() {
		return doctorSpecializationTab;
	}

	public WebElement getAddDoctorTab() {
		return addDoctorTab;
	}

	public WebElement getManageDoctorTab() {
		return manageDoctorTab;
	}

	public WebElement getUsersTab() {
		return usersTab;
	}

	public WebElement getManageUsersTab() {
		return manageUsersTab;
	}

	public WebElement getPatientsTab() {
		return patientsTab;
	}

	public WebElement getManagePatientsTab() {
		return managePatientsTab;
	}

	public WebElement getAppointmentHistoryTab() {
		return appointmentHistoryTab;
	}

	public WebElement getDoctorSessionLogsTab() {
		return doctorSessionLogsTab;
	}

	public WebElement getUserSessionLogsTab() {
		return userSessionLogsTab;
	}

	public WebElement getReportsTab() {
		return reportsTab;
	}

	public WebElement getBetweenDatesReportsTab() {
		return betweenDatesReportsTab;
	}

	public WebElement getPatientSearchTab() {
		return patientSearchTab;
	}

	public WebElement getProfileIcon() {
		return profileIcon;
	}

	public WebElement getLogOutLink() {
		return logOutLink;
	}
	
	public void logoutAsAdmin() {
		getProfileIcon().click();
		getLogOutLink().click();
	}
	
	
}
