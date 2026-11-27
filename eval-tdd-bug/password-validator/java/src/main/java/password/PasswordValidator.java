package password;

public class PasswordValidator {
    private static final int MinimumPasswordLength = 8;
    private static final int DefaultPasswordLength = 11;

    public boolean isValid(String password) {
        return password != null && password.length() >= MinimumPasswordLength;
    }

    public static int generate() {
        return DefaultPasswordLength;
    }
}

