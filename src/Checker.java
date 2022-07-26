public interface Checker {
    void check(String s, boolean login) throws WrongLoginException, WrongPasswordException;
}
