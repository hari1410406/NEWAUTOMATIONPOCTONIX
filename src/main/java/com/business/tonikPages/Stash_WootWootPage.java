package com.business.tonikPages;

import com.android.selectors.Stash_WootWootSelectors;

public class Stash_WootWootPage extends BasePage {
		
		public Stash_WootWootPage() throws InterruptedException {
	        super();
		}
		
		public void closePopupDoItLater() throws Exception
		{
			extent.HeaderChildNode("Popup do it later");

			if(ifElementPresent(Stash_WootWootSelectors.txtDoItLater, "Popup do it later"))
			{
				waitForElementAndClickIfPresent(Stash_WootWootSelectors.txtDoItLater, 20,"Click Popup do it later");
			}
		}

		public void verifyConfirmationMessage() throws Exception {
			
		if(waitForElementToBePresent(Stash_WootWootSelectors.txtWootWoot, 60, "Woot Woot text"))
        {
            String actualMessage = getText(Stash_WootWootSelectors.txtConfirmationMessage);
			String expectedMessage = "Your Time Deposit has been created. We’ll send your Tonik TD Certificate within 24 hours.";
			softAssertion.assertEquals(actualMessage, expectedMessage);
			softAssertion.assertAll();
			System.out.println("===> actualMessage: "+actualMessage);
			logger.info("Woot Woot Page");
            extent.extentLoggerPass("Woot Woot", "Displayed 'Woot Woot' page");
        }
        else 
        {
        	logger.info("Woot Woot page is not displayed");
            extent.extentLoggerFail("Woot Woot", "Not displayed 'Woot Woot ' page");
        
    }	
}
}