package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DeleteCustomer {

	WebDriver ldriver;
	
	public DeleteCustomer(WebDriver rdriver) {//this is constructor
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how = How.XPATH, using ="/html/body/div[3]/div/ul/li[4]/a")
	@CacheLookup
	WebElement lnkDeleteCustomer;

	@FindBy(how = How.NAME, using = "cusid")
	@CacheLookup
	WebElement txtCustomerId;

	@CacheLookup
	@FindBy(how = How.NAME, using = "AccSubmit")
	WebElement btnSubmit;
	
	
	public void clickDeleteCustomer() {
		lnkDeleteCustomer.click();
			
	}

	public void customerId(String cusId) {
		txtCustomerId.sendKeys(cusId);
		
	}

	public void custsubmit() {
		btnSubmit.click();
	}
	
	
}
