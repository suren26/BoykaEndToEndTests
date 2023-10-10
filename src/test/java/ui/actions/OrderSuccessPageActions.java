package ui.actions;

import static com.github.wasiqb.boyka.actions.drivers.DriverActions.withDriver;
import static com.github.wasiqb.boyka.actions.elements.ClickableActions.withMouse;
import static com.github.wasiqb.boyka.actions.elements.ElementActions.onElement;
import static ui.pages.OrderSuccessPage.orderSuccessPage;

import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrderSuccessPageActions {
    public static OrderSuccessPageActions orderSuccessPageActions() {
        return new OrderSuccessPageActions();
    }

    public void continueToHomePage() {
        withMouse(orderSuccessPage().getContinueBtn()).click();
    }

    public OrderSuccessPageActions verifySuccessMessage() {
        withDriver().waitUntil(ExpectedConditions.textToBePresentInElementLocated(
                orderSuccessPage().getSuccessMessage()
                        .getWeb(), "Your order has been placed!"));
        onElement(orderSuccessPage().getSuccessMessage()).verifyText()
                .isEqualTo("Your order has been placed!");
        return this;
    }
}
