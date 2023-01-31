package com.android.selectors;

import org.openqa.selenium.By;

public class Stash_SetupYourStashSelectors {
	
	// Setup your stash page
	public static By txtSetupYourStash=By.xpath("//*[@class='android.widget.TextView' and @text='Setup your Stash']");
	
	public static By txtStashFor=By.xpath("//*[@text='Stash for']");
	
	public static By edittxtStashFor=By.xpath("(//*[@class='android.widget.EditText'])[1]");
	
	public static By txtTargetamount=By.xpath("//*[@text='Target amount']");
	
	public static By edittxtTargetamount=By.xpath("(//*[@class='android.widget.EditText'])[2]");
	
	public static By btnNext=By.xpath("//*[@class='android.view.ViewGroup']/child::android.widget.TextView[@text='Next']");
	
}
