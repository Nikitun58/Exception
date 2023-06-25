package exceptions;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static final String REGAX = "^[a-zA-Z0-9_]*$";
    public static void main(String[] args) {
        try {
            check("Skyro", "12345", "12345");
            System.out.println("Проверка пройдена");
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void check ( String login, String password,String confirmPassword) throws WrongLoginException,WrongPasswordException {
        if (!login.matches(REGAX)){
            throw new WrongLoginException("Логин не верный");
        }
        if (login.length() > 20) {
            throw new WrongLoginException("Размер Логина не должен быть больше 20");
        }
        if (!password.matches(REGAX)){
            throw new WrongLoginException("Пароль не верный");
        }
        if (password.length() > 20) {
            throw new WrongLoginException("Размер Пароля не должен быть больше 20");
        }
        if (!password.equals(confirmPassword)){
            throw new WrongPasswordException("Пароли не совпадают");
        }


    }
}