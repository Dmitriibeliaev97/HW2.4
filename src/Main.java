import Exceptions.WrongLoginException;
import Exceptions.WrongPasswordConfirmException;
import Exceptions.WrongPasswordException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    public static void main(String[] args) {
        try {
            enter("java_skypro_go", "D_1hWiKjjP_9", "D_1hWiKjjP_9");
        } catch (WrongLoginException e) {
            System.out.println("Неверный Login");
        } catch (WrongPasswordException e) {
            System.out.println("Неверный пароль");
        } catch (WrongPasswordConfirmException e) {
            System.out.println("Пароль не совпадает");
        } finally {
            System.out.println("Данные введены");
        }
    }

    public static void enter(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException, WrongPasswordConfirmException {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9_]{1,20}");
        Matcher loginMatcher = pattern.matcher(login);
        Matcher passwordMatcher = pattern.matcher(password);
        if (!loginMatcher.matches()) {
            throw new WrongLoginException();
        }
        if (!passwordMatcher.matches()) {
            throw new WrongPasswordException();
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordConfirmException();
        }

    }
}
