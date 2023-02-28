package com.tonik.testScripts;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.extent.ExtentReporter;
import com.utility.Utilities;

public class TonikTestFlow_SoloStash_AddStash_Withdraw_CloseStash extends BaseTestCase {

	public String tonikAccountBalance;
	public String tonikNewAccountBalance;

	@Test(priority = 0)
	@Parameters({"targetAmount"})
	public void createStash(String targetAmount) throws Exception {
		//welcomePage.RingPayAppLaunch();
		//TDB-ST-001
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
	@Parameters({"AddToStashFund","stashAmount","AchievedAmount"})
	public void addToStash(String AddToStashFund, String stashAmount ,String AchievedAmount) throws Exception {
		// Nithya
		//
		stashHomePage.clickAddToStash();
		stashAddToStashPage.addToStash(AddToStashFund);
		stashConfirmTransferToStashPage.confirmTransferToStash(stashAmount, prop.getproperty("mainAccount"),prop.getproperty("educationStash"),prop.getproperty("ownerStash"));
		stashMoneyStashPage.clickViewDetailsText();
		stashMoneyStashPage.moneyStashed();
		stashHomePage.getStashName(prop.getproperty("educationStash"));
		stashHomePage.verifyStashAchieved(stashAmount, AchievedAmount);
		stashHomePage.clickOnCreatedStash();
		createdStashPage.createdStashDateAndName("Myself", "CREDIT",stashAmount);
		stashHomePage.moveToPreviousPage(1);
		stashHomePage.verifyStashAchieved(stashAmount, AchievedAmount);
		ExtentReporter.jiraID = "TON-3";
	}

	@Test(priority = 2)
	@Parameters({"AddToStashFund","stashAmount","AchievedAmount","AddOrSubstractTonikAmount"})
	public void addToStashAgain(String AddToStashFund, String stashAmount ,String AchievedAmount,String AddOrSubstractTonikAmount) throws Exception {
		// Nithya
		stashHomePage.clickAddToStash();
		stashAddToStashPage.addToStash(AddToStashFund);
		stashConfirmTransferToStashPage.confirmTransferToStash(stashAmount, prop.getproperty("mainAccount"),prop.getproperty("educationStash"),prop.getproperty("ownerStash"));
		stashMoneyStashPage.clickViewDetailsText();
		stashMoneyStashPage.moneyStashed();
		stashHomePage.verifyStashAchieved(AchievedAmount, AchievedAmount);
		stashHomePage.moveToPreviousPage(1);
	    tonikAccountBalance = Utilities.subtractTwoAmount(tonikAccountBalance, AddOrSubstractTonikAmount);
	    System.out.println(tonikAccountBalance);
		ExtentReporter.jiraID = "TON-3";
	}


	@Test(priority = 3)
	public void verifyGoalAchieved() throws Exception {
		mainPage.clickTotalStashBalance();
		stashHomePage.verifyGoalAchieved();
		ExtentReporter.jiraID = "TON-9";
	}

	@Test(priority = 4)
	@Parameters({"stashAmountAfterWithDrawn","AchievedAmount","BalanceAmount","targetAmount","AddOrSubstractTonikAmount"})
	public void withDrawStash(String stashAmountAfterWithDrawn,String AchievedAmount,String BalanceAmount,String targetAmount,String AddOrSubstractTonikAmount) throws Exception {
		// Ramkumar
		stashHomePage.clickManage();
		manageStashPage.clickWithdrawToYourTonikAccount();
		withdrawFromYourStashPage.verifyPageLoaded();
		withdrawFromYourStashPage.withDrawAmount(BalanceAmount,targetAmount);
		reviewWithdrawPage.reviewWithdrawalInfo(BalanceAmount, prop.getproperty("educationStash"), prop.getproperty("mainAccount"));
		reviewWithdrawPage.clickConfirm();
		withdrawConfirmationPage.verifyConfirmationMessage(AchievedAmount,prop.getproperty("educationStash"));
		withdrawConfirmationPage.clickViewDetailsLink();
		withdrawTransactionDetailsPage.verifyTransactionDetails(AchievedAmount, prop.getproperty("withdrawToAccount"), prop.getproperty("educationStash"), basePage.dateComparisonWithoutTime());
		withdrawTransactionDetailsPage.moveToPreviousPage(1);
		withdrawConfirmationPage.clickOhYeahButton();
		stashHomePage.getStashName(prop.getproperty("educationStash"));
		stashHomePage.verifyStashAchieved(stashAmountAfterWithDrawn, AchievedAmount);
		stashHomePage.moveToPreviousPage(1);
		String newBalance = Utilities.addTwoAmount(tonikAccountBalance, AddOrSubstractTonikAmount);
		System.out.println(newBalance);
		mainPage.verifyTonikAccountBalance(newBalance);
		mainPage.clickTotalStashBalance();
		ExtentReporter.jiraID = "TON-7";
	}	

	@Test(priority = 5)
	public void closeStash() throws Exception {
		//Harish - Close the stash
		stashHomePage.clickManage();
		manageStashPage.clickClose();
		manageStashPage.clickStayAndCloseStashConfirmation();
		stashClosePage.brokeTheStash();
		ExtentReporter.jiraID = "TON-8";

	}
}
