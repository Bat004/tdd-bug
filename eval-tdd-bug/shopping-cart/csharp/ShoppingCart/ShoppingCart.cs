namespace ShoppingCart;

public class ShoppingCart
{
    private const double DiscountThreshold = 100.0;
    private const double DiscountRate = 0.10;

    private readonly List<CartItem> _items = [];
    private bool _discountApplied;

    public void Add(string name, double unitPrice, int quantity)
    {
        _items.Add(new CartItem(name, unitPrice, quantity));
        if (Subtotal() >= DiscountThreshold)
            _discountApplied = true;
    }

    public void Remove(string name) => _items.RemoveAll(item => item.Name == name);
    public double Total() => _discountApplied ? Subtotal() * (1 - DiscountRate) : Subtotal();
    public int ItemCount => _items.Count;
    private double Subtotal() => _items.Sum(item => item.Subtotal);
}
