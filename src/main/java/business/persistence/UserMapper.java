package business.persistence;

import business.exceptions.UserException;
import business.entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserMapper {
    private Database database;

    public UserMapper(Database database) {
        this.database = database;
    }

/*
    public Cart createCart(String name) throws SQLException,UserException{


        try (Connection connection = database.connect()) {
            String sql = "INSERT INTO cart(name) VALUE(?)";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1,name);
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                rs.next();
                int cartId = rs.getInt(1);
                Cart cart = new Cart(name);
                cart.setCartId(cartId);
                return cart;



            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException | UserException ex) {
            throw new UserException(ex.getMessage());
        }

    }


 */
    /*
    public Account createAccount(Account account) throws SQLException, UserException {

        try (Connection connection = database.connect()) {
            String sql = "INSERT INTO konto (balance) VALUES (?)";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, (account.getBalance()));
                ps.executeUpdate();

                ResultSet rs = ps.getGeneratedKeys();
                rs.next();
                int konto_id = rs.getInt(1);
                account.setKonto_id(konto_id);
                return account;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException | UserException ex) {
            throw new UserException(ex.getMessage());
        }
    }


     */
/*
    public Account fetchAccount(int kontoId) throws SQLException, UserException {

        try (Connection connection = database.connect()) {
            String sql = "SELECT balance FROM konto WHERE konto_id=?";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setInt(1, kontoId);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    int balance = rs.getInt("balance");
                    Account account = new Account(balance);
                    account.setKonto_id(kontoId);
                    return account;
                }
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
        return null;
    }


 */

    public User createUser(User user) throws UserException {
        try (Connection connection = database.connect()) {
            String sql = "INSERT INTO users (name, email, password, role, balance) VALUES (?, ?, ?, ?, ?)";


            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, user.getName());
                ps.setString(2, user.getEmail());
                ps.setString(3, user.getPassword());
                ps.setString(4, user.getRole());
                ps.setInt(5, user.getBalance());
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                rs.next();
                int id = rs.getInt(1);
                user.setId(id);
                return user;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException(ex.getMessage());
        }
    }


    public User login(String email, String password) throws UserException {
        try (Connection connection = database.connect()) {
            String sql = "SELECT user_id, name, role, balance FROM users WHERE email=? AND  password=?";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setString(1, email);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    String role = rs.getString("role");
                    int user_id = rs.getInt("user_id");
                    String name = rs.getString("name");
                    int balance = rs.getInt("balance");
                    User user = new User(name, email, password, role, balance);
                    user.setId(user_id);
                    return user;
                } else {
                    throw new UserException("Could not validate user");
                }
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
    }


    public List<User> fetchAllUsers() throws UserException {
        try (Connection connection = database.connect()) {
            String sql = "SELECT user_id, name, email, role, password, balance FROM users";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                List<User> listy = new ArrayList<>();
                while (rs.next()) {
                    int user_id = rs.getInt("user_id");
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    String role = rs.getString("role");
                    String password = rs.getString("password");
                    int balance = rs.getInt("balance");
                    User user = new User(name, email, password, role, balance);
                    user.setId(user_id);
                    listy.add(user);
                }
                return listy;
            }
        } catch (
                SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
    }
}
