package web.commands;

import business.entities.Account;
import business.entities.User;
import business.persistence.Database;
import business.services.UserFacade;
import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class RegisterCommand extends CommandUnprotectedPage
{
    private UserFacade userFacade;

    public RegisterCommand(String pageToShow)
    {
        super(pageToShow);
        userFacade = new UserFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException, SQLException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");


        if (password1.equals(password2))
        {
            //create an Account entity first. Then make an instance of the account object before the user is created.
            // make an account method that will create the account in the db and then save it in the account object.


            Account account = userFacade.createAccount();

            User user = userFacade.createUser(name, email, password1, account.getKonto_id()); //account.getId);

            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            session.setAttribute("account", account);

            session.setAttribute("name", name);
            session.setAttribute("email", user.getEmail());
            session.setAttribute("role", user.getRole());
            session.setAttribute("userId", user.getId());

            session.setAttribute("balance", account.getBalance());

            return user.getRole() + "page";
        }
        else
        {
            request.setAttribute("error", "the two passwords did not match");
            return "registerpage";
        }
    }

}
