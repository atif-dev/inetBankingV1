package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.EditCustomer;
import com.inetbanking.pageObjects.LoginPage;

public class TC_EditCustomer_004 extends BaseClass
{
	

	@Test
	public void editCustomer() throws InterruptedException, IOException
	{
		//String CustomerId;
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Passsword is provided");
		lp.clickSubmit();
		
		
		
		Thread.sleep(3000);
		
		EditCustomer editCust=new EditCustomer(driver);
		
		editCust.clickEditCustomer();
		Thread.sleep(3000);
		
		logger.info("providing customer ID....");
		
		//TC_AddCustomerTest_003 obj = new TC_AddCustomerTest_003();
		//CustomerId = obj.CustomerId;
		//logger.info(CustomerId);
		
		//editCust.cusId(CustomerId);
		editCust.cusId("85900");
		Thread.sleep(3000);
		
		editCust.idSubmit();
		Thread.sleep(3000);
		
		editCust.custaddress("PK");
		editCust.custcity("SKT");
		editCust.custstate("PUN");
		editCust.custpinno("5000074");
		editCust.custtelephoneno("987890091");
		
		String email=randomestring()+"@gmail.com";
		editCust.custemailid(email);
		
		editCust.custsubmit();
		
		Thread.sleep(3000);
		
		logger.info("validation started....");
		
		boolean res=driver.getPageSource().contains("Customer details updated Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			
		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"editCustomer");
			Assert.assertTrue(false);
		}
			
	}
	
	
}
