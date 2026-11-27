using Xunit;

namespace ShoppingCart.Tests;

public class ShoppingCartTest
{
    private readonly ShoppingCart _cart = new();

    [Fact]
    public void Total_ShouldBeZero_ForEmptyCart()
    {
        Assert.Equal(0.0, _cart.Total());
    }

    [Fact]
    public void Total_ShouldSumItems_WithoutDiscount()
    {
        _cart.Add("Stylo", 5.0, 2);
        _cart.Add("Cahier", 8.0, 1);

        // sous-total = 18 € — pas de remise
        Assert.Equal(18.0, _cart.Total());
    }

    [Fact]
    public void Total_ShouldApplyDiscount_WhenTotalReachesThreshold()
    {
        _cart.Add("Ordinateur", 120.0, 1);

        // sous-total = 120 € — remise 10 % → 108 €
        Assert.Equal(108.0, _cart.Total(), precision: 3);
    }

    [Fact]
    public void Total_ShouldApplyDiscount_WithMultipleQuantities()
    {
        _cart.Add("Chaise", 60.0, 2);

        // sous-total = 120 € — remise 10 % → 108 €
        Assert.Equal(108.0, _cart.Total(), precision: 3);
    }

    [Fact]
    public void Total_ShouldApplyDiscount_AcrossMultipleItems()
    {
        _cart.Add("Clavier", 60.0, 1);
        _cart.Add("Souris", 50.0, 1);

        // sous-total = 110 € — remise 10 % → 99 €
        Assert.Equal(99.0, _cart.Total(), precision: 3);
    }

    [Fact]
    public void Remove_ShouldUpdateItemCount()
    {
        _cart.Add("Stylo", 5.0, 1);
        _cart.Add("Cahier", 8.0, 1);
        _cart.Remove("Stylo");

        Assert.Equal(1, _cart.ItemCount);
    }

    [Fact]
    public void Total_ShouldStillApplyDiscount_WhenRemainingItemsExceedThreshold()
    {
        _cart.Add("Ordinateur", 150.0, 1);
        _cart.Add("Souris", 20.0, 1);
        _cart.Remove("Souris");

        // sous-total restant = 150 € — remise toujours applicable
        Assert.Equal(135.0, _cart.Total(), precision: 3);
    }
}
