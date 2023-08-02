package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPG_Objects {
	public WebDriver driver;
	
	
	//This constructor is created to use pico webdriver reference in this page object
	public CheckoutPG_Objects(WebDriver driver)
	{
		this.driver=driver;
	}

	By cartBags= By.xpath("//img[@alt='Cart']");
	By proceedCheckout= By.xpath("//button[normalize-space()='PROCEED TO CHECKOUT']");
	By checoutQuantity = By.xpath("//p[@class='quantity']");
	By enterPromocode= By.xpath("//input[@placeholder='Enter promo code']");
	By applyPromo= By.xpath("//button[@class='promoBtn']");
	By placeOrder= By.xpath("//*[@id=\"root\"]/div/div/div/div/button");	
	By checkOutProduct=By.xpath("//*[@id=\"productCartTables\"]/tbody/tr/td[2]/p");
	
	public String getcheckOutProduct()
	{
		return driver.findElement(checkOutProduct).getText().split("-")[0].trim();
	}
	
	public void ckeckoutItems()
	{
		driver.findElement(cartBags).click();
		driver.findElement(proceedCheckout).click();
	}
	
	public boolean verifyPromocode()
	{
	
	 return driver.findElement(applyPromo).isDisplayed();
			
	}
	
	public boolean verifyPlaceOrder()
	{
	
	 return driver.findElement(placeOrder).isDisplayed();
			
	}
	
	
}
