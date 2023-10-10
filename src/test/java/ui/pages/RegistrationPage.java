package ui.pages;

import com.github.wasiqb.boyka.builders.Locator;
import ui.data.RegisterUserData;
import ui.data.TestDataBuilder;
import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class RegistrationPage {
    private static final RegistrationPage INSTANCE = new RegistrationPage();

    public static RegistrationPage registrationPage() {
        return INSTANCE;
    }

    private final Locator agreePrivacyPolicyField = Locator.buildLocator()
            .web(By.cssSelector("#input-agree +label"))
            .name("Agree privacy policy")
            .build();
    private final Locator continueBtn = Locator.buildLocator()
            .web(By.cssSelector("input.btn-primary"))
            .name("Continue Button")
            .build();
    private final Locator pageHeader = Locator.buildLocator()
            .web(By.tagName("h1"))
            .name("Page Header")
            .build();
    private final RegisterUserData registerUserData;
    private final Locator registrationForm = Locator.buildLocator()
            .web(By.id("content"))
            .name("Registration Form")
            .build();
    private final Locator lastNameField = Locator.buildLocator()
            .web(By.id("input-lastname"))
            .name("Last Name")
            .parent(this.registrationForm)
            .build();
    private final Locator firstNameField = Locator.buildLocator()
            .web(By.id("input-firstname"))
            .name("First Name")
            .parent(this.registrationForm)
            .build();
    private final Locator emailField = Locator.buildLocator()
            .parent(this.registrationForm)
            .name("Email")
            .web(By.id("input-email"))
            .build();
    private final Locator confirmPasswordField = Locator.buildLocator()
            .web(By.id("input-confirm"))
            .name("Confirm password")
            .parent(this.registrationForm)
            .build();
    private final Locator passwordField = Locator.buildLocator()
            .web(By.id("input-password"))
            .name("Password")
            .parent(this.registrationForm)
            .build();
    private final Locator telephoneField = Locator.buildLocator()
            .web(By.id("input-telephone"))
            .name("Telephone")
            .parent(this.registrationForm)
            .build();

    private RegistrationPage() {
        this.registerUserData = TestDataBuilder.getRegisterUserData();
    }
}
