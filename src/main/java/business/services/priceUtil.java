package business.services;

import business.entities.Cupcake;

import java.util.List;

public class priceUtil {

    private static int cprice = 0;



    public static int calculatePrice(List<Cupcake> list) {

        for (Cupcake item : list) {
            cprice = cprice + item.getPrice();

        }

        return cprice;
    }
}
