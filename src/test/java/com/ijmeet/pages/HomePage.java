package com.ijmeet.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ijmeet.utility.Constant;
import com.ijmeet.utility.Keywords;
import com.ijmeet.utility.TestBase;

public class HomePage extends TestBase {
	public HomePage() {
		PageFactory.initElements(Constant.driver, this);

	}

	@FindBy(xpath = "//img[@src='https://ijmeet.com/images/LOGO-F@2x.png']")
	public static WebElement logo;

	@FindBy(xpath = "//a[@href='https://ijmeet.com/app']")
	public WebElement joinMeeting;

	@FindBy(xpath = "//a[@href='https://ijmeet.com/host_meeting']")
	public WebElement hostMeeting;

	@FindBy(xpath = "//nav/div/div/ul/li/a[@href='https://ijmeet.com/contact']")
	public WebElement contactSales;

	@FindBy(xpath = "//a[@href='https://ijmeet.com/login']")
	public WebElement signIn;

	@FindBy(xpath = "//li/a[@href='https://ijmeet.com/register']")
	public WebElement signUp;

	@FindBy(xpath = "//a[@class='nav-link setlang nav-language-cutom-bg-1 font-weight-bold']")
	public WebElement language;

	@FindBy(xpath = "//img[@src='https://ijmeet.com/images/profile_img/android.png']")
	public WebElement android;

	@FindBy(xpath = "//img[@src='https://ijmeet.com/images/profile_img/ios.png']")
	public WebElement apple;

	@FindBy(xpath = "//img[@src='https://ijmeet.com/images/profile_img/windows.png']")
	public WebElement windows;

	@FindBy(xpath = "/html/body/div[3]/footer/div[2]/div[2]")
	public static WebElement helpandsupport;

// For Logo	
	public static boolean isLogoVisible() {
		return logo.isDisplayed();
	}

	public static void clickOnLogo() {
		logo.click();
	}

//For Join Meeting
	public boolean isJoinMeetingVisible() {
		return joinMeeting.isDisplayed();
	}

	public void clickOnJoinMeeting() {
		joinMeeting.click();
	}

//For Host Meeting
	public boolean isHostMeetingVisible() {
		return hostMeeting.isDisplayed();
	}

	public void clickOnHostMeeting() {
		hostMeeting.click();
	}

//For  Contact Sales
	public boolean isContactSalesVisible() {
		return contactSales.isDisplayed();
	}

	public void clickOnContactSales() {
		contactSales.click();
	}

//For Sign In button
	public boolean isSignInButtonVisible() {
		return signIn.isDisplayed();
	}

	public void clickOnSignInButton() {
		signIn.click();
	}

//For Sign Up Button
	public boolean isSignUpButtonVisible() {
		return signUp.isDisplayed();
	}

	public void clickOnSignUpButton() {
		signUp.click();
	}

//For Language button verification
	public boolean isLanguageButtonVisible() {
		return language.isDisplayed();
	}

	public void clickOnLanguageButton() {
		language.click();
	}

	// For Android button verification
	public boolean isAndroidLinkVisible() {
		return android.isDisplayed();
	}

	public void clickOnAndroidLink() {
		android.click();
	}

	// For apple button verification
	public boolean isAppleLinkVisible() {
		return apple.isDisplayed();
	}

	public void clickOnAppleLink() {
		apple.click();
	}

	// For Window button verification
	public boolean isWindowLinkVisible() {
		return windows.isDisplayed();
	}

	public void clickOnWinowLink() {
		windows.click();
	}

	// For Help and Support
	public boolean isHelpAndSupportVisibleAtFooter() {
		return helpandsupport.isDisplayed();
	}

}
