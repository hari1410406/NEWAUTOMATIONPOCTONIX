package com.business.tonikPages;

import com.android.selectors.Stash_WithdrawTransactionDetailsSelectors;

public class Stash_WithdrawTransactionDetailsPage extends BasePage {

	public Stash_WithdrawTransactionDetailsPage() throws InterruptedException {
		super();
	}

	/**
	 * Verify Transaction Details [Withdraw] page is loaded successfully
	 * Checking if page title as Transaction details is displayed
	 */
	public boolean verifyPageLoaded() throws Exception {
		waitTime(2000);
		if(waitForElementToBePresent(Stash_WithdrawTransactionDetailsSelectors.txtTransactionDetails, 120,"Review Withdrawal text"))
		{
			extent.extentLoggerPass("Page loaded ('Transaction Details [Withdraw]')", "'Transaction Details [Withdraw]' page loaded successfully");
			return true;
		}
		else
		{
			extent.extentLoggerFail("Page not loaded ('Transaction Details [Withdraw]')", "'Transaction Details [Withdraw]' page not loaded successfully");
			return false;
		}
	}

	/**
		Verify withdrawal amount, stash type, to account information in Review Withdraw page
		Parameters:
			withdrawalAmount - Amount to be withdrawn
			stashType - Stash type: Emergency, Travelling
			toAccount - To Tonik Account
	 		when - Date in dd MMM yyyy  - format [13 Jan 2023]
	 */
	public void verifyTransactionDetails(String withdrawalAmount, String toAccount,
										 String stashType, String when) throws Exception {
		extent.HeaderChildNode("Review withdrawal amount");
		waitTime(2000);

		if(this.verifyPageLoaded()) {
			String actualWithdrawalAmount = getText(Stash_WithdrawTransactionDetailsSelectors.txtAmountValue);
			String actualStashType = getText(Stash_WithdrawTransactionDetailsSelectors.txtFromValue);
			String actualToAccount = getText(Stash_WithdrawTransactionDetailsSelectors.txtToValue);
			String actualWhen = getText(Stash_WithdrawTransactionDetailsSelectors.txtWhenValue);
			String actualRefNumber = getText(Stash_WithdrawTransactionDetailsSelectors.txtRefNumberValue);
			String actualDate = actualWhen.split(",")[0].trim();
			softAssertion.assertEquals(actualWithdrawalAmount, withdrawalAmount);
			softAssertion.assertEquals(actualStashType, stashType);
			softAssertion.assertEquals(actualToAccount, toAccount);
			softAssertion.assertEquals(actualDate, when);
			softAssertion.assertEquals(actualRefNumber.length()>5, true);
			softAssertion.assertAll();
			waitTime(2000);
			//Back(1);
		}
	}
}
