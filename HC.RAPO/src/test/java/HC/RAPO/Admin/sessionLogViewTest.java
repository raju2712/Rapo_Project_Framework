package HC.RAPO.Admin;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import HC.RAPO.POM.AdminModule.adminHomePage;
import HC.RAPO.POM.AdminModule.adminLoginPage;
import HC.RAPO.POM.WelcomePage.welcomePage;
import genericUtility.BaseClass;
import genericUtility.UtilityClassObject;
import genericUtility.excelFileUtility;
import genericUtility.propertyFileUtility;
import genericUtility.webdriverUtility;

@Listeners(genericUtility.ListenerImplementClass.class)
public class sessionLogViewTest extends BaseClass {

	@Parameters("BROWSER")
	@Test(groups = "smoke")
	public void adminCanSeeSessionLogOfDoctorTest() throws Throwable {
		welcomePage wp = new welcomePage(driver);
		propertyFileUtility putil = new propertyFileUtility();
		adminLoginPage alp = new adminLoginPage(driver);
		adminHomePage ahp = new adminHomePage(driver);
		webdriverUtility wutil = new webdriverUtility();
		excelFileUtility eutil = new excelFileUtility();
		
		String ADMIN_USERNAME = putil.toReadDataFromPropertyFile("adminUserName");
		String ADMIN_PASSWORD = putil.toReadDataFromPropertyFile("adminPassword");
		String EXPECTED_TITLE = eutil.toReadDataFromExcel("doctor", 10, 2);
		
		UtilityClassObject.getTest().log(Status.INFO, "Application Opened");
		wp.toScrollDownToLoginAsAdmin(driver);
		UtilityClassObject.getTest().log(Status.INFO, "Admin Login Page Opened");
		alp.LoginAsAdmin(ADMIN_USERNAME, ADMIN_PASSWORD);
		UtilityClassObject.getTest().log(Status.INFO, "Successfully logged in as Admin");
		ahp.getDoctorSessionLogsTab().click();
		UtilityClassObject.getTest().log(Status.INFO, "Doctor session log page opened");
		String actualTitle = wutil.toGetTitleoFWebPage(driver);
		Assert.assertEquals(actualTitle, EXPECTED_TITLE);
		ahp.logoutAsAdmin();
		UtilityClassObject.getTest().log(Status.INFO, "Successfully logged out as Admin");
		wutil.switchToTabOnTitle(driver, "Hospital management System");
		UtilityClassObject.getTest().log(Status.INFO, "Switched back to Welcome Page");
		wutil.switchToTabOnTitle(driver, "Hospital management System");
		
	}
	
	@Parameters("BROWSER")
	@Test(groups = "smoke")
	public void adminCanSeeSessionLogOfUserTest() throws Throwable {
		welcomePage wp = new welcomePage(driver);
		propertyFileUtility putil = new propertyFileUtility();
		adminLoginPage alp = new adminLoginPage(driver);
		adminHomePage ahp = new adminHomePage(driver);
		excelFileUtility eutil = new excelFileUtility();
		webdriverUtility wutil = new webdriverUtility();
		
		String ADMIN_USERNAME = putil.toReadDataFromPropertyFile("adminUserName");
		String ADMIN_PASSWORD = putil.toReadDataFromPropertyFile("adminPassword");
		String EXPECTED_TITLE = eutil.toReadDataFromExcel("doctor", 13, 2);
		
		wp.toScrollDownToLoginAsAdmin(driver);
		UtilityClassObject.getTest().log(Status.INFO, "Admin Login Page Opened");
		alp.LoginAsAdmin(ADMIN_USERNAME, ADMIN_PASSWORD);
		UtilityClassObject.getTest().log(Status.INFO, "Successfully logged in as Admin");
		ahp.getUserSessionLogsTab().click();
		UtilityClassObject.getTest().log(Status.INFO, "User session log page opened");
		String actualTitle = wutil.toGetTitleoFWebPage(driver);
		Assert.assertEquals(actualTitle, EXPECTED_TITLE);
		UtilityClassObject.getTest().log(Status.INFO, "Patient session logs page opened");
		ahp.logoutAsAdmin();
		UtilityClassObject.getTest().log(Status.INFO, "Successfully logged out as Admin");
		wutil.switchToTabOnTitle(driver, "Hospital management System");
		UtilityClassObject.getTest().log(Status.INFO, "Switched back to Welcome Page");
		wutil.switchToTabOnTitle(driver, "Hospital management System");
	}
}
