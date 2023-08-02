package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


/// This class is to initilization of centralized driver

public class TestBase {
	
	public WebDriver driver;
	
	public WebDriver webDriverManager() throws IOException
	
		{
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties");
		
		Properties prop=new Properties();
		prop.load(fis);
		
		String URL=prop.getProperty("url");
		String browser=prop.getProperty("browser");
		
		if(driver==null)
		{
		
			if(browser.equalsIgnoreCase("chrome"))
			{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
			}
			
			else if(browser.equalsIgnoreCase("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
			
		driver.manage().window().maximize() ;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(URL);
		
			
			
		}
		return driver;
	}

}
