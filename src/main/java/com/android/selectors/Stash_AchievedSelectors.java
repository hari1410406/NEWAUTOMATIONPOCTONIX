package com.android.selectors;

import org.openqa.selenium.By;

public class Stash_AchievedSelectors {

	public static By txtStashName = By.xpath("(//android.widget.TextView)[1]");
	
	//public static By txtCongratsGoalAchieved = By.xpath("//android.widget.TextView[@text='Congrats! Goal achieved!']");
    
	public static By txtAchieved = By.xpath("//android.widget.TextView[contains(@text,'Achieved')]");
    
	public static By txtTarget = By.xpath("//android.widget.TextView[contains(@text,'of')]");
}
