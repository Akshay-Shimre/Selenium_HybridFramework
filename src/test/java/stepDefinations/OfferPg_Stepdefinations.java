package stepDefinations;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import dev.failsafe.internal.util.Durations;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LandingPG_Objects;
import pageObjects.OffersPg;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;


public class OfferPg_Stepdefinations {
	public WebDriver driver;
	public String offerPgProduct;
	public WebDriverWait wait; 
	TestContextSetup setup;
	public String ProductpgName;
	PageObjectManager pageObjectManager;
	
	//This constructer is created to call the varibales created under Textcontext class
	public OfferPg_Stepdefinations(TestContextSetup setup)
	{
		this.setup=setup;
	}
	
	public void switchToOffersPg()
	{
		
		//pageObjectManager=new PageObjectManager(setup.driver); or below as we are trying to avoid object creation
		
		LandingPG_Objects landingpg=setup.pageObjectManager.getLandingPG();
		
		
		landingpg.navigateTopDeals();
		//setup.driver.findElement(By.linkText("Top Deals")).click();
		setup.genericUtils.switchWindowToChild();
		
		
	}
	
	  @Then("^: user go and search  shortname (.+) on offerspage to chek if product exists$")
	    public void _user_go_and_search_shortname_something_on_offerspage_to_chek_if_product_exists(String shortName) throws Throwable {
	   
		  //pageObjectManager=new PageObjectManager(setup.driver);
		  
		  OffersPg op=setup.pageObjectManager.getoffersPg(); // this is object creation of OffersPg using test context setup
		  
		//OffersPg op=new OffersPg(setup.driver); 
		  
		switchToOffersPg(); // calling child window switch method
		
		op.offerSearchItems(shortName);
		//setup.driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys(shortName);
		
		Thread.sleep(3000);
		
		offerPgProduct=op.getOfferProductName();
		System.out.println("Product on offerpage : "+offerPgProduct);
			
	}

    @Then("^: Validate ProductPage Product and OfferPage product are equal$")
	    public void _validate_productpage_product_and_offerpage_product_are_equal() throws Throwable {
	        
    	
    	Assert.assertEquals(setup.ProductpgName, offerPgProduct);
    	
    
    	
    	
	    }
	  
}
