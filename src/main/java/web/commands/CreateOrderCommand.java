package web.commands;

import business.entities.Cupcake;
import business.entities.User;
import business.exceptions.UserException;
import business.services.CupcakeFacade;
import business.services.OrderFacade;
import business.services.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public class CreateOrderCommand extends CommandProtectedPage {
    private OrderFacade orderFacade;
    private CupcakeFacade cupcakeFacade;
    private UserFacade userFacade;


    public CreateOrderCommand(String pageToShow, String role) {
        super(pageToShow, role);
        orderFacade = new OrderFacade(database);
        cupcakeFacade = new CupcakeFacade(database);
        userFacade = new UserFacade(database);

    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException, SQLException {
        User user = (User) request.getSession().getAttribute("user");
        int balance = user.getBalance();
        int price = (Integer) request.getSession().getAttribute("price");

        List<Cupcake> cupakeList = (List<Cupcake>) request.getSession().getAttribute("cupcakelist");








        return pageToShow;
    }
}
