package com.android.selectors;

import org.openqa.selenium.By;

public class Stash_CongratsGoalAchievedSelectors 
{
	public static By txtCongratsGoalAchieved =By.xpath("//android.widget.TextView[@text='Congrats! Goal achieved!']");
	
	public static By txtTargetAmount=By.xpath("//android.widget.TextView[contains(@text,'Target Amount')]/following-sibling::android.widget.TextView");
	
	public static By txtStashBalance=By.xpath("//android.widget.TextView[contains(@text,'Stash Balance')]/following-sibling::android.widget.TextView");
	
	public static By txtStartingDate=By.xpath("//android.widget.TextView[contains(@text,'Starting date')]/following-sibling::android.widget.TextView");
	
	public static By txtInterestRate=By.xpath("//android.widget.TextView[contains(@text,'Interest rate (p.a.)')]/following-sibling::android.widget.TextView");
	
	public static By txtWithholdingTax=By.xpath("//android.widget.TextView[contains(@text,'Withholding tax')]/following-sibling::android.widget.TextView");
	
	public static By btnWhatsYourNextStep=By.xpath("//android.widget.TextView[contains(@text,'your next step?')]");
	
	public static By txtNextStep=By.xpath("//android.widget.TextView[contains(@text,'your next step?')]");
	
	public static By txtTimeDeposit=By.xpath("//android.widget.TextView[@text='Convert to Time Deposit']");
	
	public static By txtHigherGoal=By.xpath("//android.widget.TextView[@text='Set a higher goal']");
	
	public static By txtBackToStash=By.xpath("//android.widget.TextView[@text='Back to Stash']");
	
	public static By txtCloseStash=By.xpath("//android.widget.TextView[@text='Close stash']");
	
	public static By txtLeaveItAsIs=By.xpath("//android.widget.TextView[@text='Leave it as is']");
	
	
}
