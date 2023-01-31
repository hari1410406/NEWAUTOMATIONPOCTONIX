package com.business.tonikPages;

import com.android.selectors.Stash_WithdrawFromYourStashSelectors;

public class Stash_WithdrawFromYourStashPage extends BasePage {

	public Stash_WithdrawFromYourStashPage() throws InterruptedException {
		super();
	}

	/**
	 * Verify Withdraw from your stash is loaded successfully
	 * Checking if Withdraw from your stash text is displayed
	 */
	public boolean verifyPageLoaded() throws Exception {
		//extent.HeaderChildNode("Page loaded verification: Withdraw from your Stash ");

		waitTime(2000);
		if(waitForElementToBePresent(Stash_WithdrawFromYourStashSelectors.txtWithDrawFromYourStash, 60,"Withdraw from your Stash text"))
		{
			extent.extentLoggerPass("Page loaded ('Withdraw from your stash')", "'Withdraw from your Stash' page loaded successfully");
			return true;
		}
		else
		{
			extent.extentLoggerFail("Page not loaded ('Withdraw from your stash')", "'Withdraw from your Stash' page loaded successfully");
			return false;
		}
	}

	/**
	 * Enter the amount in withdraw amount edit field and click on Withdraw button
	 * Parameters
	 * 		amount - e.g. 500, 1000
	 */
	public void withDrawAmount(String balanceAmount, String amount) throws Exception {
		extent.HeaderChildNode("Withdraw from your stash");
		waitTime(2000);

		if(this.verifyPageLoaded()) {

			this.verifyBalance(balanceAmount);

			String isButtonClickable = getAttributValue("clickable", Stash_WithdrawFromYourStashSelectors.btnWithdraw);
			if(isButtonClickable.equals("false")) {
				extent.extentLoggerPass("Withdraw button", "'Withdraw' button is disabled");
			}
			else {
				extent.extentLoggerFail("Withdraw button", "'Withdraw' button is enabled");
			}

			click(Stash_WithdrawFromYourStashSelectors.edtWithDrawableAmount, "Withdraw amount edit field");
			clearField(Stash_WithdrawFromYourStashSelectors.edtWithDrawableAmount, "Withdraw amount edit field");
			hideKeyboard();
			type(Stash_WithdrawFromYourStashSelectors.edtWithDrawableAmount  , amount, "Withdraw amount");
			waitTime(2000);
			waitForElementAndClickIfPresent(Stash_WithdrawFromYourStashSelectors.btnWithdraw, 20,"Withdraw");
			waitTime(2000);
		}
	}

	/**
	 * Verify 'No enough balance in Stash account' message is displayed or not
	 */
	public void verifyNoEnoughBalanceMessage(String balanceAmount) throws Exception {
		extent.HeaderChildNode("No enough balance in Stash account - message verification");
		waitTime(4000);

		if(this.verifyPageLoaded()) {
			this.verifyBalance(balanceAmount);
			if(waitForElementToBePresent(Stash_WithdrawFromYourStashSelectors.txtNoEnoughBalance, 120, "No enough balance in Stash account text message")) {
				extent.extentLoggerPass("Message - No enough balance in Stash account", "'No enough balance in Stash account'  is displayed");
			} else {
				extent.extentLoggerFail("Message - No enough balance in Stash account", "'No enough balance in Stash account' is not displayed");
			}
		}
	}

	/**
	 * Verify 'Balance:' message is displayed or not
	 * Parameter:
	 * 		balanceAmount: 500.00
	 */
	public void verifyBalance(String balanceAmount) throws Exception {
		//extent.HeaderChildNode("Balance text verification");
		if(waitForElementToBePresent(Stash_WithdrawFromYourStashSelectors.txtBalance, 10, "Balance amount text message")) {
			String actualBalanceAmount = getText(Stash_WithdrawFromYourStashSelectors.txtBalance);
			String expectedBalanceAmount = "Balance: ₱"+balanceAmount;
			softAssertion.assertEquals(actualBalanceAmount, expectedBalanceAmount);
			softAssertion.assertAll();
		} else {
			extent.extentLoggerFail("Message - No enough balance in Stash account", "'No enough balance in Stash account' is not displayed");
		}
	}
}
