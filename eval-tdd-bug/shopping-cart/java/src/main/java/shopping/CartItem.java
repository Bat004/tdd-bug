package shopping;

public record CartItem(String name, double unitPrice, int quantity) {
    public double subtotal() {
        return unitPrice * quantity;
    }
}
