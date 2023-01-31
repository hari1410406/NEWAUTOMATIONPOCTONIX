package com.business.tonikPages;

import com.android.selectors.Stash_AchievedSelectors;

public class Stash_AchievedPage extends BasePage
{
	public Stash_AchievedPage() throws InterruptedException
	{
        super();
    }

	    /**
	     * Verify congrats goal achieved page is loaded successfully
	     * Checking if page title as congrats goal achieved is displayed
	     *
	     */
	public void verifyAchievedStashMessage(String achievedAmount, String targetAmount) throws Exception {
		//extent.HeaderChildNode("Balance text verification");
		    if(waitForElementToBePresent(Stash_AchievedSelectors.txtStashName, 10, "Achieved text message")) 
		    {
			String actualachievedAmount= getText(Stash_AchievedSelectors.txtAchieved);
			String expectedachievedAmount = "Achieved "+achievedAmount;
			softAssertion.assertEquals(actualachievedAmount, expectedachievedAmount);
			System.out.println(actualachievedAmount);
			
			String actualtargetAmount= getText(Stash_AchievedSelectors.txtTarget);
			String expectedtargetAmount = " of "+targetAmount;
			softAssertion.assertEquals(actualtargetAmount, expectedtargetAmount);
			System.out.println(actualtargetAmount);
			softAssertion.assertAll();
			Thread.sleep(3000);
			extent.extentLoggerPass("Achieved text ", "Displayed 'Achieved' text");
		} 
		    else
		    {
			extent.extentLoggerFail("Achieved text ", "Not Displayed 'Achieved' text");
		    }
	}

}