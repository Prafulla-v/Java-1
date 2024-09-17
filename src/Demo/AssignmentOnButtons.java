package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AssignmentOnButtons {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = null;
		driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();

		driver.findElement(By.id("checkBoxOption2")).click();
		String optionText = driver.findElement(By.xpath("//label[@for='benz']")).getText();

		WebElement dropDown = driver.findElement(By.id("dropdown-class-example"));
		Select sel = new Select(dropDown);
		sel.selectByVisibleText(optionText);

		driver.findElement(By.id("name")).sendKeys(optionText);
		driver.findElement(By.id("alertbtn")).click();
		String mes = driver.switchTo().alert().getText();
		Assert.assertEquals(mes, "Hello " + optionText + ", share this practice page and share your knowledge");
		driver.switchTo().alert().accept();

	}

}
