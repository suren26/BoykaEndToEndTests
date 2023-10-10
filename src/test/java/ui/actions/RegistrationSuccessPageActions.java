package ui.actions;

import static com.github.wasiqb.boyka.actions.elements.ClickableActions.withMouse;
import static com.github.wasiqb.boyka.actions.elements.ElementActions.onElement;
import static ui.pages.RegistrationSuccessPage.registrationSuccessPage;

public class RegistrationSuccessPageActions {
    public MyAccountPageActions continueToMyAccount() {
        withMouse(registrationSuccessPage().getContinueBtn()).click();
        return new MyAccountPageActions();
    }

    public RegistrationSuccessPageActions verifySuccessfulRegistration() {
        onElement(registrationSuccessPage().getPageHeader()).verifyText()
                .isEqualTo("Your Account Has Been Created!");
        return this;
    }
}
