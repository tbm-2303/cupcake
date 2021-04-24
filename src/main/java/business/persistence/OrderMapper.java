package business.persistence;

import business.entities.Order;
import business.entities.User;
import business.exceptions.UserException;

import java.sql.*;

public class OrderMapper {
    private Database database;

    public OrderMapper(Database database) {
        this.database = database;
    }


    public Order createOrder(Order order) throws UserException {
        try (Connection connection = database.connect()) {
            String sql = "INSERT INTO order (user_id, price, cart_id) VALUES (?, ?, ?)";


            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, order.getOrder_id());
                ps.setInt(2, order.getPrice());
                ps.setInt(3, order.getCart_id());
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                rs.next();
                int id = rs.getInt(1);
                order.setOrder_id(id);
                return order;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException | UserException ex) {
            throw new UserException(ex.getMessage());
        }

    }
}
