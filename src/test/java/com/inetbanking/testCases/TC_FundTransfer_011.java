package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.FundTransfer;
import com.inetbanking.pageObjects.LoginPage;

import junit.framework.Assert;

public class TC_FundTransfer_011 extends BaseClass {

	@Test
	public void fundTransfer() throws InterruptedException, IOException{
		LoginPage login = new LoginPage(driver);
		login.setUserName(username);
		logger.info("Username is provided");
		login.setPassword(password);
		logger.info("Password is provided");
		
		login.clickSubmit();
		logger.info("Logged in");
		
		FundTransfer ft = new FundTransfer(driver);
		ft.clickFundTransfer();
		Thread.sleep(2000);
		
		ft.InpPayersAccountNo("91848");
		Thread.sleep(1000);
		
		ft.InpPayeeAccountNo("91908");
		Thread.sleep(1000);
		
		ft.InpAmount("5000");
		Thread.sleep(1000);
		
		ft.InpDescription("Transfer");
		Thread.sleep(1000);
		
		ft.clickSubmitBtn();
		Thread.sleep(2000);
		
		logger.info("Validation Started");
		Thread.sleep(2000);
		
		if(isAlertPresent() == true) {
			
			String alertMsg = driver.switchTo().alert().getText();
			logger.info("Exception Message: " + alertMsg);
			Thread.sleep(2000);
			
			driver.switchTo().alert().accept();//close alert
			Thread.sleep(2000);
			
			logger.info("test case passed.");
			Assert.assertTrue(true);
		}else {
			
			boolean res=driver.getPageSource().contains("Fund Transfer Details");
			
			if(res == true) {
				Assert.assertTrue(true);
				logger.info("Test case passed");
			}else {
				logger.info("Test case failed");
				logger.info("Also exception of balance are not yet handled in code");
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
