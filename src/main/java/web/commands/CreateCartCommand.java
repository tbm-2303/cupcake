package web.commands;

import business.entities.Cupcake;
import business.entities.User;
import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CreateCartCommand extends CommandProtectedPage {


    public CreateCartCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException, SQLException {
        int price = 0;

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        List<Cupcake> cupcakeList = (List<Cupcake>) session.getAttribute("cupcakelist");

        if (cupcakeList != null) {

            for (Cupcake item : cupcakeList) {
                price += item.getPrice();
            }
            session.setAttribute("price", price);
            return pageToShow;
        }

        String page = REDIRECT_INDICATOR + "orderpage";
        request.getSession().setAttribute("error", "no items in cart");
        return page;
    }
}
