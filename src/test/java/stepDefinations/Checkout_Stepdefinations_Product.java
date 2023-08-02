package stepDefinations;

import static org.testng.Assert.assertEquals;

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
import pageObjects.CheckoutPG_Objects;
import pageObjects.LandingPG_Objects;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;


public class Checkout_Stepdefinations_Product {
	public WebDriver driver;
	public String ProductpgName;
	TestContextSetup setup;
	PageObjectManager pageObjectManager;
    public CheckoutPG_Objects checkoutPg;
	
	//This constructer is created to call the varibales created under Textcontext class
	public Checkout_Stepdefinations_Product(TestContextSetup setup)
	{
		this.setup=setup;
		//Checkout object pages object created here
        this.checkoutPg=setup.pageObjectManager.getcheckoutPg();
	}
	
	

    @Then("^: User proceed to checkout and validate the (.+) items in checkout page$")
    public void _user_proceed_to_checkout_and_validate_the_items_in_checkout_page(String name) throws Throwable {
    	
    	setup.pageObjectManager.checkoutPg.ckeckoutItems();
    	
        String checkoutPageProduct=setup.pageObjectManager.checkoutPg.getcheckOutProduct();
		
		System.out.println("Checkout Product is : "+checkoutPageProduct);
		
         Assert.assertEquals(setup.ProductpgName, checkoutPageProduct);
    	
    	
       
    }

    @Then("^: Verify user has ability to enter promocode and place the order$")
    public void _verify_user_has_ability_to_enter_promocode_and_place_the_order() throws Throwable {
        
		
    	Assert.assertTrue(checkoutPg.verifyPromocode());
		Assert.assertTrue(checkoutPg.verifyPlaceOrder());
		
		
		
    }

	  
}
