package SeleniumCode.JUnit_Assertions_Examples;

import java.time.Duration;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class C02_JUnit_Assertions {
	
	WebDriver driver;
	
	@Before
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	@After 
	public void close() {
	}
	
	@Test
	public void test01() {
		driver.get("http://automationexercise.com");
		WebElement visible = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
		Assert.assertTrue(visible.isDisplayed());
		driver.findElement(By.xpath("//a[text()=' Products']")).click();
		String expectedProductURI = "https://automationexercise.com/products";
		String actualProductURI = driver.getCurrentUrl();
		Assert.assertEquals(expectedProductURI, actualProductURI);
		WebElement searched_product = driver.findElement(By.xpath("//input[@id='search_product']"));
		searched_product.sendKeys("tshirt");
		driver.findElement(By.xpath("//button[@id='submit_search']")).click();
		WebElement visible_searched = driver.findElement(By.xpath("//h2[text()='Searched Products']"));
		Assert.assertTrue(visible_searched.isDisplayed());
		WebElement features_items = driver.findElement(By.xpath("//div[@class='features_items']"));
		Assert.assertTrue(features_items.isDisplayed());
		
		
	}

}

/* Test Case:2

1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Products' button
5. Verify user is navigated to ALL PRODUCTS page successfully
6. Enter product name in search input and click search button
7. Verify 'SEARCHED PRODUCTS' is visible
8. Verify all the products related to search are visible
9. Driver close


*/
