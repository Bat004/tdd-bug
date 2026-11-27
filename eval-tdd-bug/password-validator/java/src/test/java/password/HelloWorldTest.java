package password;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestPasswordValidator {

    @Test
    void password_have_at_least_8_characters() {
        PasswordValidator password = new PasswordValidator();
        assertThat(password.generate()).isGreaterThanOrEqualTo(8);
    }
}
