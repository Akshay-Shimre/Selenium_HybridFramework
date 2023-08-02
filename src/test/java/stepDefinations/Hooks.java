package stepDefinations;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.util.filetypedetector.FileType;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TestContextSetup;

public class Hooks {

	TestContextSetup testcontextsetup;
	
	public Hooks(TestContextSetup testcontextsetup)
	{
		this.testcontextsetup=testcontextsetup;
	}
	
	@After
	public void afterScenario() throws IOException
	{
		testcontextsetup.testbase.webDriverManager().quit();
	}
	
	@AfterStep
	public void addScreenShots(Scenario scenario) throws IOException
	{
		WebDriver driver=testcontextsetup.testbase.webDriverManager();
		if(scenario.isFailed())
		{
			//Screenshot
		File sourcePath = 	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//Convert above file format to byte format
		byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
		scenario.attach(fileContent, "image/png", "image");
		
		
			
		}
	}
}
