package HC.RAPO.POM.AdminModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class addDoctorSpecializationPage {

	WebDriver driver;

	public addDoctorSpecializationPage(WebDriver driver) {
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
