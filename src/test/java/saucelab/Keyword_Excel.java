package saucelab;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Keyword_Excel {
	@Test(dataProvider = "search_validation")
	public void searchTextfromExcel(String search_text) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver109.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://saucelabs.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//header/div[1]/div[1]/div[2]/div[1]/button[1]/div[1]/span[1]/img[1]")).click();
		driver.findElement(By.xpath("//input[@id='search']")).sendKeys(search_text);
		Thread.sleep(10000);
		driver.close();
		

		
	}

	@DataProvider(name = "search_validation")
	public Object[] search_data() throws Throwable {
		String path = "./searchkeywords.xls";
		File fi = new File(path);
		FileInputStream fis = new FileInputStream(fi);
		HSSFWorkbook xsw = new HSSFWorkbook(fis);
		HSSFSheet hst = xsw.getSheet("Sheet1");
		int row_cnt = hst.getLastRowNum();
		Object[] data = new Object[row_cnt];
		for (int i = 0; i < row_cnt; i++) {
			data[i] = hst.getRow(i+1).getCell(0).getStringCellValue();
		}
		System.out.println(data);
		return data;

	}
}
