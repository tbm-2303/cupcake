package web.commands;

import business.entities.Cupcake;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CupcakeCommand extends CommandProtectedPage {


    public CupcakeCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        int topId = Integer.parseInt(request.getParameter("top"));
        int bottomId = Integer.parseInt(request.getParameter("bottom"));
        int amount = Integer.parseInt(request.getParameter("amount"));

        Cupcake cupcake = new Cupcake(topId,bottomId,amount);

        HttpSession session = request.getSession();
        session.setAttribute("top",topId);
        session.setAttribute("bottom",bottomId);
        session.setAttribute("amount",amount);


        return REDIRECT_INDICATOR+pageToShow;
    }
}
