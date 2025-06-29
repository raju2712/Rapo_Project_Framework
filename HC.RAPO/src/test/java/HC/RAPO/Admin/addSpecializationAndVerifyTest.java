package HC.RAPO.Admin;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
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
public class addSpecializationAndVerifyTest extends BaseClass{

	@Parameters("BROWSER")
	@Test(groups = "integration")
	public void addSpecializationTest() throws Throwable {
		
		propertyFileUtility putil = new propertyFileUtility();
		welcomePage wp = new welcomePage(driver);
		adminLoginPage alp = new adminLoginPage(driver);
		adminHomePage ahp = new adminHomePage(driver);
		doctorSpecializationPage dsp = new doctorSpecializationPage(driver);
		javaUtility jutil = new javaUtility();
		excelFileUtility eutil = new excelFileUtility();
		
		String ADMIN_USERNAME = putil.toReadDataFromPropertyFile("adminUserName");
		String ADMIN_PASSWORD = putil.toReadDataFromPropertyFile("adminPassword");
		String SPECIALIZATION = eutil.toReadDataFromExcel("admin", 4, 2);
		String randomSpec = SPECIALIZATION + jutil.togetRandomNumber();
		
		wp.toScrollDownToLoginAsAdmin(driver);
		alp.LoginAsAdmin(ADMIN_USERNAME, ADMIN_PASSWORD);
		ahp.getDoctorsTab().click();
		ahp.getDoctorSpecializationTab().click();
		dsp.getDoctorSpecilizationTF().sendKeys(randomSpec);
		dsp.getSubmitBtn().click();
		
		String actualSpecialization;
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		for (;;) {
			try {
				actualSpecialization = driver.findElement(By.xpath("//tr//td[text()='"+randomSpec+"']")).getText();
				break;
			} catch (Exception e) {
				jse.executeScript("window.scrollBy(0,500)");
			}
		}

		org.testng.Assert.assertEquals(actualSpecialization, randomSpec);
		ahp.logoutAsAdmin();
		
	}
}
