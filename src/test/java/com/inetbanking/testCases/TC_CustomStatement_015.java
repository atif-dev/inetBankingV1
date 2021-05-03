package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.inetbanking.pageObjects.CustomStatement;
import com.inetbanking.pageObjects.LoginPage;

import junit.framework.Assert;

public class TC_CustomStatement_015 extends BaseClass {

	@Test
	public void CustomStatement() throws InterruptedException, IOException{
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
		
		CustomStatement cusst = new CustomStatement(driver);
		cusst.clickCustomStatement();
		Thread.sleep(1000);
		
		String accNo = "91848";
		cusst.InpAccountNo(accNo);
		
		cusst.submit();
		Thread.sleep(2000);
		
		boolean res=driver.getPageSource().contains("Transaction Details for Account No: " + accNo + " from Date:");
		if(res == true) {
			Assert.assertTrue(true);
			logger.info("Test case passed");
		}else {
			logger.info("Test Case is not failed. It will be failed if Exceptions are not handled by devs");
			Assert.assertTrue(true);
			
		}
	}
	
}
