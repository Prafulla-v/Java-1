package Demo;

import java.time.Duration;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsPractise {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = null;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("Prafulla");
		driver.findElement(By.xpath("//input[@name='inputPassword']")).sendKeys("Prafu");
		driver.findElement(By.cssSelector(".signInBtn")).click();
		System.out.println(driver.findElement(By.xpath("//p[text()='* Incorrect username or password']")).getText());
		driver.findElement(By.cssSelector(".forgot-pwd-container a")).click();

		driver.findElement(By.xpath("//input[contains(@placeholder,'Name')]")).sendKeys("Prafulla");
		driver.findElement(By.cssSelector(".sign-up-container form input[placeholder='Email']"))
				.sendKeys("Prafulla@yahoo.com");
		driver.findElement(By.xpath("//div[contains(@class,'sign-up-container')]/form/input[3]")).sendKeys("854632179");
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String password = driver.findElement(By.cssSelector(".sign-up-container form p")).getText();
		String name = password.split("'")[1].split("'")[0];
		System.out.println(name);
		driver.findElement(By.cssSelector(".go-to-login-btn")).click();

		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("Prafulla");
		driver.findElement(By.xpath("//input[@name='inputPassword']")).sendKeys(name);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@value='rmbrUsername']")).click();
		driver.findElement(By.xpath("//input[@value='agreeTerms']")).click();
		driver.findElement(By.cssSelector(".signInBtn")).click();

		String successmessage = driver.findElement(By.xpath("//p[text()='You are successfully logged in.']")).getText();
		Assert.assertEquals(successmessage, "You are successfully logged in.");
		driver.findElement(By.cssSelector(".logout-btn")).click();

		driver.close();
	}

}
