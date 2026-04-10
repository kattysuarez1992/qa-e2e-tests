package ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProductsPage {

    public static Target addToCartButton(String productName) {
        return Target.the("Add to cart button for " + productName)
                .located(By.xpath("//div[text()='" + productName + "']/ancestor::div[@class='inventory_item']//button"));
    }

    public static final Target CART_ICON = Target.the("cart icon")
            .located(By.className("shopping_cart_link"));

    public static final Target CART_BADGE = Target.the("cart badge")
            .located(By.className("shopping_cart_badge"));
}