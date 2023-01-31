package com.business.tonikPages;

import org.testng.Assert;

import com.android.selectors.WelcomeSelectors;

public class WelcomePage extends BasePage {

    public WelcomePage(String Application) throws InterruptedException {
        //super(Application);
    }

    public WelcomePage() throws InterruptedException {
        super();
    }

    /**
     * Business method for RingPay Application Launch
     *
     */

    public void WelcomeRingPayAppLaunch() throws Exception {
        extent.HeaderChildNode("RingPay App Launch");

        explicitWaitVisibility(WelcomeSelectors.txtWelcomeToTonix,60);
        if(verifyElementPresent(WelcomeSelectors.txtWelcomeToTonix, "Welcome to Tonik, the first neobank in the Philippines.")) {
            String camPermHeaderTxt = getText(WelcomeSelectors.txtWelcomeToTonix);
            Assert.assertEquals(camPermHeaderTxt, "Welcome to Tonik, the first neobank in the Philippines.");
            logger.info("Camera Permission required popup");
            extent.extentLoggerPass("Camera Permission popup", "Camera Permission required popup");
        }
        else {
            logger.info("Popup is not displayed");
            extent.extentLoggerFail("Allow popup", "Allow popup not displayed");
        }
    }
}
