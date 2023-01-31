package com.business.tonikPages;

import com.android.selectors.Stash_SoloStashCreatedSelectors;

public class Stash_SoloStashCreatedPage extends BasePage 
{
	public Stash_SoloStashCreatedPage() throws InterruptedException 
	{
		super();
	}
	  /**
	   * This Business method is to Confirmation of Solo Stash created successfully.
	   *  
	   */
	   public void soloStashCreated() throws Exception 
	   {
		   extent.HeaderChildNode("Solo Stash created Successfully");
		   waitTime(2000);
		   if(verifyElementPresent(Stash_SoloStashCreatedSelectors.txtSoloStashCreated, "Solo Stash created text"))
		   {
			   String actualMessageOfSoloStashCreated = getText(Stash_SoloStashCreatedSelectors.txtSoloStashCreated);
			   System.out.println(actualMessageOfSoloStashCreated);
			   verifyElementPresent(Stash_SoloStashCreatedSelectors.txtAddManyMore, "You add Many More text");
			   String actualMessageOfAddManyMore = getText(Stash_SoloStashCreatedSelectors.txtAddManyMore);
			   System.out.println(actualMessageOfAddManyMore);
		   }
		   if(verifyElementPresentAndClick(Stash_SoloStashCreatedSelectors.btnDone, "Done button")) 
		   {
			   logger.info("Solo stash is created successfully");
			   extent.extentLoggerPass("Solo Stash created Successfully", "Solo Stash created text is displayed and Clicked on Done button in Solo stash created  page");
		   }
		   else
		   {
			   extent.extentLoggerFail("Solo Stash created Successfully", "Solo Stash created text is not displayed in Solo stash created  page");
		   }	
	   }
}
