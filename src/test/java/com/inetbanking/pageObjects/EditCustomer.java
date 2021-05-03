package com.inetbanking.pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EditCustomer {
	
	WebDriver ldriver;
	
	public EditCustomer(WebDriver rdriver)//this is constructor
	{
		ldriver = rdriver;
		
		PageFactory.initElements(rdriver, this);
		
	}
	
	
	
	@FindBy(how = How.XPATH, using ="/html/body/div[3]/div/ul/li[3]/a")
	@CacheLookup
	WebElement editCustomer;
	
	@FindBy(how = How.NAME, using ="cusid")
	@CacheLookup
	WebElement cusid;
	
	@CacheLookup
	@FindBy(how = How.NAME, using = "AccSubmit")
	WebElement cusIdSubmit;
	
	@CacheLookup
	@FindBy(how = How.NAME, using = "addr")
	WebElement txtaddress;

	@CacheLookup
	@FindBy(how = How.NAME, using = "city")
	WebElement txtcity;

	@CacheLookup
	@FindBy(how = How.NAME, using = "state")
	WebElement txtstate;

	@CacheLookup
	@FindBy(how = How.NAME, using = "pinno")
	WebElement txtpinno;

	@CacheLookup
	@FindBy(how = How.NAME, using = "telephoneno")
	WebElement txttelephoneno;

	@CacheLookup
	@FindBy(how = How.NAME, using = "emailid")
	WebElement txtemailid;

	@CacheLookup
	@FindBy(how = How.NAME, using = "sub")
	WebElement btnSubmit;
	
	public void clickEditCustomer() {
		editCustomer.click();
	}
	
	public void cusId(String id) {
		cusid.sendKeys(id);
	}
	
	public void idSubmit() {
		cusIdSubmit.click();
	}
	
	public void custaddress(String caddress) {
		txtaddress.sendKeys(Keys.CONTROL + "a");
		txtaddress.sendKeys(Keys.DELETE);
		txtaddress.sendKeys(caddress);
	}

	public void custcity(String ccity) {
		txtcity.sendKeys(Keys.CONTROL + "a");
		txtcity.sendKeys(Keys.DELETE);
		txtcity.sendKeys(ccity);
	}

	public void custstate(String cstate) {
		txtstate.sendKeys(Keys.CONTROL + "a");
		txtstate.sendKeys(Keys.DELETE);
		txtstate.sendKeys(cstate);
	}

	public void custpinno(String cpinno) {
		txtpinno.sendKeys(Keys.CONTROL + "a");
		txtpinno.sendKeys(Keys.DELETE);
		txtpinno.sendKeys(String.valueOf(cpinno));
	}

	public void custtelephoneno(String ctelephoneno) {
		txttelephoneno.sendKeys(Keys.CONTROL + "a");
		txttelephoneno.sendKeys(Keys.DELETE);
		txttelephoneno.sendKeys(ctelephoneno);
	}

	public void custemailid(String cemailid) {
		txtemailid.sendKeys(Keys.CONTROL + "a");
		txtemailid.sendKeys(Keys.DELETE);
		txtemailid.sendKeys(cemailid);
	}

	public void custsubmit() {
		btnSubmit.click();
	}
	
	
	
}