package com.business.tonikPages;

import com.android.selectors.Stash_StashCloseSelectors;

public class Stash_StashClosePage extends BasePage{
	
	public Stash_StashClosePage() throws InterruptedException {
	  super();	
	}
	
	/**
	 * This Business Method is to verify the confirmation of broke stash
	 * @throws Exception
	 */
	public void brokeTheStash() throws Exception 
	{
		extent.HeaderChildNode("Confirmation Broke the Stash Page");
		waitTime(2000);
		if(verifyElementPresent(Stash_StashCloseSelectors.txtBrokeTheStash, "You Broke the Stash text"))
		{
			String actualMessageBrokeTheStash = getText(Stash_StashCloseSelectors.txtBrokeTheStash);
			System.out.println(actualMessageBrokeTheStash);
	        verifyElementPresent(Stash_StashCloseSelectors.txtJustKiddingYouHaveClosedIt, "You have closed It text");
			String actualMessageOfYouHaveClosed = getText(Stash_StashCloseSelectors.txtJustKiddingYouHaveClosedIt);
			System.out.println(actualMessageOfYouHaveClosed);
		}
        if(verifyElementPresent(Stash_StashCloseSelectors.btnDone, "Done button"))
		{
			click(Stash_StashCloseSelectors.btnDone, "Done button");
			extent.extentLoggerPass("Broke the Stash succesfully", "Broke the Stash is displayed and Clicked on Done button in Close Stash page");
		}
		else
		{
			extent.extentLoggerFail("Broke the Stash", "You broke the Stash Text is not displayed in Close Stash page");
		}	
	}
}
