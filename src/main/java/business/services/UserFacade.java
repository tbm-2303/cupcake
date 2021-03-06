package business.services;

import business.entities.Bottom;
import business.entities.User;
import business.persistence.Database;
import business.persistence.UserMapper;
import business.exceptions.UserException;

import java.util.List;

public class UserFacade
{
    UserMapper userMapper;

    public UserFacade(Database database)
    {
        userMapper = new UserMapper(database);
    }
/*
    public Cart createCart(String name) throws UserException,SQLException{
        return userMapper.createCart(name);
    }


 */
    /*
    public Account fetchAccount(int kontoId) throws UserException, SQLException {
        return userMapper.fetchAccount(kontoId);
    }

     */
/*
    public Account createAccount() throws SQLException, UserException {
        Account account = new Account(0);
        Account account1 = userMapper.createAccount(account);
        return account1;
    }

     */

    public User login(String email, String password) throws UserException {
        return userMapper.login(email, password);
    }


    public User createUser(String name, String email, String password) throws UserException {
        User user = new User(name, email, password, "customer", 0);
        User user2 = userMapper.createUser(user);
        return user2;
    }

    public List<User> fetchAllUsers() throws UserException {
        return userMapper.fetchAllUsers();
    }








}
