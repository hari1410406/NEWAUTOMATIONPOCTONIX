package com.business.tonikPages;

import com.android.selectors.Stash_SetupYourStashSelectors;

public class Stash_SetupYourStashPage  extends BasePage 
{
	public Stash_SetupYourStashPage() throws InterruptedException {
		super();
	}
	
	public void enterDetailsIntoSetupYourStash(String stashName, String stashAmount) throws Exception 
	{
		extent.HeaderChildNode("Enter Stash For and Target Amount");
		logger.info("Setup Your Stash Details");
		waitTime(2000);	
		verifyElementPresent(Stash_SetupYourStashSelectors.txtSetupYourStash, "Setup Your Stash text");
		waitTime(2000);
		if(verifyElementPresent(Stash_SetupYourStashSelectors.txtStashFor, "Stash For"))
		{
			Aclick(Stash_SetupYourStashSelectors.edittxtStashFor, "text field");
			type(Stash_SetupYourStashSelectors.edittxtStashFor, stashName, " stash For text Field");
			logger.info("Entered the Stash For Name");
			waitTime(3000);
			hideKeyboard();
			verifyElementPresent(Stash_SetupYourStashSelectors.txtTargetamount, "Target Amount");
			Aclick(Stash_SetupYourStashSelectors.edittxtTargetamount, "text field");
			type(Stash_SetupYourStashSelectors.edittxtTargetamount, stashAmount, "target amount Field");
			logger.info("Entered the Target Amount");
			verifyElementPresentAndClick(Stash_SetupYourStashSelectors.btnNext, "Next button");

			extent.extentLoggerPass("Setup Your Stash", "Entered Details of Stash For name and Target Amount  in SetUp Your Stash page");
		}
		else
		{
			extent.extentLoggerFail("Setup Your Stash", "Unable to Enter Details of Stash For name and Target Amount  in SetUp Your Stash page");
		}
	}

	public void modifyStashForField(String stashName) throws Exception {
		extent.HeaderChildNode("Enter Stash For Details");
		logger.info("Setup Your Stash Details");
		waitTime(2000);
		verifyElementPresent(Stash_SetupYourStashSelectors.txtSetupYourStash, "Setup Your Stash text");
		waitTime(2000);
		if(verifyElementPresent(Stash_SetupYourStashSelectors.txtStashFor, "Stash For"))
		{
			Aclick(Stash_SetupYourStashSelectors.edittxtStashFor, "text field");
			type(Stash_SetupYourStashSelectors.edittxtStashFor, stashName, " stash For text Field");
			logger.info("Entered the Stash For Name");
			waitTime(3000);
			hideKeyboard();
			verifyElementPresentAndClick(Stash_SetupYourStashSelectors.btnNext, "Next button");
			extent.extentLoggerPass("Setup Your Stash", "Entered Details of Stash For name in SetUp Your Stash page");
		}
		else
		{
			extent.extentLoggerFail("Setup Your Stash", "Unable to Enter Details of Stash For name in SetUp Your Stash page");
		}


	}

	public void modifyTargetamountField(String stashAmount) throws Exception
	{
		extent.HeaderChildNode("Enter Stash For and Target Amount");
		logger.info("Setup Your Stash Details");
		waitTime(2000);
		if(verifyElementPresent(Stash_SetupYourStashSelectors.txtTargetamount, "Target Amount"))
		{
			Aclick(Stash_SetupYourStashSelectors.edittxtTargetamount, "text field");
			type(Stash_SetupYourStashSelectors.edittxtTargetamount, stashAmount, "target amount Field");
			logger.info("Entered the Target Amount");
			verifyElementPresentAndClick(Stash_SetupYourStashSelectors.btnNext, "Next button");
			extent.extentLoggerPass("Setup Your Stash", "Entered Details of Target Amount in SetUp Your Stash page");
		}
		else
		{
			extent.extentLoggerFail("Setup Your Stash", "Unable to Enter Details of Target Amount in SetUp Your Stash page");
		}
	}
}
