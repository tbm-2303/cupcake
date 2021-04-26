package web.commands;

import business.entities.User;
import business.exceptions.UserException;
import business.services.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public class showCustomersCommand extends CommandProtectedPage {
UserFacade userFacade;

    public showCustomersCommand(String pageToShow, String role) {
        super(pageToShow, role);
        userFacade = new UserFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException, SQLException {

        List<User> customerList = userFacade.fetchAllUsers();
        request.getSession().setAttribute("customerList",customerList);

        return pageToShow;
    }


}