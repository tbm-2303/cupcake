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
    CupcakeFacade cupcakeFacade;


    public CreateOrderCommand(String pageToShow, String role) {
        super(pageToShow, role);
        cupcakeFacade = new CupcakeFacade(database);
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException, SQLException {

            User user = (User) request.getSession().getAttribute("user");
            int balance = user.getBalance();
            int price = (Integer) request.getSession().getAttribute("price");


            List<Cupcake> cupakeList = (List<Cupcake>) request.getSession().getAttribute("cupcakeList");
            cupcakeFacade.makeOrder(user.getId(),price,cupakeList);
            cupakeList.clear();

        return pageToShow;
    }
}
