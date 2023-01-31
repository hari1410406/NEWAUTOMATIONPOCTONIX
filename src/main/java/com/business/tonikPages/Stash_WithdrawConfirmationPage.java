package com.business.tonikPages;

import com.android.selectors.Stash_WithdrawConfirmationSelectors;

public class Stash_WithdrawConfirmationPage extends BasePage {

	public Stash_WithdrawConfirmationPage() throws InterruptedException {
		super();
	}

	/**
	 * Verify Withdraw confirmation page is loaded successfully
	 * Checking if page title as Sweet! is displayed
	 */
	public boolean verifyPageLoaded() throws Exception {
		extent.HeaderChildNode("Page loaded verification: Withdraw from your Stash ");

		waitTime(2000);
		if(waitForElementToBePresent(Stash_WithdrawConfirmationSelectors.txtConfirmationTitle, 60,"Withdrawal Confirmation text"))
		{
			extent.extentLoggerPass("Page loaded ('Withdrawal Confirmation')", "'Withdrawal Confirmation' page loaded successfully");
			return true;
		}
		else
		{
			extent.extentLoggerFail("Page not loaded ('Withdrawal Confirmation')", "'Withdrawal Confirmation' page not loaded successfully");
			return false;
		}
	}

	/**
	 * Verify if confirmation page is loaded
	 * Parameters:
	 * 		withdrawalAmount - ₱1,000.00
	 * 		stashType - e.g. Education or Travelling or Emergency
	 * Message verified: e.g. You moved ₱1,000.00 from Emergency to your Tonik account. Now you’ve got cash. Date night?
	 */
	public void verifyConfirmationMessage(String withdrawalAmount, String stashType) throws Exception {
		extent.HeaderChildNode("Withdrawal Confirmation: Confirmation message verification");

		if(this.verifyPageLoaded()) {
			String actualMessage = getText(Stash_WithdrawConfirmationSelectors.txtConfirmationMessage);
			String expectedMessage = "You moved "+withdrawalAmount+" from "+stashType+" to your Tonik account. Now you’ve got cash. Date night?";
			softAssertion.assertEquals(actualMessage, expectedMessage);
			softAssertion.assertAll();
			System.out.println("===> actualMessage: "+actualMessage);
		}
	}

	/**
	 * Click on View Details link
	 */
	public void clickViewDetailsLink() throws Exception {
		waitTime(2000);
		if(this.verifyPageLoaded()) {
			click(Stash_WithdrawConfirmationSelectors.txtViewDetails, "View Details");
		}
	}

	/**
	 * Click on View Details link
	 */
	public void clickOhYeahButton() throws Exception {
		waitTime(2000);
		if(this.verifyPageLoaded()) {
			click(Stash_WithdrawConfirmationSelectors.btnOhYeah, "View Details");
		}
	}
}
