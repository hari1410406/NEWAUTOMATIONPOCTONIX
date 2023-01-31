package com.business.tonikPages;

import com.android.selectors.Stash_SetUpTimeDepositSelectors;

public class Stash_SetUpTimeDepositPage extends BasePage{
	
	public Stash_SetUpTimeDepositPage() throws InterruptedException {
        super();
	}

	public void verifySetUpTimeDeposit(String investmentAmount, String termTimeDeposit, String nicknameTimeDeposit, String interestRateTimeDeposit, String interestEarnedAtMaturity, String payoutAtMaturity, String earlyWithdrawal) throws Exception {
		
		if(waitForElementToBePresent(Stash_SetUpTimeDepositSelectors.txtSetUpTimeDeposit,60, "Set up time deposit text"))
        {
	        String actualinvestmentAmount = getText(Stash_SetUpTimeDepositSelectors.txtInvestmentAmount);
	        System.out.println(actualinvestmentAmount);
			String actualterm = getText(Stash_SetUpTimeDepositSelectors.txtTerm);
			System.out.println(actualterm);
			String actualnickname = getText(Stash_SetUpTimeDepositSelectors.txtNickname);
			System.out.println(actualnickname);
			String actualinterestRate = getText(Stash_SetUpTimeDepositSelectors.txtInterestRate);
			System.out.println(actualinterestRate);
			String actualinterestEarnedAtMaturity = getText(Stash_SetUpTimeDepositSelectors.txtInterestEarnedAtMaturity);
			System.out.println(actualinterestEarnedAtMaturity);
			String actualpayoutAtMaturity = getText(Stash_SetUpTimeDepositSelectors.txtPayoutAtMaturity);
			System.out.println(actualpayoutAtMaturity);
			String actualearlyWithdrawal = getText(Stash_SetUpTimeDepositSelectors.txtEarlyWithdrawal);
			System.out.println(actualearlyWithdrawal);
			dateComparisonWithoutTimeAndFutureDates(6);
			String actualdateOfMaturity = getText(Stash_SetUpTimeDepositSelectors.txtDateOfMaturity);
			System.out.println(actualdateOfMaturity);
			System.out.println("--------------------");
			
			softAssertion.assertEquals(investmentAmount, actualinvestmentAmount);
			System.out.println(actualinvestmentAmount);
			softAssertion.assertEquals(termTimeDeposit, actualterm);
			System.out.println(actualterm);
			softAssertion.assertEquals(nicknameTimeDeposit, actualnickname);
			System.out.println(actualnickname);
			softAssertion.assertEquals(interestRateTimeDeposit, actualinterestRate);
			System.out.println(actualinterestRate);
			softAssertion.assertEquals(interestEarnedAtMaturity, actualinterestEarnedAtMaturity);
			System.out.println(actualinterestEarnedAtMaturity);
			softAssertion.assertEquals(payoutAtMaturity, actualpayoutAtMaturity);
			System.out.println(actualpayoutAtMaturity);
			softAssertion.assertEquals(earlyWithdrawal, actualearlyWithdrawal);
			System.out.println(actualearlyWithdrawal);
			softAssertion.assertEquals(formattedDate, actualdateOfMaturity);
			System.out.println(actualdateOfMaturity);
			softAssertion.assertAll();
			Swipe("up", 1);
			
	        waitForElementAndClickIfPresent(Stash_SetUpTimeDepositSelectors.btnTermsAndConditions, 20,"Click terms and condition");
	        waitForElementAndClickIfPresent(Stash_SetUpTimeDepositSelectors.btnLetUsOpenThisTimeDeposit, 20,"Click let us open this time deposit");
	        
	        logger.info("Clicked on let us open this time deposit");
	        extent.extentLoggerPass("Let us open this time deposit", "Clicked 'Let us open this time deposit'");
        }
        else 
        {
        	logger.info("Did not click on let us open this time deposit");
            extent.extentLoggerFail("Let us open this time deposit", "Not clicked 'Let us open this time deposit'");
        
        }

	        
	}
}
