package com.android.selectors;

import org.openqa.selenium.By;

public class Stash_ReviewWithdrawalSelectors {
	
	public static By txtReviewWithdrawal = By.xpath("//android.widget.TextView[@text='Review withdrawal']");

	public static By txtAmountTitle = By.xpath("//android.widget.TextView[contains(@text,'Amount')]");

	public static By txtAmountValue = By.xpath("//android.widget.TextView[contains(@text,'Amount')]/following-sibling::android.widget.TextView");

	public static By txtFromTitle = By.xpath("//android.widget.TextView[contains(@text,'From')]");

	public static By txtFromValue = By.xpath("//android.widget.TextView[contains(@text,'From')]/following-sibling::android.widget.TextView");

	public static By txtToTitle = By.xpath("//android.widget.TextView[contains(@text,'To')]");

	public static By txtToValue = By.xpath("//android.widget.TextView[contains(@text,'To')]/following-sibling::android.widget.TextView");

	public static By btnConfirm = By.xpath("//android.widget.TextView[@text='Confirm']");

}
