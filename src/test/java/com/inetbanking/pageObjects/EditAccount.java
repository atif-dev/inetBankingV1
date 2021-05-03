package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EditAccount {

	WebDriver ldriver;
	
	public EditAccount(WebDriver rdriver) {//this is constructor
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how = How.XPATH, using ="/html/body/div[3]/div/ul/li[6]/a")
	@CacheLookup
	WebElement lnkEditAccount;

	@FindBy(how = How.NAME, using = "accountno")
	@CacheLookup
	WebElement txtAccountNo;

	@FindBy(how = How.NAME, using = "a_type")
	@CacheLookup
	WebElement dropDown;

	@CacheLookup
	@FindBy(how = How.NAME, using = "AccSubmit")
	WebElement btnSubmit;
	
	@CacheLookup
	@FindBy(how = How.NAME, using = "AccSubmit")
	WebElement btnSubmit2;
	
	public void clickEditAccount() {
		lnkEditAccount.click();
			
	}

	public void custAccNo(String accno) {
		txtAccountNo.sendKeys(accno);
		
	}

	public void accountType(String acctype) {
		Select dropdown = new Select(dropDown);
		//dropdown.sendKeys(acctype);
		dropdown.selectByVisibleText(acctype);
		//OR==> dropdown.selectByIndex(1);
		//OR==> dropdown.selectByValue("Savings");
	}

	public void accsubmit() {
		btnSubmit.click();
	}
	
	public void accsubmit2() {
		btnSubmit2.click();
	}
	
	
	
}
