package com.android.selectors;

import org.openqa.selenium.By;

public class Stash_ModifyStashSelectors {

	public static By txtModifyStash=By.xpath("//*[@class='android.widget.TextView' and @text='Modify Stash']");

	public static By txtStashFor=By.xpath("//*[@text='Stash for']");

	public static By edittxtStashFor=By.xpath("(//*[@class='android.widget.EditText'])[1]");

	public static By txtTargetamount=By.xpath("//*[@text='Target amount']");

	public static By edittxtTargetamount=By.xpath("(//*[@class='android.widget.EditText'])[2]");

	public static By btnSave=By.xpath("//*[@class='android.widget.TextView' and @text='Save']");

	public static By btnSaveTxtBox=By.xpath("//*[@class='android.widget.ScrollView']/following-sibling::android.view.ViewGroup/child::android.view.ViewGroup");

	public static By txtMinAmountCanBePeso=By.xpath("//*[@class='android.widget.TextView' and @text='Min amount can be 1000 Peso.']");

	public static By txtPleaseEnterAValidStashName=By.xpath("//*[@class='android.widget.TextView' and @text='Please enter a valid stash name']");

	public static By txtNoEnoughBalance=By.xpath("//*[@class='android.widget.TextView' and @text='No enough balance in Stash account']");

	

	

}
