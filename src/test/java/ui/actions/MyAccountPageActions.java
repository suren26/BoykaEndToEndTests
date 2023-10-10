package ui.actions;

import static com.github.wasiqb.boyka.actions.elements.ElementActions.onElement;
import static ui.pages.MyAccountPage.myAccountPage;

public class MyAccountPageActions {
    public void verifyPageHeader() {
        onElement(myAccountPage().getPageHeader()).verifyText()
                .isEqualTo("My Account");
    }
}
