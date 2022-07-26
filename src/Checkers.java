public class Checkers implements Checker {
    private static final String validCharacters = "0123456789_abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWYZ";

    @Override
    public void check(String s, boolean login) throws WrongLoginException, WrongPasswordException {
        for (int i = 0; i < s.length(); i++)
            if (!validCharacters.contains(String.valueOf(s.charAt(i)))) {
                if (login) {
                    throw new WrongLoginException("Логин должен содержать только латинские буквы, цифры и нижнее подчеркивание");
                } else {
                    throw new WrongPasswordException("Пароль должен содержать только латинские буквы, цифры и нижнее подчеркивание");
                }
            }
    }
}
