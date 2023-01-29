import java.util.Arrays;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptioner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1.Handle HTTP certification
		ChromeOptions options=new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\LENOVO\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
		
		//2.Handling Proxy
		Proxy proxy=new Proxy();
		proxy.setHttpProxy(" ");
		options.setCapability("proxy",proxy );
		
		//3.Disabling Pop-up
		options.setExperimentalOption("excludeswitch", Arrays.asList("Disable-popup-Blocking"));
		
		
		
	}

}
