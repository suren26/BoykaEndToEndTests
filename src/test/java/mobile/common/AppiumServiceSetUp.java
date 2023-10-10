package mobile.common;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import lombok.Getter;

import java.io.File;

@Getter
public class AppiumServiceSetUp {
    private static AppiumDriverLocalService appiumService;

    public AppiumServiceSetUp(String deviceType) {
        if (deviceType.contains("android")) {
            appiumService = new AppiumServiceBuilder().withArgument(GeneralServerFlag.BASEPATH, "/wd/hub")
                    .withArgument(() -> "--allow-insecure", "chromedriver_autodownload")
                    .withLogFile(new File(System.getProperty("user.dir") + "/appiumLog.txt"))
                    .usingAnyFreePort()
                    .build();
        } else if (deviceType.contains("ios")) {
            appiumService = new AppiumServiceBuilder().withArgument(GeneralServerFlag.BASEPATH, "/wd/hub")
                    .withArgument(GeneralServerFlag.USE_PLUGINS, "element-wait")
                    .withLogFile(new File(System.getProperty("user.dir") + "/appiumLog.txt"))
                    .usingAnyFreePort()
                    .build();
        }
    }

    public AppiumDriverLocalService getAppiumService() {
        return appiumService;

    }
}
