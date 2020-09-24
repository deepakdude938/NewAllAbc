package com.ijmeet.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.FluentWait;

public class WaitFor {
	public static FluentWait wait;
	public void minTime() {
		wait.withTimeout(10, TimeUnit.SECONDS);
		wait.pollingEvery(200, TimeUnit.MILLISECONDS);
	}
	public void moderateTime() {
		wait.withTimeout(20, TimeUnit.SECONDS);
		wait.pollingEvery(200, TimeUnit.MILLISECONDS);
	}
	public void maxTime() {
		wait.withTimeout(50, TimeUnit.SECONDS);
		wait.pollingEvery(500, TimeUnit.MILLISECONDS);
	}
}
