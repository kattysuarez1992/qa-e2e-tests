package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import ui.LoginPage;

public class ProductsTitle implements Question<String> {

    public static ProductsTitle value() {
        return new ProductsTitle();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(LoginPage.PRODUCTS_TITLE).answeredBy(actor);
    }
}