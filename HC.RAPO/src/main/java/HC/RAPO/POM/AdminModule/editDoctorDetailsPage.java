package HC.RAPO.POM.AdminModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class editDoctorDetailsPage {

	WebDriver driver;

	public editDoctorDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "Doctorspecialization")
	private WebElement doctorSpecilizationDropDown;
	
	@FindBy(name = "docname")
	private WebElement doctorNameTF;
	
	@FindBy(name = "clinicaddress")
	private WebElement clinicAddressTF;
	
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

	public WebElement getDoctorContactTF() {
		return doctorContactTF;
	}

	public WebElement getUpdateBtn() {
		return UpdateBtn;
	}

	@FindBy(name = "docfees")
	private WebElement doctorFeesTF;
	
	@FindBy(name = "doccontact")
	private WebElement doctorContactTF;
	
	@FindBy(name = "submit")
	private WebElement UpdateBtn;
	
	
	
}
