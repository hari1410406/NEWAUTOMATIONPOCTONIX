package com.tonik.testScripts;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.extent.ExtentReporter;
import com.utility.Utilities;

public class TonikTestFlow_SoloStash_AddStash_BackToStash_LeaveItAsIs_CloseLater extends BaseTestCase {
	
	public String tonikAccountBalance;
	public String tonikNewAccountBalance;

	@Test(priority = 0)
	@Parameters({"targetAmount"})
    public void createStash(String targetAmount) throws Exception {
		//welcomePage.RingPayAppLaunch();
		loginPage.performLogin();
		tonikAccountBalance = mainPage.getTonikAccounBalance();
		System.out.println("Balance:"+tonikAccountBalance);
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
	@Parameters({"stashAmount", "AchievedAmount"})
	public void addToStash(String stashAmount,String AchievedAmount) throws Exception {
		// Nithya
		stashHomePage.clickAddToStash();
		stashAddToStashPage.addToStash("500");
		stashConfirmTransferToStashPage.confirmTransferToStash(stashAmount, prop.getproperty("mainAccount"),prop.getproperty("educationStash"),prop.getproperty("ownerStash"));
        stashMoneyStashPage.moneyStashed();
        stashHomePage.verifyStashAchieved(stashAmount, AchievedAmount);
		ExtentReporter.jiraID = "TON-3";
	}
	
	@Test(priority = 2)
	@Parameters({"AddToStashFund","stashAmount","AchievedAmount","AddOrSubstractTonikAmount"})
	public void addToStashAgain(String AddToStashFund,String stashAmount,String AchievedAmount ,String AddOrSubstractTonikAmount) throws Exception {
		// Nithya
		stashHomePage.clickAddToStash();
		stashAddToStashPage.addToStash(AddToStashFund);
		stashConfirmTransferToStashPage.confirmTransferToStash(stashAmount, prop.getproperty("mainAccount"),prop.getproperty("educationStash"),prop.getproperty("ownerStash"));
        stashMoneyStashPage.moneyStashed();
        stashHomePage.verifyStashAchieved(AchievedAmount, AchievedAmount);
        stashHomePage.verifyGoalAchieved();
        basePage.moveToPreviousPage(1);
	    tonikAccountBalance = Utilities.subtractTwoAmount(tonikAccountBalance, AddOrSubstractTonikAmount);
	    System.out.println(tonikAccountBalance);
		mainPage.clickTotalStashBalance();
		ExtentReporter.jiraID = "TON-3";
	}
	
	@Test(priority = 3)
	@Parameters({"AchievedAmount"})
	public void backTostash(String AchievedAmount) throws Exception
	{
		stashHomePage.clickStash();
		stashCongratsGoalAchievedPage.verifyCongratsGoalAchieved(AchievedAmount, AchievedAmount, prop.getproperty("rateofInterest"), prop.getproperty("taxWithholding"));
		stashCongratsGoalAchievedPage.verifynextsteps();
		stashCongratsGoalAchievedPage.clickBackToStash();
		stashAchievedPage.verifyAchievedStashMessage(AchievedAmount, AchievedAmount);
		basePage.moveToPreviousPage(1);
		ExtentReporter.jiraID = "TON-16";
	}
	
	
	@Test(priority = 4)
	@Parameters({"AchievedAmount"})
	public void LeaveItAsIs(String AchievedAmount) throws Exception {
		stashHomePage.clickStash();
		stashCongratsGoalAchievedPage.verifyCongratsGoalAchieved(AchievedAmount, AchievedAmount, prop.getproperty("rateofInterest"), prop.getproperty("taxWithholding"));
		stashCongratsGoalAchievedPage.clickConvertToTimeDeposit();
		stashCongratsGoalAchievedPage.verifyConvertToTimeDeposit();
		stashCongratsGoalAchievedPage.clickLeaveItAsIs();		
		stashAchievedPage.verifyAchievedStashMessage(AchievedAmount, AchievedAmount);
		basePage.moveToPreviousPage(1);
		ExtentReporter.jiraID = "TON-16";
    
	}
    
	@Test(priority = 5)
	@Parameters({"AchievedAmount","AddOrSubstractTonikAmount"})
	public void closeLater(String AchievedAmount, String AddOrSubstractTonikAmount) throws Exception {
		stashHomePage.clickStash();
		stashCongratsGoalAchievedPage.verifyCongratsGoalAchieved(AchievedAmount, AchievedAmount, prop.getproperty("rateofInterest"), prop.getproperty("taxWithholding"));
		stashCongratsGoalAchievedPage.clickConvertToTimeDeposit();
		stashCongratsGoalAchievedPage.clickCloseStash();
		stashYouBrokeTheStashPage.clickLater();
		//stashAchievedPage.getAllWebElements();
		basePage.moveToPreviousPage(2);
		String newBalance = Utilities.addTwoAmount(tonikAccountBalance, AddOrSubstractTonikAmount);
		//System.out.println("Balance:"+newBalance);
		mainPage.verifyTonikAccountBalance(newBalance);
		ExtentReporter.jiraID = "TON-16";
    
	}
}

