package business.persistence;

import business.entities.Cupcake;
import business.exceptions.UserException;

import java.sql.*;

public class CupcakeMapper {
    private Database database;

    public CupcakeMapper(Database database)
    {
        this.database = database;


    }

    public Cupcake makeCupcake(Cupcake cupcake) throws UserException {

        try (Connection connection = database.connect()) {
            String sql = "INSERT INTO cupcakes (bottom_id, top_id, amount) VALUES (?, ?, ?)";


            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, cupcake.getBottomId());
                ps.setInt(2, cupcake.getTopId());
                ps.setInt(3, cupcake.getAmount());
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
}
