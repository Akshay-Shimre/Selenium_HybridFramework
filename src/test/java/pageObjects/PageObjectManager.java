package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	
	//This class is responsible for just creating object of pg classes
	//This example of pg factory
	
	public LandingPG_Objects landingPage;
	public OffersPg offersPg;
	public WebDriver driver;
	public CheckoutPG_Objects checkoutPg;
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver=driver;
	}
	

	public CheckoutPG_Objects getcheckoutPg()
	{
		checkoutPg=new  CheckoutPG_Objects(driver);
		return checkoutPg;
	}
	
	public LandingPG_Objects getLandingPG()
	{
		landingPage=new  LandingPG_Objects(driver);
		return landingPage;
	}
	
	public OffersPg getoffersPg()
	{
		offersPg=new  OffersPg(driver);
		return offersPg;
	}
}
