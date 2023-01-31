package com.business.tonikPages;

import com.android.selectors.Stash_HowMuchWillYouInvestSelectors;

public class Stash_HowMuchWillYouInvestPage extends BasePage {
	
	public Stash_HowMuchWillYouInvestPage() throws InterruptedException {
		super();
	}
	/**
	 * This Business Method is for confirmation of the Updated Stash Details 
	 * @return 
	 * @throws Exception
	 */

	public void verifyHowMuchWillYouInvest() throws InterruptedException, Exception
	   {    
		    Thread.sleep(20000);
	    	if(waitForElementToBePresent(Stash_HowMuchWillYouInvestSelectors.txtHowMuchWillYouInvest, 60, "How much will you invest text"))
	        {
	         
	            click(Stash_HowMuchWillYouInvestSelectors.btnIAmInterested, "Click button I am interested");
	            Thread.sleep(10000);
	            logger.info("Clicked on button I am interested");
	            extent.extentLoggerPass("I am interested", "Clicked 'button I am interested'");
	        }
	        else 
	        {
	        	logger.info("Did not click on button I am interested");
	            extent.extentLoggerFail("I am interested", "Not clicked 'button I am interested'");
	        
	    }	
	   }	
	
	  public void verifyConfirmationMessage(String mailid) throws InterruptedException, Exception
	   {
		    extent.HeaderChildNode("Withdrawal Confirmation: Confirmation message verification");

			String actualMessage = getText(Stash_HowMuchWillYouInvestSelectors.txtVerificationLink);
			String actualFormattedMessage = actualMessage.replaceAll("\\s+", " ");
			String expectedMessage = "A verification link will be sent to "+mailid+". Do you want to verify now? If it were me, every OTP will start with 1 4 3";                                           
			softAssertion.assertEquals(actualFormattedMessage, expectedMessage);
			softAssertion.assertAll();
			System.out.println(actualFormattedMessage);
		}
	   
}
