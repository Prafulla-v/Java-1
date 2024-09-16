package Demo;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowAssingment {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = null;
		driver = new ChromeDriver();

		driver.navigate().to(new String("https://the-internet.herokuapp.com/"));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String partedId = it.next();
		String childId = it.next();

		driver.switchTo().window(childId);
		System.out.println(driver.findElement(By.cssSelector(".example h3")).getText());
		driver.switchTo().window(partedId);
		System.out.println(driver.findElement(By.cssSelector(".example h3")).getText());

	}

}
