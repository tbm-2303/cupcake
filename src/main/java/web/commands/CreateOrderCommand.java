package web.commands;

import business.entities.Cart;
import business.entities.Cupcake;
import business.exceptions.UserException;
import business.services.CupcakeFacade;
import business.services.OrderFacade;
import business.services.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class CreateOrderCommand extends CommandProtectedPage{
    private OrderFacade orderFacade;
    private CupcakeFacade cupcakeFacade;
    private UserFacade userFacade;

    public CreateOrderCommand(String pageToShow, String role) {
        super(pageToShow, role);
        orderFacade = new OrderFacade(database);
        cupcakeFacade = new CupcakeFacade(database);
        userFacade = new UserFacade(database);

    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {

// brug facade og mapper til at oprette cupcakes i db. Sideløbende skal der oprettes en cart og en order i db og disse skal kobles
// sammen ved hjælp af link tabellen som skal udfyldes samtidigt.
// brug facade til at hente mapper. Mapper skal skrives til at oprette en cart i db. Derefter oprettes
        //cupcake-> cart-> link tabel-> order

        try {

           if(request.getSession().getAttribute("cupcakelist") == null){
               request.getSession().setAttribute("error", "There is no cupcakes in your shopping cart. Please order some cupcakes first");
               String pagetoshow = "orderpage";
               return pagetoshow;
           }

           List<Cupcake> listy = new ArrayList<>();
           listy = (List<Cupcake>) request.getSession().getAttribute("cupcakelist");
           String name = (String) request.getSession().getAttribute("name");

           Cart cart = userFacade.createCart(name);
           int cart_id = cart.getCartId();

            for (Cupcake item: listy) {

                Cupcake cupcake = cupcakeFacade.makeCupcake(item.getBottomId(), item.getTopId(), item.getAmount());
                int cupcake_id = cupcake.getCupcakeId();

                //udfyld link tabel SAMTIDIGT(vi har cupcake_id og vi har cart_id)
            }

            // int price = priceUtil.calculateOrderPrice(listy)


            int userId = (Integer) request.getSession().getAttribute("userId");
            //int balance = (Integer) request.getSession().getAttribute("balance")
            //if(balance >= price){orderFacade.createorder(userId,price,cart_id);}





            /*
            - vi har oprettet en cart i db. den har auto gen. ID og 'name' er sat til 'name' fra user tabellen.
            - oprette cupcakes i db for hver cupcake i cupcakelist.
            - udfyld link tabellen således at cart_id stemples for hver cupcake i cupcakelist.
            - nu kan vi oprette en order i db. den skal tilknyttes cart_id fra den nyligt oprettede cart.
            - lav en metode i service laget til at udregne den samlede pris på ordren. kald den priceUtil.
            for (Cupcake item : listy) {
                Cupcake


            }


             */


        } catch (Exception e) {
            e.printStackTrace();
        }


        return REDIRECT_INDICATOR+pageToShow;
    }
}
