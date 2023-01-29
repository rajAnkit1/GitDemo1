import java.lang.reflect.Array;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ADDTOCart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\LENOVO\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String[] item= {"Cauliflower","Tomato","Potato","Corn"};
		int j=0;
	    List<WebElement> product= driver.findElements(By.cssSelector(".product"));
	    for(int i=0;i<product.size();i++)
	    {
	    	String[] name=product.get(i).getText().split("-");
	    	     String formatted=name[0].trim();
	    	    List<String> al= Arrays.asList(item);
	    	    
	    	    if(al.contains(formatted))
	    	    {
	    	    	j++;
	    	    	driver.findElements(By.cssSelector(".product-action button")).get(i).click();
	    	    	
	    	    	if(j==item.length)
	    	    	{
	    	    		break;
	    	    	}
	    	    }
	    }
	    driver.findElement(By.cssSelector(".cart-icon")).click();
	    driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
	    driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahul");
	    driver.findElement(By.cssSelector(".promoBtn")).click();
	    Thread.sleep(3000);
	    System.out.println(driver.findElement(By.cssSelector(".promoInfo")).getText());
	    driver.findElement(By.xpath("//button[text()='Place Order']")).click();
	    WebElement staticDrop=driver.findElement(By.xpath("//div[@class='wrapperTwo']/div/select"));
	    Select dropDown=new Select(staticDrop);
	    dropDown.selectByValue("India");
	    System.out.println(dropDown.getFirstSelectedOption().getText());
	    driver.findElement(By.cssSelector(".chkAgree")).click();
	    driver.findElement(By.xpath("//button[text()='Proceed']")).click();
	    driver.close();
}
}