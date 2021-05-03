package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.BalanceEnquiry;
import com.inetbanking.pageObjects.LoginPage;

import junit.framework.Assert;

public class TC_BalanceEnquiry_013 extends BaseClass {

	@Test
	public void BalanceEnquiry() throws InterruptedException, IOException{
		
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
		
		BalanceEnquiry balEnq = new BalanceEnquiry(driver);
		balEnq.clickBalanceEnquiry();
		Thread.sleep(1000);
		
		String accountNo = "91848";
		balEnq.InpAccountNo(accountNo);
		Thread.sleep(1000);
		
		balEnq.submit();
		Thread.sleep(1000);
		
		if(isAlertPresent() == true) {
			
			String alertMsg = driver.switchTo().alert().getText();
			logger.info("Exception Message: " + alertMsg);
			Thread.sleep(2000);
			
			driver.switchTo().alert().accept();//close alert
			Thread.sleep(2000);
			
			logger.info("test case passed.");
			Assert.assertTrue(true);
		}else {
			
			boolean res=driver.getPageSource().contains("Balance Details for Account " + accountNo);
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
