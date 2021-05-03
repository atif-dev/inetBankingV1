package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CustomStatement {

	WebDriver ldriver;
	public CustomStatement(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how = How.XPATH, using = "/html/body/div[3]/div/ul/li[14]/a")
	@CacheLookup
	WebElement lnkCustomStatement;
	
	@FindBy(how = How.NAME, using = "accountno")
	@CacheLookup
	WebElement accno;
	
	@FindBy(how = How.NAME, using = "AccSubmit")
	@CacheLookup
	WebElement btnsubmit;
	
	public void clickCustomStatement() {
		lnkCustomStatement.click();
	}
	
	public void InpAccountNo(String accNo) {
		accno.sendKeys(accNo);
	}
	
	public void submit() {
		btnsubmit.click();
	}
	
}
