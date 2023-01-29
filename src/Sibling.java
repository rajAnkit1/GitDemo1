import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sibling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\LENOVO\\Documents\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.findElement(By.xpath("/html/body/header/div/button[1]")).click();
		System.out.println(driver.findElement(By.xpath("/html/body/header/div/button[1]/following-sibling::button[1]")).getText());
	}

}
