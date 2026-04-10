package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import ui.CheckoutPage;

public class ConfirmationMessage implements Question<String> {

    public static ConfirmationMessage value() {
        return new ConfirmationMessage();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(CheckoutPage.CONFIRMATION_MESSAGE).answeredBy(actor);
    }
}