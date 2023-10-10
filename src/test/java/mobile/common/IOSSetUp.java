package mobile.common;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class IOSSetUp {
    final XCUITestOptions xcuiTestOptions;
    WebDriver driver;

    public IOSSetUp() {
        xcuiTestOptions = new XCUITestOptions()
                .setPlatformName("iOS")
                .setDeviceName("iPhone 11")
                //.setPlatformVersion("16.4")
                .setAutomationName(AutomationName.IOS_XCUI_TEST)
                .setUdid("")
                .setBundleId("com.demo.wda");
    }

    public WebDriver getIOSDriver(AppiumDriverLocalService appiumService) throws MalformedURLException {
        driver = new IOSDriver(new URL(appiumService.getUrl().toString()), xcuiTestOptions);
        return driver;
    }
}
