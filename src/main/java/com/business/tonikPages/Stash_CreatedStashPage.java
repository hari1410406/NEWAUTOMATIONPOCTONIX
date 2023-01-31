package com.business.tonikPages;

import com.android.selectors.Stash_CreatedStashSelectors;

public class Stash_CreatedStashPage extends BasePage{

	//public String[] actualTodayDate=null;

	public Stash_CreatedStashPage() throws InterruptedException {
		super();
	}


	public void createdStashDateAndName(String creditName, String creditText,String creditAmount) throws Exception
	{
		extent.HeaderChildNode("verifying stash Credit and time");
		dateComparisonWithoutTime();
		String  actualTodayDate = getText(Stash_CreatedStashSelectors.txtTodayDate).substring(7, 18);
		System.out.println(actualTodayDate);
		String actualCreditName = getText(Stash_CreatedStashSelectors.txtMyselfCreditName);
		System.out.println(actualCreditName);
		String actualcreditText = getText(Stash_CreatedStashSelectors.txtCredit);
		System.out.println(actualcreditText);
		String actualCreditAmount=getText(Stash_CreatedStashSelectors.txtCreditAmount);
		System.out.println(actualCreditAmount);
		softAssertion.assertEquals(formattedDate, actualTodayDate);
		softAssertion.assertEquals(creditName, actualCreditName);
		softAssertion.assertEquals(creditText, actualcreditText);
		softAssertion.assertEquals(creditAmount, actualCreditAmount);
		softAssertion.assertAll();
	}
}
