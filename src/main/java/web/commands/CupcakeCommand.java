package web.commands;

import business.entities.Bottom;
import business.entities.Cupcake;
import business.entities.Top;
import business.entities.User;
import business.exceptions.UserException;
import business.services.CupcakeFacade;
import com.sun.corba.se.spi.ior.ObjectKey;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CupcakeCommand extends CommandProtectedPage {
    CupcakeFacade cupcakeFacade;


    public CupcakeCommand(String pageToShow, String role) {
        super(pageToShow, role);
        this.pageToShow = pageToShow;
        this.role = role;
        cupcakeFacade = new CupcakeFacade(database);

    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        try {
        int topId = Integer.parseInt(request.getParameter("top"));
        int bottomId = Integer.parseInt(request.getParameter("bot"));
        int amount = Integer.parseInt(request.getParameter("amount"));

            Bottom bot = cupcakeFacade.getBottom(bottomId);
            Top top = cupcakeFacade.getTop(topId);
            List<Cupcake> cupcakeList = (List<Cupcake>) request.getSession().getAttribute("cupcakeList");

            if (cupcakeList == null) {
                cupcakeList = new ArrayList<>();
            }
            cupcakeList.add(new Cupcake(top, bot, amount));
            request.getSession().setAttribute("cupcakeList", cupcakeList);
            int price = 0;
                for (Cupcake item : cupcakeList) {
                    price += item.getPrice();
                }
            request.getSession().setAttribute("price", price);

        } catch (UserException | NumberFormatException e) {
            request.getSession().setAttribute("error", "Your input is not valid");
            return "orderpage";
        }
        return pageToShow;
    }
}
