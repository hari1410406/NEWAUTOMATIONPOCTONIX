package com.android.selectors;

import org.openqa.selenium.By;

public class Stash_UpdateYourStashSelectors {
	
	public static By txtYourUpdatedYourStash=By.xpath("//*[@class='android.widget.TextView' and @text='You updated your Stash.']");

	public static By txtThanksForUpdating=By.xpath("//*[@class='android.widget.TextView' and contains(@text,'when you go out with someone who is better looking than you. Thanks for updating.')]");

	public static By btnDone=By.xpath("//*[@text='Done']");
}
