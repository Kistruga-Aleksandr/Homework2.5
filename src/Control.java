import java.util.Objects;

public class Control {
    public static boolean controler(String login, String password, String confirmPassword) {
        try {
            check(login, password, confirmPassword);
            return true;
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    private static void check(String login, String password, String confirmPassword) throws WrongLoginException,
            WrongPasswordException {
        if (login == null || login.isEmpty() || login.length() > 20) {
            throw new WrongLoginException("Длина логина не должнабыть меньше одного символа и не должна привышать 20 символов!");
        }
        if (password == null || password.isEmpty() || password.length() >= 20) {
            throw new WrongPasswordException("Длина пароля не должнабыть меньше одного символа и должна быть меньше 20 символов!");
        }
        if (!Objects.equals(password, confirmPassword)) {
            throw new WrongPasswordException("Пороли должны совподать");
        }

        Checkers checkers = new Checkers();
        checkers.check(login, true);
        checkers.check(password, false);
    }
}
