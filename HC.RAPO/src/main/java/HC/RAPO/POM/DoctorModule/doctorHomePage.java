package HC.RAPO.POM.DoctorModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class doctorHomePage {
	
	WebDriver driver;

	public doctorHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[contains(text(),'Appointment History')]")
	private WebElement appointmentHistoryLink;
	
	@FindBy(xpath = "//a[contains(text(),'Update Profile')]")
	private WebElement updateProfileLink;
	
	@FindBy(xpath = "//div[@class='item-inner']//span[normalize-space()='Patients']")
	private WebElement patientsTab;
	
	@FindBy(xpath = "//a[@href='add-patient.php']")
	private WebElement addPatientTab;
	
	@FindBy(xpath = "//a[@href='manage-patient.php']")
	private WebElement managePatientTab;
	
	@FindBy(xpath = "//div[@class='item-inner']//span[normalize-space()='Dashboard']")
	private WebElement myDashBoardTab;
	
	@FindBy(xpath = "//div[@class='item-inner']//span[normalize-space()='Search']")
	private WebElement searchTab;
	
	@FindBy(xpath = "//img[@src='assets/images/images.jpg']")
	private WebElement profileIcon;
	
	@FindBy(xpath = "//a[contains(text(),'Log Out')]")
	private WebElement logOutLink;

	public WebElement getAppointmentHistoryLink() {
		return appointmentHistoryLink;
	}

	public WebElement getUpdateProfileLink() {
		return updateProfileLink;
	}

	public WebElement getPatientsTab() {
		return patientsTab;
	}

	public WebElement getAddPatientTab() {
		return addPatientTab;
	}

	public WebElement getManagePatientTab() {
		return managePatientTab;
	}

	public WebElement getMyDashBoardTab() {
		return myDashBoardTab;
	}

	public WebElement getSearchTab() {
		return searchTab;
	}

	public WebElement getProfileIcon() {
		return profileIcon;
	}

	public WebElement getLogOutLink() {
		return logOutLink;
	}
	
	public void logoutAsDoctor() {
	getProfileIcon().click();
	getLogOutLink().click();
	}
	
}
