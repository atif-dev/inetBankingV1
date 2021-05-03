package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Deposit {

	WebDriver ldriver;
	
	public Deposit(WebDriver rdriver) {//this is constructor
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how = How.XPATH, using ="/html/body/div[3]/div/ul/li[8]/a")
	@CacheLookup
	WebElement lnkDeposit;

	@FindBy(how = How.NAME, using = "accountno")
	@CacheLookup
	WebElement txtAccountNo;

	@FindBy(how = How.NAME, using = "ammount")
	@CacheLookup
	WebElement Amount;

	@CacheLookup
	@FindBy(how = How.NAME, using = "desc")
	WebElement description;
	
	@CacheLookup
	@FindBy(how = How.NAME, using = "AccSubmit")
	WebElement btnSubmit;
	
	public void clickDeposit() {
		lnkDeposit.click();
			
	}

	public void custAccNo(String accno) {
		txtAccountNo.sendKeys(accno);
		
	}

	public void amount(String amm) {
		Amount.sendKeys(amm);
	}

	public void provideDesc(String desc) {
		description.sendKeys(desc);
	}
	
	public void depositSubmit() {
		btnSubmit.click();
	}
	
	
	
}

