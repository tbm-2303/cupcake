package web.commands;

import business.entities.Order;
import business.exceptions.UserException;
import business.services.OrderFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public class ShowOrders extends CommandProtectedPage {
    OrderFacade orderFacade;

    public ShowOrders(String pageToShow, String role) {
        super(pageToShow, role);
        this.orderFacade = new OrderFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException, SQLException {
        List<Order> orderList = orderFacade.getAllOrdersFromDB();
        request.getSession().setAttribute("orderList", orderList);
        return pageToShow;

    }
}
