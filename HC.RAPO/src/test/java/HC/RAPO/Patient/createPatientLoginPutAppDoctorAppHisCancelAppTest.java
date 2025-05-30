package HC.RAPO.Patient;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import HC.RAPO.POM.DoctorModule.doctorHomePage;
import HC.RAPO.POM.DoctorModule.doctorLoginPage;
import HC.RAPO.POM.PatientModule.bookAppointmentPage;
import HC.RAPO.POM.PatientModule.createNewAccountPage;
import HC.RAPO.POM.PatientModule.patientHomePage;
import HC.RAPO.POM.PatientModule.patientLoginPage;
import HC.RAPO.POM.WelcomePage.welcomePage;
import genericUtility.BaseClass;
import genericUtility.UtilityClassObject;
import genericUtility.excelFileUtility;
import genericUtility.propertyFileUtility;
import genericUtility.webdriverUtility;

@Listeners(genericUtility.ListenerImplementClass.class)
public class createPatientLoginPutAppDoctorAppHisCancelAppTest extends BaseClass{

	@Parameters("BROWSER")
	@Test(groups = "system")
	public void createPatientAndLogin() throws IOException, Throwable {
		
		welcomePage wp = new welcomePage(driver);
		webdriverUtility wutil = new webdriverUtility();
		patientLoginPage plp = new patientLoginPage(driver);
		createNewAccountPage cnap = new createNewAccountPage(driver);
		excelFileUtility eutil = new excelFileUtility();
		propertyFileUtility putil = new propertyFileUtility();
		patientHomePage php = new patientHomePage(driver);
		bookAppointmentPage bap = new bookAppointmentPage(driver);
		doctorLoginPage dlp = new doctorLoginPage(driver);
		doctorHomePage dhp = new doctorHomePage(driver);
		
		String FULL_NAME = eutil.toReadDataFromExcel("patient", 1, 2);
		String ADDRESS = eutil.toReadDataFromExcel("patient", 1, 3);
		String CITY = eutil.toReadDataFromExcel("patient", 1, 4);
		//String EMAIL = eutil.toReadDataFromExcel("patient", 1, 5);
		String PASSWORD = eutil.toReadDataFromExcel("patient", 1, 6);
		String PATIENT_USERNAME = putil.toReadDataFromPropertyFile("patientUserName");
		String PATIENT_PASSWORD = putil.toReadDataFromPropertyFile("patientPassword");
		String SPECIALIZATION = eutil.toReadDataFromExcel("patient", 4, 2);
		String DOCTOR_USERNAME = putil.toReadDataFromPropertyFile("doctorUserName");
		String DOCTOR_PASSWORD = putil.toReadDataFromPropertyFile("doctorPassword");
		
		UtilityClassObject.getTest().log(Status.PASS,"Application opened");
		wp.toScrollDownToLoginAsPatient(driver);
		wutil.switchWindowUsiingPartialUrl(driver, "hms/user-login.php");
		UtilityClassObject.getTest().log(Status.PASS,"Patient log in page opened");
		plp.getCreateAccountLink().click();
		wutil.switchWindowUsiingPartialUrl(driver, "hms/registration.php");
		UtilityClassObject.getTest().log(Status.PASS,"User registration page opened");
		cnap.createNewAccount(FULL_NAME, ADDRESS, CITY, PASSWORD);
		UtilityClassObject.getTest().log(Status.PASS,"New user created");
	    wutil.SwitchWindowUsingPartialTitle(driver, "Hospital management System");
	    UtilityClassObject.getTest().log(Status.PASS,"Switched back to welcome page");
		wp.toScrollDownToLoginAsPatient(driver);
		UtilityClassObject.getTest().log(Status.PASS,"Patient log in page opened");
		plp.loginAsPatient(PATIENT_USERNAME, PATIENT_PASSWORD);
		UtilityClassObject.getTest().log(Status.PASS,"Successfully logged in as patient");
		php.getBookAppointmentTab().click();
		UtilityClassObject.getTest().log(Status.PASS,"Book appointment page opened");
		bap.putAppointment(SPECIALIZATION);
		UtilityClassObject.getTest().log(Status.PASS,"Appointment created");
		String userName = php.getUserName().getText();
		php.logoutAsPatient();
		wp.toScrollDownToLoginAsDoctor(driver);
		UtilityClassObject.getTest().log(Status.PASS,"Doctor login page opened");
		dlp.loginAsDoctor(DOCTOR_USERNAME, DOCTOR_PASSWORD);
		UtilityClassObject.getTest().log(Status.PASS,"Successfully logged in as doctor");
		dhp.getAppointmentHistoryLink().click();
		UtilityClassObject.getTest().log(Status.PASS,"Appointment history page opened");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		for (;;) {
			try {
				driver.findElement(By.xpath("//td[contains(text(),'"+userName+"')]/../td[8]/div/a[@title='Cancel Appointment']")).click();
				break;
			} catch (Exception e) {
				jse.executeScript("window.scrollBy(0,100)");
			}
		}
		wutil.toHandleAlertPopupByAccept(driver);
		UtilityClassObject.getTest().log(Status.PASS,"Appointment Cancelled");
	    dhp.logoutAsDoctor();
	    UtilityClassObject.getTest().log(Status.PASS,"Logged out as doctor");
	}
}
