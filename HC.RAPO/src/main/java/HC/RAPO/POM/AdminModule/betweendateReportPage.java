package HC.RAPO.POM.AdminModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.javaUtility;

public class betweendateReportPage {

	WebDriver driver;
	javaUtility jutil = new javaUtility();

	public betweendateReportPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='fromdate']")
	private WebElement fromDateIcon;
	
	@FindBy(xpath = "//input[@id='todate']")
	private WebElement toDateIcon;
	
	@FindBy(id = "submit")
	private WebElement submitBtn;

	public WebElement getFromDateIcon() {
		return fromDateIcon;
	}

	public WebElement getToDateIcon() {
		return toDateIcon;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	public void enterBetweenDate() {
		String fromDate = jutil.togetRequiredDate(30);
		String toDate = jutil.togetSystemDateYYYYMMDD();
        getFromDateIcon().sendKeys(fromDate);
	    getToDateIcon().sendKeys(toDate);
		getSubmitBtn().click();
	}
	
}
