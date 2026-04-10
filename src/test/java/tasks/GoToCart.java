package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ui.CartPage;
import ui.ProductsPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class GoToCart implements Task {

    public static GoToCart now() {
        return instrumented(GoToCart.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(ProductsPage.CART_BADGE, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(ProductsPage.CART_ICON),
                WaitUntil.the(CartPage.CART_TITLE, isVisible()).forNoMoreThan(10).seconds()
        );
    }
}