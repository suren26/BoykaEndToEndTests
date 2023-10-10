package ui.pages;

import static com.github.wasiqb.boyka.builders.Locator.buildLocator;

import com.github.wasiqb.boyka.builders.Locator;
import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class CheckoutPage {
    private static final CheckoutPage INSTANCE = new CheckoutPage();

    public static CheckoutPage checkoutPage() {
        return INSTANCE;
    }

    private final Locator agreeTermsAndConditionsField = buildLocator().web(By.cssSelector("#input-agree +label"))
            .name("Agree terms condition")
            .build();
    private final Locator continueBtn = buildLocator().web(By.cssSelector("button#button-save"))
            .name("Continue Button")
            .build();
    private final Locator getUnitPriceOfCameraLens = buildLocator().web(
                    By.cssSelector("#checkout-total > tbody > tr:nth-child(1) > td.text-right"))
            .name("Unit price")
            .build();
    private final Locator paymentAddressForm = buildLocator().web(By.id("payment-address"))
            .name("Payment Address Form")
            .build();
    private final Locator firstNameField = buildLocator().web(By.id("input-payment-firstname"))
            .parent(this.paymentAddressForm)
            .name("First Name")
            .build();
    private final Locator lastNameField = buildLocator().web(By.id("input-payment-lastname"))
            .parent(this.paymentAddressForm)
            .name("Last Name")
            .build();
    private final Locator addressLineOneField = buildLocator().web(By.id("input-payment-address-1"))
            .parent(this.paymentAddressForm)
            .name("Address 1")
            .build();
    private final Locator cityField = buildLocator().web(By.id("input-payment-city"))
            .parent(this.paymentAddressForm)
            .name("City")
            .build();
    private final Locator countryField = buildLocator().web(By.id("input-payment-country"))
            .parent(this.paymentAddressForm)
            .name("Country")
            .build();
    private final Locator postCodeField = buildLocator().web(By.id("input-payment-postcode"))
            .parent(this.paymentAddressForm)
            .name("Payment Address")
            .build();
    private final Locator stateField = buildLocator().web(By.id("input-payment-zone"))
            .parent(this.paymentAddressForm)
            .name("State")
            .build();
}
