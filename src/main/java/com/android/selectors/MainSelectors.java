package com.android.selectors;

import org.openqa.selenium.By;

public class MainSelectors {

    public static By txtTotalStashBalance = By.xpath("//android.widget.TextView[@text='Total Stash balance']");

    public static By txtStashes = By.xpath("//android.widget.TextView[@text='Stashes']");

    public static By txtPutYourStashInCash = By.xpath("//android.widget.TextView[@text='Put your cash in a Stash!']");

    public static By txtYourTonikAccount = By.xpath("//android.widget.TextView[@text='Your tonik account']");
    
    public static By textStashes =By.xpath("//*[@class='android.widget.TextView' and @text='Stashes']");

	public static By txtTonikAccountBalance = By.xpath("//android.widget.TextView[@text='Your tonik account']/following-sibling::android.widget.TextView[1]");

    //
	
	public static By txtIndividualstash=By.xpath("//*[@class='android.widget.TextView' and @text='Individual Stash']");
	
	public static By BtnAlright=By.xpath("//*[@class='android.widget.TextView' and @text='Alright']");
	
	public static By txtIDeserveStash=By.xpath("//*[@class='android.widget.TextView' and @text='#IDeserveThis']");
	
	public static By BtnAmazing= By.xpath("//*[@class='android.widget.TextView' and @text='Amazing!']");
	
	public static By txtReboundStash= By.xpath("//*[@class='android.widget.TextView' and @text='#Rebound']");
	
	public static By BtnReally=By.xpath("//*[@class='android.widget.TextView' and @text='Really?']");
	
	public static By txtGoalsStash=By.xpath("//*[@class='android.widget.TextView' and @text='#Goals']");
	
	public static By BtnobjCool =By.xpath("//*[@class='android.widget.TextView' and @text='Cool!']");
	
	public static By txtWerkitstash= By.xpath("//*[@class='android.widget.TextView' and @text='#WerkIt']");
	
	public static By BtnLetsstartStashing=By.xpath("//*[@class='android.widget.TextView' and @text='Let’s start stashing!']");

}
