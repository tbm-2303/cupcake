package business.services;

import business.entities.Cupcake;
import business.entities.Top;
import business.exceptions.UserException;
import business.persistence.CupcakeMapper;
import business.persistence.Database;

public class CupcakeFacade {
    CupcakeMapper cupcakeMapper;

    public CupcakeFacade(Database database) {
        cupcakeMapper = new CupcakeMapper(database);
    }


    public Cupcake makeCupcake(int bottomId, int topId, int amount) throws UserException {
        Cupcake cupcake = new Cupcake(bottomId,topId,amount);
        return cupcakeMapper.makeCupcake(cupcake);

    }
}
