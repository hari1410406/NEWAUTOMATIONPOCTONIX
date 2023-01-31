package com.android.selectors;

import org.openqa.selenium.By;

public class Stash_WootWootSelectors {

	public static By txtWootWoot=By.xpath("//android.widget.TextView[@text='Woot woot!']");

    public static By txtConfirmationMessage=By.xpath("//android.widget.TextView[contains(@text,'Your Time Deposit has been created.')]");
	
    public static By txtDoItLater=By.xpath("//*[contains(@text,'pinky swear')]");
}
