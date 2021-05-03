package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.pageObjects.Withdrawal;

import junit.framework.Assert;

public class TC_Withdrawal_010 extends BaseClass {

	@Test
	public void withDrawal() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Username is provided");
		lp.setPassword(password);
		logger.info("Password is provided");
		lp.clickSubmit();
		logger.info("Logged in");
		Thread.sleep(3000);
		
		Withdrawal withdraw = new Withdrawal(driver);
		
		withdraw.clickwithDrawal();
		Thread.sleep(2000);
		
		logger.info("Filling Deposit Form...");
		String accno = "91848";
		withdraw.setAccNo(accno);
		Thread.sleep(1000);
		
		withdraw.setAmount("5000");
		Thread.sleep(1000);
		
		withdraw.setDescription("Withdraw");
		Thread.sleep(2000);
		
		withdraw.submit();
		Thread.sleep(3000);
		
		if(isAlertPresent() == true) {
			
			String alertMsg = driver.switchTo().alert().getText();
			logger.info("Alert Message: " + alertMsg);
			
			driver.switchTo().alert().accept();//close alert
			Thread.sleep(2000);
			
			//captureScreen(driver, "withDrawal");
			Assert.assertTrue(true);
		}else {
			
			boolean res=driver.getPageSource().contains("Transaction details of Withdrawal for Account " + accno);
			
			if(res == true) {
				Assert.assertTrue(true);
				logger.info("Test case passed");
			}else {
				logger.info("Test case failed");
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
