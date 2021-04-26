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
        this.pageToShow = pageToShow;
        this.role = role;
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        List<Cupcake> cupcakeList = (List<Cupcake>) request.getSession().getAttribute("cupcakeList");
        int price = 0;

        if (cupcakeList != null) {
            for (Cupcake item : cupcakeList) {
                price += item.getPrice();
            }
            request.getSession().setAttribute("price", price);
        }
        return pageToShow;

    }
}
