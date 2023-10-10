package ui.actions;

import static com.github.wasiqb.boyka.actions.elements.ClickableActions.withMouse;
import static ui.pages.HomePage.homePage;

public class HomePageActions {
    public static HomePageActions homePageActions() {
        return new HomePageActions();
    }

    public RegistrationPageActions openUserRegistrationPage() {
        withMouse(homePage().getOpenMyAccountMenu()).click();
        withMouse(homePage().getRegisterLink()).click();
        return new RegistrationPageActions();
    }

    public ProductPageActions shopByCategory(final String linkName) {
        withMouse(homePage().getShopByCategory()).click();
        withMouse(homePage().selectCategory(linkName)).click();
        return new ProductPageActions();
    }
}
