package datadriventesting;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDT_DP_EXCEL_DEMO {
	@Test(dataProvider = "google_search_data")
	public void google_search_validation(String search_text) throws Throwable {

		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver109.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();

		driver.findElement(By.name("q")).sendKeys(search_text);
		driver.findElement(By.xpath("//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[4]/center[1]/input[1]")).click();
		driver.close();

	}

	@DataProvider(name = "google_search_data")
	public Object[] search_Data() throws Throwable {

		String path = "./searchkeywords.xls";
		File fi = new File(path); // to open file
		FileInputStream fis = new FileInputStream(fi); // to read the file
		HSSFWorkbook xsw = new HSSFWorkbook(fis); // to create the workbook
		HSSFSheet hst = xsw.getSheet("textfile"); // to go to sheet
		int row_cnt = hst.getLastRowNum();
		Object[] data = new Object[row_cnt-1];
		for (int i = 1; i < row_cnt; i++) {
			 data[i-1] = hst.getRow(i).getCell(0).getStringCellValue();
		}
		return data;
	}
}
