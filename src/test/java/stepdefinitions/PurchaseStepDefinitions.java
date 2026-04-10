package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.PurchaseData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import questions.CartBadgeCount;
import questions.ConfirmationMessage;
import tasks.AddProductsToCart;
import tasks.Checkout;
import tasks.FinishPurchase;
import tasks.GoToCart;
import tasks.Login;
import tasks.OpenTheApplication;
import utils.JsonDataReader;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class PurchaseStepDefinitions {

    private Actor user;
    private PurchaseData purchaseData;

    //enlace con los features

    @Before
    public void setup() {
        OnStage.setTheStage(new OnlineCast());
        user = OnStage.theActorCalled("QA User");
    }

    @Given("the purchase data for {string} is loaded")
    public void thePurchaseDataIsLoaded(String scenarioName) {
        purchaseData = JsonDataReader.getPurchaseData(scenarioName);
    }

    @Given("the user opens SauceDemo")
    public void openPage() {
        user.attemptsTo(OpenTheApplication.onSauceDemo());
    }

    @When("logs in")
    public void login() {
        user.attemptsTo(
                Login.withCredentials(
                        purchaseData.getUsername(),
                        purchaseData.getPassword()
                )
        );
    }

    @And("adds products to the cart")
    public void addsProductsToTheCart() {
        user.attemptsTo(
                AddProductsToCart.called(
                        purchaseData.getProduct1(),
                        purchaseData.getProduct2()
                )
        );
    }

    @Then("the cart badge should show {string}")
    public void validateCartBadge(String expectedCount) {
        user.should(
                seeThat(CartBadgeCount.value(), equalTo(expectedCount))
        );
    }

    @And("goes to the cart")
    public void goesToCart() {
        user.attemptsTo(GoToCart.now());
    }

    @And("completes the checkout")
    public void completesTheCheckout() {
        user.attemptsTo(
                Checkout.withData(
                        purchaseData.getFirstName(),
                        purchaseData.getLastName(),
                        purchaseData.getPostalCode()
                )
        );
    }

    @And("confirms the purchase")
    public void confirmsThePurchase() {
        user.attemptsTo(FinishPurchase.now());
    }

    @Then("should see the confirmation message")
    public void shouldSeeTheConfirmationMessage() {
        user.should(
                seeThat(
                        ConfirmationMessage.value(),
                        equalTo(purchaseData.getConfirmationMessage())
                )
        );
    }
}