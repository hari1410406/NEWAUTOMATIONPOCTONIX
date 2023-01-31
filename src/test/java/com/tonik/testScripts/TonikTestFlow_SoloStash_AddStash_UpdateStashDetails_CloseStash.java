package com.tonik.testScripts;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.extent.ExtentReporter;
import com.utility.Utilities;

public class TonikTestFlow_SoloStash_AddStash_UpdateStashDetails_CloseStash extends BaseTestCase {

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
		stashAddToStashPage.addToStash("750");
		stashConfirmTransferToStashPage.confirmTransferToStash("₱750.00", prop.getproperty("mainAccount"),prop.getproperty("educationStash"),prop.getproperty("ownerStash"));
		//stashMoneyStashPage.clickViewDetailsText();
		stashMoneyStashPage.moneyStashed();
		ExtentReporter.jiraID = "TON-3";
	}

	@Test(priority = 2)
	public void modifyStashName() throws Exception {
		stashHomePage.clickManage();
		manageStashPage.clickModify();
		modifyStashPage.modifyStashName(prop.getproperty("educationStash"), "AB");
		modifyStashPage.verifyStashNameErrorMessage();
		ExtentReporter.jiraID = "TON-15";
		modifyStashPage.modifyStashName("AB", prop.getproperty("travellingStash"));
		updatedStashPage.verifyUpdatedStashConfirmationMessage();
		stashHomePage.getStashName(prop.getproperty("travellingStash"));
		ExtentReporter.jiraID = "TON-10";
	}	

	@Test(priority = 3)
	public void modifyStashAmount() throws Exception {
		stashHomePage.clickManage();
		manageStashPage.clickModify();
		modifyStashPage.modifyStashAmount("1,000.00", "900");
		modifyStashPage.verifyStashAmountErrorMessage();
		ExtentReporter.jiraID = "TON-14";
		modifyStashPage.modifyStashAmount("900", "1500");
		updatedStashPage.verifyUpdatedStashConfirmationMessage();
		stashHomePage.verifyStashAchieved("₱750.00", "₱1,500.00");
		ExtentReporter.jiraID = "TON-11";
	}



	@Test(priority = 4)
	public void addToStashAgain() throws Exception {
		// Nithya
		stashHomePage.clickAddToStash();
		stashAddToStashPage.addToStash("750");
		stashConfirmTransferToStashPage.confirmTransferToStash("₱750.00", prop.getproperty("mainAccount"),prop.getproperty("travellingStash"),prop.getproperty("ownerStash"));
		//stashMoneyStashPage.clickViewDetailsText();
		stashMoneyStashPage.moneyStashed();
		stashHomePage.moveToPreviousPage(1);
	    tonikAccountBalance = Utilities.subtractTwoAmount(tonikAccountBalance, "1500.00");
	    System.out.println(tonikAccountBalance);
	    ExtentReporter.jiraID = "TON-3";
		ExtentReporter.jiraID = "TON-3";
	}	


	@Test(priority = 5)
	public void verifyNoEnoughBalanceMessage() throws Exception {
		// Ramkumar
		stashHomePage.clickManage();
		manageStashPage.clickWithdrawToYourTonikAccount();
		//withdrawFromYourStashPage.verifyPageLoaded();
		withdrawFromYourStashPage.withDrawAmount("1,500.00","2000");
		withdrawFromYourStashPage.verifyNoEnoughBalanceMessage("1,500.00");
		withdrawFromYourStashPage.withDrawAmount("1,500.00","1500");
		reviewWithdrawPage.reviewWithdrawalInfo("1,500.00", prop.getproperty("travellingStash"), prop.getproperty("mainAccount"));
		reviewWithdrawPage.clickConfirm();
		withdrawConfirmationPage.verifyConfirmationMessage("₱1,500.00",prop.getproperty("travellingStash"));
		withdrawConfirmationPage.clickOhYeahButton();
		stashHomePage.getStashName(prop.getproperty("travellingStash"));
		stashHomePage.verifyStashAchieved("₱0.00", "₱1,500.00");
		basePage.moveToPreviousPage(1);
		String newBalance = Utilities.addTwoAmount(tonikAccountBalance, "1500.00");
		System.out.println(newBalance);
		mainPage.verifyTonikAccountBalance(newBalance);
		mainPage.clickTotalStashBalance();
		ExtentReporter.jiraID = "TON-13";
	}

	@Test(priority=6)
	public void verifyStashDetails() throws Exception {
		stashHomePage.clickManage();
		manageStashPage.clickStashDetails();
		stashDetailsPage.stashDetails("₱1,500.00");
		basePage.moveToPreviousPage(1);
		ExtentReporter.jiraID = "TON-12";

	}

	@Test(priority = 7)
	public void closeStash() throws Exception {
		//Harish - Close the stash
		stashHomePage.clickManage();
		manageStashPage.clickClose();
		manageStashPage.clickStayAndCloseStashConfirmation();
		stashClosePage.brokeTheStash();
		ExtentReporter.jiraID = "TON-8";

	}
}
