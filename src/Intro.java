import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Intro {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
 
		System.setProperty("webdriver.chrome.driver","C:\\Users\\LENOVO\\Documents\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='form-container sign-up-container']/form/input[1]")).sendKeys("abhi");
		driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("1234@3#");
		//driver.findElement(By.xpath("//input[@type='text']/following-sibling::input[1]")).sendKeys("1234@3");
		driver.findElement(By.cssSelector("input[type='text']:nth-child(4)")).sendKeys("987678768");
		//driver.findElement(By.xpath("//input[@type='text']/following-sibling::input[2]")).sendKeys("987678768");
		//driver.findElement(By.xpath("//div/form/div/button[2]")).click();
		//System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		driver.findElement(By.cssSelector(".go-to-login-btn")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("inputUsername")).sendKeys("rahul");
		driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//input[@value='rmbrUsername']")).click();
		driver.findElement(By.cssSelector("[value='agreeTerms']")).click();
		driver.findElement(By.cssSelector(".submit.signInBtn")).click();
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.xpath("//p[text()='You are successfully logged in.']")).getText());
		driver.findElement(By.xpath("//button[contains(@class,'logout')]")).click();
		driver.close();
	}
	

}
