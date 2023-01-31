package com.android.selectors;

import org.openqa.selenium.By;

public class Stash_StashCloseSelectors {
	
	public static By txtBrokeTheStash=By.xpath("//*[@class='android.widget.TextView' and @text='You broke the Stash!']");
	
	public static By txtJustKiddingYouHaveClosedIt=By.xpath("//*[@class='android.widget.TextView' and contains(@text,'Your Stash balance has now been moved to your account. Sweet!')]");

	public static By btnDone=By.xpath("//*[@text='Done']");
	
}
