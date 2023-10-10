package ui.pages;

import static java.text.MessageFormat.format;

import com.github.wasiqb.boyka.builders.Locator;
import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class HomePage {
    private static final HomePage INSTANCE = new HomePage();

    public static HomePage homePage() {
        return INSTANCE;
    }

    private final Locator loginLink = Locator.buildLocator()
            .web(By.linkText("Login"))
            .name("Login")
            .build();
    private final Locator openMyAccountMenu = Locator.buildLocator()
            .web(By.linkText("My account"))
            .name("Open My Account")
            .build();
    private final Locator registerLink = Locator.buildLocator()
            .web(By.linkText("Register"))
            .name("Register")
            .build();
    private final Locator shopByCategory = Locator.buildLocator()
            .web(By.linkText("Shop by Category"))
            .name("Show By Category")
            .build();

    public Locator selectCategory(final String linkName) {
        return Locator.buildLocator()
                .web(By.linkText(linkName))
                .name(format("Select Category {0}", linkName))
                .build();
    }
}
