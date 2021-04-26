package business.persistence;

import business.entities.Bottom;
import business.entities.Cupcake;
import business.entities.Order;
import business.entities.Top;
import business.exceptions.UserException;

import java.sql.*;
import java.util.List;

public class CupcakeMapper {
    private Database database;

    public CupcakeMapper(Database database) {
        this.database = database;
    }
/*
    public void insertIntoLinkTable(int cart_id, int cupcake_id) throws UserException {
        try (Connection connection = database.connect()) {
            String sql = "INSERT INTO link_cart_cupcakes (cart_id,cupcake_id) VALUES (?,?)";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, cart_id);
                ps.setInt(2, cupcake_id);
                ps.executeUpdate();
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException(ex.getMessage());
        }
    }

 */
/*
    public Cupcake makeCupcake(Cupcake cupcake) throws UserException {

        try (Connection connection = database.connect()) {
            String sql = "INSERT INTO cupcakes (bottom_id, top_id, amount, cupcakeprice) VALUES (?, ?, ?,?)";


            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, cupcake.getBottomId());
                ps.setInt(2, cupcake.getTopId());
                ps.setInt(3, cupcake.getAmount());
                ps.setInt(4,cupcake.getPrice());
                ps.executeUpdate();

                ResultSet rs = ps.getGeneratedKeys();
                rs.next();
                int id = rs.getInt(1);
                cupcake.setCupcakeId(id);
                return cupcake;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException | UserException ex) {
            throw new UserException(ex.getMessage());
        }
    }

     */

    public Bottom getBottom(int bottomId) throws UserException {
        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM bottom WHERE bottom_id = ?";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, bottomId);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    String name = rs.getString("name");
                    int price = rs.getInt("price");
                    Bottom bottom = new Bottom(bottomId, name, price);

                    return bottom;
                } else {
                    throw new UserException("Database Bottom issue");
                }
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
    }

    public Top getTop(int topId) throws UserException {
        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM top WHERE top_id = ?";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, topId);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    String name = rs.getString("name");
                    int price = rs.getInt("price");
                    Top top = new Top(topId, name, price);

                    return top;
                } else {
                    throw new UserException("Database Bottom issue");
                }
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
    }

    public Order makeOrder(int user_id, int price, List<Cupcake> list) throws UserException {

        try (Connection connection = database.connect()) {

            String sql = "INSERT INTO orderz (user_id, price) VALUES (?, ?)";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, user_id);
                ps.setInt(2, price);
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                rs.next();
                int id = rs.getInt(1);
                Order order = new Order(user_id,price);
                order.setOrder_id(id);

                for (Cupcake item: list) {
                    InsertCartTable(item,order.getOrder_id());
                }

                return order;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException | UserException ex) {
            throw new UserException(ex.getMessage());
        }

    }

    public void InsertCartTable(Cupcake item, int order_id) throws UserException {
        try (Connection connection = database.connect()) {
            String sql = "INSERT INTO cart (top_id, bottom_id, order_id, amount) VALUES (?,?,?,?)";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, item.getTop().getTopId());
                ps.setInt(2, item.getBot().getBottomId());
                ps.setInt(3, order_id);
                ps.setInt(4, item.getAmount());
                ps.executeUpdate();

            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException | UserException ex) {
            throw new UserException("Connection to database could not be established");
        }
    }

}
