package com.business.tonikPages;

import com.android.selectors.Stash_ReviewStashDetailsSelectors;


public class Stash_ReviewStashDetailsPage extends BasePage{

	public Stash_ReviewStashDetailsPage() throws InterruptedException {
		super();	
	}

	   /**
	    * This method is to verify Details of Stash Name , Stash Amount and click on Create Stash
	    * @throws Exception
	    */
	    public void verifyDetailsAndCreateStash() throws Exception
	    {
	        extent.HeaderChildNode("verify Review Stash details and Click on Create Stash");
	    	waitTime(2000);
	    	if(verifyElementPresent(Stash_ReviewStashDetailsSelectors.txtReviewStashDetails, "Review Stash Details Text"))
	    	{
	    		waitTime(2000);
	    		Swipe("up", 1);
	    		verifyStashAccountDetails("1,000.00", "0.00" ,"TONIK account", "4%");
	    		waitTime(2000);
	    		String enabled_before = getAttributValue("enabled",Stash_ReviewStashDetailsSelectors.btnTickedRadioButton);
	    		System.out.println(enabled_before);
	    		softAssertion.assertEquals("true", enabled_before);

	    		//	click(Stash_ReviewStashDetailsSelectors.btnTickedRadioButton,  " Radio button");
	    		verifyElementPresentAndClick(Stash_ReviewStashDetailsSelectors.btnTickedRadioButton, "Terms and Conditions radio button");
	    		String enabled_after = getAttributValue("enabled",Stash_ReviewStashDetailsSelectors.btnTickedRadioButton);
	    		System.out.println(enabled_after);
	    		softAssertion.assertEquals("false", enabled_after);
	    		extent.extentLoggerPass("Radio Button", "Clicked on Terms and Conditions Radio Button in Review Stash Details page");
	    		waitTime(2000);
	    		verifyElementPresentAndClick(Stash_ReviewStashDetailsSelectors.btnCreateStash, "create stash button");
	    		extent.extentLoggerPass("create stash button", "Clicked on create stash button in Review Stash Details page");
	    		softAssertion.assertAll();
	    	}
	    	else
	    	{
	    		extent.extentLoggerFail("Radio Button", "Clicked on Radio Button in Review Stash Details page");
	    		extent.extentLoggerFail("create stash button", "Clicked on create stash button in Review Stash Details page");
	    	}
	    }


	/**
	 * This method is to Verify Stash Account Details in Review Stash Details Page
	 * @param transferAmount  -- 1,000
	 * @param initialSaving   -- 0.00
	 * @param transferAccount --Tonik account
	 * @param interestRate	  --4%
	 * @throws Exception
	 */
	public void verifyStashAccountDetails(String transferAmount, String initialSaving,String transferAccount, String interestRate) throws Exception 
	{
		extent.HeaderChildNode("Review Stash Details");
		logger.info("Review Stash Details");

		String targetAmountInCurrency = getText(Stash_ReviewStashDetailsSelectors.txtTargetAmountCurreny).substring(1);
		System.out.println(targetAmountInCurrency);
		String initialSavingCurrency = getText(Stash_ReviewStashDetailsSelectors.txtInitialSavingCurreny).substring(1);
		System.out.println(initialSavingCurrency);
		String transferFrom = getText(Stash_ReviewStashDetailsSelectors.txtTransferFromTonikAccount);
		System.out.println(transferFrom);
		String interestRatePercentage = getText(Stash_ReviewStashDetailsSelectors.txtInterestRatePercentage);
		System.out.println(interestRatePercentage);
		softAssertion.assertEquals(transferAmount, targetAmountInCurrency);
		softAssertion.assertEquals(initialSaving, initialSavingCurrency);
		softAssertion.assertEquals(transferAccount, transferFrom);
		softAssertion.assertEquals(interestRate, interestRatePercentage);
		softAssertion.assertAll();
	}
}
