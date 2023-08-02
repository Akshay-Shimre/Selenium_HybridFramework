package cucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		
		features = "src/test/java/features",
		glue="stepDefinations" ,
		monochrome=true,
		tags="@PlaceOrder or @OfferPage" ,
		plugin= {"html:target/cucumber.html" , "json:target/cucumber.json" ,
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				}
			
		)


public class TestNG_TestRunner extends AbstractTestNGCucumberTests {
	
	/// To exectute test in parallel use below method
	
	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios()
	{
		return super.scenarios();
	}

}
  