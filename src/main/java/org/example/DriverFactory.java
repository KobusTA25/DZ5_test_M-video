package org.example;

import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;


import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_ACTIVITY;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_PACKAGE;
public class DriverFactory {
    public AndroidDriver setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability(APP_PACKAGE, "com.anydog.t2m.test");
        capabilities.setCapability(APP_ACTIVITY, "com.anydog.t2m.test.MainActivity");

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        return new AndroidDriver(remoteUrl, capabilities);
    }
}
