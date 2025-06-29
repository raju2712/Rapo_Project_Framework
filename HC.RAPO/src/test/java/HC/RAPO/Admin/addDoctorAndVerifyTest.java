package HC.RAPO.Admin;

import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.aventstack.extentreports.Status;

import HC.RAPO.POM.AdminModule.addDoctorPage;
import HC.RAPO.POM.AdminModule.adminHomePage;
import HC.RAPO.POM.AdminModule.adminLoginPage;
import HC.RAPO.POM.DoctorModule.doctorSpecializationPage;
import HC.RAPO.POM.WelcomePage.welcomePage;
import genericUtility.BaseClass;
import genericUtility.UtilityClassObject;
import genericUtility.excelFileUtility;
import genericUtility.javaUtility;
import genericUtility.propertyFileUtility;

@Listeners(genericUtility.ListenerImplementClass.class)
public class addDoctorAndVerifyTest extends BaseClass {

	@Parameters("BROWSER")
	@Test(groups = "integration")
	public void addDoctorTest(XmlTest test) throws Throwable {

		propertyFileUtility putil = new propertyFileUtility();
		welcomePage wp = new welcomePage(driver);
		adminLoginPage alp = new adminLoginPage(driver);
		adminHomePage ahp = new adminHomePage(driver);
		javaUtility jutil = new javaUtility();
		addDoctorPage adp = new addDoctorPage(driver);
		excelFileUtility eutil = new excelFileUtility();
		doctorSpecializationPage dsp = new doctorSpecializationPage(driver);

		String ADMIN_USERNAME = putil.toReadDataFromPropertyFile("adminUserName");
		String ADMIN_PASSWORD = putil.toReadDataFromPropertyFile("adminPassword");
		StringBuilder DOCTOR_NAME = jutil.getRandomName();
		String SPECIALIZATION = eutil.toReadDataFromExcel("admin", 4, 2);
		String randomSpec = SPECIALIZATION + jutil.togetRandomNumber();
		StringBuilder CLINIC_ADDRESS = jutil.getRandomName();
		StringBuilder FEES = jutil.getRandomMobileNumber();
		StringBuilder CONTACT_NO = jutil.getRandomMobileNumber();
		String EMAIL = eutil.toReadDataFromExcel("admin", 4, 3) + jutil.togetRandomNumber() + "@gmail.com";
		StringBuilder PASSWORD = jutil.getRandomName();

		wp.toScrollDownToLoginAsAdmin(driver);
		alp.LoginAsAdmin(ADMIN_USERNAME, ADMIN_PASSWORD);
		ahp.getDoctorsTab().click();
		ahp.getDoctorSpecializationTab().click();
		dsp.getDoctorSpecilizationTF().sendKeys(randomSpec);
		dsp.getSubmitBtn().click();
		ahp.getDoctorsTab().click();
		ahp.getAddDoctorTab().click();
		adp.createDoctor(randomSpec, DOCTOR_NAME, CLINIC_ADDRESS, FEES, CONTACT_NO, EMAIL, PASSWORD);
		
//		WebElement pencilEdit = driver.findElement(By.xpath("//tr/td[text()='"+DOCTOR_NAME+"']/../td[5]/div/a/i[@class='fa fa-pencil']"));
//		WebElement removeIcon = driver.findElement(By.xpath("//tr/td[text()='"+DOCTOR_NAME+"']/../td[5]/div/a/i[@class='fa fa-times fa fa-white']"));
		String docName = driver.findElement(By.xpath("//tr/td[text()='" + DOCTOR_NAME + "']")).getText();
		
	//Assertion
		Assert.assertTrue(docName.contains(DOCTOR_NAME));
		ahp.logoutAsAdmin();
		
	}
}
