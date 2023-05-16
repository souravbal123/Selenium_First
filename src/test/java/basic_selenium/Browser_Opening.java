package basic_selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser_Opening {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "./Driver/chromedriver109.exe"); ChromeDriver ch_driver = new ChromeDriver();
		 * ch_driver.get("https://www.google.com/");
		 * System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
		 * FirefoxDriver ff_driver = new FirefoxDriver();
		 * ff_driver.get("https://www.google.com/");
		 */
		System.setProperty("webdriver.chrome.driver","./Driver/chromedriver109.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com");
		System.setProperty("webdriver.edge.driver", "./Driver/msedgedriver.exe");
		driver=new EdgeDriver();
		driver.get("https://www.google.com");
	}

}
