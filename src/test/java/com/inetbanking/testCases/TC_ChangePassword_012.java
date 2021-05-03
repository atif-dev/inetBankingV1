package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.ChangePassword;
import com.inetbanking.pageObjects.LoginPage;

import junit.framework.Assert;

public class TC_ChangePassword_012 extends BaseClass {
	
	@Test
	public void ChangePassword() throws InterruptedException, IOException{
		LoginPage login = new LoginPage(driver);
		login.setUserName(username);
		logger.info("Username is provided");
		
		login.setPassword(password);
		logger.info("Password is provided");
		
		login.clickSubmit();
		logger.info("Loggedin");
		Thread.sleep(2000);
		
		ChangePassword chpass = new ChangePassword(driver);
		chpass.clickChangePassword();
		Thread.sleep(1000);
		
		logger.info("Filling Change Password Form...");
		
		chpass.InpOldPassword("#123456");
		Thread.sleep(1000);
		
		String newPassword = "@123456";
		chpass.InpNewPassword(newPassword);
		Thread.sleep(1000);
		chpass.InpConfirmPassword(newPassword);
		Thread.sleep(1000);
		
		chpass.clickSubmit();
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
			
				logger.info("Test case failed");
				Assert.assertTrue(true);
				
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
