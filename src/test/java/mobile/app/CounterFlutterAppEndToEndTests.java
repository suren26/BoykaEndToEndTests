package mobile.app;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import mobile.common.AndroidSetUp;
import mobile.common.AppiumServiceSetUp;
import mobile.common.IOSSetUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

public class CounterFlutterAppEndToEndTests {
    AppiumDriverLocalService appiumService;
    private WebDriver driver;
    private IOSSetUp iosSetUp = new IOSSetUp();
    private AndroidSetUp androidSetUp;
    WebDriverWait wait;

    @BeforeClass
    @Parameters({"driverKey"})
    public void setUp(String driverKey) throws MalformedURLException {
        appiumService = new AppiumServiceSetUp(driverKey).getAppiumService();
        appiumService.clearOutPutStreams();
        appiumService.start();
        if (driverKey.contains("android")) {
            androidSetUp = new AndroidSetUp("app");
            driver = androidSetUp.getAndroidDriver(appiumService);
        } else if (driverKey.contains("ios")) {
            driver = iosSetUp.getIOSDriver(appiumService);
            wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        }

    }

    @Test
    public void counterTestDisplay() {
        int count;
        System.out.println("----Inside Counter Test Display----");
        final WebElement counterText = driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"You have pushed the button this many times:\"]/parent::android.view.View/android.view.View[2]"));
        assert (counterText.isDisplayed());
        System.out.println("Verified the presence of content text : " + counterText.getAttribute("content-desc"));
        count = getCounterValue();
        System.out.println("Counter present with value : " + count);
        final WebElement counter = driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"counter\"]"));
        assert (counter.isDisplayed());
        System.out.println("----Exiting Counter Test Display----");
    }

    @Test(dependsOnMethods = {"counterTestDisplay"})
    public void counterTestFunctionality() throws InterruptedException {
        int count;
        System.out.println("----Inside Counter Test Functionality----");
        count = getCounterValue();
        final WebElement counter = driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"counter\"]"));
        counter.click();
        Thread.sleep(2000);
        System.out.println("Performed counter click");
        assertEquals(getCounterValue(), count + 1);
        System.out.println("Counter functionality working");
        System.out.println("----Exiting Counter Test Functionality----");
    }

    public int getCounterValue() {
        final WebElement counterValue = driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"You have pushed the button this many times:\"]/following-sibling::android.view.View[1]"));
        System.out.println("Counter Value :" + counterValue.getAttribute("content-desc"));
        return Integer.parseInt(counterValue.getAttribute("content-desc"));
    }

}
