package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;

public class TestContextSetup {
	
	public WebDriver driver;
	public String ProductpgName;
	public TestBase testbase; // This will give us driver from TestBase class webDriverManager method
	public PageObjectManager pageObjectManager;
	public GenericUtils genericUtils;
	
	public TestContextSetup () throws IOException
	{
		testbase =new TestBase();
		pageObjectManager =new PageObjectManager(testbase.webDriverManager()); // manage page objects
		genericUtils=new GenericUtils(testbase.webDriverManager()); // manage driver
		
	}
	

}
