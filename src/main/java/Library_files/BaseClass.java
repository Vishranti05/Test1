package Library_files;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseClass 
{
	
	public WebDriver driver;
	public void initializeBrowser()
	{
		ChromeOptions CO=new ChromeOptions();
		 CO.addArguments("--remote-allow-Origins=*", "ignore-certificate-errors");
		 
		 driver=new ChromeDriver(CO); 
		
		//To enter URL/Open an Application
		 driver.get("http://adactinhotelapp.com/HotelAppBuild2/");
			
		 driver.manage().window().maximize();
		 	
		 //Wait
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}

}
