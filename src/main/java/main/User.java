package main;

/**
 * Created by dmitry on 08.07.17.
 */
public class User {
    private String login;
    private String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password == null ? "" : password;
    }

    public boolean isPasswordCorrect(String password) {
        return this.password.equals(password);
    }
}
