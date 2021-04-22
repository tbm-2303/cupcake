package business.services;

import business.entities.Account;
import business.entities.User;
import business.persistence.Database;
import business.persistence.UserMapper;
import business.exceptions.UserException;

import java.sql.SQLException;

public class UserFacade
{
    UserMapper userMapper;

    public UserFacade(Database database)
    {
        userMapper = new UserMapper(database);
    }

    public User login(String email, String password) throws UserException
    {
        return userMapper.login(email, password);
    }
    public Account createAccount() throws SQLException, UserException {
        Account account = new Account(0);
        userMapper.createAccount(account);
        return account;
    }

    public User createUser(String name, String email, String password, int konto_id) throws UserException
    {
        User user = new User(name, email, password, "customer",konto_id);
        userMapper.createUser(user);
        return user;
    }

}
