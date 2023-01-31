package com.android.selectors;

import org.openqa.selenium.By;

  public class Stash_StashDetailsSelectors {

	public static  By txtStashID = By.xpath("//*[@class='android.widget.TextView' and @text='Stash ID']/following-sibling::android.widget.TextView");

	public static By txtStartingDate=By.xpath("//*[@class='android.widget.TextView' and @text='Starting date']/following-sibling::android.widget.TextView");

	public static By txtTargetAmount=By.xpath("//*[@class='android.widget.TextView' and @text='Target amount']/following-sibling::android.widget.TextView");

	public static By txtStashDetailsHeader=By.xpath("//*[@class='android.widget.TextView' and @text='Stash details']");




}
