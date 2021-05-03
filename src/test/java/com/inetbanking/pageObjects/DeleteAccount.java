package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DeleteAccount {

	WebDriver ldriver;
	
	public DeleteAccount(WebDriver rdriver) {//this is constructor
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how = How.XPATH, using ="/html/body/div[3]/div/ul/li[7]/a")
	@CacheLookup
	WebElement lnkDeleteAccount;

	@FindBy(how = How.NAME, using = "accountno")
	@CacheLookup
	WebElement txtAccountNo;

	@CacheLookup
	@FindBy(how = How.NAME, using = "AccSubmit")
	WebElement btnSubmit;
	
	
	public void clickDeleteAccount() {
		lnkDeleteAccount.click();
			
	}

	public void custAccNo(String accno) {
		txtAccountNo.sendKeys(accno);
		
	}


	public void accsubmit() {
		btnSubmit.click();
	}
	
	
	
}

