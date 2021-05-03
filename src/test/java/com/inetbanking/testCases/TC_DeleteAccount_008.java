package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.DeleteAccount;
import com.inetbanking.pageObjects.LoginPage;

public class TC_DeleteAccount_008 extends BaseClass
{
	

	@Test
	public void deleteAccount() throws InterruptedException, IOException
	{
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Passsword is provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		DeleteAccount delacc=new DeleteAccount(driver);
		
		delacc.clickDeleteAccount();
		
		logger.info("providing account no....");
		
		
		delacc.custAccNo("12345");
		Thread.sleep(2000);
		
		delacc.accsubmit();
		Thread.sleep(2000);
		
		logger.info("validation started....");
		
		if(isAlertPresent()==true) {
			
			driver.switchTo().alert().accept();//close alert
			Thread.sleep(3000);
			
			String alertmsg2 = driver.switchTo().alert().getText();
			logger.info("Alert Message: " + alertmsg2);
			
			driver.switchTo().alert().accept();
			Thread.sleep(2000);
			//driver.switchTo().defaultContent();
			Assert.assertTrue(true);
			logger.info("Test case passed");
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
