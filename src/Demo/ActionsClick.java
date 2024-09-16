package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class ActionsClick {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = null;
		driver = new ChromeDriver();
		
		driver.get("https://www.amazon.com/India/b?ie=UTF8&node=13153885011");
		WebElement move = driver.findElement(By.cssSelector("#nav-link-accountList"));
		WebElement text = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
		
		Actions a = new Actions(driver);
		a.moveToElement(move).build().perform();
		//a.moveToElement(move).contextClick().build().perform();
		Thread.sleep(1000);
		a.moveToElement(text).click().keyDown(Keys.SHIFT).sendKeys("hi this is prafulla").build().perform();
		
		
		
		
		}

}
