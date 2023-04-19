import Exceptions.WrongLoginException;
import Exceptions.WrongPasswordConfirmException;
import Exceptions.WrongPasswordException;

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

    public static boolean enter(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException, WrongPasswordConfirmException {
        if (login.length() >= 20) {
            throw new WrongLoginException();
        }
        if (password.length() >= 20) {
            throw new WrongPasswordException();
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordConfirmException();
        }
        return true;
    }

}