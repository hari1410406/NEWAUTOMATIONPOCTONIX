package com.business.tonikPages;

import com.android.selectors.Stash_CongratsGoalAchievedSelectors;
import com.android.selectors.Stash_MoneyStashSelectors;

public class Stash_CongratsGoalAchievedPage extends BasePage
{
	public Stash_CongratsGoalAchievedPage() throws InterruptedException {
        super();
    }

	    /**
	     * Verify congrats goal achieved page is loaded successfully
	     * Checking if page title as congrats goal achieved is displayed
	     *
	     */

	    public void verifyCongratsGoalAchieved(String targetAmount, String stashBalance, String interestRate, String withholdingTax) throws Exception 
	    {
	        extent.HeaderChildNode("Review congrats goal achieved");
	        
	        if(ifElementPresent(Stash_MoneyStashSelectors.txtDoItLater, "Popup Do It Later is displayed"))
	        {
	            waitForElementAndClickIfPresent(Stash_MoneyStashSelectors.txtDoItLater, 20,"Click on Popup Do It Later is displayed");
	        }
	        
	        if(waitForElementToBePresent(Stash_CongratsGoalAchievedSelectors.txtCongratsGoalAchieved,60, "Congrats goal achieved text"))
	        {
		        String actualtargetAmount = getText(Stash_CongratsGoalAchievedSelectors.txtTargetAmount);
				String actualstashBalance = getText(Stash_CongratsGoalAchievedSelectors.txtStashBalance);
				dateComparisonWithoutTime();
				String actualstartingDate = getText(Stash_CongratsGoalAchievedSelectors.txtStartingDate);
				String actualinterestRate = getText(Stash_CongratsGoalAchievedSelectors.txtInterestRate);
				String actualwithholdingTax = getText(Stash_CongratsGoalAchievedSelectors.txtWithholdingTax);
				
				softAssertion.assertEquals(targetAmount, actualtargetAmount);
				System.out.println(actualtargetAmount);
				softAssertion.assertEquals(stashBalance, actualstashBalance);
				System.out.println(actualstashBalance);
				softAssertion.assertEquals(formattedDate, actualstartingDate);
				System.out.println(actualstartingDate);
				softAssertion.assertEquals(interestRate, actualinterestRate);
				System.out.println(actualinterestRate);
				softAssertion.assertEquals(withholdingTax, actualwithholdingTax);
				System.out.println(actualwithholdingTax);
				softAssertion.assertAll();
				
		        waitForElementAndClickIfPresent(Stash_CongratsGoalAchievedSelectors.btnWhatsYourNextStep, 20,"Click what's your next step");
		        
		        logger.info("Clicked on button what's your next step");
		        extent.extentLoggerPass("what's your next step", "Displayed 'what's your next step'");
	        }
	        else 
	        {
	        	logger.info("Did not click on button what's your next step");
	            extent.extentLoggerFail("what's your next step", "Not displayed 'what's your next step'");
	        
	        }
         }
	    
	    public void verifynextsteps() throws Exception 
	    {
	    	
	    	if(waitForElementToBePresent(Stash_CongratsGoalAchievedSelectors.txtNextStep, 60, "what's your next step text"))
	        {
	  
	            logger.info("what's your next step text");
	            extent.extentLoggerPass("what's your next step", "Displayed 'what's your next step' text");
	        }
	        else 
	        {
	        	logger.info("what's your next step text is not displayed");
	            extent.extentLoggerFail("what's your next step", "Not displayed 'what's your next step' text");
	        
	    }
	    	if(waitForElementToBePresent(Stash_CongratsGoalAchievedSelectors.txtTimeDeposit, 60, "Convert to time deposit text"))
	        {
	            logger.info("Convert to time deposit");
	            extent.extentLoggerPass("Convert to time deposit", "Displayed 'Convert to time deposit' text");
	        }
	        else 
	        {
	        	logger.info("Convert to time deposit is not displayed");
	            extent.extentLoggerFail("Convert to time deposit", "Not displayed 'Convert to time deposit");
	        
	    }
	    	if(waitForElementToBePresent(Stash_CongratsGoalAchievedSelectors.txtHigherGoal, 60, "Set higher goal text"))
	        {
	            logger.info("Set higher goal");
	            extent.extentLoggerPass("Set higher goal", "Displayed 'Set higher goal' text");
	        }
	        else 
	        {
	        	logger.info("Set higher goal is not displayed");
	            extent.extentLoggerFail("Set higher goal", "Not displayed 'Set higher goal");
	        
	    }
	    	if(waitForElementToBePresent(Stash_CongratsGoalAchievedSelectors.txtBackToStash, 60, "Back to stash text"))
	        {
	   
	            logger.info("Back to stash");
	            extent.extentLoggerPass("Back to stash", "Displayed 'Back to stash' text");
	        }
	        else 
	        {
	        	logger.info("Back to stash is not displayed");
	            extent.extentLoggerFail("Back to stash", "Not displayed 'Back to stash' text");
	        
	    }
	    }
	            
	    
	    public void clickConvertToTimeDeposit() throws Exception
	    {
	    	if(waitForElementToBePresent(Stash_CongratsGoalAchievedSelectors.txtTimeDeposit, 60, "Convert to time deposit text"))
	        {
	            click(Stash_CongratsGoalAchievedSelectors.txtTimeDeposit, "Click Convert to time deposit");
	            logger.info("Clicked on Convert to time deposit");
	            extent.extentLoggerPass("Convert to time deposit", "Clicked on 'Convert to time deposit'text");
	        }
	        else 
	        {
	        	logger.info("Did not click on Convert to time deposit");
	            extent.extentLoggerFail("Convert to time deposit", "Not clicked on 'Convert to time deposit'text");
	        
	    }
	    }
	    
	    public void clickSetHigherGoal() throws InterruptedException, Exception
	    {

	    	if(waitForElementToBePresent(Stash_CongratsGoalAchievedSelectors.txtHigherGoal, 60, "Set higher goal"))
	        {
	            //waitForElementToBePresent(Stash_MoneyStashSelectors.btnDone, 60, "Money Stashed");
	            click(Stash_CongratsGoalAchievedSelectors.txtHigherGoal, "Click Set higher goal text");
	            logger.info("Set higher goal");
	            extent.extentLoggerPass("Set higher goal", "Clicked on 'Set higher goal' text");
	        }
	        else 
	        {
	        	logger.info("Set higher goal is not displayed");
	            extent.extentLoggerFail("Set higher goal", "Not clicked on 'Set higher goal'text");
	        
	    }
	    }
	    
	    public void clickBackToStash() throws InterruptedException, Exception
	    {

	    	if(waitForElementToBePresent(Stash_CongratsGoalAchievedSelectors.txtBackToStash, 60, "Back to stash text"))
	        {
	
	            click(Stash_CongratsGoalAchievedSelectors.txtBackToStash, "Click Back to stash");
	            logger.info("Back to stash");
	            extent.extentLoggerPass("Confirm Back to stash", "Clicked on 'Back to stash' text");
	        }
	        else 
	        {
	        	logger.info("Back to stash not displayed");
	            extent.extentLoggerFail("Back to stash", "Not clicked on 'Back to stash' text");
	        
	    }	
	    }
	    
	    public void verifyConvertToTimeDeposit() throws InterruptedException
		   {
	    	if(waitForElementToBePresent(Stash_CongratsGoalAchievedSelectors.txtCloseStash, 60, "Close stash text"))
	        {  	    		
	    		logger.info("Close stash");
	            extent.extentLoggerPass("Close stash", "Clicked on 'Close stash' text");
	        }
	        else 
	        {
	        	logger.info("Close stash not displayed");
	            extent.extentLoggerFail("Close stash", "Not clicked 'Close stash' text");	
	        }
	    	
	    	if(waitForElementToBePresent(Stash_CongratsGoalAchievedSelectors.txtLeaveItAsIs, 60, "Leave It As Is text"))
	        {	    		
	            logger.info("Leave It As Is");
	            extent.extentLoggerPass("Leave It As Is", "Clicked on 'Leave It As Is' text");
	        }
	        else 
	        {
	        	logger.info("Leave It As Is not displayed");
	            extent.extentLoggerFail("Leave It As Is", "Not clicked on 'Leave It As Is' text");
	        
	    }
		   }
	    
	    public void clickLeaveItAsIs() throws InterruptedException, Exception
	   {
	    	if(waitForElementToBePresent(Stash_CongratsGoalAchievedSelectors.txtLeaveItAsIs, 60, "Leave It As Is text"))
	        {
	            click(Stash_CongratsGoalAchievedSelectors.txtLeaveItAsIs, "Click Leave It As Is");
	            logger.info("Leave It As Is");
	            extent.extentLoggerPass("Leave It As Is", "Clicked on 'Leave It As Is' text");
	        }
	        else 
	        {
	        	logger.info("Leave It As Is not displayed");
	            extent.extentLoggerFail("Leave It As Is", "Not clicked on 'Leave It As Is' text");
	        
	    }	  
	   }
	    
	    public void clickCloseStash() throws InterruptedException, Exception
		   {
		    	if(waitForElementToBePresent(Stash_CongratsGoalAchievedSelectors.txtCloseStash, 60, "Close stash text"))
		        {
		            //waitForElementToBePresent(Stash_MoneyStashSelectors.btnDone, 60, "Money Stashed");
		            click(Stash_CongratsGoalAchievedSelectors.txtCloseStash, "Click Close stash");
		            logger.info("Close stash");
		            extent.extentLoggerPass("Confirm Close stash", "Clicked on 'Close stash' text");
		        }
		        else 
		        {
		        	logger.info("Did not click on Close stash");
		            extent.extentLoggerFail("Close stash", "Not clicked on 'Close stash' text");
		        
		    }	
		   }	
}
