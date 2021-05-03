package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ChangePassword {
	
	WebDriver ldriver;
	
	public ChangePassword(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how = How.XPATH, using = "/html/body/div[3]/div/ul/li[11]/a")
	@CacheLookup
	WebElement lnkChangePassword;
	
	@FindBy(how = How.NAME, using = "oldpassword")
	@CacheLookup
	WebElement oldpass;
	
	@FindBy(how = How.NAME, using = "newpassword")
	@CacheLookup
	WebElement newpass;
	
	@FindBy(how = How.NAME, using = "confirmpassword")
	@CacheLookup
	WebElement confpass;
	
	@FindBy(how = How.NAME, using = "sub")
	@CacheLookup
	WebElement btnsubmit;
	
	public void clickChangePassword() {
		lnkChangePassword.click();
	}
	
	public void InpOldPassword(String oldPass) {
		oldpass.sendKeys(oldPass);
	}
	
	public void InpNewPassword(String newPass) {
		newpass.sendKeys(newPass);
	}
	
	public void InpConfirmPassword(String confPass) {
		confpass.sendKeys(confPass);
	}
	
	public void clickSubmit() {
		btnsubmit.click();
	}

}
