package com.tonik.testScripts;


import com.propertyfilereader.PropertyFileReader;
import com.utility.Utilities;
//good
import java.io.IOException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class BaseTestCase {
    protected com.business.tonikPages.WelcomePage welcomePage;
    protected com.business.tonikPages.LoginPage loginPage;
    protected com.business.tonikPages.BasePage basePage;
    protected com.business.tonikPages.MainPage mainPage;
    protected com.business.tonikPages.Stash_StashHomePage stashHomePage;
    protected com.business.tonikPages.Stash_SetupYourStashPage stashSetupPage;
    protected com.business.tonikPages.Stash_StashClosePage stashClosePage;
    protected com.business.tonikPages.Stash_StartNewStashPage startNewStaShPage;
    protected com.business.tonikPages.Stash_SetInitialSavingPage setInitialSavingPage;
    protected com.business.tonikPages.Stash_ReviewStashDetailsPage reviewStashDetailsPage;
    protected com.business.tonikPages.Stash_SoloStashCreatedPage  soloStashCreatedPage;
    protected com.business.tonikPages.Stash_ManageStashPage manageStashPage;
    protected com.business.tonikPages.Stash_ModifyStashPage modifyStashPage;
    protected com.business.tonikPages.Stash_UpdatedYourStashPage updatedStashPage;
    protected com.business.tonikPages.Stash_WithdrawFromYourStashPage withdrawFromYourStashPage;
    protected com.business.tonikPages.Stash_ReviewWithdrawPage reviewWithdrawPage;
    protected com.business.tonikPages.Stash_WithdrawConfirmationPage withdrawConfirmationPage;
    protected com.business.tonikPages.Stash_AddToStashPage stashAddToStashPage;
    protected com.business.tonikPages.Stash_ConfirmTransferToStashPage stashConfirmTransferToStashPage;
    protected com.business.tonikPages.Stash_MoneyStashPage stashMoneyStashPage;
    protected com.business.tonikPages.Stash_StashDetailsPage stashDetailsPage;
    protected com.business.tonikPages.Stash_AchievedPage stashAchievedPage;
    protected com.business.tonikPages.Stash_CongratsGoalAchievedPage stashCongratsGoalAchievedPage;
    protected com.business.tonikPages.Stash_HowMuchWillYouInvestPage stashHowMuchWillYouInvestPage;
    protected com.business.tonikPages.Stash_YouBrokeTheStashPage stashYouBrokeTheStashPage;
    protected com.business.tonikPages.Stash_WithdrawTransactionDetailsPage withdrawTransactionDetailsPage;
    protected com.business.tonikPages.Stash_CreatedStashPage createdStashPage;
    protected com.business.tonikPages.Stash_SetUpTimeDepositPage stashSetupTimeDepositPage;
    protected com.business.tonikPages.Stash_WootWootPage stashWootWootPage;
    
    
    
    public static PropertyFileReader prop = new PropertyFileReader(".\\properties\\testdata.properties");

    Utilities util=new Utilities();
    @BeforeClass
    public void Before() throws InterruptedException, IOException {
        Utilities.relaunch = false;
      //  util.clearBackgroundApps();
        basePage = new com.business.tonikPages.BasePage("tonix");
        welcomePage = new com.business.tonikPages.WelcomePage();
        loginPage = new com.business.tonikPages.LoginPage();
        mainPage = new com.business.tonikPages.MainPage();
        stashHomePage=new com.business.tonikPages.Stash_StashHomePage();
        stashSetupPage=new com.business.tonikPages.Stash_SetupYourStashPage();
        stashClosePage=new com.business.tonikPages.Stash_StashClosePage();
        startNewStaShPage=new com.business.tonikPages.Stash_StartNewStashPage();
        setInitialSavingPage=new com.business.tonikPages.Stash_SetInitialSavingPage();
        reviewStashDetailsPage=new com.business.tonikPages.Stash_ReviewStashDetailsPage();
        soloStashCreatedPage=new com.business.tonikPages.Stash_SoloStashCreatedPage();
        manageStashPage=new com.business.tonikPages.Stash_ManageStashPage();
        modifyStashPage=new com.business.tonikPages.Stash_ModifyStashPage();
        updatedStashPage=new com.business.tonikPages.Stash_UpdatedYourStashPage();
        manageStashPage = new com.business.tonikPages.Stash_ManageStashPage();
        withdrawFromYourStashPage = new com.business.tonikPages.Stash_WithdrawFromYourStashPage();
        reviewWithdrawPage = new com.business.tonikPages.Stash_ReviewWithdrawPage();
        withdrawConfirmationPage = new com.business.tonikPages.Stash_WithdrawConfirmationPage();
        stashAddToStashPage=new com.business.tonikPages.Stash_AddToStashPage();
        stashConfirmTransferToStashPage=new com.business.tonikPages.Stash_ConfirmTransferToStashPage();
        stashMoneyStashPage=new com.business.tonikPages.Stash_MoneyStashPage();
        stashDetailsPage=new com.business.tonikPages.Stash_StashDetailsPage();
        stashAchievedPage=new com.business.tonikPages.Stash_AchievedPage();
        stashCongratsGoalAchievedPage=new com.business.tonikPages.Stash_CongratsGoalAchievedPage();
        stashHowMuchWillYouInvestPage=new com.business.tonikPages.Stash_HowMuchWillYouInvestPage();
        stashYouBrokeTheStashPage=new com.business.tonikPages.Stash_YouBrokeTheStashPage();
        withdrawTransactionDetailsPage = new com.business.tonikPages.Stash_WithdrawTransactionDetailsPage();
        createdStashPage=new com.business.tonikPages.Stash_CreatedStashPage();
        stashSetupTimeDepositPage=new com.business.tonikPages.Stash_SetUpTimeDepositPage();
        stashWootWootPage=new com.business.tonikPages.Stash_WootWootPage();
    }

    @AfterClass
    public void tonikAppQuit() throws Exception{
        basePage.TearDown();
    }
}
