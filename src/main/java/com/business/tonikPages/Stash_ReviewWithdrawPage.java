package com.business.tonikPages;

import com.android.selectors.Stash_ReviewWithdrawalSelectors;

public class Stash_ReviewWithdrawPage extends BasePage {

	public Stash_ReviewWithdrawPage() throws InterruptedException {
		super();
	}

	/**
	 * Verify Withdraw review page is loaded successfully
	 * Checking if page title as Review withdrawal is displayed
	 */
	public boolean verifyPageLoaded() throws Exception {
		extent.HeaderChildNode("Page loaded verification: Withdraw from your Stash ");

		waitTime(2000);
		if(waitForElementToBePresent(Stash_ReviewWithdrawalSelectors.txtReviewWithdrawal, 60,"Review Withdrawal text"))
		{
			extent.extentLoggerPass("Page loaded ('Review Withdrawal')", "'Review Withdrawal' page loaded successfully");
			return true;
		}
		else
		{
			extent.extentLoggerFail("Page not loaded ('Review Withdrawal')", "'Review Withdrawal' page loaded successfully");
			return false;
		}
	}

	/**
		Verify withdrawal amount, stash type, to account information in Review Withdraw page
		Parameters:
			withdrawalAmount - Amount to be withdrawn
			stashType - Stash type: Emergency, Travelling
			toAccount - To Tonik Account
	 */
	public void reviewWithdrawalInfo(String withdrawalAmount, String stashType, String toAccount) throws Exception {
		extent.HeaderChildNode("Review withdrawal amount");
		waitTime(2000);

		if(this.verifyPageLoaded()) {
			String actualWithdrawalAmount = getText(Stash_ReviewWithdrawalSelectors.txtAmountValue).substring(1);
			String actualStashType = getText(Stash_ReviewWithdrawalSelectors.txtFromValue);
			String actualToAccount = getText(Stash_ReviewWithdrawalSelectors.txtToValue);
			softAssertion.assertEquals(actualWithdrawalAmount, withdrawalAmount);
			softAssertion.assertEquals(actualStashType, stashType);
			softAssertion.assertEquals(actualToAccount, toAccount);
			softAssertion.assertAll();
			waitTime(2000);
		}
	}

	/**
	 * Click on Confirm button
	 */
	public void clickConfirm() throws Exception {
		waitTime(2000);
		if(this.verifyPageLoaded()) {
			click(Stash_ReviewWithdrawalSelectors.btnConfirm, "Confirm");
		}
	}
}
