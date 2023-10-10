package mobile.web;

import com.github.wasiqb.boyka.enums.PlatformType;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import mobile.common.AndroidSetUp;
import mobile.common.AppiumServiceSetUp;
import mobile.common.IOSSetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ui.data.BillingData;
import ui.data.TestDataBuilder;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static com.github.wasiqb.boyka.actions.drivers.NavigateActions.navigate;
import static com.github.wasiqb.boyka.manager.ParallelSession.createSession;
import static org.testng.AssertJUnit.assertEquals;

public class EcommerceMobileEndToEndTests {
    AppiumDriverLocalService appiumService;
    private WebDriver driver;
    private BillingData billingData;
    private IOSSetUp iosSetUp = new IOSSetUp();
    private AndroidSetUp androidSetUp;

    private WebDriverWait wait;

    @BeforeClass
    @Parameters({"driverKey"})
    public void setUp(String driverKey) throws MalformedURLException {
        appiumService = new AppiumServiceSetUp(driverKey).getAppiumService();
        appiumService.clearOutPutStreams();
        appiumService.start();
        if (driverKey.contains("android")) {
            System.out.println("----Setting Chrome Properties----");
            androidSetUp = new AndroidSetUp("CHROME");
            driver = androidSetUp.getAndroidDriver(appiumService);
        } else if (driverKey.contains("ios")) {
            driver = iosSetUp.getIOSDriver(appiumService);
            wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        }
    }

    @Test
    public void webApp() {
        System.out.println("----Inside webApp----");
        driver.get("https://ecommerce-playground.lambdatest.io/");
        final WebElement counter = driver.findElement(By.xpath("//i[@class='icon fas fa-user-cog']"));
        counter.click();
        System.out.println("----Exiting webApp----");
    }

    @AfterClass
    public void tearDown() {
        appiumService.stop();
    }
}


