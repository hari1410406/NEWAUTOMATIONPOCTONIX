package com.android.selectors;

import org.openqa.selenium.By;

public class Stash_ManageStashSelectors {
	
	public static By txtManageStash =By.xpath("//*[@class='android.widget.TextView' and @text='Manage Stash']");
	
	public static By txtStashDetails=By.xpath("//*[@class='android.widget.TextView' and contains(@text,'Stash details')]");
	
	public static By txtModify=By.xpath("//*[@class='android.widget.TextView' and contains(@text,' Modify')]");
	
	public static By txtWithdrawToyourTONIKAccount=By.xpath("//*[@class='android.widget.TextView' and contains(@text,' Withdraw to your TONIK Account')]");
	
	public static By btnClose=By.xpath("//*[@class='android.widget.TextView' and @text=' Close']");
	
	public static By txtYesCloseStash= By.xpath("//*[@class='android.widget.TextView' and @text='Yes, close the stash']");
	
	public static By txtAreYouSureConfirmation=By.xpath("//*[@class='android.widget.TextView' and contains(@text='Are you sure you want to close this Stash? All the contributions so far will be moved to your Tonik account.')]");

	public static By btnStay=By.xpath("//*[@class='android.widget.TextView' and @text='Stay']");
	
	public static By btnDone=By.xpath("//*[contains(@text,'Done')]");
}
