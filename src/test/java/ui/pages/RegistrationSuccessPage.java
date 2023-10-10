package ui.pages;

import com.github.wasiqb.boyka.builders.Locator;
import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class RegistrationSuccessPage {
    private static final RegistrationSuccessPage INSTANCE = new RegistrationSuccessPage();

    public static RegistrationSuccessPage registrationSuccessPage() {
        return INSTANCE;
    }

    private final Locator continueBtn = Locator.buildLocator()
            .web(By.cssSelector(".buttons > a.btn-primary"))
            .name("Continue Button")
            .build();
    private final Locator pageHeader = Locator.buildLocator()
            .web(By.tagName("h1"))
            .name("Page Header")
            .build();
}
