package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestMain;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class LoginTC extends TestMain {
	
	public LoginTC() {
		// this will call main TestMain to intialize the variable
		super();
	}
@BeforeMethod
public static void Setup() {
	// TODO Auto-generated method stub
	initialization();

}
/*
 * @DataProvider public Object[][] getTestDatafromExcel(){ Object[][] data=
 * TestUtil.ReadExceldata(); return data;
 * 
 * }
 */

//@Test(priority = 1, dataProvider = "getTestDatafromExcel")
@Test(priority = 1)
public static void Exection() {
	LoginPage LP= new LoginPage();
	String strTitle= LP.fnLogin();
	System.out.println(strTitle);
	Assert.assertEquals(strTitle, "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
}
@AfterMethod
private void CloseBrowser() {
	// TODO Auto-generated method stub
	driver.quit();

}

}
