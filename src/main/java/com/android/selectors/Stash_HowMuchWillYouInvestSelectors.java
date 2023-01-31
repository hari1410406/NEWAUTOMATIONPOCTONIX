package com.android.selectors;

import org.openqa.selenium.By;

public class Stash_HowMuchWillYouInvestSelectors {

	public static By txtHowMuchWillYouInvest =By.xpath("//android.widget.TextView[@text='How much will you invest?']");
	
	public static By btnIAmInterested = By.xpath("//android.widget.TextView[@text='I am interested']");
	
	public static By txtVerificationLink = By.xpath("//android.widget.TextView[contains(@text,'A verification link will be sent to')]");
	
	//public static By txtVerificationLink = By.xpath("//android.widget.TextView[contains(@text,' If it were me, every OTP will start with 1 4 3')]");
}

