package ui.actions;

import static com.github.wasiqb.boyka.actions.elements.ClickableActions.withMouse;
import static com.github.wasiqb.boyka.actions.elements.ElementActions.onElement;
import static ui.pages.ConfirmOrderPage.confirmOrderPage;

import java.text.MessageFormat;

import ui.data.BillingData;

public class ConfirmOrderPageActions {
    public static ConfirmOrderPageActions confirmOrderPageActions() {
        return new ConfirmOrderPageActions();
    }

    public OrderSuccessPageActions confirmOrder() {
        withMouse(confirmOrderPage().getConfirmOrderBtn()).click();
        return new OrderSuccessPageActions();
    }

    public ConfirmOrderPageActions verifyPageHeader() {
        onElement(confirmOrderPage().getPageHeader()).verifyText()
                .isEqualTo("Confirm Order");
        return this;
    }

    public ConfirmOrderPageActions verifyProductName() {
        onElement(confirmOrderPage().getProductName()).verifyText()
                .isEqualTo("Palm Treo Pro");
        return this;
    }

    public ConfirmOrderPageActions verifyShippingAddress(final BillingData billingData) {
        final String expectedShippingAddress = "{0} {1}\n{2}\n{3} {4}\n{5},{6}";
        onElement(confirmOrderPage().getShippingAddress()).verifyText()
                .isEqualTo(
                        MessageFormat.format(expectedShippingAddress, billingData.getFirstName(), billingData.getLastName(),
                                billingData.getAddressLineOne(), billingData.getCity(), billingData.getPostCode(),
                                billingData.getState(), billingData.getCountry()));
        return this;
    }

    public ConfirmOrderPageActions verifyUnitPrice(final String unitPrice) {
        onElement(confirmOrderPage().getUnitPrice()).verifyText()
                .isEqualTo(unitPrice);
        return this;
    }
}
