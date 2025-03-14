package HC.RAPO.Patient;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import HC.RAPO.POM.DoctorModule.doctorHomePage;
import HC.RAPO.POM.DoctorModule.doctorLoginPage;
import HC.RAPO.POM.PatientModule.bookAppointmentPage;
import HC.RAPO.POM.PatientModule.patientHomePage;
import HC.RAPO.POM.PatientModule.patientLoginPage;
import HC.RAPO.POM.WelcomePage.welcomePage;
import genericUtility.BaseClass;
import genericUtility.UtilityClassObject;
import genericUtility.excelFileUtility;
import genericUtility.propertyFileUtility;
import genericUtility.webdriverUtility;

@Listeners(genericUtility.ListenerImplementClass.class)
public class createAppointmentAndVerifyTest extends BaseClass {

	@Test(groups = "integration")
	public void createAppointmentAndVerifyInDoctorTest() throws Throwable {

		propertyFileUtility putil = new propertyFileUtility();
		excelFileUtility eutil = new excelFileUtility();

		welcomePage wp = new welcomePage(driver);
		patientLoginPage plp = new patientLoginPage(driver);
		patientHomePage php = new patientHomePage(driver);
		bookAppointmentPage bap = new bookAppointmentPage(driver);
		doctorLoginPage dlp = new doctorLoginPage(driver);
		doctorHomePage dhp = new doctorHomePage(driver);

		String PATIENT_USERNAME = putil.toReadDataFromPropertyFile("patientUserName");
		String PATIENT_PASSWORD = putil.toReadDataFromPropertyFile("patientPassword");
		String DOCTOR_USERNAME = putil.toReadDataFromPropertyFile("doctorUserName");
		String DOCTOR_PASSWORD = putil.toReadDataFromPropertyFile("doctorPassword");
		String SPECIALIZATION = eutil.toReadDataFromExcel("patient", 4, 2);
		//String DOCTOR = eutil.toReadDataFromExcel("patient", 4, 3);

		UtilityClassObject.getTest().log(Status.PASS,"Application opened");
		wp.toScrollDownToLoginAsPatient(driver);
		UtilityClassObject.getTest().log(Status.PASS,"Patient log in page opened");
		plp.loginAsPatient(PATIENT_USERNAME, PATIENT_PASSWORD);
		UtilityClassObject.getTest().log(Status.PASS,"Successfully logged in as patient");
		php.getBookAppointmentLink().click();
		UtilityClassObject.getTest().log(Status.PASS,"Book appointment page opened");
		bap.putAppointment(SPECIALIZATION);
		UtilityClassObject.getTest().log(Status.PASS,"Appointment created");
		php.logoutAsPatient();

		wp.toScrollDownToLoginAsDoctor(driver);
		UtilityClassObject.getTest().log(Status.PASS,"Doctor login page opened");
		dlp.loginAsDoctor(DOCTOR_USERNAME, DOCTOR_PASSWORD);
		UtilityClassObject.getTest().log(Status.PASS,"Successfully logged in as doctor");
		dhp.getAppointmentHistoryLink().click();
		/**
		 * verify steps
		 */
		dhp.logoutAsDoctor();
		UtilityClassObject.getTest().log(Status.PASS,"Logged out as doctor");

	}
}
