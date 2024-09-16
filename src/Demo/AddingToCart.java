package Demo;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AddingToCart {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = null;
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Thread.sleep(2000);
		int j = 0;

		String[] itemsNeeded = { "Brocolli", "Cucumber", "Beans", "Potato" };

		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		for (int i = 0; i < products.size(); i++) {
			String productName = products.get(i).getText().split("-")[0].trim();
			List itemsNeededlist = Arrays.asList(itemsNeeded);

			if (itemsNeededlist.contains(productName)) {
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

				if (j == itemsNeeded.length) {
					break;
				}
			}

		}
		
		driver.findElement(By.cssSelector(".cart-icon  img")).click();
		driver.findElement(By.cssSelector(".cart-preview.active button[type='button']")).click();
		Thread.sleep(1500);
		driver.findElement(By.cssSelector("input[placeholder='Enter promo code']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector(".promoBtn")).click();
		Thread.sleep(5000);
		
		String promomessage = driver.findElement(By.cssSelector("span[class='promoInfo']")).getText();
		Assert.assertEquals(promomessage, "Code applied ..!");
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		
		WebElement element =driver.findElement(By.cssSelector("div select"));
		Select sel = new Select(element);
		sel.selectByValue("India");
		
		driver.findElement(By.cssSelector(".chkAgree")).click();
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
		driver.findElement(By.linkText("Home")).click();
		
		driver.close();
	}

}
