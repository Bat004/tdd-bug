package password;

public class PasswordValidator {
    private static final int MinimumPasswordLength = 8;
    private static final int DefaultPasswordLength = 11;
    private static final int MinimumMajusculesCount = 1;
    private static final int MinimumMinusculesCount = 1;
    private static final int MinimumDigitsCount = 1;
    private static final int MinimumSpecialCharactersCount = 1;

    public boolean LengthisValid(String password) {
        return password != null && password.length() >= MinimumPasswordLength;

    }
    public boolean MajusculesCountisvalid(String password) {
        return password != null && password.chars().filter(Character::isUpperCase).count() >= MinimumMajusculesCount;
    }

    public boolean MinusculesCountisvalid(String password) {
        return password != null && password.chars().filter(Character::isLowerCase).count() >= MinimumMinusculesCount;
    }

    public boolean DigitsCountisvalid(String password) {
        return password != null && password.chars().filter(Character::isDigit).count() >= MinimumDigitsCount;
    }

    public boolean SpecialCharactersCountisvalid(String password) {
        return password != null && password.chars().filter(c -> !Character.isLetterOrDigit(c)).count() >= MinimumSpecialCharactersCount;
    }

}

