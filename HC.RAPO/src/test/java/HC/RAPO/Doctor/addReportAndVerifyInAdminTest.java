package HC.RAPO.Doctor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import HC.RAPO.POM.AdminModule.adminHomePage;
import HC.RAPO.POM.AdminModule.adminLoginPage;
import HC.RAPO.POM.AdminModule.betweendateReportPage;
import HC.RAPO.POM.DoctorModule.addPatientPage;
import HC.RAPO.POM.DoctorModule.doctorHomePage;
import HC.RAPO.POM.DoctorModule.doctorLoginPage;
import HC.RAPO.POM.DoctorModule.patientViewPage;
import HC.RAPO.POM.WelcomePage.welcomePage;
import genericUtility.BaseClass;
import genericUtility.UtilityClassObject;
import genericUtility.excelFileUtility;
import genericUtility.javaUtility;
import genericUtility.propertyFileUtility;
import genericUtility.webdriverUtility;

@Listeners(genericUtility.ListenerImplementClass.class)
public class addReportAndVerifyInAdminTest extends BaseClass {
	
	@Parameters("BROWSER")
	@Test(groups = "integration")
	public void addReport() throws Throwable {
		
		webdriverUtility wutil = new webdriverUtility();
		welcomePage wp = new welcomePage(driver);
		doctorLoginPage dlp = new doctorLoginPage(driver);
		doctorHomePage dhp = new doctorHomePage(driver);
		propertyFileUtility putil = new propertyFileUtility();
		patientViewPage pvp = new patientViewPage(driver);
		excelFileUtility eutil = new excelFileUtility();
		adminLoginPage alp = new adminLoginPage(driver);
		adminHomePage ahp = new adminHomePage(driver);
		betweendateReportPage bdrp = new betweendateReportPage(driver);
		javaUtility jutil = new javaUtility();
		addPatientPage app = new addPatientPage(driver);
		
		String DOCTOR_USERNAME = putil.toReadDataFromPropertyFile("doctorUserName");
		String DOCTOR_PASSWORD = putil.toReadDataFromPropertyFile("doctorPassword");
		String BLOOD_PRESSURE = eutil.toReadDataFromExcel("doctor", 7, 2);
		String BLOOD_SUGAR = eutil.toReadDataFromExcel("doctor", 7, 3);
		String BODY_TEMPERATURE = eutil.toReadDataFromExcel("doctor", 7, 5);
		String WEIGHT = eutil.toReadDataFromExcel("doctor", 7, 4);
		String PRESCRIPTION = eutil.toReadDataFromExcel("doctor", 7, 6);
		StringBuilder PATIENT_NAME = jutil.getRandomName();
		String ADMIN_USERNAME = putil.toReadDataFromPropertyFile("adminUserName");
		String ADMIN_PASSWORD = putil.toReadDataFromPropertyFile("adminPassword");
		StringBuilder PATIENT_CONTACT_NO = jutil.getRandomMobileNumber();
		String PATIENT_EMAIL = "patient" + jutil.togetRandomNumber() + "@gmail.com";
		String PATIENT_ADDRESS = eutil.toReadDataFromExcel("doctor", 1, 5);
		String PATIENT_AGE = eutil.toReadDataFromExcel("doctor", 1, 6);
		String MEDICAL_HISTORY = eutil.toReadDataFromExcel("doctor", 1, 7);
	
		
		UtilityClassObject.getTest().log(Status.PASS,"Application opened");
		wp.toScrollDownToLoginAsDoctor(driver);
		UtilityClassObject.getTest().log(Status.PASS,"Doctor login page opened");
		dlp.loginAsDoctor(DOCTOR_USERNAME, DOCTOR_PASSWORD);
		UtilityClassObject.getTest().log(Status.PASS,"Successfully logged in as doctor");
		dhp.getPatientsTab().click();
		dhp.getAddPatientTab().click();
		UtilityClassObject.getTest().log(Status.PASS,"Add patient page opened");
		app.addNewPatient(PATIENT_NAME, PATIENT_CONTACT_NO, PATIENT_EMAIL, PATIENT_ADDRESS, PATIENT_AGE,MEDICAL_HISTORY);
		UtilityClassObject.getTest().log(Status.PASS,"New patient added");
		dhp.getPatientsTab().click();
		dhp.getManagePatientTab().click();
		UtilityClassObject.getTest().log(Status.PASS,"Manage patients page is opened");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		for (;;) {
			try {
				driver.findElement(By.xpath("//td[text()='"+PATIENT_NAME+"']/../td[7]/a/i[@class='fa fa-eye']")).click();
				break;
			} catch (Exception e) {
				jse.executeScript("window.scrollBy(0,100)");
			}
		}
		UtilityClassObject.getTest().log(Status.PASS,"Patient Viw page opened");
		wutil.jse(driver);
		pvp.getAddMedicalHistoryBtn().click();
		UtilityClassObject.getTest().log(Status.PASS,"Add medical history pop-up page opened");
		pvp.addMedicalHistory(BLOOD_PRESSURE, BLOOD_SUGAR, BODY_TEMPERATURE, WEIGHT, PRESCRIPTION);
		UtilityClassObject.getTest().log(Status.PASS,"Medical history added");
		dhp.logoutAsDoctor();
		UtilityClassObject.getTest().log(Status.PASS,"Logged out as doctor");
		wp.toScrollDownToLoginAsAdmin(driver);
		UtilityClassObject.getTest().log(Status.PASS,"Admin login page opened");
		alp.LoginAsAdmin(ADMIN_USERNAME, ADMIN_PASSWORD);
		UtilityClassObject.getTest().log(Status.PASS,"Succesfully logged in as Admin");
		ahp.getReportsTab().click();
		ahp.getBetweenDatesReportsTab().click();
		UtilityClassObject.getTest().log(Status.PASS,"Between date reports page opened");
		bdrp.enterBetweenDate();
		UtilityClassObject.getTest().log(Status.PASS,"From date and to date entered");
		ahp.logoutAsAdmin();
		UtilityClassObject.getTest().log(Status.PASS,"Logged out as Admin");
		
	}
}
