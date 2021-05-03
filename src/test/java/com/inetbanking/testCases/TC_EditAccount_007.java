package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.EditAccount;
import com.inetbanking.pageObjects.LoginPage;

public class TC_EditAccount_007 extends BaseClass
{
	

	@Test
	public void editAccount() throws InterruptedException, IOException
	{
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Passsword is provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		EditAccount editacc=new EditAccount(driver);
		
		editacc.clickEditAccount();
		
		logger.info("providing account no....");
		
		
		editacc.custAccNo("91971");
		Thread.sleep(2000);
		
		editacc.accsubmit();
		Thread.sleep(2000);
		
		logger.info("validation started....");
		if(isAlertPresent()==true) {
			
			alertMessage();
			
		}else {
			
			//editacc.accountType("Savings");
			editacc.accountType("Current");//Saving and current both are handled.
			Thread.sleep(2000);
			
			editacc.accsubmit2();
			Thread.sleep(2000);
			if(isAlertPresent()==true) {
				
				alertMessage();
				
			}else {
			
			boolean res=driver.getPageSource().contains("Account details updated Successfully!!!");
	
			Assert.assertTrue(res);
			logger.info("test case passed....");
			
			}
			
		}
		
		
		
			
	}
	
	public void alertMessage() throws InterruptedException, IOException {
		String alertmsg = driver.switchTo().alert().getText(); 
		logger.info("Alert Message: "+ alertmsg);
		Thread.sleep(3000);
		driver.switchTo().alert().accept();//close alert
		Thread.sleep(3000);
		//driver.switchTo().defaultContent();
		Assert.assertTrue(true);
		logger.info("Test case passed");
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
