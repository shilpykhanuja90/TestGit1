package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestMain;

public class LoginPage extends TestMain{
//Page factory or OR for elements
	@FindBy(xpath="//span[text()='Hello, sign in']")
	WebElement Signin;
	@FindBy(name="email")
	WebElement txtUserName;
	@FindBy(id="continue")
	WebElement btnContinue;
	@FindBy(name="password")
	WebElement txtpassword;
	@FindBy(id="signInSubmit")
	WebElement btnSignin;
	@FindBy(id="nav-logo-sprites")
	WebElement imgLogo;
	
	
	// Intializing the OR elements
public LoginPage() {
	PageFactory.initElements(driver, this);
}

public String fnLogin() {
	if(imgLogo.isDisplayed()) {
		System.out.println("Pass");
	}
	else {
		System.out.println("FAIL");
	}
	return driver.getTitle();	
}


}
