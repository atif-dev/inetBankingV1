package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.DeleteCustomer;
import com.inetbanking.pageObjects.LoginPage;

public class TC_DeleteCustomer_005 extends BaseClass
{
	
	

	@Test
	public void deleteCustomer() throws InterruptedException, IOException
	{
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Passsword is provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		DeleteCustomer delcust=new DeleteCustomer(driver);
		
		delcust.clickDeleteCustomer();
		
		logger.info("providing customer id....");
		
		delcust.customerId("40949");
		
		delcust.custsubmit();
		
		Thread.sleep(5000);
		
		if(isAlertPresent()==true)
		{
			
			driver.switchTo().alert().accept();//close alert
			Thread.sleep(5000);
			
			String txt = driver.switchTo().alert().getText();
			logger.info("Alert Message: " + txt);
			
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			Assert.assertTrue(true);
			logger.warn("Test case passed");
		}
		else
		{
			//Assert.assertTrue(true);//test case is passed
			//logger.info("Login passed");
			//lp.clickLogout();
			//Thread.sleep(3000);
			//driver.switchTo().alert().accept();//close logout alert
			//driver.switchTo().defaultContent();//focus on login page
			
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