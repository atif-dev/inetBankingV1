package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewAccount {

	WebDriver ldriver;
	
	public NewAccount(WebDriver rdriver) {//this is constructor
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how = How.XPATH, using ="/html/body/div[3]/div/ul/li[5]/a")
	@CacheLookup
	WebElement lnkNewAccount;

	@FindBy(how = How.NAME, using = "cusid")
	@CacheLookup
	WebElement txtCustomerId;

	@FindBy(how = How.NAME, using = "selaccount")
	@CacheLookup
	WebElement dropDown;

	@CacheLookup
	@FindBy(how = How.NAME, using = "inideposit")
	WebElement txtinitialdeposit;


	@CacheLookup
	@FindBy(how = How.NAME, using = "button2")
	WebElement btnSubmit;
	
	
	public void clickNewAccount() {
		lnkNewAccount.click();
			
	}

	public void custId(String cid) {
		txtCustomerId.sendKeys(cid);
		
	}

	public void accountType(String acctype) {
		Select dropdown = new Select(dropDown);
		//dropdown.sendKeys(acctype);
		dropdown.selectByVisibleText(acctype);
		//OR==> dropdown.selectByIndex(1);
		//OR==> dropdown.selectByValue("Current");
	}


	public void initialDeposit(String deposit) {
		txtinitialdeposit.sendKeys(deposit);
	}


	public void accsubmit() {
		btnSubmit.click();
	}
	
	
	
}