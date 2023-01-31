package com.tonik.testScripts;

import org.testng.annotations.Test;

import com.android.selectors.Stash_StashHomeSelectors;

public class TonikTestFlow_CreateMoreThanFiveStashes extends BaseTestCase
{
	public String tonikAccountBalance;
	public String tonikNewAccountBalance;

	@Test(priority=0)
	public void checkStashNames() throws Exception {
		loginPage.performLogin();
		tonikAccountBalance = mainPage.getTonikAccounBalance();
		System.out.println("Balance:"+tonikAccountBalance);
		mainPage.clickTotalStashBalance();
		//
		stashHomePage.clickStartANewStash();
		startNewStaShPage.clickOpenANewStash();
		startNewStaShPage.selectSoloStashType();
		stashSetupPage.enterDetailsIntoSetupYourStash(prop.getproperty("educationStash"),"1000");
		setInitialSavingPage.clickOnSkipForNow();
		reviewStashDetailsPage.verifyDetailsAndCreateStash();
		soloStashCreatedPage.soloStashCreated();
		stashHomePage.getStashName("Education");
		stashHomePage.verifyStashAchieved("₱0.00", "₱1,000.00");
//
		stashHomePage.clickStartANewStash();
		startNewStaShPage.clickEmergencyStash();
		startNewStaShPage.selectSoloStashType();
		stashSetupPage.enterDetailsIntoSetupYourStash(" ","1000");
		setInitialSavingPage.clickOnSkipForNow();
		reviewStashDetailsPage.verifyDetailsAndCreateStash();
		soloStashCreatedPage.soloStashCreated();
//
		stashHomePage.clickStartANewStash();
		startNewStaShPage.clickVacationStash();
		startNewStaShPage.selectSoloStashType();
		stashSetupPage.enterDetailsIntoSetupYourStash(" ","1000");
		setInitialSavingPage.clickOnSkipForNow();
		reviewStashDetailsPage.verifyDetailsAndCreateStash();
		soloStashCreatedPage.soloStashCreated();
//
		stashHomePage.clickStartANewStash();
		startNewStaShPage.clickNewRideStash();
		startNewStaShPage.selectSoloStashType();
		stashSetupPage.enterDetailsIntoSetupYourStash(" ","1000");
		setInitialSavingPage.clickOnSkipForNow();
		reviewStashDetailsPage.verifyDetailsAndCreateStash();
		soloStashCreatedPage.soloStashCreated();
//
		stashHomePage.clickStartANewStash();
		startNewStaShPage.clickGameConsoleStash();
		startNewStaShPage.selectSoloStashType();
		stashSetupPage.enterDetailsIntoSetupYourStash(" ","1000");
		setInitialSavingPage.clickOnSkipForNow();
		reviewStashDetailsPage.verifyDetailsAndCreateStash();
		soloStashCreatedPage.soloStashCreated();
//
        basePage.fetchAllStashNames();
        stashHomePage.verifyAlertPromptIfFiveStashesPresent();
        
	}
	

}
