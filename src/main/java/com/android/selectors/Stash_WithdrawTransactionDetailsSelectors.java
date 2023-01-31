package com.android.selectors;

import org.openqa.selenium.By;

public class Stash_WithdrawTransactionDetailsSelectors {
	
	public static By txtTransactionDetails = By.xpath("//android.widget.TextView[@text='Transaction details']");

	public static By txtAmountTitle = By.xpath("//android.widget.TextView[contains(@text,'Amount')]");

	public static By txtAmountValue = By.xpath("//android.widget.TextView[contains(@text,'Amount')]/following-sibling::android.widget.TextView");

	public static By txtToTitle = By.xpath("//android.widget.TextView[contains(@text,'To')]");

	public static By txtToValue = By.xpath("//android.widget.TextView[contains(@text,'To')]/following-sibling::android.widget.TextView");

	public static By txtFromTitle = By.xpath("//android.widget.TextView[contains(@text,'From')]");

	public static By txtFromValue = By.xpath("//android.widget.TextView[contains(@text,'From')]/following-sibling::android.widget.TextView");

	public static By txtWhenTitle = By.xpath("//android.widget.TextView[contains(@text,'When')]");

	public static By txtWhenValue = By.xpath("//android.widget.TextView[contains(@text,'When')]/following-sibling::android.widget.TextView");

	public static By txtRefNumberTitle = By.xpath("//android.widget.TextView[contains(@text,'Ref number')]");

	public static By txtRefNumberValue = By.xpath("//android.widget.TextView[contains(@text,'Ref number')]/following-sibling::android.widget.TextView");

}
