using Xunit;

namespace PasswordValidator.Tests;

public class HelloWorldTest
{
    [Fact]
    public void GreetsTheWorld() =>
        Assert.Equal("Hello World", HelloWorld.Greet());
}
