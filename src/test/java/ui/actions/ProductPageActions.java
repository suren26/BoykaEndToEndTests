package ui.actions;

import static com.github.wasiqb.boyka.actions.elements.ClickableActions.withMouse;
import static com.github.wasiqb.boyka.actions.elements.ElementActions.onElement;
import static ui.pages.ProductPage.productPage;
import static java.text.MessageFormat.format;

public class ProductPageActions {
    public ProductPageActions addPalmTreoCameraLensToCart() {
        withMouse(productPage().getPalmTreoCameraLens()).hover();
        withMouse(productPage().getAddToCartBtn()).hover();
        withMouse(productPage().getAddToCartBtn()).click();
        return this;
    }

    public CheckoutPageActions checkoutProduct() {
        withMouse(productPage().getCheckoutBtn()).click();
        return new CheckoutPageActions();
    }

    public ProductPageActions verifySuccessMessage() {
        final String expectedSuccessMessage = "{0}\n{1}\n{2}\n{3}\n{4}";
        System.out.println("Success message text is " + onElement(productPage().getSuccessMessage()).getText());
        onElement(productPage().getSuccessMessage()).verifyText()
                .isEqualTo(
                        format(expectedSuccessMessage, "Success: You have added", "Palm Treo Pro", "to your", "shopping cart",
                                "!"));
        return this;
    }
}
