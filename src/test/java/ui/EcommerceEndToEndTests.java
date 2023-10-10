package ui;

import static com.github.wasiqb.boyka.actions.drivers.NavigateActions.navigate;
import static com.github.wasiqb.boyka.actions.drivers.WindowActions.onWindow;
import static com.github.wasiqb.boyka.manager.ParallelSession.clearSession;
import static com.github.wasiqb.boyka.manager.ParallelSession.createSession;
import static ui.actions.CheckoutPageActions.checkoutPageActions;
import static ui.actions.ConfirmOrderPageActions.confirmOrderPageActions;
import static ui.actions.HomePageActions.homePageActions;
import static ui.actions.OrderSuccessPageActions.orderSuccessPageActions;

import com.github.wasiqb.boyka.enums.PlatformType;
import ui.data.BillingData;
import ui.data.TestDataBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class EcommerceEndToEndTests {
    private BillingData billingData;
    private String unitPriceOfCameraLens;

    @BeforeClass(description = "Setup test class")
    @Parameters({"driverKey"})
    public void setupTestClass(final String driverKey) {
        final String url = "https://ecommerce-playground.lambdatest.io/";
        createSession("User 1", PlatformType.WEB, driverKey);
        this.billingData = TestDataBuilder.getBillingData();
        navigate().to(url);
    }

    @AfterClass(description = "Tear down test class")
    public void tearDownTestClass() {
        clearSession();
    }

    @Test(dependsOnMethods = "testRegisterUser")
    public void testAddProductToCart() {
        try {
            homePageActions().shopByCategory("Components")
                    .addPalmTreoCameraLensToCart()
                    .verifySuccessMessage()
                    .checkoutProduct();
        } finally {
            onWindow().takeScreenshot();
        }
    }

    @Test(dependsOnMethods = "testAddProductToCart")
    public void testCheckoutProduct() {
        this.unitPriceOfCameraLens = checkoutPageActions().textOfUnitPriceOfCameraLens();
        System.out.println("Unit price of Camera Lens is: " + this.unitPriceOfCameraLens);
        checkoutPageActions().setBillingAddress(this.billingData)
                .checkoutProduct();
    }

    @Test(dependsOnMethods = "testCheckoutProduct")
    public void testConfirmOrder() {
        confirmOrderPageActions().verifyPageHeader()
                .verifyProductName()
                .verifyUnitPrice(this.unitPriceOfCameraLens)
                .verifyShippingAddress(this.billingData)
                .confirmOrder();
    }

    @Test(dependsOnMethods = "testConfirmOrder")
    public void testOrderSuccess() {
        orderSuccessPageActions().verifySuccessMessage()
                .continueToHomePage();
    }

    @Test(description = "Test login functionality")
    public void testRegisterUser() {
        homePageActions().openUserRegistrationPage()
                .verifyPageHeader()
                .registerUser()
                .verifySuccessfulRegistration()
                .continueToMyAccount()
                .verifyPageHeader();
    }
}
