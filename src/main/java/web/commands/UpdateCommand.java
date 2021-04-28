package web.commands;

import business.entities.Cupcake;
import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UpdateCommand extends CommandProtectedPage {


    public UpdateCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException, SQLException {
        List<Cupcake> cupcakeList = (List<Cupcake>) request.getSession().getAttribute("cupcakeList");
        List<Integer> amountsListInteger = new ArrayList<>();


        List<String> parameterListString = Arrays.asList(request.getParameterValues("amount"));

        for (String string : parameterListString) {
            amountsListInteger.add(Integer.parseInt(string));
        }

        for (int i = 0; i < cupcakeList.size(); ++i) {
            cupcakeList.get(i).setAmount(amountsListInteger.get(i));
        }

        String remove = request.getParameter("remove");
        if (remove != null) {
            cupcakeList.remove(Integer.parseInt(remove));
        }
        for (Cupcake item : cupcakeList) {
            if (item.getAmount() <= 0) {
                cupcakeList.remove(item);
            }
        }


        int price = 0;
        if (cupcakeList != null) {
            for (Cupcake item : cupcakeList) {
                price += item.getPrice();
            }
        }
        request.getSession().setAttribute("price", price);
        return pageToShow;
    }
}
