package datadriventesting;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDT_DP_Login_Validation {
	@Test(dataProvider="login_validation")
	public void Login_valid(String username,String password) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver109.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/login");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys(username);
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id=\"login\"]")).click();
		Thread.sleep(5000);
		String logout_link=driver.findElement(By.xpath("//*[@id=\"submit\"]")).getText();
		Assert.assertEquals(logout_link, "Log out");
		driver.close();
	}
	@DataProvider(name="login_validation")
	public Object[][] search_user() throws Throwable {
		/*
		 * String path = "./searchkeywords.xls"; File fi = new File(path);
		 * FileInputStream fis = new FileInputStream(fi); HSSFWorkbook xsw = new
		 * HSSFWorkbook(fis); HSSFSheet hst = xsw.getSheet("Sheet2"); int row_cnt =
		 * hst.getLastRowNum(); Object[][] data = new Object[row_cnt]; for (int i = 0; i
		 * < row_cnt; i++) { data[i] = hst.getRow(i).getCell(0).getStringCellValue(); }
		 * System.out.println(data);
		 */
		Object[][] data=new Object[4][2];
		data[0][0]="username";
		data[0][1]="password";
		data[1][0]="sourav_kumar";
		data[1][1]="Sourav@123";
		data[2][0]="sai_kumar";
		data[2][1]="Saikumar@123";
		data[3][0]="satishk";
		data[3][1]="Satishk@123";
		return data;
	}

}
