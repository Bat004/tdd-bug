package shopping;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private static final double DISCOUNT_THRESHOLD = 100.0;
    private static final double DISCOUNT_RATE = 0.10;

    private final List<CartItem> items = new ArrayList<>();
    private boolean discountApplied = false;

    public void add(String name, double unitPrice, int quantity) {
        items.add(new CartItem(name, unitPrice, quantity));
        if (subtotal() >= DISCOUNT_THRESHOLD) {
            discountApplied = true;
        }
    }

    public void remove(String name) {
        items.removeIf(item -> item.name().equals(name));
        if (subtotal() < DISCOUNT_THRESHOLD) {
            discountApplied = false;
        }
    }

    public double total() {
        if (discountApplied) {
            return subtotal() * (1 - DISCOUNT_RATE);
        }
        return subtotal();
    }

    public int itemCount() {
        return items.size();
    }

    private double subtotal() {
        return items.stream()
                .mapToDouble(CartItem::subtotal)
                .sum();
    }
}
