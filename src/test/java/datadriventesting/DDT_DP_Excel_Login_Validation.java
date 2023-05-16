package datadriventesting;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDT_DP_Excel_Login_Validation {
	@Test(dataProvider = "login_validation")
	public void Login_valid(String username, String password) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver109.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys(username);
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"login\"]")).click();
		Thread.sleep(2000);
		String logout_link = driver.findElement(By.xpath("//*[@id=\"submit\"]")).getText();
		Assert.assertEquals(logout_link, "Log out");
		driver.close();
	}

	@DataProvider(name = "login_validation")
	public Object[][] search_user() throws Throwable {

		String path = "./Book1.xls";
		File fi = new File(path);
		FileInputStream fis = new FileInputStream(fi);
		HSSFWorkbook hsw = new HSSFWorkbook(fis);
		HSSFSheet hst = hsw.getSheet("Sheet1");
		int row_cnt = hst.getLastRowNum();
		System.out.println(row_cnt);
		Object[][] data = new Object[row_cnt][2];
		for (int i = 0; i < row_cnt; i++) {
			int col_cnt = hst.getRow(i).getLastCellNum();
			for (int j = 0; j < col_cnt; j++) {

				data[i][j] = hst.getRow(i + 1).getCell(j).getStringCellValue();
			}
		}
		System.out.println(data);

		return data;
	}

}
