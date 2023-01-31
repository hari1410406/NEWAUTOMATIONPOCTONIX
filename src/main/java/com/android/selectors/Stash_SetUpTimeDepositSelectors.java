package com.android.selectors;

import org.openqa.selenium.By;

public class Stash_SetUpTimeDepositSelectors {

	public static By txtSetUpTimeDeposit=By.xpath("//android.widget.TextView[@text='Set up a Time Deposit']");

    public static By txtInvestmentAmount=By.xpath("//android.widget.TextView[contains(@text,'Investment amount')]/following-sibling::android.widget.TextView");
	
	public static By txtTerm=By.xpath("//android.widget.TextView[contains(@text,'Term')]/following-sibling::android.widget.TextView");
	
	public static By txtNickname=By.xpath("//android.widget.TextView[contains(@text,'Nickname')]/following-sibling::android.widget.TextView");
	
	public static By txtInterestRate=By.xpath("//android.widget.TextView[contains(@text,'Interest rate (p.a.)')]/following-sibling::android.widget.TextView");
	
	public static By txtInterestEarnedAtMaturity=By.xpath("//android.widget.TextView[contains(@text,'Interest earned at maturity')]/following-sibling::android.widget.TextView");
	
	public static By txtPayoutAtMaturity=By.xpath("//android.widget.TextView[contains(@text,'Payout at maturity')]/following-sibling::android.widget.TextView");
	
	public static By txtEarlyWithdrawal=By.xpath("//android.widget.TextView[contains(@text,'Early withdrawal')]/following-sibling::android.widget.TextView");
	
	public static By txtDateOfMaturity=By.xpath("//android.widget.TextView[contains(@text,'Date of maturity')]/following-sibling::android.widget.TextView");
	
	public static By btnTermsAndConditions=By.xpath("(//*[contains(@text,'I accept the')]/preceding-sibling::android.view.ViewGroup)[3]");
	
	public static By btnLetUsOpenThisTimeDeposit=By.xpath("//*[contains(@text,'open this Time Deposit')]");
}

