package ui.pages;

import com.github.wasiqb.boyka.builders.Locator;
import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class ConfirmOrderPage {
    private static final ConfirmOrderPage INSTANCE = new ConfirmOrderPage();

    public static ConfirmOrderPage confirmOrderPage() {
        return INSTANCE;
    }

    private final Locator confirmOrderBtn = Locator.buildLocator()
            .web(By.id("button-confirm"))
            .name("Confirm Order")
            .build();

    private final Locator pageHeader = Locator.buildLocator()
            .web(By.tagName("h1"))
            .name("Page Header")
            .build();

    private final Locator productName = Locator.buildLocator()
            .web(By.cssSelector("#content > div.table-responsive > table > tbody > tr > td:nth-child(1)"))
            .name("Product Name")
            .build();

    private final Locator shippingAddress = Locator.buildLocator()
            .web(By.cssSelector("#content > div.row > div:nth-child(2) > div > div"))
            .name("Shipping Address")
            .build();

    private final Locator unitPrice = Locator.buildLocator()
            .web(By.cssSelector("#content > div.table-responsive > table > tbody > tr > td:nth-child(4)"))
            .name("Unit Price")
            .build();
}
