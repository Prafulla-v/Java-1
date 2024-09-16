package Demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class FlightBooking {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = null;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.cssSelector("input[placeholder='Type to Select']")).sendKeys("ind");
		Thread.sleep(1000);
		List<WebElement> options =driver.findElements(By.cssSelector(".ui-menu-item .ui-corner-all"));
		
		for(WebElement option:options) {
			if(option.getText().equalsIgnoreCase("India")) {
				option.click();
				break;
			}
		}
		
		driver.findElement(By.cssSelector("#travelOptions input[value='OneWay']")).click();
		Assert.assertTrue(true);
		
		driver.findElement(By.cssSelector("#marketCityPair_1 #ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Bengaluru (BLR)')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#ctl00_mainContent_ddl_destinationStation1_CTNR ul li a[text='Chennai (MAA)']")).click();
		
		driver.findElement(By.xpath("//td[@data-month='8']/a[text()='20']")).click();
		
		driver.findElement(By.cssSelector(".row1 .paxinfo")).click();
		Thread.sleep(1000);
		for(int i=1; i<5; i++) {
			driver.findElement(By.cssSelector("#divAdult #hrefIncAdt")).click();
		}
		for(int i=0; i<2; i++) {
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("#divChild #hrefIncChd")).click();
		}
		driver.findElement(By.cssSelector(".align-center #btnclosepaxoption")).click();
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
		WebElement element = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select sel = new Select(element);
		sel.selectByVisibleText("AED");
		
		driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
		
		driver.findElement(By.cssSelector("#Div6 .btn-find-flight-home #ctl00_mainContent_btn_FindFlights")).click();
	
		driver.quit();
		}

}
