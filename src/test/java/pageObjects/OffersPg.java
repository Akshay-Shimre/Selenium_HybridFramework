package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPg {
	
	public WebDriver driver;
	public OffersPg(WebDriver driver) {
		
		this.driver=driver;
	}
	
	By offerSearch=By.xpath("//input[@id='search-field']");
	By offerProduct=By.cssSelector("tbody tr td:nth-child(1)");
	
	public void offerSearchItems(String name)
	{
		driver.findElement(offerSearch).sendKeys(name);
	}
	
	public String getOfferProductName()
	{
		return driver.findElement(By.cssSelector("tbody tr td:nth-child(1)")).getText();
	}

}
