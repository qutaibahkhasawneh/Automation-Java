import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;



public class HTML {

	public WebDriver driver;

	@BeforeTest

	public void LaunchBrowser() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get("https://www.saucedemo.com/");
		
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
		
		Thread.sleep(5000);
		
	}
	
	@Test()
	
	public void test_the_high_to_low() {
	
	driver.findElement(By.className("product_sort_container")).click();
	
	driver.findElement(By.name("lohi")).click();
		
	}

}
