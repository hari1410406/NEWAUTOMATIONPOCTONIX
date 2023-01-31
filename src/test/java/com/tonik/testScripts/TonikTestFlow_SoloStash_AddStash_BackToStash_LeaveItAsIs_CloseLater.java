package com.tonik.testScripts;

import org.testng.annotations.Test;
import com.extent.ExtentReporter;
import com.utility.Utilities;

public class TonikTestFlow_SoloStash_AddStash_BackToStash_LeaveItAsIs_CloseLater extends BaseTestCase {
	
	public String tonikAccountBalance;
	public String tonikNewAccountBalance;

	@Test(priority = 0)
    public void createStash() throws Exception {
		//welcomePage.RingPayAppLaunch();
		loginPage.performLogin();
		tonikAccountBalance = mainPage.getTonikAccounBalance();
		System.out.println("Balance:"+tonikAccountBalance);
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
		stashConfirmTransferToStashPage.confirmTransferToStash("₱500.00", prop.getproperty("mainAccount"),prop.getproperty("educationStash"),prop.getproperty("ownerStash"));
        stashMoneyStashPage.moneyStashed();
        stashHomePage.verifyStashAchieved("₱500.00", "₱1,000.00");
		ExtentReporter.jiraID = "TON-3";
	}
	
	@Test(priority = 2)
	public void addToStashAgain() throws Exception {
		// Nithya
		stashHomePage.clickAddToStash();
		stashAddToStashPage.addToStash("500");
		stashConfirmTransferToStashPage.confirmTransferToStash("₱500.00", prop.getproperty("mainAccount"),prop.getproperty("educationStash"),prop.getproperty("ownerStash"));
        stashMoneyStashPage.moneyStashed();
        stashHomePage.verifyStashAchieved("₱1,000.00", "₱1,000.00");
        stashHomePage.verifyGoalAchieved();
        basePage.moveToPreviousPage(1);
	    tonikAccountBalance = Utilities.subtractTwoAmount(tonikAccountBalance, "1000.00");
	    System.out.println(tonikAccountBalance);
		mainPage.clickTotalStashBalance();
		ExtentReporter.jiraID = "TON-3";
	}
	
	@Test(priority = 3)
	public void backTostash() throws Exception
	{
		stashHomePage.clickStash();
		stashCongratsGoalAchievedPage.verifyCongratsGoalAchieved("₱1,000.00", "₱1,000.00", prop.getproperty("rateofInterest"), prop.getproperty("taxWithholding"));
		stashCongratsGoalAchievedPage.verifynextsteps();
		stashCongratsGoalAchievedPage.clickBackToStash();
		stashAchievedPage.verifyAchievedStashMessage("₱1,000.00", "₱1,000.00");
		basePage.moveToPreviousPage(1);
		ExtentReporter.jiraID = "TON-16";
	}
	
	
	@Test(priority = 4)
	public void LeaveItAsIs() throws Exception {
		stashHomePage.clickStash();
		stashCongratsGoalAchievedPage.verifyCongratsGoalAchieved("₱1,000.00", "₱1,000.00", prop.getproperty("rateofInterest"), prop.getproperty("taxWithholding"));
		stashCongratsGoalAchievedPage.clickConvertToTimeDeposit();
		stashCongratsGoalAchievedPage.verifyConvertToTimeDeposit();
		stashCongratsGoalAchievedPage.clickLeaveItAsIs();		
		stashAchievedPage.verifyAchievedStashMessage("₱1,000.00", "₱1,000.00");
		basePage.moveToPreviousPage(1);
		ExtentReporter.jiraID = "TON-16";
    
	}
    
	@Test(priority = 5)
	public void closeLater() throws Exception {
		stashHomePage.clickStash();
		stashCongratsGoalAchievedPage.verifyCongratsGoalAchieved("₱1,000.00", "₱1,000.00", prop.getproperty("rateofInterest"), prop.getproperty("taxWithholding"));
		stashCongratsGoalAchievedPage.clickConvertToTimeDeposit();
		stashCongratsGoalAchievedPage.clickCloseStash();
		stashYouBrokeTheStashPage.clickLater();
		//stashAchievedPage.getAllWebElements();
		basePage.moveToPreviousPage(2);
		String newBalance = Utilities.addTwoAmount(tonikAccountBalance, "1000.00");
		//System.out.println("Balance:"+newBalance);
		mainPage.verifyTonikAccountBalance(newBalance);
		ExtentReporter.jiraID = "TON-16";
    
	}
}

