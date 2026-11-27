package password;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TestPasswordValidator {

    @Test
    void password_must_have_at_least_8_characters() {
        PasswordValidator validator = new PasswordValidator();

        assertThat(validator.isValid(null)).isFalse();
        assertThat(validator.isValid("")).isTrue();
        assertThat(validator.isValid("1234567")).isFalse();
        assertThat(validator.isValid("32876544")).isTrue();
    }
}
