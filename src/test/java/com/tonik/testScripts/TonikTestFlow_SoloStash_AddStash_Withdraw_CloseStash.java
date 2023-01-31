package com.tonik.testScripts;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.extent.ExtentReporter;
import com.utility.Utilities;

public class TonikTestFlow_SoloStash_AddStash_Withdraw_CloseStash extends BaseTestCase {

	public String tonikAccountBalance;
	public String tonikNewAccountBalance;

	@Test(priority = 0)
	public void createStash() throws Exception {
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
		stashSetupPage.enterDetailsIntoSetupYourStash(prop.getproperty("educationStash"),"1000");
		setInitialSavingPage.clickOnSkipForNow();
		reviewStashDetailsPage.verifyDetailsAndCreateStash();
		soloStashCreatedPage.soloStashCreated();
		ExtentReporter.jiraID = "TON-2";
	}

	@Test(priority = 1)
	public void addToStash() throws Exception {
		// Nithya
		//
		stashHomePage.clickAddToStash();
		stashAddToStashPage.addToStash("500");
		stashConfirmTransferToStashPage.confirmTransferToStash("₱500.00", prop.getproperty("mainAccount"),prop.getproperty("educationStash"),prop.getproperty("ownerStash"));
		stashMoneyStashPage.clickViewDetailsText();
		stashMoneyStashPage.moneyStashed();
		stashHomePage.getStashName(prop.getproperty("educationStash"));
		stashHomePage.verifyStashAchieved("₱500.00", "₱1,000.00");
		stashHomePage.clickOnCreatedStash();
		createdStashPage.createdStashDateAndName("Myself", "CREDIT","₱500.00");
		stashHomePage.moveToPreviousPage(1);
		stashHomePage.verifyStashAchieved("₱500.00", "₱1,000.00");
		ExtentReporter.jiraID = "TON-3";
	}

	@Test(priority = 2)
	public void addToStashAgain() throws Exception {
		// Nithya
		stashHomePage.clickAddToStash();
		stashAddToStashPage.addToStash("500");
		stashConfirmTransferToStashPage.confirmTransferToStash("₱500.00", prop.getproperty("mainAccount"),prop.getproperty("educationStash"),prop.getproperty("ownerStash"));
		stashMoneyStashPage.clickViewDetailsText();
		stashMoneyStashPage.moneyStashed();
		stashHomePage.verifyStashAchieved("₱1,000.00", "₱1,000.00");
		stashHomePage.moveToPreviousPage(1);
	    tonikAccountBalance = Utilities.subtractTwoAmount(tonikAccountBalance, "1000.00");
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
	public void withDrawStash() throws Exception {
		// Ramkumar
		stashHomePage.clickManage();
		manageStashPage.clickWithdrawToYourTonikAccount();
		withdrawFromYourStashPage.verifyPageLoaded();
		withdrawFromYourStashPage.withDrawAmount("1,000.00","1000");
		reviewWithdrawPage.reviewWithdrawalInfo("1,000.00", prop.getproperty("educationStash"), prop.getproperty("mainAccount"));
		reviewWithdrawPage.clickConfirm();
		withdrawConfirmationPage.verifyConfirmationMessage("₱1,000.00",prop.getproperty("educationStash"));
		withdrawConfirmationPage.clickViewDetailsLink();
		withdrawTransactionDetailsPage.verifyTransactionDetails("₱1,000.00", prop.getproperty("withdrawToAccount"), prop.getproperty("educationStash"), basePage.dateComparisonWithoutTime());
		withdrawTransactionDetailsPage.moveToPreviousPage(1);
		withdrawConfirmationPage.clickOhYeahButton();
		stashHomePage.getStashName(prop.getproperty("educationStash"));
		stashHomePage.verifyStashAchieved("₱0.00", "₱1,000.00");
		stashHomePage.moveToPreviousPage(1);
		String newBalance = Utilities.addTwoAmount(tonikAccountBalance, "1000.00");
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
