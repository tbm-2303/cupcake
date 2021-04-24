package web.commands;

import business.entities.Cupcake;
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
    private CupcakeFacade cupcakeFacade;

    public CupcakeCommand(String pageToShow, String role) {
        super(pageToShow, role);
        cupcakeFacade = new CupcakeFacade(database);

    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {

        int topId = Integer.parseInt(request.getParameter("top"));
        int bottomId = Integer.parseInt(request.getParameter("bottom"));
        int amount = Integer.parseInt(request.getParameter("amount"));

        try {

            if(request.getSession().getAttribute("cupcakelist") == null){
                List<Cupcake> listy = new ArrayList<>();
                Cupcake cupcake = new Cupcake(topId,bottomId,amount);
                listy.add(cupcake);

               request.getSession().setAttribute("cupcakelist", listy);
            }
            else {
                Cupcake cupcake = new Cupcake(topId,bottomId,amount);
                List<Cupcake> listy = (List<Cupcake>) request.getSession().getAttribute("cupcakelist");
                listy.add(cupcake);
                request.getSession().setAttribute("cupcakelist",listy);
            }


        } catch (NumberFormatException e) {
            e.printStackTrace();

        }

        return REDIRECT_INDICATOR + pageToShow;
    }
}
