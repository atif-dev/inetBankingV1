package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.NewAccount;
import com.inetbanking.pageObjects.LoginPage;

public class TC_NewAccount_006 extends BaseClass
{
	

	@Test
	public void newAccount() throws InterruptedException, IOException
	{
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Passsword is provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		NewAccount newacc=new NewAccount(driver);
		
		newacc.clickNewAccount();
		
		logger.info("providing new account details....");
		
		
		newacc.custId("98637");
		Thread.sleep(2000);
		newacc.accountType("Current");
		Thread.sleep(5000);
		newacc.initialDeposit("10000");
		Thread.sleep(5000);
		
		newacc.accsubmit();
		
		Thread.sleep(3000);
		
		logger.info("validation started....");
		
		
		boolean res=driver.getPageSource().contains("Account Generated Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			
		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"newAccount");
			Assert.assertTrue(false);
		}
			
	}
	
	
}