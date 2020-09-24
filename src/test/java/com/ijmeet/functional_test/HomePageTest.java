package com.ijmeet.functional_test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.LogManager;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ijmeet.pages.HomePage;
import com.ijmeet.utility.Constant;
import com.ijmeet.utility.Keywords;
import com.ijmeet.utility.TestBase;

public class HomePageTest extends TestBase {
	public HomePage home;
	public static Logger log = Logger.getLogger(HomePageTest.class);

	@BeforeMethod
	public void initializePage() {
		home = new HomePage();
	}

	@Test
	public void verifyHomePage() {
		String actualtitle = Constant.driver.getTitle();
		String expectedTitle = "IJmeet";
		Assert.assertEquals(expectedTitle, actualtitle);
		log.info("HomePage is available for IJmeet");

	}

	@Test
	public void isLogoVisibleTest() {
		boolean verify = home.isLogoVisible();
		Assert.assertTrue(verify, "Logo is Not Found");
		log.info("Logo is available");
		
	}@Test
	public void isLogoClickableTest() {
		home.clickOnLogo();
		String expectedUrl = Constant.driver.getCurrentUrl();
		String actualUrl = "https://ijmeet.com/home";
		Assert.assertEquals(expectedUrl, actualUrl);
		log.info("Logo is clickable");
		
	}

	@Test
	public void isJoinMeetingVisibleTest() {
		boolean verify = home.isJoinMeetingVisible();
		Assert.assertTrue(verify, "Join Meeting is Not Found");
		log.info("Join Meeting is visible");
	
	}
	@Test
	public void isJoinMeetingClickableTest() {
		home.clickOnJoinMeeting();
		String expectedUrl = Constant.driver.getCurrentUrl();
		String actualUrl = "https://ijmeet.com/app";
		Assert.assertEquals(expectedUrl, actualUrl);
		log.info("Join Meeting is clickable");
		
	}

	@Test
	public void isHostMeetingVisibleTest() {
		boolean verify = home.isHostMeetingVisible();
		Assert.assertTrue(verify, "Host Meeting is Not Found");
		
	}
	@Test
	public void isHostMeetingClickableTest() {
		home.clickOnHostMeeting();
		String expectedUrl = Constant.driver.getCurrentUrl();
		String actualUrl = "https://ijmeet.com/host_meeting";
		Assert.assertEquals(expectedUrl, actualUrl);
		log.info("Host Meeting is clickable");		
	}

	@Test
	public void isContactSalesVisibleTest() {
		boolean verify = home.isContactSalesVisible();
		Assert.assertTrue(verify, "Contact sales is Not Found");
		log.info("Contact Sales is Visible");
		
	}
	@Test
	public void isContactClickableTest() {
		home.clickOnContactSales();
		String expectedUrl = Constant.driver.getCurrentUrl();
		String actualUrl = "https://ijmeet.com/contact";
		Assert.assertEquals(expectedUrl, actualUrl);
		log.info("Contact sales is clickable");
	}

	@Test
	public void isSignInButtonVisibleTest() {
		boolean verify = home.isSignInButtonVisible();
		Assert.assertTrue(verify, "Sign in button is Not Found");
		log.info("Sign In button is visible");
		
	}
	@Test
	public void isSignInButtonClickableTest() {
		home.clickOnSignInButton();
		String expectedUrl = Constant.driver.getCurrentUrl();
		String actualUrl = "https://ijmeet.com/login";
		Assert.assertEquals(expectedUrl, actualUrl);
		log.info("Sign In button is clickable");
	}

	@Test
	public void isSignUpButtonVisibleAndClickableTest() {
		boolean verify = home.isSignUpButtonVisible();
		Assert.assertTrue(verify, "Sign Up button is Not Found");
		log.info("Sign Up button is visible");
	}
	@test
	public void isSignUpButtonClickableTest() {
		home.clickOnSignUpButton();
		String expectedUrl = Constant.driver.getCurrentUrl();
		String actualUrl = "https://ijmeet.com/register";
		Assert.assertEquals(expectedUrl, actualUrl);
		log.info("SignUp button is clickable");
	}

	@Test
	public void isLanguageButtonVisibleTest() {
		boolean verify = home.isLanguageButtonVisible();
		Assert.assertTrue(verify, "Language button is Not Found");
		log.info("Language Button is visible");
		
	}
	public void isLanguageButtonClickableTest() {
		home.clickOnLanguageButton();
		String expectedUrl = Constant.driver.getCurrentUrl();
		String actualUrl = "https://ijmeet.com/#";
		Assert.assertEquals(expectedUrl, actualUrl);
		log.info("Language Button is clickable");
	}

	@Test
	public void isAndroidButtonVisibleTest() {
		
		boolean verify = home.isAndroidLinkVisible();
		Assert.assertTrue(verify, "Android button is Not Found");

		}
	
	public void isAndroidButtonClickable() {
		String expectedUrl = null;
		String actualUrl = null;
		String winHandleBefore = Constant.driver.getWindowHandle();

		home.clickOnAndroidLink();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//For switching window using Set
		Set<String> handle = Constant.driver.getWindowHandles();
		Iterator itr = handle.iterator();
		while (itr.hasNext()) {
			String winHandle = (String) itr.next();
			if (!winHandle.equals(winHandleBefore)) {
				Constant.driver.switchTo().window(winHandle);
				expectedUrl = Constant.driver.getCurrentUrl();
				System.out.println(expectedUrl);
				actualUrl = "https://play.google.com/store/apps/details?id=com.gcnt.ijmeet";
			}
		}
			Assert.assertEquals(expectedUrl, actualUrl);

			// Switch to new window using For each loop
			/*
			 * for (String winHandle : Constant.driver.getWindowHandles()) {
			 * 
			 * if (winHandle != winHandleBefore) {
			 * Constant.driver.switchTo().window(winHandle);
			 * 
			 * String expectedUrl = Constant.driver.getCurrentUrl();
			 * System.out.println(expectedUrl); String actualUrl =
			 * "https://play.google.com/store/apps/details?id=com.gcnt.ijmeet";
			 * Assert.assertEquals(expectedUrl, actualUrl);
			 * 
			 * }
			 */
		
	}
	@Test
	public void isAppleLinkVisibleAndClickableTest() {
		String actualUrl=null;
		String expectedUrl=null;
		
		boolean verify = home.isAppleLinkVisible();
		Assert.assertTrue(verify);
		String appleHandle = Constant.driver.getWindowHandle();
		home.clickOnAppleLink();
		Set handles = Constant.driver.getWindowHandles();
		Iterator<String> itr = handles.iterator();
		while (itr.hasNext()) {
			String handle = (String) itr.next();
			if (!handle.equals(appleHandle)) {
				Constant.driver.switchTo().window(handle);
				actualUrl = Constant.driver.getCurrentUrl();
				expectedUrl = "https://apps.apple.com/us/app/id1524001778";
			
				log.info("Apple link is available");
			}
		}
		Assert.assertEquals(actualUrl, expectedUrl);
	}

	@Test
	public void isWindowLinkVisibleAndClickableTest() {
		String actualTitle=null;
		String expectedTitle=null;
		
		boolean verify = home.isWindowLinkVisible();
		Assert.assertTrue(verify);
		String windowHandle = Constant.driver.getWindowHandle();
		home.clickOnWinowLink();
		Set handles = Constant.driver.getWindowHandles();
		Iterator<String> itr = handles.iterator();
		while (itr.hasNext()) {
			String handle = (String) itr.next();
			if (!handle.equals(windowHandle)) {
				Constant.driver.switchTo().window(handle);
				actualTitle = Constant.driver.getTitle();
				System.out.println(actualTitle);
				expectedTitle = "IJmeet - Apps on Google Play";
				
				log.info("Window Link is available");

			}
		}
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	public void isHelpAndSupportVisibilityTest() {
		HomePage home = new HomePage();
		boolean verify = home.isHelpAndSupportVisibleAtFooter();
		Assert.assertTrue(verify);

		WebElement menu = HomePage.helpandsupport.findElement(By.tagName("a"));
		List<String> list = new ArrayList<String>();
		// Iterator<WebElement> itr=menu.
	}
}