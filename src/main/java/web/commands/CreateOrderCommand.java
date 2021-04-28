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
        try {
        List<Cupcake> cupakeList = (List<Cupcake>) request.getSession().getAttribute("cupcakeList");
        int price = (int) request.getSession().getAttribute("price");
        int userId = (int) request.getSession().getAttribute("userId");
        int balance = (int) request.getSession().getAttribute("balance");

            if (balance < price) {
                cupakeList.clear();
                price = 0;
                request.getSession().setAttribute("price", price);
                request.getSession().setAttribute("cupcakeList", cupakeList);
                request.getSession().setAttribute("error", "insufficient balance on your account");
            } else {
                cupcakeFacade.makeOrder(userId, price, cupakeList);
                int newBalance = balance - price;
                request.getSession().setAttribute("balance", newBalance);
                cupakeList.clear();
                request.getSession().setAttribute("cupcakeList", cupakeList);
                price = 0;
                request.getSession().setAttribute("price", price);
            }
            return "customerpage";
        } catch (UserException e) {
            request.setAttribute("error", "insufficient balance on your account!");
            return "customerpage";
        }

    }
}
