import example.WrongLoginException;
import example.WrongPasswordException;

import java.util.regex.Pattern;


public class PersonChecking {


    public static void personalInformation(String login, String password, String confirmPassword){
        try {
            checkLogin(login);
            checkPassword(password);
            passwordСomparison(password, confirmPassword);
        } catch (WrongLoginException e) {
            throw new RuntimeException(e);
        } catch (WrongPasswordException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Проверка логина и пароля проведена успешна");


    }
    public static boolean checkLogin(String login) throws WrongLoginException {
        if (login.length() > 20) {
            throw new WrongLoginException("Логин не может быть длиннее 20 смволов.");
        }
        if (Pattern.matches("^[a-zA-Z-_]+$", login)) {
            return true;

        } else {
            throw new WrongLoginException("Логин может содержать в себе только латинские буквы, цифры и знак подчеркивания.\n" +
                    "Пример: java_skypro_go");
        }


    }
    public static boolean checkPassword(String password) throws WrongPasswordException {
        if (password.length() > 20) {
            throw new WrongPasswordException("Пароль не может быть длиннее 20 смволов.");
        }

        if (Pattern.matches("^[a-zA-Z-0-9-_]+$", password)) {
            return true;

        } else {
            throw new WrongPasswordException("Пароль может содержать только латинские буквы, цифры и знак подчеркивания.\n " +
                    "Пример: D_1hWiKjjP_9");
        }
    }
    public static boolean passwordСomparison(String password, String confirmPassword) throws WrongPasswordException{
        if (password.length() > 20 && confirmPassword.length() > 20){
            throw new WrongPasswordException("Пароль не может быть длиннее 20 смволов.");
        }
        if(password == confirmPassword){
            return true;
        }else {
        throw new WrongPasswordException("Проверте совпадение пароля");
    }

    }



}

