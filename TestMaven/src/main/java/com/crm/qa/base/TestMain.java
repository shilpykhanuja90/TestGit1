package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestMain {
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public TestMain(){
		try {
			prop=new Properties();
			FileInputStream in= new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/crm/qa/config/config.properties");
			prop.load(in);
		} catch (FileNotFoundException e) {
			e.getStackTrace();
			// TODO: handle exception
		}catch (Exception e) {
			e.getMessage();
			// TODO: handle exception
		}
	}
	public static void initialization() {
		String Browsername=prop.getProperty("Browser");
		if (Browsername.equalsIgnoreCase("CHROME")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/java/com/crm/qa/util/Driver/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if (Browsername.equalsIgnoreCase("FIREFOX")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/main/java/com/crm/qa/util/Driver/geckodriver.exe");
			driver =new FirefoxDriver();
		}
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Time, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait_Time,TimeUnit.SECONDS );
		driver.get(prop.getProperty("URL"));
		
		
	}
}
