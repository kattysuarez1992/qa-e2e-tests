package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import ui.ProductsPage;

public class CartBadgeCount implements Question<String> {

    public static CartBadgeCount value() {
        return new CartBadgeCount();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(ProductsPage.CART_BADGE).answeredBy(actor);
    }
}