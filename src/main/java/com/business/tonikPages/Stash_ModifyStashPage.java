package com.business.tonikPages;

import com.android.selectors.Stash_ModifyStashSelectors;

public class Stash_ModifyStashPage extends BasePage {

	public Stash_ModifyStashPage() throws InterruptedException {
		super();
	}
	/**
	 *  Function verify if 'Modify Stash' page is loaded successfully
	 */
	public boolean verifyPageLoaded() throws Exception {
		waitTime(2000);
		if(waitForElementToBePresent(Stash_ModifyStashSelectors.txtModifyStash, 60,"Withdrawal Confirmation text"))
		{
			extent.extentLoggerPass("Page loaded ('Modify Stash')", "'Modify Stash' page loaded successfully");
			return true;
		}
		else
		{
			extent.extentLoggerFail("Page not loaded ('Modify Stash')", "'Modify Stash' page not loaded successfully");
			return false;
		}
	}

	/**
	 * This Business Method is to modify Stash Name and amount in Modify Stash Page
	 * Parameters
	 * 		  stashName - e.g. Education
	 *        newStashName - e.g. Travelling
	 *        stashAmount - 5,000
	 *        newStashAmount - 6,000
	 */
	public void modifyStashInfo(String stashName, String newStashName, String stashAmount, String newStashAmount) throws Exception {
		extent.HeaderChildNode("Modify Existing Stash Name and Stash Amount");
		if(this.verifyPageLoaded()) {
			this.verifyAndUpdateStashName(stashName, newStashName);
			this.verifyAndUpdateStashAmount(stashAmount, newStashAmount);
			this.clickSaveButton();
		}
	}
	/**
	 * This Business Method is to modify Stash Name in Modify Stash Page
	 * @param stashName - e.g. Education
	 *        newStashName - e.g. Travelling
	 * @throws Exception
	 */
	public void modifyStashName(String stashName, String stashNewName) throws Exception
	{
		extent.HeaderChildNode("Modify Existing Stash Name");
		if(this.verifyPageLoaded()) {
			this.verifyAndUpdateStashName(stashName, stashNewName);
			waitTime(2000);
			this.clickSaveButton();
		}
	}

	/**
	 * This Business Method verify existing stash name and update a new stash name
	 * @param stashName - e.g. Education
	 *        newStashName - e.g. Travelling
	 * @throws Exception
	 */
	public void verifyAndUpdateStashName(String stashName, String stashNewName) throws Exception{
		String stashName_before = getText(Stash_ModifyStashSelectors.edittxtStashFor);
		System.out.println(stashName_before);
		softAssertion.assertEquals(stashName, stashName_before);
		softAssertion.assertAll();
		clearField(Stash_ModifyStashSelectors.edittxtStashFor, "Stash For text Field");
		Aclick(Stash_ModifyStashSelectors.edittxtStashFor, "text field");
	    waitTime(2000);
		type(Stash_ModifyStashSelectors.edittxtStashFor, stashNewName, " into stash For text Field");
		waitTime(3000);
		hideKeyboard();

	}

	/**
	 * This Business Method is to Modify Stash Amount in Modify Stash Page
	 * @param stashAmount - 1,000
	 *        newStashAmount - 2,000
	 * @throws Exception
	 */
	public void modifyStashAmount(String stashAmount, String newStashAmount) throws Exception {
		extent.HeaderChildNode("Modify Existing Stash Amount");
		if(this.verifyPageLoaded()) {
			this.verifyAndUpdateStashAmount(stashAmount, newStashAmount);
			waitTime(2000);
			this.clickSaveButton();
		}
	}

	/**
	 * This Business Method verify existing stash amount and update a new stash amount
	 * @param stashAmount - e.g. Education
	 *        newStashName - e.g. Travelling
	 * @throws Exception
	 */
	public void verifyAndUpdateStashAmount(String stashAmount, String stashNewAmount) throws Exception {
		String stashAmount_before = getText(Stash_ModifyStashSelectors.edittxtTargetamount);
		System.out.println(stashAmount_before);
		softAssertion.assertEquals(stashAmount, stashAmount_before);
		softAssertion.assertAll();
		clearField(Stash_ModifyStashSelectors.edittxtTargetamount, "Target Amount text Field");
		Aclick(Stash_ModifyStashSelectors.edittxtTargetamount, "text field");
		type(Stash_ModifyStashSelectors.edittxtTargetamount, stashNewAmount, " into target amount Field");
		hideKeyboard();
		waitTime(2000);
	}
	/**
	 * Click on the Save button
	 * @throws Exception
	 */
	public void clickSaveButton() throws Exception {
		if(waitForElementToBePresent(Stash_ModifyStashSelectors.btnSave,60, "Save button")) {
			click(Stash_ModifyStashSelectors.btnSave, "Save button");
		} else {
			extent.extentLoggerFail("Save button ('Modify Stash')", "Unable to click on 'Save' button");
		}
	}
	/**
	 * This Business Method is to verify stash Name Error Message
	 * @throws Exception
	 */
	
	public void verifyStashNameErrorMessage() throws Exception {
		String StashNameErrormessage = getText(Stash_ModifyStashSelectors.txtPleaseEnterAValidStashName);
		System.out.println(StashNameErrormessage);
		softAssertion.assertEquals("Please enter a valid stash name", StashNameErrormessage);
        softAssertion.assertAll();
	}
	/**
	 * This Business method is to verify Stash Amount Error Message
	 * @throws Exception
	 */
	public void verifyStashAmountErrorMessage() throws Exception {
		String actualLessThanInputAmountError = getText(Stash_ModifyStashSelectors.txtMinAmountCanBePeso);
		System.out.println(actualLessThanInputAmountError);
		softAssertion.assertEquals("Min amount can be 1000 Peso.", actualLessThanInputAmountError);
		softAssertion.assertAll();
	}
	
	/**
	 * This Business Method is to Enter Less Input characters and verify Error message
	 * @param stashName
	 * @param stashNewNameWithTwoCharacters
	 * @param stashNewName
	 * @throws Exception
	 */
	public void checkStashNameWithLessInput(String stashName, String stashNewNameWithTwoCharacters, String stashNewName) throws Exception {
		extent.HeaderChildNode("check with Less Input characters");
		modifyStashName(stashName, stashNewNameWithTwoCharacters);
		modifyStashName(stashNewNameWithTwoCharacters, stashNewName);
		
	}
	/**
	 * This Business method is enter Target Amount less Input digits and verify Error Message
	 * @param stashAmount
	 * @param stashNewamountWithThreeDigits
	 * @param stashNewAmount
	 * @throws Exception
	 */
	public void checkStashAmountWithLessInput(String stashAmount,String stashNewamountWithThreeDigits, String stashNewAmount) throws Exception {
		extent.HeaderChildNode("check with Less Input Numbers");
		modifyStashAmount(stashAmount, stashNewamountWithThreeDigits);
		modifyStashAmount(stashNewamountWithThreeDigits, stashNewAmount);
	}
	
	public void verifyStashNameStashAmount(String stashName, String stashAmount) throws Exception {
		
		extent.HeaderChildNode("Modify Existing Stash Name and Stash Amount");
		if(this.verifyPageLoaded()) {
		String stashName_before = getText(Stash_ModifyStashSelectors.edittxtStashFor);
		System.out.println(stashName_before);
		softAssertion.assertEquals(stashName, stashName_before);
		softAssertion.assertAll();
		
		String stashAmount_before = getText(Stash_ModifyStashSelectors.edittxtTargetamount);
		System.out.println(stashAmount_before);
		softAssertion.assertEquals(stashAmount, stashAmount_before);
		softAssertion.assertAll();
		waitForElementToBePresent(Stash_ModifyStashSelectors.btnSave,60, "Save button");
		extent.extentLoggerPass("Page loaded ('Modify Stash')", "'Modify Stash' page loaded successfully");
		} else {
			extent.extentLoggerFail("Save button ('Modify Stash')", "Unable to click on 'Save' button");
		}
	}
}
