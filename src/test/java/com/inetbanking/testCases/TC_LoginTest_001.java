package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;




public class TC_LoginTest_001 extends BaseClass
{

	@Test
	public void loginTest() throws InterruptedException, IOException
	{
		
		
		
		logger.info("URL is opened");
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(username);
		logger.info("Entered username");
		lp.setPassword(password);
		logger.info("Entered password");
		
		
		lp.clickSubmit();
		
		Thread.sleep(1000);
		
		if(isAlertPresent() == true) {
			
			String alertMsg = driver.switchTo().alert().getText();
			logger.info("Exception Message: " + alertMsg);
			Thread.sleep(2000);
			
			driver.switchTo().alert().accept();//close alert
			Thread.sleep(2000);
			
			
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
		}else if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			
				logger.info("Logged in");
				logger.info("Login test passed");
				Assert.assertTrue(true);
			}
		
	}
	
	public boolean isAlertPresent() //user defined method created to check alert is present or not
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
	}
	
}
