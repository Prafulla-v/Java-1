package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = null;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.navigate().to("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.cssSelector("form input[name='name']")).sendKeys("Nivedtha");
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("Niveditha@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("exampleCheck1")).click();
		
		WebElement element = driver.findElement(By.id("exampleFormControlSelect1"));
		Select sel = new Select(element);
		sel.selectByVisibleText("Female");
		
		driver.findElement(By.id("inlineRadio1")).click();
		driver.findElement(By.cssSelector("input[name='bday']")).sendKeys("12-09-2024");
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		
		System.out.println(driver.findElement(By.cssSelector(".container .alert-success")).getText());
		
		
		
	}

}
