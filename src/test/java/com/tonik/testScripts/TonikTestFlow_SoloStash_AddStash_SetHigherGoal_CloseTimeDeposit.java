package com.tonik.testScripts;

import org.testng.annotations.Test;
import com.extent.ExtentReporter;
import com.utility.Utilities;

public class TonikTestFlow_SoloStash_AddStash_SetHigherGoal_CloseTimeDeposit extends BaseTestCase 
{
	@Test(priority = 0)
    public void createStash() throws Exception {
		//welcomePage.RingPayAppLaunch();
		loginPage.performLogin();
		mainPage.clickTotalStashBalance();
		// Harish
		stashHomePage.clickStartANewStash(); 
		startNewStaShPage.clickOpenANewStash();
		startNewStaShPage.selectSoloStashType();
		stashSetupPage.enterDetailsIntoSetupYourStash(prop.getproperty("educationStash"),"1000"); 
		setInitialSavingPage.clickOnSkipForNow();
		reviewStashDetailsPage.verifyDetailsAndCreateStash();
		soloStashCreatedPage.soloStashCreated();
		ExtentReporter.jiraID = "TON-2";
		 	}

	
	  @Test(priority = 1) 
	  public void addToStash() throws Exception { 
	  // Nithya
	  stashHomePage.clickAddToStash(); 
	  stashAddToStashPage.addToStash("500");
	  stashConfirmTransferToStashPage.confirmTransferToStash("₱500.00",prop.getproperty("mainAccount"),prop.getproperty("educationStash"),prop.getproperty("ownerStash")); 
	  stashMoneyStashPage.moneyStashed();
	  stashHomePage.verifyStashAchieved("₱500.00", "₱1,000.00");
	  ExtentReporter.jiraID = "TON-3"; 
	  }
	  
	  @Test(priority = 2) 
	  public void addToStashAgain() throws Exception { 
	  //Nithya
	  stashHomePage.clickAddToStash();
	  stashAddToStashPage.addToStash("500");
	  stashConfirmTransferToStashPage.confirmTransferToStash("₱500.00",prop.getproperty("mainAccount"),prop.getproperty("educationStash"),prop.getproperty("ownerStash")); 
	  stashMoneyStashPage.moneyStashed();
	  stashHomePage.verifyStashAchieved("₱1,000.00", "₱1,000.00");
      stashHomePage.verifyGoalAchieved();
	  ExtentReporter.jiraID = "TON-3"; 
	  }
	  
	  @Test(priority = 3) 
	  public void setHigherGoal() throws Exception {
	  stashHomePage.clickStash();
	  stashCongratsGoalAchievedPage.verifyCongratsGoalAchieved("₱1,000.00","₱1,000.00", prop.getproperty("rateofInterest"),prop.getproperty("taxWithholding"));
	  stashCongratsGoalAchievedPage.verifynextsteps();
	  stashCongratsGoalAchievedPage.clickSetHigherGoal();
	  modifyStashPage.verifyStashNameStashAmount(prop.getproperty("educationStash"), "1,000.00");
	  modifyStashPage.modifyStashAmount("1,000.00", "900");
      modifyStashPage.verifyStashAmountErrorMessage();
	  modifyStashPage.modifyStashAmount("900", "1500");
	  modifyStashPage.clickSaveButton();
	  updatedStashPage.verifyUpdatedStashConfirmationMessage();
	  stashHomePage.verifyStashAchieved("₱1,000.00", "₱1,500.00");
	  ExtentReporter.jiraID = "TON-17";
	  }
	  
	  
	  @Test(priority = 4)
	  public void addToStashAgainAndAgain () throws Exception {
	  stashHomePage.clickAddToStash(); 
	  stashAddToStashPage.addToStash("500");
	  stashConfirmTransferToStashPage.confirmTransferToStash("₱500.00",prop.getproperty("mainAccount"),prop.getproperty("educationStash"),prop.getproperty("ownerStash"));
	  stashMoneyStashPage.moneyStashed();
	  ExtentReporter.jiraID = "TON-3";
	  
	  }
	 
    
	@Test(priority = 5)
	public void closeTimeDeposit() throws Exception {
	stashHomePage.clickStash();
	stashCongratsGoalAchievedPage.verifyCongratsGoalAchieved("₱1,500.00", "₱1,500.00", prop.getproperty("rateofInterest"), prop.getproperty("taxWithholding"));
	stashCongratsGoalAchievedPage.verifynextsteps();
	stashCongratsGoalAchievedPage.clickConvertToTimeDeposit();
	stashCongratsGoalAchievedPage.clickCloseStash();
	stashYouBrokeTheStashPage.clickStartTimeDeposit();
	stashHowMuchWillYouInvestPage.verifyHowMuchWillYouInvest();
	stashSetupTimeDepositPage.verifySetUpTimeDeposit("₱5,000", prop.getproperty("term"), prop.getproperty("nickName"), prop.getproperty("rateofInterestPA"),"₱148.77", "₱5,148.77" , prop.getproperty("earlyWithdrawal"));
	stashWootWootPage.closePopupDoItLater();
	stashWootWootPage.verifyConfirmationMessage();
	//stashHowMuchWillYouInvestPage.verifyConfirmationMessage(prop.getproperty("Email"));
	ExtentReporter.jiraID = "TON-16";
    
	}
}

