package com.business.tonikPages;

import com.android.selectors.Stash_ConfirmTransferToStashSelectors;
import com.android.selectors.Stash_ReviewWithdrawalSelectors;
import com.android.selectors.Stash_WithdrawConfirmationSelectors;

public class Stash_ConfirmTransferToStashPage extends BasePage
{

	public Stash_ConfirmTransferToStashPage() throws InterruptedException {
        super();
    }

	    /**
	     * Verify Confirm transfer to stash page is loaded successfully
	     * Checking if page title as confirm transfer to stash is displayed
	     *
	     */

	    public void confirmTransferToStash(String editAmount, String fromAccount, String stashType, String stashOwner) throws Exception 
	    {
	        extent.HeaderChildNode("Confirm transfer to stash");
	        
	        if(waitForElementToBePresent(Stash_ConfirmTransferToStashSelectors.txtConfirmTransferToStash,60, "Confirm transfer to stash text"))
	        {
		        String actualeditAmount = getText(Stash_ConfirmTransferToStashSelectors.txtAmount);
				String actualfromAccount = getText(Stash_ConfirmTransferToStashSelectors.txtFrom);
				String actualtoStashType = getText(Stash_ConfirmTransferToStashSelectors.txtTo);
				String actualstashOwner = getText(Stash_ConfirmTransferToStashSelectors.txtStashOwner);
				softAssertion.assertEquals(editAmount, actualeditAmount);
				System.out.println(actualeditAmount);
				softAssertion.assertEquals(fromAccount, actualfromAccount);
				System.out.println(actualfromAccount);
				softAssertion.assertEquals(stashType, actualtoStashType);
				System.out.println(actualtoStashType);
				softAssertion.assertEquals(stashOwner, actualstashOwner);
				System.out.println(actualstashOwner);
				softAssertion.assertAll();
				
		        //if(ifElementPresent(Stash_ConfirmTransferToStashSelectors.btnConfirm, "Confirm transfer to stash")) {
		        waitForElementAndClickIfPresent(Stash_ConfirmTransferToStashSelectors.btnConfirm, 20,"Click confirm transfer to stash");
		        logger.info("Clicked on confirm transfer to stash");
		        extent.extentLoggerPass("Confirm", "Clicked on 'Confirm' in confirm transfer to stash page");
	        }
	        else 
	        {
	        	logger.info("Not clicked on confirm transfer to stash");
	            extent.extentLoggerFail("Confirm", "Not clicked on 'Confirm' in confirm transfer to stash page");
	        
	        }
         }
}