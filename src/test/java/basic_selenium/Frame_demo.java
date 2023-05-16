package basic_selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frame_demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver109.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/frames");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().frame("frame1");
		String test = driver.findElement(By.xpath("//*[@id=\"sampleHeading\"]")).getText();
		System.out.println(test);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame2");
		String test2=driver.findElement(By.xpath("//*[@id=\"sampleHeading\"]")).getText();
		System.out.println(test2);
		driver.switchTo().defaultContent();
		driver.close();
	}

}
