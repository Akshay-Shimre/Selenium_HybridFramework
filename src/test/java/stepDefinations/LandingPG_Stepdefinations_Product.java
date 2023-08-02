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
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LandingPG_Objects;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;


public class LandingPG_Stepdefinations_Product {
	public WebDriver driver;
	public String offerPgProduct;
	public String ProductpgName;
	TestContextSetup setup;
	PageObjectManager pageObjectManager;
	
	//This constructer is created to call the varibales created under Textcontext class
	public LandingPG_Stepdefinations_Product(TestContextSetup setup)
	{
		this.setup=setup;
	}
	
	@Given(": User is on GreenKart landing Page")
	public void user_is_on_green_kart_landing_page() {
	    
		//wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		/*
		 * 
		 * WebDriverManager.chromedriver().setup(); setup.driver = new ChromeDriver();
		 * setup.driver.manage().window().maximize() ;
		 * setup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		 * setup.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		 */
		
	}
	@When("^: user search with short name (.+) and extracted actual name of product$")
	public void user_search_with_short_name_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
	   
			
		//pageObjectManager=new PageObjectManager(setup.driver); OR below code
		//here we are trying to avoid object creation in stepdefination hence we use testcontextsetp approach
		
		LandingPG_Objects landingpg=setup.pageObjectManager.getLandingPG();
		landingpg.serchItem(shortName);
		//setup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		Thread.sleep(3000);
		setup.ProductpgName=landingpg.getProductName();
		System.out.println("Product Name extracted is : "+setup.ProductpgName);
	}
	
	 @And("^: Added \"([^\"]*)\" items of selected product to cart$")
	    public void _added_something_items_of_selected_product_to_cart(String quantity) throws Throwable {
		 
		 System.out.println(quantity);
	        
		 setup.pageObjectManager.landingPage.increamentQuantity(Integer.parseInt(quantity));
		
		 
		 
		 
	    }

	  
}
