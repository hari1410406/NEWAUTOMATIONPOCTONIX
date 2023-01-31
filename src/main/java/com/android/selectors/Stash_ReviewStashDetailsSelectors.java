package com.android.selectors;

import org.openqa.selenium.By;

public class Stash_ReviewStashDetailsSelectors {
	
	public static By txtReviewStashDetails=By.xpath("//*[@class='android.widget.TextView' and contains(@text,'Review Stash Details')]");
	
	public static By btnTickedRadioButton=By.xpath("(//*[@text='I accept the']/preceding-sibling::android.view.ViewGroup)[3]");
	
	public static By txtIAccept=By.xpath("//*[@text='I accept the']");
	
	public static By txtTermsAndConditions=By.xpath("//*[@text=' terms and conditions']");
	
	public static By btnCreateStash=By.xpath("//*[@class='android.view.ViewGroup']/child::android.widget.TextView[@text='Create Stash']");
	
	public static By txtTargetAmount=By.xpath("//*[contains(@text,'Target amount')]");
	
	public static By txtInitialSaving=By.xpath("//*[contains(@text,'Initial saving')]");
	
	public static By txtTransferFrom=By.xpath("//*[contains(@text,'Transfer from')]");
	
	public static By txtInterestRate=By.xpath("//*[contains(@text,' Interest rate ')]");
	
	public static By txtTargetAmountCurreny=By.xpath("//*[@text='Target amount']/following-sibling::android.widget.TextView");
	
	public static By txtInitialSavingCurreny=By.xpath("//*[@text='Initial saving']/following-sibling::android.widget.TextView");
	
	public static By txtTransferFromTonikAccount=By.xpath("//*[@text='Transfer from']/following-sibling::android.widget.TextView");
	
	public static By txtInterestRatePercentage=By.xpath("//*[@text=' Interest rate ']/following-sibling::android.widget.TextView");
	
	public static By txtStashNameForInBox=By.xpath("//*[@class='android.widget.TextView' and @text='Review Stash Details']/parent::android.view.ViewGroup/parent::android.view.ViewGroup/(child::android.view.ViewGroup)");
	
	public static By txtEachCustomerByPDIc=By.xpath("//*[@class='android.widget.TextView' and contains(@text,'Each customer is insured up to P500,000 by PDIC')]");
}
