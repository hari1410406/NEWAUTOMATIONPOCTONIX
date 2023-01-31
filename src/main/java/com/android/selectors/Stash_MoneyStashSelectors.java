package com.android.selectors;

import org.openqa.selenium.By;

public class Stash_MoneyStashSelectors {

	
	public static By txtDoItLater =By.xpath("//*[contains(@text,'pinky swear')]");
	
	public static By txtMoneyStashed = By.xpath("//android.widget.TextView[@text='Money stashed!']");
	
	public static By txtYouAddedTo=By.xpath("//*[@class='android.widget.TextView' and contains(@text,'You added')]");
	
	public static By txtViewDetailsOFHowWeMoved=By.xpath("//*[@class='android.widget.TextView' and contains(@text,'View details of how we moved it.')]");

	public static By btnDone = By.xpath("//android.widget.TextView[@text='Done']");
	
	public static By txtTransactionDetails=By.xpath("//*[@class='android.widget.TextView' and @text='Transaction details']");
	
	public static By txtAmount=By.xpath("//*[@class='android.widget.TextView' and @text='Amount']/following-sibling::android.widget.TextView");

    public static By txtTo=By.xpath("//*[@class='android.widget.TextView' and @text='To']/following-sibling::android.widget.TextView");

    public static By txtFrom=By.xpath("//*[@class='android.widget.TextView' and @text='From']/following-sibling::android.widget.TextView");
    
    public static By txtWhen=By.xpath("//*[@class='android.widget.TextView' and @text='When']/following-sibling::android.widget.TextView");
    
    public static By txtRefNumber=By.xpath("//*[@class='android.widget.TextView' and @text='Ref number']/following-sibling::android.widget.TextView");

}
