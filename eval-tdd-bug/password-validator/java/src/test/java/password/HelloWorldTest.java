package password;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TestPasswordValidator {
    @Test
    void password_have_at_least_8_characters() {
        assertEquals(8, PasswordValidator.validate());
    }
}
