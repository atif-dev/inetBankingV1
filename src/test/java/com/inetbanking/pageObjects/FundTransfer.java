package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;



public class FundTransfer {
	
	WebDriver ldriver;
	
	public FundTransfer(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how = How.XPATH, using = "/html/body/div[3]/div/ul/li[10]/a")
	@CacheLookup
	WebElement lnkFundTransfer;
	
	@FindBy(how = How.NAME, using ="payersaccount")
	@CacheLookup
	WebElement payersAccountNo;
	
	@FindBy(how = How.NAME, using = "payeeaccount")
	@CacheLookup
	WebElement payeeAccountNo;
	
	@FindBy(how = How.NAME, using = "ammount")
	@CacheLookup
	WebElement amount;
	
	@FindBy(how = How.NAME, using = "desc")
	@CacheLookup
	WebElement description;
	
	@FindBy(how = How.NAME, using = "AccSubmit")
	@CacheLookup
	WebElement btnSubmit;
	
	public void clickFundTransfer() {
		lnkFundTransfer.click();
	}
	
	public void InpPayersAccountNo(String accNo) {
		payersAccountNo.sendKeys(accNo);
	}
	
	public void InpPayeeAccountNo(String accNo2) {
		payeeAccountNo.sendKeys(accNo2);
	}
	
	public void InpAmount(String am) {
		amount.sendKeys(am);
	}
	
	public void InpDescription(String desc) {
		description.sendKeys(desc);
	}
	
	public void clickSubmitBtn() {
		btnSubmit.click();
	}
}
