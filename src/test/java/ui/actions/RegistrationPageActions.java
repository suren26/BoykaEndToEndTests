package ui.actions;

import static com.github.wasiqb.boyka.actions.elements.ClickableActions.withMouse;
import static com.github.wasiqb.boyka.actions.elements.ElementActions.onElement;
import static com.github.wasiqb.boyka.actions.elements.TextBoxActions.onTextBox;
import static ui.pages.RegistrationPage.registrationPage;

import ui.data.RegisterUserData;
import ui.data.TestDataBuilder;

public class RegistrationPageActions {
    private static final String PASSWORD = "Password@123";
    private final RegisterUserData registerUserData;

    public RegistrationPageActions() {
        this.registerUserData = TestDataBuilder.getRegisterUserData();
    }

    public RegistrationSuccessPageActions registerUser() {
        onTextBox(registrationPage().getFirstNameField()).enterText(this.registerUserData.getFirstName());
        onTextBox(registrationPage().getLastNameField()).enterText(this.registerUserData.getLastName());
        onTextBox(registrationPage().getEmailField()).enterText(this.registerUserData.getEmail());
        onTextBox(registrationPage().getTelephoneField()).enterText(this.registerUserData.getTelephone());
        onTextBox(registrationPage().getPasswordField()).enterText(PASSWORD);
        onTextBox(registrationPage().getConfirmPasswordField()).enterText(PASSWORD);
        withMouse(registrationPage().getAgreePrivacyPolicyField()).click();
        withMouse(registrationPage().getContinueBtn()).click();
        return new RegistrationSuccessPageActions();
    }

    public RegistrationPageActions verifyPageHeader() {
        onElement(registrationPage().getPageHeader()).verifyText()
                .isEqualTo("Register Account");
        return this;
    }
}
