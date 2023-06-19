
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SmartBy {

	public WebDriver driver;
	public int numberOfTry = 1;
	SoftAssert softassertProcess = new SoftAssert();

	@BeforeTest

	public void lunchBrowser() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get("https://smartbuy-me.com/smartbuystore/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("/html/body/main/header/div[2]/div/div[2]/a")).click();
	}

	@Test()

	public void add_to_cart() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		for (int i = 0; i < numberOfTry; i++) {
			driver.findElement(By.xpath(
					"//*[@id=\"newtab-Featured\"]/div/div[1]/div/div/div/div[2]/div/div[3]/div[1]/div/div/form[1]/div[1]/button"))
					.click();
			driver.findElement(By.xpath("//*[@id=\"addToCartLayer\"]/a[2]")).click();
		}
	}

	@Test()

	public void we_need_to_check_the_correct_price() {
		String the_single_item_price = driver
				.findElement(By.xpath(
						"//*[@id=\"newtab-Featured\"]/div/div[1]/div/div/div/div[2]/div/div[2]/div[2]/div/div/span[3]"))
				.getText();
		String [] the_updated_single_price  = the_single_item_price.split("JOD");
		String the_final_single_item_price =  the_updated_single_price[0].trim();
		System.err.println(the_final_single_item_price);
		
//		** Comment it just to save the code because the item which have (,) dose not exist in smartby
//		String updated = the_final_single_item_price.replace(",", ".");
//		Double final_price = Double.parseDouble(updated);
//		System.err.println(final_price*numberOfTry);
		
		String actualWebSite = driver.getTitle();
		System.out.println(actualWebSite);
		softassertProcess.assertEquals(actualWebSite, "ahmad");
		softassertProcess.assertAll();
	}
}
