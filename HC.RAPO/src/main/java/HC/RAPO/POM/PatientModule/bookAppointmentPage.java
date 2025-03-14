package HC.RAPO.POM.PatientModule;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.javaUtility;
import genericUtility.webdriverUtility;

public class bookAppointmentPage {

	WebDriver driver;
	webdriverUtility wutil = new webdriverUtility();

	public bookAppointmentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "Doctorspecialization")
	private WebElement doctorSpecializationDropDown;
	
	@FindBy(id = "doctor")
	private WebElement doctorNameDropDown;
	
	@FindBy(name = "appdate")
	private WebElement dateTF;
	
	@FindBy(name = "apptime")
	private WebElement timeTF;
	
	public WebElement getDoctorSpecializationDropDown() {
		return doctorSpecializationDropDown;
	}

	public WebElement getDoctorNameDropDown() {
		return doctorNameDropDown;
	}

	public WebElement getDateTF() {
		return dateTF;
	}

	public WebElement getTimeTF() {
		return timeTF;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	@FindBy(name = "submit")
	private WebElement submitBtn;
	
public void putAppointment(String SPECIALIZATION) throws InterruptedException {
		
		WebElement specDD = getDoctorSpecializationDropDown();
		wutil.toHandleDropDown(specDD, SPECIALIZATION);
		WebElement dNameDD = getDoctorNameDropDown();
		wutil.toHandleDropDown(dNameDD, "229");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,500)");
		getDateTF().click();
		driver.findElement(By.xpath("//tbody//tr//td[@class='day' and text()='27']")).click();
		// give preffered time
		getSubmitBtn().click();
		Thread.sleep(2000);
		wutil.toHandleAlertPopupByAccept(driver);
		
	}
	
	
}
