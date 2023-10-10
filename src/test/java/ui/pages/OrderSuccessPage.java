package ui.pages;

import com.github.wasiqb.boyka.builders.Locator;
import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class OrderSuccessPage {
    private static final OrderSuccessPage INSTANCE = new OrderSuccessPage();

    public static OrderSuccessPage orderSuccessPage() {
        return INSTANCE;
    }

    private final Locator continueBtn = Locator.buildLocator()
            .name("Continue Button")
            .web(By.cssSelector("#content > div > a"))
            .build();

    private final Locator successMessage = Locator.buildLocator()
            .name("Success Message")
            .web(By.tagName("h1"))
            .build();
}
