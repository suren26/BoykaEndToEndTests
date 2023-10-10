package mobile.common;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;

@Getter
public class AndroidSetUp {
    private static UiAutomator2Options uiAutomator2Options;
    private static WebDriver driver;

    public AndroidSetUp(String activity) {
        if (activity.contains("app")) {
            System.out.println("Setting Options for Android Flutter App");
            uiAutomator2Options = new UiAutomator2Options()
                    .setDeviceName("android")
                    .setAutomationName("UiAutomator2")
                    .setAppActivity("com.example.flutter_application_1.MainActivity");
        } else if (activity.contains("CHROME")) {
            System.out.println("Setting Options for Chrome");
            uiAutomator2Options = new UiAutomator2Options()
                    .setDeviceName("android")
                    .setAutomationName("UiAutomator2")
                    .withBrowserName("CHROME");
        }
    }

    public WebDriver getAndroidDriver(AppiumDriverLocalService appiumService) throws MalformedURLException {
        driver = new AndroidDriver(new URL(appiumService.getUrl().toString()), uiAutomator2Options);
        return driver;
    }
}
