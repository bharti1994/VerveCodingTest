package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class Common {
		
		public WebDriver d;


		@Parameters("browser") 
		@BeforeMethod
		public void launchBrowser(String browser)
		{
			if(browser.equals("CH"))
			{
			System.setProperty("webdriver.chrome.driver","D:\\Bharti\\chromedriver.exe");	
			 d=new ChromeDriver();
			}
			else if (browser.equals("FF")) {
				System.setProperty("webdriver.gecko.driver","C:\\Users\\amolf\\OneDrive\\Desktop\\geckodriver.exe");	
				 d=new FirefoxDriver();
			} 
			else if (browser.equals("Edge")) {
				System.setProperty("webdriver.edge.driver", "C:\\Users\\amolf\\OneDrive\\Desktop\\msedgedriver.exe");  
		       
			 d=new EdgeDriver();  
			}
			
			d.manage().window().maximize();
			
		}
		
		@AfterMethod
		public void closeBrowser() throws InterruptedException
		{
	      Thread.sleep(3000);
		    d.quit();
		
		}
	}




