import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class BrokenLink {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\LENOVO\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		List<WebElement> link=driver.findElements(By.xpath("//li[@class='gf-li']/a"));
		SoftAssert s=new SoftAssert();
		for(WebElement links:link)
		{
			String url=links.getAttribute("href");
			HttpURLConnection conn=(HttpURLConnection) new URL(url).openConnection();
			conn.connect();
			conn.setRequestMethod("HEAD");
			int resp=conn.getResponseCode();
			System.out.println(resp);
			s.assertTrue(resp<400, links.getText());
			
		}
		s.assertAll();
	}

}
