package ui.pages;

import com.github.wasiqb.boyka.builders.Locator;
import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class MyAccountPage {
    private static final MyAccountPage INSTANCE = new MyAccountPage();

    public static MyAccountPage myAccountPage() {
        return INSTANCE;
    }

    private final Locator pageHeader = Locator.buildLocator()
            .web(By.tagName("h2"))
            .name("Page Header")
            .build();
}
