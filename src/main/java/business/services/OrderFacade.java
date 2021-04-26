package business.services;

import business.entities.Order;
import business.exceptions.UserException;
import business.persistence.Database;
import business.persistence.OrderMapper;

import java.sql.SQLException;
import java.util.List;

public class OrderFacade {

    OrderMapper orderMapper;

    public OrderFacade(Database database) {
        orderMapper = new OrderMapper(database);
    }

    public List<Order> getAllOrdersFromDB() throws UserException {
       return orderMapper.getAllOrdersFromDB();

    }
}
