package services.db;

import model.db.UserDAO;
import model.db.UserDataSet;

import java.util.Objects;

public class UserAccountsService {
    private UserDAO userDAO = new UserDAO();

    public void register(String login, String password) throws Exception {
        UserDataSet userInDb = userDAO.findByLogin(login);
        if (Objects.nonNull(userInDb))
            throw new Exception("Such login is already used");
        else
            userDAO.save(new UserDataSet(login, password));
    }

    public void login(String login, String password) throws Exception {
        if (Objects.isNull(password))
            throw new Exception("Null password received");

        UserDataSet userInDb = userDAO.findByLogin(login);
        Objects.requireNonNull(userInDb, "User is not found in db");
        if (!password.equals(userInDb.getPassword()))
            throw new Exception("Password mismatch");
    }
}
