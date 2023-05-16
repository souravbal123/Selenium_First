package basic_selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Select_Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver109.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		WebElement dropdown = driver.findElement(By.xpath(
				"//body/div[@id='root']/div[@id='page_wrapper']/div[@id='contents_wrapper']/div[@id='header_container']/div[2]/div[1]/span[1]/select[1]"));
		Select sel = new Select(dropdown);
		// sel.selectByVisibleText("Name (Z to A)");
		// sel.selectByIndex(3);
		// sel.selectByValue("lohi");
		List<WebElement> options = sel.getOptions();
		System.out.println(options);
		for(int i=0;i<options.size();i++) {
			System.out.println(options.get(i).getText());
		}
		for(WebElement element:options) {
			System.out.println(element.getText());
		}
		driver.close();
	}

}
