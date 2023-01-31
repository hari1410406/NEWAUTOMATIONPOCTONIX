package com.android.selectors;

import org.openqa.selenium.By;

public class Stash_WithdrawFromYourStashSelectors {
	
	public static By txtWithDrawFromYourStash =By.xpath("//android.widget.TextView[@text='Withdraw from your Stash']");

	public static By txtBalance = By.xpath("//android.widget.TextView[contains(@text,'Balance:')]");
	public static By edtWithDrawableAmount = By.xpath("(//android.widget.TextView[contains(@text,'Balance:')]/following-sibling::android.widget.EditText)[2]");
	public static By btnWithdraw = By.xpath("//android.widget.TextView[@text='Withdraw']");

	public static By txtNoEnoughBalance =By.xpath("//android.widget.TextView[@text='No enough balance in Stash account']");
}
