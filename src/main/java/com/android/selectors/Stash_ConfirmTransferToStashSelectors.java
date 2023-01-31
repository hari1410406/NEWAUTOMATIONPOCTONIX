package com.android.selectors;

import org.openqa.selenium.By;

public class Stash_ConfirmTransferToStashSelectors {

	public static By txtConfirmTransferToStash = By.xpath("//android.widget.TextView[@text='Confirm transfer to Stash']");
	public static By btnConfirm = By.xpath("//android.widget.TextView[@text='Confirm']");
	public static By txtAmount = By.xpath("//android.widget.TextView[contains(@text,'Amount')]/following-sibling::android.widget.TextView");
	public static By txtFrom = By.xpath("//android.widget.TextView[contains(@text,'From')]/following-sibling::android.widget.TextView");
	public static By txtTo = By.xpath("//android.widget.TextView[contains(@text,'To')]/following-sibling::android.widget.TextView");
	public static By txtStashOwner = By.xpath("//android.widget.TextView[contains(@text,'Stash owner')]/following-sibling::android.widget.TextView");
}
