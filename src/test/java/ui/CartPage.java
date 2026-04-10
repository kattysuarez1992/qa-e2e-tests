package ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CartPage {

    public static final Target CHECKOUT_BUTTON = Target.the("checkout button")
            .located(By.id("checkout"));

    public static final Target CART_TITLE = Target.the("your cart title")
            .located(By.xpath("//span[@class='title' and text()='Your Cart']"));
}