package com.business.tonikPages;

import com.android.selectors.Stash_MoneyStashSelectors;

public class Stash_MoneyStashPage extends BasePage 
{
	public String actualWhentime =null;

	public Stash_MoneyStashPage() throws InterruptedException {
		super();
	}

	/**
	 * Verify Money stash page is loaded successfully
	 * Checking if Money Stash text is displayed
	 * @return 
	 *
	 */

	public boolean closePopupDoItLater() throws Exception
	{
		extent.HeaderChildNode("Money Stashed");

		if(ifElementPresent(Stash_MoneyStashSelectors.txtDoItLater, "Money Stashed"))
		{
			waitForElementAndClickIfPresent(Stash_MoneyStashSelectors.txtDoItLater, 20,"Click Done");
		}
		return true;
	}

	public void moneyStashed() throws Exception
	{
		if(this.closePopupDoItLater())
		{
			logger.info("Popup Do It Later is displayed");
		}
		if(waitForElementToBePresent(Stash_MoneyStashSelectors.txtMoneyStashed, 60, "Money stashed text"))
		{
			// waitForElementAndClickIfPresent(Stash_MoneyStashSelectors.btnDone, 20,"Click Done");
			clickOnDoneButton();
			logger.info("Confirming money stashed");
			extent.extentLoggerPass("Confirm money stashed", "Clicked on 'Done' button in money stashed page");
		}
		else 
		{
			logger.info("Money not stashed");
			extent.extentLoggerFail("Money not stashed", "Not clicked on 'Done' button in money stashed page");

		}

	}

	public void clickViewDetailsText() throws Exception {

		extent.HeaderChildNode("click on View Details text");
		if(this.closePopupDoItLater())
		{
			logger.info("Popup Do It Later is displayed");
		}
		if(verifyElementPresent(Stash_MoneyStashSelectors.txtViewDetailsOFHowWeMoved, "view Details Of How We moved text"))
		{

			Aclick(Stash_MoneyStashSelectors.txtViewDetailsOFHowWeMoved, "view Details Of How We moved");
			verifyTranscationdetails("₱500.00","Education","My Tonik Account");

			extent.extentLoggerPass("view Details Of How We moved", "Clicked on view Details Of How We moved link in money stashed page");
		}
		else 
		{
			logger.info("Money not stashed");
			extent.extentLoggerFail("view Details Of How We moved", "Not clicked on view Details Of How We moved link in money stashed page");
		}
	}


	public void clickOnDoneButton() throws InterruptedException, Exception {
		if(waitForElementToBePresent(Stash_MoneyStashSelectors.btnDone,60, "Done button")) {
			click(Stash_MoneyStashSelectors.btnDone, "Done button");
		} else {
			extent.extentLoggerFail("Done button ('Money Stash')", "Unable to click on 'Done' button");
		}
	}

	public boolean verifyTransactionDetailsHeader() throws InterruptedException {
		extent.HeaderChildNode("Page loaded verification -Transcation Details header of the Stash");
		waitTime(2000);
		if(waitForElementToBePresent(Stash_MoneyStashSelectors.txtTransactionDetails, 60,"Transcation Details text"))
		{
			extent.extentLoggerPass("Page loaded ('Transcation Details')", "'Transcation Details' page loaded successfully");
			return true;
		}
		else
		{
			extent.extentLoggerFail("Page not loaded ('Transcation Details')", "'Transcation Details' page loaded successfully");
			return false;
		}	
	}

	public void verifyTranscationdetails(String transactionAmount,String stashName,String fromAccount) throws Exception {
		extent.HeaderChildNode("Transcation Details of the stash");
		String actualAmount = getText(Stash_MoneyStashSelectors.txtAmount);
		System.out.println("Amount -->"+actualAmount);
		String actualToStashName = getText(Stash_MoneyStashSelectors.txtTo);
		System.out.println("stash Name -->"+actualToStashName);
		String actualFromAccount = getText(Stash_MoneyStashSelectors.txtFrom);
		System.out.println("From -->"+actualFromAccount);
		dateComparisonWithoutTime();
		actualWhentime = getText(Stash_MoneyStashSelectors.txtWhen).replace(",","").substring(0, 11);
		System.out.println("When -->"+actualWhentime);
		String actualRefNumber = getText(Stash_MoneyStashSelectors.txtRefNumber);
		System.out.println("Ref Number -->"+actualRefNumber);
		softAssertion.assertEquals(transactionAmount, actualAmount);
		softAssertion.assertEquals(stashName, actualToStashName);
		softAssertion.assertEquals(fromAccount, actualFromAccount);
		softAssertion.assertEquals(formattedDate, actualWhentime);
		moveToPreviousPage(1);
		softAssertion.assertAll();  	
	}
}


