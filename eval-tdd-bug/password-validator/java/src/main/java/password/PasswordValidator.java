package password;

public class PasswordValidator {
    private static final int MinimumPasswordLength = 8;
    private static final int DefaultPasswordLength = 11;
    private static final int MinimumMajusculesCount = 1;

    public boolean LengthisValid(String password) {
        return password != null && password.length() >= MinimumPasswordLength;

    }

    public boolean MajusculesCountisvalid(String password) {
        return password != null && password.chars().filter(Character::isUpperCase).count() >= MinimumMajusculesCount;
    }

    public static int generate() {
        return DefaultPasswordLength;
    }
}

