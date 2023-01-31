package com.android.selectors;

import org.openqa.selenium.By;

public class LoginSelectors {

    //Page title
    public static By txtPageTitle = By.xpath("//android.widget.TextView[@resource-id='com.tonik.mobile:id/title']");

    //Page info
    public static By txtPageInfo = By.xpath("//android.widget.TextView[@resource-id='com.tonik.mobile:id/info']");

    //Password edit field
    public static By edtPassword = By.xpath("//android.widget.EditText[@resource-id='com.tonik.mobile:id/pin']");

    //Password eye icon
    public static By imgEyeIcon = By.xpath("//android.widget.ImageButton[@resource-id='com.tonik.mobile:id/text_input_end_icon']");

    //Forgot Password
    public static By btnForgotPassword = By.xpath("//android.widget.Button[@resource-id='com.tonik.mobile:id/forgotpwdbutton']");

    //Log-in
    public static By btnLogin = By.xpath("//android.widget.Button[@resource-id='com.tonik.mobile:id/loginbutton']");



}
