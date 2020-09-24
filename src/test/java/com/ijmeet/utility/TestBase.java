package com.ijmeet.utility;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.ijmeet.utility.Keywords;

public class TestBase {
	@BeforeMethod
	public void openBrowser() throws InterruptedException {
		Keywords.keyword("CHROME");
		Keywords.openBrowser("https://ijmeet.com/");
		Thread.sleep(10000);
	}
	@AfterMethod
	public void closeBrowser() {
		Constant.driver.close();
	}
	
	

}
