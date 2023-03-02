package com.tonik.testScripts;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.extent.ExtentReporter;
import com.utility.Utilities;

public class TonikTestFlow_SoloStash_AddStash_UpdateStashDetails_CloseStash extends BaseTestCase {

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
	@Parameters({"updateFundToStash", "addingStashAmount"})
	public void addToStash(String updateFundToStash,String addingStashAmount) throws Exception {
		// Nithya
		stashHomePage.clickAddToStash();
		stashAddToStashPage.addToStash(updateFundToStash);
		stashConfirmTransferToStashPage.confirmTransferToStash(addingStashAmount, prop.getproperty("mainAccount"),prop.getproperty("educationStash"),prop.getproperty("ownerStash"));
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
	}
	@Test(priority = 2)
	public void modifyStashNamewithLessInput() throws Exception {
		modifyStashPage.modifyStashName("AB", prop.getproperty("travellingStash"));
		updatedStashPage.verifyUpdatedStashConfirmationMessage();
		stashHomePage.getStashName(prop.getproperty("travellingStash"));
		ExtentReporter.jiraID = "TON-10";
	}	

	@Test(priority = 3)
	@Parameters({"modifiedBeforeAmount","lessThanInputAmount"})
	public void modifyStashAmount(String modifiedBeforeAmount, String  lessThanInputAmount) throws Exception {
		stashHomePage.clickManage();
		manageStashPage.clickModify();
		modifyStashPage.modifyStashAmount(modifiedBeforeAmount, lessThanInputAmount);
		modifyStashPage.verifyStashAmountErrorMessage();
		ExtentReporter.jiraID = "TON-14";
	}
	
	@Test(priority = 4)
	@Parameters({"lessThanInputAmount","modifiedAfterAmount","AchievedModifiedAmount","addingStashAmount"})
	public void modifyStashAmountWithLessInput( String  lessThanInputAmount, String modifiedAfterAmount,String AchievedModifiedAmount,String addingStashAmount) throws Exception {
		modifyStashPage.modifyStashAmount(lessThanInputAmount, modifiedAfterAmount);
		updatedStashPage.verifyUpdatedStashConfirmationMessage();
		stashHomePage.verifyStashAchieved(addingStashAmount, AchievedModifiedAmount);
		ExtentReporter.jiraID = "TON-11";
	}



	@Test(priority = 5)
	@Parameters({"updateFundToStash", "addingStashAmount","modifiedAddOrSubstractTonikAmount"})
	public void addToStashAgain(String updateFundToStash,String addingStashAmount,String modifiedAddOrSubstractTonikAmount) throws Exception {
		// Nithya
		stashHomePage.clickAddToStash();
		stashAddToStashPage.addToStash(updateFundToStash);
		stashConfirmTransferToStashPage.confirmTransferToStash(addingStashAmount, prop.getproperty("mainAccount"),prop.getproperty("travellingStash"),prop.getproperty("ownerStash"));
		//stashMoneyStashPage.clickViewDetailsText();
		stashMoneyStashPage.moneyStashed();
		stashHomePage.moveToPreviousPage(1);
	    tonikAccountBalance = Utilities.subtractTwoAmount(tonikAccountBalance, modifiedAddOrSubstractTonikAmount);
	    System.out.println(tonikAccountBalance);
	    ExtentReporter.jiraID = "TON-3";
		
	}	


	@Test(priority = 6)
	@Parameters({"BeforeWithDrawnAmount","withDrawnAmount","moreThanWithdrawnAmount","stashAmountAfterWithDrawn","AchievedModifiedAmount","modifiedAddOrSubstractTonikAmount"})
	public void verifyNoEnoughBalanceMessage(String BeforeWithDrawnAmount,String withDrawnAmount,String moreThanWithdrawnAmount,String stashAmountAfterWithDrawn,String AchievedModifiedAmount,String modifiedAddOrSubstractTonikAmount) throws Exception {
		// Ramkumar
		stashHomePage.clickManage();
		manageStashPage.clickWithdrawToYourTonikAccount();
		//withdrawFromYourStashPage.verifyPageLoaded();
		withdrawFromYourStashPage.withDrawAmount(BeforeWithDrawnAmount,moreThanWithdrawnAmount);
		withdrawFromYourStashPage.verifyNoEnoughBalanceMessage(BeforeWithDrawnAmount);
		withdrawFromYourStashPage.withDrawAmount(BeforeWithDrawnAmount,withDrawnAmount);
		reviewWithdrawPage.reviewWithdrawalInfo(BeforeWithDrawnAmount, prop.getproperty("travellingStash"), prop.getproperty("mainAccount"));
		reviewWithdrawPage.clickConfirm();
		withdrawConfirmationPage.verifyConfirmationMessage(AchievedModifiedAmount,prop.getproperty("travellingStash"));
		withdrawConfirmationPage.clickOhYeahButton();
		stashHomePage.getStashName(prop.getproperty("travellingStash"));
		stashHomePage.verifyStashAchieved(stashAmountAfterWithDrawn, AchievedModifiedAmount);
		basePage.moveToPreviousPage(1);
		String newBalance = Utilities.addTwoAmount(tonikAccountBalance, modifiedAddOrSubstractTonikAmount);
		System.out.println(newBalance);
		mainPage.verifyTonikAccountBalance(newBalance);
		mainPage.clickTotalStashBalance();
		ExtentReporter.jiraID = "TON-13";
	}

	@Test(priority=7)
	@Parameters({"AchievedModifiedAmount"})
	public void verifyStashDetails(String AchievedModifiedAmount) throws Exception {
		stashHomePage.clickManage();
		manageStashPage.clickStashDetails();
		stashDetailsPage.stashDetails(AchievedModifiedAmount);
		basePage.moveToPreviousPage(1);
		ExtentReporter.jiraID = "TON-12";

	}

	@Test(priority = 8)
	public void closeStash() throws Exception {
		//Harish - Close the stash
		stashHomePage.clickManage();
		manageStashPage.clickClose();
		manageStashPage.clickStayAndCloseStashConfirmation();
		stashClosePage.brokeTheStash();
		ExtentReporter.jiraID = "TON-8";

	}
}
