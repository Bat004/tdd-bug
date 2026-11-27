package password;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TestPasswordValidator {

    @Test
    void password_must_have_at_least_8_characters() {
        PasswordValidator validator = new PasswordValidator();

        assertThat(validator.LengthisValid(null)).isFalse();
        assertThat(validator.LengthisValid("")).isFalse();
        assertThat(validator.LengthisValid("1234567")).isFalse();
        assertThat(validator.LengthisValid("32876544")).isTrue();
    }

    @Test
    void password_must_have_at_least_one_majuscules() {
        PasswordValidator validator = new PasswordValidator();

        assertThat(validator.MajusculesCountisvalid(null)).isFalse();
        assertThat(validator.MajusculesCountisvalid("")).isFalse();
        assertThat(validator.MajusculesCountisvalid("abc")).isFalse();
        assertThat(validator.MajusculesCountisvalid("ABC")).isTrue();
        assertThat(validator.MajusculesCountisvalid("aBc")).isTrue();
    }

    @Test
    void password_must_have_at_least_one_minuscules() {
        PasswordValidator validator = new PasswordValidator();

        assertThat(validator.MinusculesCountisvalid(null)).isFalse();
        assertThat(validator.MinusculesCountisvalid("")).isFalse();
        assertThat(validator.MinusculesCountisvalid("ABc")).isFalse();
        assertThat(validator.MinusculesCountisvalid("abc")).isTrue();
        assertThat(validator.MinusculesCountisvalid("AbC")).isTrue();
    }
}
