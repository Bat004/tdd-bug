package password;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HelloWorldTest {
    @Test
    void greets_the_world() {
        assertThat(HelloWorld.greet()).isEqualTo("Hello World");
    }
}
