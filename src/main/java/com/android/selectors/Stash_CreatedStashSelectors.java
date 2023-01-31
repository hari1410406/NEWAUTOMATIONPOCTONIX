package com.android.selectors;

import org.openqa.selenium.By;

public class Stash_CreatedStashSelectors {
	
	//Created stash selectors when No amount is added to stash Page selectors
	public static By imgCreatedStash=By.xpath("//*[@class='android.widget.ScrollView']/child::android.view.ViewGroup/descendant::android.widget.ImageView");
	
	public static By txtAddToStashBox=By.xpath("(//*[@class='android.widget.ScrollView']/child::android.view.ViewGroup/child::android.view.ViewGroup)[5]");
	
	public static By txtManageBox=By.xpath("(//*[@class='android.widget.ScrollView']/child::android.view.ViewGroup/child::android.view.ViewGroup)[6]");

	public static By txtManage1=By.xpath("//*[@class='android.widget.TextView' and @text='Manage']");
	
	public static By txtNoContribution=By.xpath("//*[@class='android.widget.TextView' and @text='No contribution has been made yet. Did you know? This Stash has a higher interest compared to your Tonik account?']");
	
	
	public static By txtTodayDate=By.xpath("//*[@class='android.widget.TextView' and contains(@text,'Today')]");
	
	public static By txtDate=By.xpath("//*[@class='android.widget.TextView' and @text='CREDIT']/parent::android.view.ViewGroup/parent::android.view.ViewGroup/preceding-sibling::android.view.ViewGroup/child::android.widget.TextView");
	
	public static By txtMyselfCreditName=By.xpath("//*[@class='android.widget.TextView' and contains(@text,'Myself')]");
	
	public static By txtCredit=By.xpath("//*[@class='android.widget.TextView' and contains(@text,'CREDIT')]");
	
	public static By txtCreditAmount=By.xpath("//*[@class='android.widget.TextView' and contains(@text,'CREDIT')]/following-sibling::android.widget.TextView");
}
