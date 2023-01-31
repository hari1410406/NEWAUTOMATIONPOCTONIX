package com.business.tonikPages;

import com.android.selectors.Stash_StashDetailsSelectors;

public class Stash_StashDetailsPage extends BasePage
{

  public String actualStartingDate=null;

  public Stash_StashDetailsPage() throws InterruptedException 
  {
		super();
  }
	/**
	 * This Business Method is to verify Stash Details header
	 * @throws Exception
	 */
	public void VerifystashDetailsHeader() throws Exception {
		extent.HeaderChildNode("Page loaded verification: Stash Details text");

		waitTime(2000);
		if(verifyElementPresent(Stash_StashDetailsSelectors.txtStashDetailsHeader, "Stash Details  text"))
		{
			extent.extentLoggerPass("Page loaded ('Stash Details ')", "'Stash Details ' page loaded successfully");
		}
		else
		{
			extent.extentLoggerFail("Page not loaded ('Stash Details ')", "'Stash Details ' page loaded successfully");
		}
	}

	/**
	 *  This Business Method to verify stash details
	 * @param targetAmount
	 * @throws Exception
	 */
	public void stashDetails(String targetAmount) throws Exception {
		extent.HeaderChildNode("stash Details");
		String actualstashID = getText(Stash_StashDetailsSelectors.txtStashID);
		System.out.println("Stash ID --->"+actualstashID);
		dateComparisonWithoutTime();
		actualStartingDate= getText(Stash_StashDetailsSelectors.txtStartingDate);
		System.out.println("Starting Date -->"+actualStartingDate);
		softAssertion.assertEquals(formattedDate, actualStartingDate);
		String actualTargetAmount = getText(Stash_StashDetailsSelectors.txtTargetAmount);
		System.out.println("Target Amount -->"+actualTargetAmount);
		softAssertion.assertEquals(targetAmount, actualTargetAmount);
		moveToPreviousPage(1);
		softAssertion.assertAll();
	}
	
}
