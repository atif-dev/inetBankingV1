package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.pageObjects.MiniStatement;

import junit.framework.Assert;

public class TC_MiniStatement_014 extends BaseClass{
	
	@Test
	public void MiniStatement() throws InterruptedException, IOException{
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
		
		MiniStatement minst = new MiniStatement(driver);
		minst.clickMiniStatement();
		Thread.sleep(1000);
		
		String accountNo = "91848";
		minst.InpAccountNo(accountNo);
		minst.submit();
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
			
			boolean res=driver.getPageSource().contains("Last Five Transaction Details for Account No: " + accountNo);
			if(res == true) {
				Assert.assertTrue(true);
				logger.info("Test case passed");
			}else {
				logger.info("Test case failed");
				Assert.assertTrue(false);
				
			}
				
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
