package com.ijmeet.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ijmeet.utility.TestBase;

public class JoinMeetingPage extends TestBase {
	@FindBy(xpath = "//h2[@class='m-txt']")
	public WebElement text1;

	@FindBy(xpath = "//a[@class='back-arrow']")
	public WebElement backArrow;
	
	@FindBy(xpath="//input[@id='username']")
	public static WebElement username;
	public static WebElement meetingid;
	public static WebElement before_start;
	
	@FindBy(xpath="//p[@class='text-center mb-0']")
	public static WebElement errorMessage1;
	
	@FindBy(xpath="//p[@class='text-center mb-0']")
	public static WebElement errorMessage2;
	
	@FindBy(xpath="//p[@class='text-center mb-0']")
	public static WebElement errorMessage3;

	public boolean isTextDisplayed() {
		return text1.isDisplayed();
	}

	public String getTextMessage() {
		String text = text1.getText();
		return text;
	}
	public void clickOnBackArrow() {
		backArrow.click();
	}
	public boolean isBackArrowDisplayed() {
		return backArrow.isDisplayed();
	}
	
	public static boolean isTextBoxAvailable(WebElement element) {
		return element.isDisplayed();
	}
	public static void sendValueToTextBox(WebElement element,String text) throws InterruptedException {
		element.sendKeys(text);
		Thread.sleep(5000);
	}
	public static String getValueFromTextbox(WebElement element) {
	return	element.getAttribute("value");
	}
	
	public boolean isJoinMeetingButtonDisplayed() {
		return before_start.isDisplayed();
	}
	public void clickOnJoinMeetingButton() {
		before_start.click();
	}
	public String getErrorMessage1() {
		String errorText=errorMessage1.getAttribute("innerHTML");
		return errorText;
	}
	public String getErrorMessage2() {
		String errorText=errorMessage2.getAttribute("innerHTML");
		return errorText;

	}
	public String getErrorMessage3() {
		String errorText=errorMessage3.getAttribute("innerHTML");
		return errorText;

	}
	
	
	
	

}
