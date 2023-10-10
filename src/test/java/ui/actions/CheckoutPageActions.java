package ui.actions;

import static com.github.wasiqb.boyka.actions.elements.ClickableActions.withMouse;
import static com.github.wasiqb.boyka.actions.elements.DropDownActions.onDropDown;
import static com.github.wasiqb.boyka.actions.elements.ElementActions.onElement;
import static com.github.wasiqb.boyka.actions.elements.TextBoxActions.onTextBox;
import static ui.pages.CheckoutPage.checkoutPage;

import ui.data.BillingData;

public class CheckoutPageActions {
    public static CheckoutPageActions checkoutPageActions() {
        return new CheckoutPageActions();
    }

    public ConfirmOrderPageActions checkoutProduct() {
        withMouse(checkoutPage().getAgreeTermsAndConditionsField()).click();
        withMouse(checkoutPage().getContinueBtn()).click();
        return new ConfirmOrderPageActions();
    }

    public CheckoutPageActions setBillingAddress(final BillingData billingData) {
        onTextBox(checkoutPage().getFirstNameField()).enterText(billingData.getFirstName());
        onTextBox(checkoutPage().getLastNameField()).enterText(billingData.getLastName());
        onTextBox(checkoutPage().getAddressLineOneField()).enterText(billingData.getAddressLineOne());
        onTextBox(checkoutPage().getCityField()).enterText(billingData.getCity());
        onTextBox(checkoutPage().getPostCodeField()).enterText(billingData.getPostCode());
        onDropDown(checkoutPage().getCountryField()).selectByText(billingData.getCountry());
        onDropDown(checkoutPage().getStateField()).selectByText(billingData.getState());
        return this;
    }

    public String textOfUnitPriceOfCameraLens() {
        return onElement(checkoutPage().getGetUnitPriceOfCameraLens()).getText();
    }
}
