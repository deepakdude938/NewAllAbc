package com.ijmeet.functional_test;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ijmeet.pages.HomePage;
import com.ijmeet.pages.JoinMeetingPage;
import com.ijmeet.utility.Constant;
import com.ijmeet.utility.Keywords;
import com.ijmeet.utility.TestBase;

public class JoinMeetingPageTest extends JoinMeetingPage {
	JoinMeetingPage join = PageFactory.initElements(Constant.driver, JoinMeetingPage.class);
	public static Logger log=Logger.getLogger(JoinMeetingPageTest.class);

	@BeforeClass
	public void clickOnJoiningmeeting() {
		Keywords.clickOnElement("XPATH", "//a[@href='https://ijmeet.com/app']");

	}
	

	@Test
	public void verifyTextQuickJoinAMeetingTest() {
		JoinMeetingPage join = PageFactory.initElements(Constant.driver, JoinMeetingPage.class);
		boolean verify = join.isTextDisplayed();
		Assert.assertTrue(verify);
		String actualText = join.getTextMessage();
		System.out.println(actualText);
		log.info(actualText);
		log.info("ok");
		String expectedText = "Quick Join a Meeting";
		Assert.assertEquals(actualText, expectedText);
		log.info("Quick join meeting is availabel on page");
	}

	@Test
	public void verifyBackArrowTest() {
		JoinMeetingPage join = PageFactory.initElements(Constant.driver, JoinMeetingPage.class);
		boolean verify = join.isBackArrowDisplayed();
		Assert.assertTrue(verify);
		join.clickOnBackArrow();
		String expectedurl = "https://ijmeet.com/";
		String actualUrl = Constant.driver.getCurrentUrl();
		Assert.assertEquals(expectedurl, actualUrl);
	}

	@Test
	public static void verifyUserNameTextboxTest() throws InterruptedException {
		JoinMeetingPage join = PageFactory.initElements(Constant.driver, JoinMeetingPage.class);
		boolean verify = JoinMeetingPage.isTextBoxAvailable(username);
		Assert.assertTrue(verify);
		join.sendValueToTextBox(username, "abcd123");
		String actualValue = join.getValueFromTextbox(username);
		String expectedValue = "abcd123";
		System.out.println(actualValue);
		Assert.assertEquals(actualValue, expectedValue);

	}

	@Test
	public static void verifyMeetingIdTextboxTest() throws InterruptedException {
		JoinMeetingPage join = PageFactory.initElements(Constant.driver, JoinMeetingPage.class);
		boolean verify = join.isTextBoxAvailable(meetingid);
		Assert.assertTrue(verify);
		join.sendValueToTextBox(meetingid, "abcd123");
		String actualValue = join.getValueFromTextbox(meetingid);
		String expectedValue = "abcd123";
		System.out.println(actualValue);
		Assert.assertEquals(actualValue, expectedValue);

	}

	@Test
	public static void verifyJoinMeetingButtonVisibilityTest() {
		JoinMeetingPage join = PageFactory.initElements(Constant.driver, JoinMeetingPage.class);
		boolean verify = join.isJoinMeetingButtonDisplayed();
		Assert.assertTrue(verify);
	}
	@Test
	public static void verifyJoinMeetingTest() throws InterruptedException {
		String username1 = "abd";
		String meetingId = "yjf";
		JoinMeetingPage join = PageFactory.initElements(Constant.driver, JoinMeetingPage.class);
		if (username1 != null && meetingId == null) {
			join.sendValueToTextBox(username, "abcd123");
			join.clickOnJoinMeetingButton();
			String actualText = join.getErrorMessage1();
			System.out.println(actualText);
			String expectedText = "Please enter meeting id.";
			Assert.assertEquals(actualText, expectedText);

		}
		else if(username1==null && meetingId!=null) {
			join.sendValueToTextBox(meetingid, "abc");
			join.clickOnJoinMeetingButton();
			String actualText = join.getErrorMessage2();
			System.out.println(actualText);
			String expectedText = "Please enter user name.";
			Assert.assertEquals(actualText, expectedText);
		}
		else if(username1!=null && meetingId!=null) {
			join.sendValueToTextBox(meetingid, "abc");
			join.sendValueToTextBox(username, "abcd123");
			join.clickOnJoinMeetingButton();
			String actualText = join.getErrorMessage3();
			System.out.println(actualText);
			String expectedText = "Meeting not found";
			Assert.assertEquals(actualText, expectedText);
		}

	}

}
