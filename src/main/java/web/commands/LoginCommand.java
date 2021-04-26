package web.commands;

import business.entities.User;
import business.services.UserFacade;
import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class LoginCommand extends CommandUnprotectedPage {
    private UserFacade userFacade;

    public LoginCommand(String pageToShow) {
        super(pageToShow);
        userFacade = new UserFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            User user = userFacade.login(email, password);

            HttpSession session = request.getSession();

            session.setAttribute("user", user);
            session.setAttribute("name", user.getName());
            session.setAttribute("role", user.getRole());
            session.setAttribute("email", user.getEmail());
            session.setAttribute("userId", user.getId());
            session.setAttribute("balance", user.getBalance());

            String pageToShow2 = user.getRole() + "page";
            return REDIRECT_INDICATOR + pageToShow2;


        } catch (UserException ex) {
            request.setAttribute("error", "Wrong username or password!");
            return "loginpage";
        }
    }

}
