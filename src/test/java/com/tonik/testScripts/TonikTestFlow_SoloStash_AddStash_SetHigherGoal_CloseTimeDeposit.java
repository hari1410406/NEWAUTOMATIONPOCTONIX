package com.tonik.testScripts;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.extent.ExtentReporter;
import com.utility.Utilities;

public class TonikTestFlow_SoloStash_AddStash_SetHigherGoal_CloseTimeDeposit extends BaseTestCase 
{
	@Test(priority = 0)
	@Parameters({"targetAmount"})
    public void createStash(String targetAmount) throws Exception {
		//welcomePage.RingPayAppLaunch();
		loginPage.performLogin();
		mainPage.clickTotalStashBalance();
		// Harish
		stashHomePage.clickStartANewStash(); 
		startNewStaShPage.clickOpenANewStash();
		startNewStaShPage.selectSoloStashType();
		stashSetupPage.enterDetailsIntoSetupYourStash(prop.getproperty("educationStash"),targetAmount); 
		setInitialSavingPage.clickOnSkipForNow();
		reviewStashDetailsPage.verifyDetailsAndCreateStash();
		soloStashCreatedPage.soloStashCreated();
		ExtentReporter.jiraID = "TON-2";
		 	}

	
	  @Test(priority = 1) 
	  @Parameters({"AddToStashFund","stashAmount","AchievedAmount"})
	  public void addToStash(String AddToStashFund,String stashAmount,String AchievedAmount) throws Exception { 
	  // Nithya
	  stashHomePage.clickAddToStash(); 
	  stashAddToStashPage.addToStash(AddToStashFund);
	  stashConfirmTransferToStashPage.confirmTransferToStash(stashAmount,prop.getproperty("mainAccount"),prop.getproperty("educationStash"),prop.getproperty("ownerStash")); 
	  stashMoneyStashPage.moneyStashed();
	  stashHomePage.verifyStashAchieved(stashAmount, AchievedAmount);
	  ExtentReporter.jiraID = "TON-3"; 
	  }
	  
	  @Test(priority = 2) 
	  @Parameters({"AddToStashFund","stashAmount","AchievedAmount"})
	  public void addToStashAgain(String AddToStashFund,String stashAmount,String AchievedAmount) throws Exception { 
	  //Nithya
	  stashHomePage.clickAddToStash();
	  stashAddToStashPage.addToStash(AddToStashFund);
	  stashConfirmTransferToStashPage.confirmTransferToStash(stashAmount,prop.getproperty("mainAccount"),prop.getproperty("educationStash"),prop.getproperty("ownerStash")); 
	  stashMoneyStashPage.moneyStashed();
	  stashHomePage.verifyStashAchieved(AchievedAmount, AchievedAmount);
      stashHomePage.verifyGoalAchieved();
	  ExtentReporter.jiraID = "TON-3"; 
	  }
	  
	  @Test(priority = 3) 
	  @Parameters({"AchievedAmount","modifiedBeforeAmount","lessThanInputAmount","modifiedAfterAmount","AchievedModifiedAmount"})
	  public void setHigherGoal(String AchievedAmount,String modifiedBeforeAmount,String lessThanInputAmount,String modifiedAfterAmount,String AchievedModifiedAmount ) throws Exception {
	  stashHomePage.clickStash();
	  stashCongratsGoalAchievedPage.verifyCongratsGoalAchieved(AchievedAmount,AchievedAmount, prop.getproperty("rateofInterest"),prop.getproperty("taxWithholding"));
	  stashCongratsGoalAchievedPage.verifynextsteps();
	  stashCongratsGoalAchievedPage.clickSetHigherGoal();
	  modifyStashPage.verifyStashNameStashAmount(prop.getproperty("educationStash"), modifiedBeforeAmount);
	  modifyStashPage.modifyStashAmount(modifiedBeforeAmount, lessThanInputAmount);
      modifyStashPage.verifyStashAmountErrorMessage();
	  modifyStashPage.modifyStashAmount(lessThanInputAmount, modifiedAfterAmount);
	  modifyStashPage.clickSaveButton();
	  updatedStashPage.verifyUpdatedStashConfirmationMessage();
	  stashHomePage.verifyStashAchieved(AchievedAmount, AchievedModifiedAmount);
	  ExtentReporter.jiraID = "TON-17";
	  }
	  
	  
	  @Test(priority = 4)
	  @Parameters({"AddToStashFund","stashAmount"})
	  public void addToStashAgainAndAgain (String AddToStashFund,String stashAmount) throws Exception {
	  stashHomePage.clickAddToStash(); 
	  stashAddToStashPage.addToStash(AddToStashFund);
	  stashConfirmTransferToStashPage.confirmTransferToStash(stashAmount,prop.getproperty("mainAccount"),prop.getproperty("educationStash"),prop.getproperty("ownerStash"));
	  stashMoneyStashPage.moneyStashed();
	  ExtentReporter.jiraID = "TON-3";
	  
	  }
	 
    
	@Test(priority = 5)
	@Parameters({"AchievedModifiedAmount","setupTimeDepositAmount"})
	public void closeTimeDeposit(String AchievedModifiedAmount,String setupTimeDepositAmount ) throws Exception {
	stashHomePage.clickStash();
	stashCongratsGoalAchievedPage.verifyCongratsGoalAchieved(AchievedModifiedAmount, AchievedModifiedAmount, prop.getproperty("rateofInterest"), prop.getproperty("taxWithholding"));
	stashCongratsGoalAchievedPage.verifynextsteps();
	stashCongratsGoalAchievedPage.clickConvertToTimeDeposit();
	stashCongratsGoalAchievedPage.clickCloseStash();
	stashYouBrokeTheStashPage.clickStartTimeDeposit();
	stashHowMuchWillYouInvestPage.verifyHowMuchWillYouInvest();
	stashSetupTimeDepositPage.verifySetUpTimeDeposit(setupTimeDepositAmount, prop.getproperty("term"), prop.getproperty("nickName"), prop.getproperty("rateofInterestPA"),"₱151.23", "₱5,151.23" , prop.getproperty("earlyWithdrawal"));
	stashWootWootPage.closePopupDoItLater();
	stashWootWootPage.verifyConfirmationMessage();
	//stashHowMuchWillYouInvestPage.verifyConfirmationMessage(prop.getproperty("Email"));
	ExtentReporter.jiraID = "TON-16";
    
	}
}

