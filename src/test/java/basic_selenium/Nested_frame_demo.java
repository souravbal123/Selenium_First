package basic_selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Nested_frame_demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver109.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/nestedframes");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().frame("frame1");
	    driver.switchTo().frame(driver.findElement(By.xpath("/html/body/iframe")));
	    String test=driver.findElement(By.xpath("/html/body/p")).getText();
	    System.out.println(test);
	    driver.switchTo().defaultContent(); //its comes back to main browser
		driver.close();
		
		
	}

}
