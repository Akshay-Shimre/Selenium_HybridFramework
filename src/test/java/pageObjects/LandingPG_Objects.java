package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPG_Objects {
	public WebDriver driver;
	
	
	//This constructor is created to use pico webdriver reference in this page object
	public LandingPG_Objects(WebDriver driver)
	{
		this.driver=driver;
	}

	By search=By.xpath("//input[@type='search']");
	By productName=By.cssSelector("h4.product-name");
	By topDeals=By.linkText("Top Deals");
	By addProd=By.xpath("//a[@class='increment']");
	By deleteProd=By.xpath("//a[@class='decrement']");
	By addCart=By.xpath("//button[normalize-space()='ADD TO CART']");
	
	
	
	
	public void serchItem(String name)
	{
		driver.findElement(search).sendKeys(name);
	}
	
	public String getProductName()
	{
		return driver.findElement(productName).getText().split("-")[0].trim();
	}
	
	public void navigateTopDeals()
	{
		driver.findElement(By.linkText("Top Deals")).click();
	}
	
	public void increamentQuantity(int quantity)
	
	{
		System.out.println("Enter quantity");
		int i= quantity-1;
		
		while(i>0)
		{
			System.out.println("Inside while loop");
			driver.findElement(addProd).click();
			i--;
		}
		
		driver.findElement(addCart).click();
	}
	
	
	
}
