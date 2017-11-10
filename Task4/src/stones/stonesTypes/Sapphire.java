package stones.stonesTypes;

import stones.Stone;
import usersExceptions.MineralFactoryException;
import usersExceptions.NobleMineralFactoryException;
import usersExceptions.StonesCostCalculatingException;

public class Sapphire extends Stone {
    public Sapphire(int costPerCarat, String name, double weight, double hardness, double shine) throws MineralFactoryException, NobleMineralFactoryException, StonesCostCalculatingException {
        super(costPerCarat, name, weight, hardness, shine);
    }
}
