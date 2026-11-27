package shopping;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

class ShoppingCartTest {
    private ShoppingCart cart;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
    }

    @Test
    void totalShouldBeZeroForEmptyCart() {
        assertThat(cart.total()).isEqualTo(0.0);
    }

    @Test
    void totalShouldSumItemsWithoutDiscount() {
        cart.add("Stylo", 5.0, 2);
        cart.add("Cahier", 8.0, 1);

        // sous-total = 18 € — pas de remise
        assertThat(cart.total()).isEqualTo(18.0);
    }

    @Test
    void discountShouldApplyWhenTotalReachesThreshold() {
        cart.add("Ordinateur", 120.0, 1);

        // sous-total = 120 € — remise 10 % → 108 €
        assertThat(cart.total()).isCloseTo(108.0, within(0.001));
    }

    @Test
    void discountShouldApplyWithMultipleQuantities() {
        cart.add("Chaise", 60.0, 2);

        // sous-total = 120 € — remise 10 % → 108 €
        assertThat(cart.total()).isCloseTo(108.0, within(0.001));
    }

    @Test
    void discountShouldApplyAcrossMultipleItems() {
        cart.add("Clavier", 60.0, 1);
        cart.add("Souris", 50.0, 1);

        // sous-total = 110 € — remise 10 % → 99 €
        assertThat(cart.total()).isCloseTo(99.0, within(0.001));
    }

    @Test
    void removingAnItemShouldUpdateItemCount() {
        cart.add("Stylo", 5.0, 1);
        cart.add("Cahier", 8.0, 1);
        cart.remove("Stylo");

        assertThat(cart.itemCount()).isEqualTo(1);
    }

    @Test
    void discountShouldStillApplyWhenRemainingItemsExceedThreshold() {
        cart.add("Ordinateur", 150.0, 1);
        cart.add("Souris", 20.0, 1);
        cart.remove("Souris");

        // sous-total restant = 150 € — remise toujours applicable
        assertThat(cart.total()).isCloseTo(135.0, within(0.001));
    }

    @Test
    void retirer_Ordinateur_annule_reduction() {
        cart.add("Ordinateur", 150.0, 1);
        cart.add("Souris", 20.0, 1);
        cart.remove("Ordinateur");

        assertThat(cart.total()).isEqualTo(20.0);
    }
}
