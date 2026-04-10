package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class CartItems implements Question<List<String>> {

    private static final Target ITEMS = Target.the("cart items")
            .located(By.className("inventory_item_name"));

    public static CartItems displayed() {
        return new CartItems();
    }

    @Override
    public List<String> answeredBy(Actor actor) {
        return new ArrayList<>(Text.ofEach(ITEMS).answeredBy(actor));
    }
}