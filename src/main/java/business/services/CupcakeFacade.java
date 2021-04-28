package business.services;

import business.entities.Bottom;
import business.entities.Cupcake;
import business.entities.Order;
import business.entities.Top;
import business.exceptions.UserException;
import business.persistence.CupcakeMapper;
import business.persistence.Database;

import java.util.List;

public class CupcakeFacade {
    CupcakeMapper cupcakeMapper;

    public CupcakeFacade(Database database) {
        cupcakeMapper = new CupcakeMapper(database);
    }


    public Bottom getBottom(int bottomId) throws UserException {
        return cupcakeMapper.getBottom(bottomId);
    }


    public Top getTop(int topId) throws UserException {
        return cupcakeMapper.getTop(topId);
    }

    public Order makeOrder(int user_id, int price, List<Cupcake> list) throws UserException {
        return cupcakeMapper.makeOrder(user_id,price,list);
    }
    public List<Bottom> getAllBottoms() throws UserException {
        return cupcakeMapper.getAllBottoms();
    }
    public List<Top> getAllTops() throws UserException {
        return cupcakeMapper.getAllTops();
    }
/*
    public void insertIntoLinkTable(int cart_id, int cupcake_id) throws UserException {
        cupcakeMapper.insertIntoLinkTable(cart_id, cart_id);

    }

 */
}
