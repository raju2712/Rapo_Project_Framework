package NestedFrame_Model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Flip {

	@Test
	public void Amazon() throws Throwable {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://www.flipkart.in/");
		driver.findElement(By.name("q")).sendKeys("iphone16", Keys.ENTER);

		List<WebElement> Pname = driver.findElements(By.xpath("//div[@class=\"yKfJKb row\"]/descendant::div[@class=\"KzDlHZ\"]"));
		List<WebElement> Pprice = driver.findElements(By.xpath("//div[@class=\"yKfJKb row\"]/descendant::div[@class=\"Nx9bqj _4b5DiR\"]"));

		for (int i = 0; i <= Pname.size()-1; i++) {

			String Name = Pname.get(i).getText();
			String Price = Pprice.get(i).getText();
			
//			System.out.println(Name);
//			System.out.println(Price);

			FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData4.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			wb.getSheet("Sheet1").createRow(i).createCell(0, CellType.STRING).setCellValue(Name);
			wb.getSheet("Sheet1").getRow(i).createCell(1, CellType.STRING).setCellValue(Price);
			FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\TestData4.xlsx");
			wb.write(fos);
			wb.close();
			
		}
		driver.quit();
	}

}
