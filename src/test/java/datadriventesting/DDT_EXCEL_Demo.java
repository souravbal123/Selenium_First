package datadriventesting;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Path;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DDT_EXCEL_Demo {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub

		String path = "./searchkeywords.xls";
		File fi = new File(path); // to open file
		FileInputStream fis = new FileInputStream(fi); // to read the file
		HSSFWorkbook xsw = new HSSFWorkbook(fis); // to create the workbook
		HSSFSheet hst = xsw.getSheet("textfile"); // to go to sheet
		int row_cnt = hst.getLastRowNum(); // to get nos of rows
		for (int i = 1; i < row_cnt; i++) {
			int col_cnt = hst.getRow(i).getLastCellNum(); // to get the column count in a row
			String search_text = hst.getRow(i).getCell(0).getStringCellValue();
			System.out.println(search_text);
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver109.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.google.com/");
			driver.manage().window().maximize();

			driver.findElement(By.name("q")).sendKeys(search_text);
			driver.findElement(By.xpath("//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[4]/center[1]/input[1]"))
					.click();
			driver.close();

		}
	}

}
