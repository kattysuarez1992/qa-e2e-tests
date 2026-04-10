package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ui.ProductsPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AddProductsToCart implements Task {

    private final String product1;
    private final String product2;

    public AddProductsToCart(String product1, String product2) {
        this.product1 = product1;
        this.product2 = product2;
    }

    public static AddProductsToCart called(String product1, String product2) {
        return instrumented(AddProductsToCart.class, product1, product2);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(ProductsPage.addToCartButton(product1), isVisible()).forNoMoreThan(10).seconds(),
                Click.on(ProductsPage.addToCartButton(product1)),
                WaitUntil.the(ProductsPage.addToCartButton(product2), isVisible()).forNoMoreThan(10).seconds(),
                Click.on(ProductsPage.addToCartButton(product2))
        );
    }
}