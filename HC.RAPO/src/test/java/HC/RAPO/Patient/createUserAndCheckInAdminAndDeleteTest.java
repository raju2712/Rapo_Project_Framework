package HC.RAPO.Patient;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import HC.RAPO.POM.AdminModule.adminHomePage;
import HC.RAPO.POM.AdminModule.adminLoginPage;
import HC.RAPO.POM.PatientModule.createNewAccountPage;
import HC.RAPO.POM.PatientModule.patientLoginPage;
import HC.RAPO.POM.WelcomePage.welcomePage;
import genericUtility.BaseClass;
import genericUtility.UtilityClassObject;
import genericUtility.excelFileUtility;
import genericUtility.propertyFileUtility;
import genericUtility.webdriverUtility;

@Listeners(genericUtility.ListenerImplementClass.class)
public class createUserAndCheckInAdminAndDeleteTest extends BaseClass {

	@Test(groups = "system")
	public void createPatient() throws IOException, Throwable {
		
		propertyFileUtility putil = new propertyFileUtility();
		webdriverUtility wutil = new webdriverUtility();
		excelFileUtility eutil = new excelFileUtility();
		
		welcomePage wp= new welcomePage(driver);
		patientLoginPage plp = new patientLoginPage(driver);
		createNewAccountPage cnap = new createNewAccountPage(driver);
		adminLoginPage alp = new adminLoginPage(driver);
		adminHomePage ahp = new adminHomePage(driver);
		
		String FULL_NAME = eutil.toReadDataFromExcel("patient", 1, 2);
		String ADDRESS = eutil.toReadDataFromExcel("patient", 1, 3);
		String CITY = eutil.toReadDataFromExcel("patient", 1, 4);
		String PASSWORD = eutil.toReadDataFromExcel("patient", 1, 6);
		String ADMIN_USERNAME = putil.toReadDataFromPropertyFile("adminUserName");
		String ADMIN_PASSWORD = putil.toReadDataFromPropertyFile("adminPassword");
		
		
		UtilityClassObject.getTest().log(Status.PASS,"Application opened");
		wp.toScrollDownToLoginAsPatient(driver);
		UtilityClassObject.getTest().log(Status.PASS,"Patient log in page opened");
		wutil.switchToTabOnUrl(driver, "hms/user-login.php");
		plp.getCreateAccountLink().click();
		wutil.switchToTabOnUrl(driver, "hms/registration.php");
		UtilityClassObject.getTest().log(Status.PASS,"Patient registration page opened");
		cnap.createNewAccount(FULL_NAME, ADDRESS, CITY, PASSWORD);
		UtilityClassObject.getTest().log(Status.PASS,"New Patient created");
		wutil.switchToTabOnTitle(driver, "Hospital management System");
		wp.toScrollDownToLoginAsAdmin(driver);
		UtilityClassObject.getTest().log(Status.PASS,"Admin login page opened");
		alp.LoginAsAdmin(ADMIN_USERNAME, ADMIN_PASSWORD);
		UtilityClassObject.getTest().log(Status.INFO, "Successfully logged in as Admin");
		ahp.getUsersTab().click();
		ahp.getManageUsersTab().click();
		UtilityClassObject.getTest().log(Status.INFO, "Manage patients page opened");
		
		//ToZoomOut
		 Robot robot = new Robot();
		 for(int i=0; i<3; i++){
			   robot.keyPress(KeyEvent.VK_CONTROL);
			   robot.keyPress(KeyEvent.VK_SUBTRACT);
			   robot.keyRelease(KeyEvent.VK_SUBTRACT);
			   robot.keyRelease(KeyEvent.VK_CONTROL);
			   
			   Thread.sleep(2000);
			  }
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		for (;;) {
			try {
				driver.findElement(By.xpath("//tr/td[text()='"+FULL_NAME+"']/../td[9]/div/a/i[@class='fa fa-times fa fa-white']")).click();
				break;
			} catch (Exception e) {
				jse.executeScript("window.scrollBy(0,100)");
			}
		}
		Thread.sleep(1000);
		wutil.toHandleAlertPopupByAccept(driver);
		UtilityClassObject.getTest().log(Status.INFO, "Registered user is removed");
		ahp.logoutAsAdmin();
		UtilityClassObject.getTest().log(Status.INFO, "logged out as admin");
		
		
	}
	
	
	
}
