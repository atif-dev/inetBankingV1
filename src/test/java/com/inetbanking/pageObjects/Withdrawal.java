package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Withdrawal {
	WebDriver ldriver;
	
	public Withdrawal(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how = How.XPATH, using = "/html/body/div[3]/div/ul/li[9]/a")
	@CacheLookup
	WebElement withdrawal;
	
	@FindBy(how = How.NAME, using = "accountno")
	@CacheLookup
	WebElement accNo;
	
	@FindBy(how = How.NAME, using = "ammount")
	@CacheLookup
	WebElement amount;
	
	@FindBy(how = How.NAME, using = "desc")
	@CacheLookup
	WebElement description;
	
	@FindBy(how = How.NAME, using = "AccSubmit")
	@CacheLookup
	WebElement btnSubmit;
	
	public void clickwithDrawal() {
		withdrawal.click();
	}
	
	public void setAccNo(String accno) {
		accNo.sendKeys(accno);
	}
	
	public void setAmount(String am) {
		amount.sendKeys(am);
	}
	
	public void setDescription(String desc) {
		description.sendKeys(desc);
	}
	
	public void submit() {
		btnSubmit.click();
	}
	
	
	
	
}
