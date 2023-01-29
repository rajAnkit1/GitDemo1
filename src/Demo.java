import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class Demo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\LENOVO\\Documents\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("rahul");
		driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//input[@value='rmbrUsername']")).click();
		driver.findElement(By.cssSelector("[value='agreeTerms']")).click();
		driver.findElement(By.cssSelector(".submit.signInBtn")).click();
		System.out.println(driver.findElement(By.xpath("//p[text()='You are successfully logged in.']")).getText());
		driver.findElement(By.xpath("//button[contains(@class,'logout')]")).click();
		driver.navigate().to("https://www.google.com/");
		driver.getTitle();
		driver.getCurrentUrl();
		driver.getPageSource();
		driver.navigate().back();
		Thread.sleep(3000);
		driver.close();
		
		
	}

}
