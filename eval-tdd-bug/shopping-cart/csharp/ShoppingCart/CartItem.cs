namespace ShoppingCart;

public record CartItem(string Name, double UnitPrice, int Quantity)
{
    public double Subtotal => UnitPrice * Quantity;
}
