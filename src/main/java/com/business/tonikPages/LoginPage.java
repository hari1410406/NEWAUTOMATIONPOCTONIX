package com.business.tonikPages;

import com.android.selectors.LoginSelectors;
import org.testng.Assert;

public class LoginPage extends BasePage {

    public LoginPage() throws InterruptedException {
        super();
    }

    /**
     * Perform login into application
     * Entering password stored in testdata.properties - password field and clicking on login button
     */
    public void performLogin() throws Exception {
        extent.HeaderChildNode("Tonik Login Page");

        if(waitForElementToBePresent(LoginSelectors.edtPassword, 60,"Password edit field")) {
            String camPermHeaderTxt = getText(LoginSelectors.edtPassword);
            Assert.assertEquals(camPermHeaderTxt, "Password");
            click(LoginSelectors.edtPassword, "Password field");
            type(LoginSelectors.edtPassword  , prop.getproperty("password"), "Enter secret code");
            //waitForElementAndClickIfPresent()
            waitForElementAndClickIfPresent(LoginSelectors.btnLogin, 20,"Log in button");
            logger.info("Logging into Tonik app");
            extent.extentLoggerPass("Login Page", "Clicked on Login button after entering password");
        }
        else {
            logger.info("Login page not loaded");
            extent.extentLoggerFail("Login page", "Login page is not loaded successfully");
        }
    }
}
