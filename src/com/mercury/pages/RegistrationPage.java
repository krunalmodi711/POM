package com.mercury.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {
	
	
	WebDriver objDriver;
	
	public RegistrationPage(WebDriver objDriver){
		
		this.objDriver= objDriver;
	}
	
	@FindBy(how=How.XPATH,using="//input[@name='firstName']")
	WebElement firstname;
	@FindBy(how = How.XPATH,using="//input[@name='lastName']")
	WebElement lastname;
	@FindBy(how = How.XPATH,using="//input[@name='phone']")
	WebElement phone;
	@FindBy(how = How.XPATH,using="//input[@name='userName']")
	WebElement email;
	@FindBy(how = How.XPATH,using="//input[@name='address1']")
	WebElement address1;
	@FindBy(how = How.XPATH,using="//input[@name='address2']")
	WebElement address2;
	@FindBy(how = How.XPATH,using="//input[@name='city']")
	WebElement city;
	@FindBy(how = How.XPATH,using="//input[@name='state']")
	WebElement state;
	@FindBy(how = How.XPATH,using="//input[@name='postalCode']")
	WebElement postalcode;
	@FindBy(how = How.XPATH,using="//select[@name='country']")
	WebElement country;
	@FindBy(how = How.XPATH,using="//input[@name='email']")
	WebElement username;
	@FindBy(how = How.XPATH,using="//input[@name='password']")
	WebElement password;
	@FindBy(how = How.XPATH,using="//input[@name='confirmPassword']")
	WebElement confirmPassword;
	@FindBy(how= How.NAME,using="register")
	WebElement button;
	
	
	public RegistrationPage regiruser(String fname,String lname,String phn,String mail,String add1
			,String add2,String cit,String stat,String post,String count,String unam,String pas,String confirmpas){
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		phone.sendKeys(phn);
		email.sendKeys(mail);
		address1.sendKeys(add1);
		address2.sendKeys(add2);
		city.sendKeys(cit);
		state.sendKeys(stat);
		postalcode.sendKeys(post);
		Select objSel = new Select(country);
		objSel.selectByVisibleText(count);
		password.sendKeys(pas);
		confirmPassword.sendKeys(confirmpas);
		username.sendKeys(unam);
		JavascriptExecutor jse = ((JavascriptExecutor) objDriver);
		jse.executeScript("window.scrollTo(400, document.body.scrollHeight)");
		button.click();
		return this;
	}
	
	

}
	