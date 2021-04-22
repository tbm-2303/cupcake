package web.commands;

import business.entities.Cupcake;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CupcakeCommand extends CommandProtectedPage {


    public CupcakeCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        int topId = Integer.parseInt(request.getParameter("top"));
        int bottomId = Integer.parseInt(request.getParameter("bottom"));
        int amount = Integer.parseInt(request.getParameter("amount"));


        request.setAttribute("top",topId);
        request.setAttribute("bottom",bottomId);
        request.setAttribute("amount",amount);


        return pageToShow;
    }
}
