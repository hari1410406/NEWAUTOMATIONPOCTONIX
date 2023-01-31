package com.business.tonikPages;

import com.android.selectors.Stash_YouBrokeTheStashSelectors;

public class Stash_YouBrokeTheStashPage extends BasePage {

	public Stash_YouBrokeTheStashPage() throws InterruptedException {
		super();
	}
	/**
	 * This Business Method is for confirmation of the Updated Stash Details 
	 * @return 
	 * @throws Exception
	 */
	
	public boolean verifyPageLoaded() throws InterruptedException, Exception
	   {
		
		waitTime(2000);
		if(waitForElementToBePresent(Stash_YouBrokeTheStashSelectors.txtYouBrokeTheStash, 60,"You broke the stash text"))
		{
			extent.extentLoggerPass("Page loaded ('You broke the stash')", "'You broke the stash' page loaded successfully");
			return true;
		}
		else
		{
			extent.extentLoggerFail("Page not loaded ('You broke the stash')", "'You broke the stash' page not loaded successfully");
			return false;
		}
	}
	
	public void clickLater() throws InterruptedException, Exception
	   {
		   
		    if(this.verifyPageLoaded()) {
	    	waitForElementToBePresent(Stash_YouBrokeTheStashSelectors.txtLater, 60, "Click later text");
	        click(Stash_YouBrokeTheStashSelectors.txtLater, "Click Click later");
	        logger.info("Click later");
	        extent.extentLoggerPass("Click later", "Clicked on 'Click later' text");
	        }
	        else 
	        {
	        	logger.info("Click later not displayed");
	            extent.extentLoggerFail("Click later", "Not clicked on 'Click later' text");
	        
	    }	  
	   }
	
	public void clickStartTimeDeposit() throws InterruptedException, Exception{
		
		    Thread.sleep(9000);
	        if(this.verifyPageLoaded()) {
	    	waitForElementToBePresent(Stash_YouBrokeTheStashSelectors.btnStartTimeDeposit, 60, "start time deposit");
	        click(Stash_YouBrokeTheStashSelectors.btnStartTimeDeposit, "Click start time deposit");
	        logger.info("Clicked on Start time deposit");
	        extent.extentLoggerPass("start time deposit", "Clicked on 'start time deposit' text");
	        }
	        else 
	        {
	        	logger.info("Did not click on start time deposit");
	            extent.extentLoggerFail("start time deposit", "Not clicked on 'start time deposit' text");
	        
	    }	  
	   }
	    
}
