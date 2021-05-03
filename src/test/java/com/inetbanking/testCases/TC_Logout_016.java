package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.pageObjects.Logout;

import junit.framework.Assert;

public class TC_Logout_016 extends BaseClass {
	
	@Test
	public void Logout() throws InterruptedException, IOException{
		logger.info("Logging in...");
		LoginPage login = new LoginPage(driver);
		login.setUserName(username);
		logger.info("Username is provided");
		Thread.sleep(1000);
		
		login.setPassword(password);
		logger.info("Password is provided");
		Thread.sleep(1000);
		
		login.clickSubmit();
		logger.info("Logged in");
		
		Logout logout = new Logout(driver);
		logout.clickLogout();
		Thread.sleep(1000);
		
		logger.info("Validation Started...");
		if(isAlertPresent() == true) {
			
			String alertMsg = driver.switchTo().alert().getText();
			logger.info("Exception Message: " + alertMsg);
			Thread.sleep(2000);
			
			driver.switchTo().alert().accept();//close alert
			Thread.sleep(2000);
			
			logger.info("test case passed.");
			Assert.assertTrue(true);
		}else {
			logger.info("Test case failed");
			Assert.assertTrue(false);
			
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
