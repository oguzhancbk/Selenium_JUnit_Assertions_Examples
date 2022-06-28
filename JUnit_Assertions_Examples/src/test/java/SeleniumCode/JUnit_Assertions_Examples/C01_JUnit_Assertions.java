package SeleniumCode.JUnit_Assertions_Examples;

import java.time.Duration;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class C01_JUnit_Assertions {
	
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
		driver.close();
	}
	
	@Test
	public void test01() {
		driver.get("http://automationexercise.com");
		WebElement visible = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
		Assert.assertTrue(visible.isDisplayed());
		WebElement signup_login = driver.findElement(By.xpath("//a[text()=' Signup / Login']"));
		signup_login.click();
		WebElement visible2 = driver.findElement(By.xpath("//h2[text()='Login to your account']"));
		Assert.assertTrue(visible2.isDisplayed());
		WebElement email = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
		email.sendKeys("ahmet@nehaber.com");
		WebElement pass = driver.findElement(By.xpath("//input[@data-qa='login-password']"));
		pass.sendKeys("12345");
		WebElement login = driver.findElement(By.xpath("//button[@data-qa='login-button']"));
		login.click();
		WebElement visible3 = driver.findElement(By.xpath("//a[text()=' Logged in as ']"));
		Assert.assertTrue(visible3.isDisplayed());
		WebElement logout = driver.findElement(By.xpath("//a[@href='/logout']"));
		logout.click();
		String expectedURI = "https://automationexercise.com/login";
		String actualURI = driver.getCurrentUrl();
		Assert.assertEquals(expectedURI, actualURI);
		
	}
	
}

/*

1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'Login to your account' is visible
6. Enter correct email address and password
7. Click 'login' button
8. Verify that 'Logged in as username' is visible
9. Click 'Logout' button
10. Verify that user is navigated to login page

*/
