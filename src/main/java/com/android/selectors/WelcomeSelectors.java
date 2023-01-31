package com.android.selectors;

import org.openqa.selenium.By;

public class WelcomeSelectors {

    //Welcome Page 1 - Text - Welcome to Tonik, the first neobank in the Philippine
    public static By txtWelcomeToTonix = By.xpath("//*[@text='Welcome to Tonik, the first neobank in the Philippines.']");

    //Welcome Page 1 - Button(Text) - What’s a neobank?
    public static By btnWhatsNeobank = By.xpath("//*[@text='What’s a neobank?']");

    // Permission popup - ALLOW button
    public static By btnPermissionAllow = By.xpath("//*[@resource-id='com.android.packageinstaller:id/permission_allow_button']");

    //Permission popup - DENY button
    public static By btnPermissionDeny = By.xpath("//*[@resource-id='com.android.packageinstaller:id/permission_deny_button']");

    // Permission popup - Message
    public static By txtPermissionMessage = By.xpath("//android.widget.TextView[@resource-id='com.android.packageinstaller:id/permission_message']");

    // Permission popup - Message - manage phone calls
    public static By txtPermissionPhoneCalls = By.xpath("//*[contains(@text,'Allow TONIK to make and manage phone calls?')]");

    //Permission popup - Message - access device location
    public static By txtPermissionDeviceLocation = By.xpath("//*[contains(@text,'Allow TONIK to access this device\'s location?')]");

    //Permission popup - Message - access photos, media and files
    public static By txtPermissionFiles = By.xpath("//*[contains(@text,'to access photos, media, and files on your device')]");
    

}
