package com.android.selectors;

import org.openqa.selenium.By;

public class Stash_WithdrawConfirmationSelectors {
	
	public static By txtConfirmationTitle = By.xpath("//android.widget.TextView[@text='Sweet!']");

	public static By btnOhYeah = By.xpath("//android.widget.TextView[@text='Oh yeah!']");

	public static By txtConfirmationMessage = By.xpath("//android.widget.TextView[contains(@text,'You moved') and contains(@text,'to your Tonik account')]");

	public static By txtViewDetails = By.xpath("//android.widget.TextView[@text='View Details']");

}
