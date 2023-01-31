package com.business.tonikPages;

import com.android.selectors.Stash_SetInitialSavingSelectors;

public class Stash_SetInitialSavingPage extends BasePage {
	
	public Stash_SetInitialSavingPage() throws InterruptedException {
		super();	
	}
    /**
     * This method is to click on Skip For Now link in Set Initial Saving Page
     * @throws Exception
     */
	public void clickOnSkipForNow() throws Exception {
		extent.HeaderChildNode("Click on Skip For Now Option");
		waitTime(2000);
		if(verifyElementPresent(Stash_SetInitialSavingSelectors.txtSkipForNow, "Skip For Now text"))
		{
			click(Stash_SetInitialSavingSelectors.txtSkipForNow, "Skip For Now text");
			extent.extentLoggerPass("Skip For Now text", "Clicked on Skip For Now text in Set Intial Saving page");
		}
		else
		{
			extent.extentLoggerFail("Skip For Now text", "Clicked on Skip For Now text in Set Intial Saving page");
		}

	}
}
