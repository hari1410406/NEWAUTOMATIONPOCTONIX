package com.business.tonikPages;

import com.android.selectors.Stash_ManageStashSelectors;

public class Stash_ManageStashPage extends BasePage {

	public Stash_ManageStashPage() throws InterruptedException {
		super();
	}

	/**
	 * Verify Manage stash page is loaded successfully
	 * Checking if Manage Stash text is displayed
	 */
	public boolean verifyPageLoaded() throws Exception {
		extent.HeaderChildNode("Page loaded verification: Manage Stash ");

		waitTime(2000);
		if(waitForElementToBePresent(Stash_ManageStashSelectors.txtManageStash, 60, "Manage Stash text"))
		{
			extent.extentLoggerPass("Page loaded ('Manage Stash')", "'Manage Stash' page loaded successfully");
			return true;
		}
		else
		{
			extent.extentLoggerFail("Page not loaded ('Manage Stash')", "'Manage Stash' page not loaded successfully");
			return false;
		}
	}

	/**
	 * Clicking on Withdraw To Your TONIK Account link in Manage Stash page
	 */
	public void clickWithdrawToYourTonikAccount() throws Exception {
		extent.HeaderChildNode("Click on 'Withdraw to your TONIK Account' option");
		waitTime(2000);

		if(this.verifyPageLoaded()) {
			if(waitForElementToBePresent(Stash_ManageStashSelectors.txtWithdrawToyourTONIKAccount, 30,"Withdraw to your TONIK Account text"))
			{
				click(Stash_ManageStashSelectors.txtWithdrawToyourTONIKAccount, "Withdraw to your TONIK Account");
				extent.extentLoggerPass("'Withdraw to your TONIK Account' text click", "Clicked on 'Withdraw to your TONIK Account' text in Manage Stash page");
			}
			else
			{
				extent.extentLoggerFail("'Withdraw to your TONIK Account' text click", "Unable to click on 'Withdraw to your TONIK Account' link in Manage Stash page");
			}
		}
	}

	/**
	 * Clicking on 'Stash details' link in Manage Stash page
	 */
	public void clickStashDetails() throws Exception {
		extent.HeaderChildNode("Click on 'Stash details' option");
		waitTime(2000);

		if(this.verifyPageLoaded()) {
			if(waitForElementToBePresent(Stash_ManageStashSelectors.txtStashDetails, 30,"'Stash details' text"))
			{
				click(Stash_ManageStashSelectors.txtStashDetails, "Stash details");
				extent.extentLoggerPass("'Stash details' text click", "Clicked on 'Stash details' text in Manage Stash page");
			}
			else
			{
				extent.extentLoggerFail("'Stash details' text click", "Unable to click on 'Stash details' link in Manage Stash page");
			}
		}
	}

	/**
	 * Clicking on 'Modify' link in Manage Stash page
	 */
	public void clickModify() throws Exception {
		extent.HeaderChildNode("Click on 'Modify' option");
		waitTime(2000);

		if(this.verifyPageLoaded()) {
			if(waitForElementToBePresent(Stash_ManageStashSelectors.txtModify, 30,"'Stash details' text"))
			{
				click(Stash_ManageStashSelectors.txtModify, "Modify");
				extent.extentLoggerPass("'Modify' text click", "Clicked on 'Modify' text in Manage Stash page");
			}
			else
			{
				extent.extentLoggerFail("'Modify' text click", "Unable to click on 'Modify' link in Manage Stash page");
			}
		}
	}

	/**
	 * Clicking on 'Close' link in Manage Stash page
	 */
	public void clickClose() throws Exception {
		extent.HeaderChildNode("Click on 'Close' option");
		waitTime(2000);

		if(this.verifyPageLoaded()) {
			if(waitForElementToBePresent(Stash_ManageStashSelectors.btnClose, 30,"'Close' text"))
			{
				click(Stash_ManageStashSelectors.btnClose, "Close");
				extent.extentLoggerPass("'Close' text click", "Clicked on 'Close' text in Manage Stash page");
			}
			else
			{
				extent.extentLoggerFail("'Close' text click", "Unable to click on 'Close' link in Manage Stash page");
			}
		}
	}

	/**
	 * Handling the popup where we click on 'Yes, close the stash' link
	 */
	public void handleCloseStashConfirmation() throws Exception {
		extent.HeaderChildNode("Confirmation pop-up for closing the Stash");
		waitTime(2000);
		//explicitWaitVisibility(Stash_ManageStashSelectors.txtYesCloseStash, 10);
		if(waitForElementToBePresent(Stash_ManageStashSelectors.txtYesCloseStash, 45,"Yes close the Stash"))
		{
			click(Stash_ManageStashSelectors.txtYesCloseStash, "Yes close the Stash");
			extent.extentLoggerPass("Yes Close the Stash", "Clicked on Yes close the Stash text in Manage Stash page");
		}
		else
		{
			extent.extentLoggerFail("Yes close the Stash", "Unable to click on Yes close the Stash text in Manage Stash page");
		}
	}
	
	/**
	 * Handling close the Stash confirmation By clicking On Stay and Yes, Close the Stash link 
	 * @throws Exception
	 */
	
	public void clickStayAndCloseStashConfirmation() throws Exception {
		extent.HeaderChildNode("Click on stay on the pop-up for closing the stash");
		waitTime(2000);
		ConfirmationCloseStashPopUP();
		waitTime(2000);
		clickClose();
		if(verifyElementPresent(Stash_ManageStashSelectors.txtYesCloseStash, "Yes close the Stash"))
		{
			click(Stash_ManageStashSelectors.txtYesCloseStash, "Yes close the Stash");
			extent.extentLoggerPass("Yes Close the Stash", "Clicked on Yes close the Stash text in Manage Stash page");
		}
		else
		{
			extent.extentLoggerFail("Yes close the Stash", "Unable to click on Yes close the Stash text in Manage Stash page");
		}
	}
	
	public void ConfirmationCloseStashPopUP() throws Exception {
		extent.HeaderChildNode("Pop-Up closed verification: Manage Stash ");

		waitTime(2000);
		if(verifyElementPresent(Stash_ManageStashSelectors.btnStay, "Pop-up is opened, Stay Button"))
		{
			click(Stash_ManageStashSelectors.btnStay, "stay Button");
			extent.extentLoggerPass("Pop-Up closed ","Close the stash pop-up is closed successfully");
		}
		if(verifyElementPresent(Stash_ManageStashSelectors.txtManageStash, "Pop-up is closed, Are you sure ,You want to close the stash "))
		{
			extent.extentLoggerPass("Manage Stash' page loaded successfully","Close the stash pop-up is closed successfully");
		}
		else
		{
			extent.extentLoggerFail("Pop-Up is not closed ('Manage Stash')", "'Manage Stash' page loaded successfully");
		}	
	}

}
