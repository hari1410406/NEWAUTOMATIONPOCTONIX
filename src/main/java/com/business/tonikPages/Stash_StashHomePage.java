package com.business.tonikPages;

import com.android.selectors.Stash_StashHomeSelectors;

public class Stash_StashHomePage extends BasePage {

	public Stash_StashHomePage() throws InterruptedException {
		super();
	}

	/**
	 * Verify Add to stash page is loaded successfully
	 * Checking if add to stash is displayed
	 * Checking stash achieved and goal achieved validations are displayed
	 */

	public void clickStartANewStash() throws Exception {
		extent.HeaderChildNode("Click on Start a new stash");
		waitTime(2000);
		if(verifyElementPresent(Stash_StashHomeSelectors.txtStartNewStash, "stashes text"))
		{
			click(Stash_StashHomeSelectors.txtStartNewStash, "Start a new stash");
			extent.extentLoggerPass("Start a new stash", "Clicked on 'Start a new stash' text in main page");
		}
		else
		{
			extent.extentLoggerFail("Start a new stash", "Unable to click on 'Start a new stash' link in stash home page");
		}
	}

	public  void clickManage() throws Exception {
		extent.HeaderChildNode("Click on 'Manage' text");
		waitTime(2000);
		if(verifyElementPresent(Stash_StashHomeSelectors.txtManage, "Manage text"))
		{
			click(Stash_StashHomeSelectors.txtManage, "Manage stash");
			extent.extentLoggerPass("Manage stash", "Clicked on 'Manage' text in stash main page");
		}
		else
		{
			extent.extentLoggerFail("Manage stash", "Unable to click on 'Manage' link in stash home page");
		}
	}

	public void clickAddToStash() throws Exception 
	{
		extent.HeaderChildNode("Click on 'Add to stash' text");
		waitTime(2000);
		if(waitForElementToBePresent(Stash_StashHomeSelectors.txtAddToStash, 120, "'Add to Stash' text"))
		{
			click(Stash_StashHomeSelectors.txtAddToStash,"Click 'Add to Stash' text in stash page");
			logger.info("Adding to stash");
			extent.extentLoggerPass("Add to Stash", "Clicked on 'Add to Stash' text in stash page");
		}
		else 
		{
			logger.info("Not added to stash");
			extent.extentLoggerFail("Not added to Stash", "Not clicked on 'Add to stash' text in stash page");
		}
	}

	//	public void verifyStashAchieved() throws InterruptedException, Exception 
	//	{
	//		extent.HeaderChildNode("Verify 'Achieved' text");	
	//		waitTime(2000);
	//		if(waitForElementToBePresent(Stash_StashHomeSelectors.txtAchieved, 60, "'Achieved' text")) 
	//		{
	//			//verifyElementPresent(Stash_StashHomeSelectors.txtAchieved, "Verify 'Achieved' text in stash page");
	//			logger.info("Achieved");
	//			extent.extentLoggerPass("Achieved", "Verified 'Achieved' text in stash page");
	//		}
	//		else 
	//		{
	//			logger.info("Not achieved");
	//			extent.extentLoggerFail("Achieved", "Not verified 'Achieved' text in stash page");
	//		}
	//	}

	public void verifyStashAchieved(String achievedAmount, String targetAmount) throws InterruptedException, Exception {
		extent.HeaderChildNode("Verify 'Achieved' text");	
		waitTime(5000);
		if(waitForElementToBePresent(Stash_StashHomeSelectors.txtStash, 60, "'Achieved' text"))
		{
			String actualMessage = getText(Stash_StashHomeSelectors.txtAchieved);

			String result = actualMessage.replaceAll("\\s+", " ");
			System.out.println(actualMessage);
			String expectedMessage = "Achieved "+achievedAmount+" of "+targetAmount;
			softAssertion.assertEquals(result, expectedMessage);
			softAssertion.assertAll();

			logger.info("Achieved");
			extent.extentLoggerPass("Achieved", "Verified 'Achieved' text in stash page");
		}
		else 
		{
			logger.info("Not achieved");
			extent.extentLoggerFail("Not Achieved", "Not displayed 'Achieved' text in stash page");
		}
	}

	public void verifyGoalAchieved() throws Exception
	{
		extent.HeaderChildNode("Verify 'Goal achieved' text");
		String actualMessage = getText(Stash_StashHomeSelectors.txtgoalachieved);
		String expectedMessage = "Congrats! Goal achieved!";
		softAssertion.assertEquals(actualMessage, expectedMessage);
		//int color = getColour(Stash_StashHomeSelectors.txtslideBar);
		//System.out.println("slide bar green color "+color);
		softAssertion.assertAll();
		System.out.println("actualMessage: "+actualMessage);
	}

	public void clickStash() throws Exception
	{
		waitTime(2000);
		extent.HeaderChildNode("Click on 'Stash' text");
		if(verifyElementPresent(Stash_StashHomeSelectors.txtStash, "Stash text"))
		{
			click(Stash_StashHomeSelectors.txtStash, "Stash text");
			extent.extentLoggerPass("Stash text ", "Clicked on 'Stash' text in stash main page");
		}
		else
		{
			extent.extentLoggerFail("Stash text not present", "Not clicked on 'stash' text in stash home page");
		}  
	}


	public void clickOnCreatedStash() throws Exception {
		waitTime(6000);
		if(verifyElementPresent(Stash_StashHomeSelectors.txtStartNewStash, "stashes text"))
		{
			waitTime(4000);
			String actualAchieved = getText(Stash_StashHomeSelectors.txtAchieved);
			System.out.println(actualAchieved);
			click(Stash_StashHomeSelectors.txtStash, "Stash name Box");
			//click(Stash_StashHomeSelectors.txtStashName, "click on stash Name Box");
		}
	}

	public void getStashName(String stashName) throws Exception {

		if(verifyElementPresent(Stash_StashHomeSelectors.txtStartNewStash, "stashes text"))
		{
			verifyElementPresent(Stash_StashHomeSelectors.txtStash, "Stash");
			String actualstashName = getText(Stash_StashHomeSelectors.txtStash);
			System.out.println("Stash Name ---> "+actualstashName);
			softAssertion.assertEquals(actualstashName, stashName);
			softAssertion.assertAll();
			verifyElementPresent(Stash_StashHomeSelectors.txtAchieved, "Achieved text and amount");
			String stashAchievedAmount = getText(Stash_StashHomeSelectors.txtAchieved);
			System.out.println(stashName+"----->"+stashAchievedAmount);
		}
	}
	/**
	 * Verify Alert prompt if already Five stashes present
	 * Checking if Five stashes present are displayed
	 * Checking stash achieved and goal achieved validations are displayed
	 */
	public void verifyAlertPromptIfFiveStashesPresent() throws Exception {
		extent.HeaderChildNode("verifying Alert prompt if already Five stashes present");
		waitTime(2000);

		if(verifyElementPresent(Stash_StashHomeSelectors.txtZerooOfFiveAvailablestatshes, "zero of Five stashes text"))
		{
			clickStartANewStash();
			logger.info("Alert Pop-up is displayed");
			String actualAlertMessage = getText(Stash_StashHomeSelectors.txtYouCanCreateOnlyFiveStashes);
			System.out.println(actualAlertMessage);
			String AlertPopupMessage = "Sorry, you can only have 5 actived Stashes created by yourself at the same time. You can close a Stash and create a new one.";
			softAssertion.assertEquals(actualAlertMessage, AlertPopupMessage);
			softAssertion.assertAll();
			waitTime(2000);
			click(Stash_StashHomeSelectors.btnOk, "Done button");
			extent.extentLoggerPass("Alert prompt Pop-up is displayed", "Verified 'Alert Message' text in pop-up  page");
		}
		else 
		{
			logger.info("Not achieved");
			extent.extentLoggerFail("Alert prompt Pop-up is not displayed", "Not verified 'Alert Message' text in pop-up page");
		}
	}
}







