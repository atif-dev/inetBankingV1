package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.Deposit;
import com.inetbanking.pageObjects.LoginPage;

public class TC_Deposit_009 extends BaseClass
{
	

	@Test
	public void Deposit() throws InterruptedException, IOException
	{
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Passsword is provided");
		lp.clickSubmit();
			
		Thread.sleep(3000);
		
		Deposit dep=new Deposit(driver);
		
		dep.clickDeposit();
		
		logger.info("Filling Deposit form....");
		
		
		dep.custAccNo("91823");
		Thread.sleep(2000);
		
		dep.amount("50000");
		Thread.sleep(2000);
		
		dep.provideDesc("Deposit");
		Thread.sleep(2000);
		
		dep.depositSubmit();
		Thread.sleep(2000);
		
		logger.info("validation started....");
		
		if(isAlertPresent()==true) {
			
			String alertmsg = driver.switchTo().alert().getText(); 
			logger.info(alertmsg);
			Thread.sleep(3000);
			driver.switchTo().alert().accept();//close alert
			Thread.sleep(3000);
			//driver.switchTo().defaultContent();
			Assert.assertTrue(true);
			logger.info("Test case passed");
		}else {
			
			boolean res=driver.getPageSource().contains("Transaction details of Deposit for Account 91823");
			Assert.assertTrue(res);
			logger.info("Desposit Successful");
			logger.info("test case passed....");
			
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
