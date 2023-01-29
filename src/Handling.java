import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Handling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\LENOVO\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		// 1.Handling Static Dropdown
		WebElement staticDrop = driver.findElement(By.xpath("//*[contains(@id,'Currency')]"));
		Select Dropdown = new Select(staticDrop);
		Dropdown.selectByValue("USD");
		System.out.println(Dropdown.getFirstSelectedOption().getText());
		Dropdown.selectByIndex(1);
		System.out.println(Dropdown.getFirstSelectedOption().getText());
		Dropdown.selectByVisibleText("AED");
		System.out.println(Dropdown.getFirstSelectedOption().getText());
		// 2.Handling latest Dropdown
		driver.findElement(By.cssSelector(".paxinfo")).click();
		Thread.sleep(3000);
		for(int i=1;i<5;i++)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		System.out.println(driver.findElement(By.cssSelector(".paxinfo")).getText());
		// 3.Handling Dynamic Dropdown
		driver.findElement(By.xpath("//input[contains(@value,'Departure City')]")).click();
		driver.findElement(By.xpath("//a[@value='DEL']")).click();
		Thread.sleep(3000);
		// driver.findElement(By.xpath("(//a[@value='PNQ'])[2]")).click();
		driver.findElement(By.xpath("//div[contains(@id,'destinationStation1')] //a[@value='PNQ']")).click();
		// 4.Handling Auto-suggestive
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(1000);
		List<WebElement> option = driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));
		for (WebElement options : option) {
			if (options.getText().equalsIgnoreCase("India")) {
				options.click();
				break;
			}
		}
		// 5.Handling checkbox and getting size
		System.out.println(driver.findElement(By.xpath("//input[contains(@name,'StudentDiscount')]")).isSelected());
		driver.findElement(By.xpath("//input[contains(@name,'StudentDiscount')]")).click();
		System.out.println(driver.findElement(By.xpath("//input[contains(@name,'StudentDiscount')]")).isSelected());
		System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
		// 6.Handling Calender UI & Element Disabled/Enabled
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		driver.findElement(By.xpath("//input[@value='RoundTrip']")).click();
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))
		{
			System.out.println("it's Enabled");
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='Search']")).click();
		
		driver.close();
	}

}
