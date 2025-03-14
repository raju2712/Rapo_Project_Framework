package HC.RAPO.POM.AdminModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class patientSearchPage {
	
	WebDriver driver;

	public patientSearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "searchdata")
	private WebElement searchTF;
	
	@FindBy(id = "submit")
	private WebElement searchBtn;

	public WebElement getSearchTF() {
		return searchTF;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	
	

}
