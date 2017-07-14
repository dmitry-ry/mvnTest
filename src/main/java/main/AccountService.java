package main;

import java.util.HashMap;

public class AccountService {
    private static AccountService instance = new AccountService();
    private HashMap<String, User> customers;

    private AccountService(){
        customers = new HashMap();
    }

    public static AccountService getInstance() {
        return instance;
    }

    public void register(String login, String password) throws Exception {
        if (!customers.containsKey(login)) {
            customers.put(login, new User(login, password));
        } else {
            throw new Exception("Such login is already used");
        }
    }

    public void login(String login, String password) throws Exception {
        if (!customers.containsKey(login) || !customers.get(login).isPasswordCorrect(password)) {
            throw new Exception("Unauthorized");
        }
    }
}
