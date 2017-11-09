package minerals;

import usersExceptions.MineralFactoryException;
import usersExceptions.NobleMineralFactoryException;

public class NobleMineral extends Mineral {
    private double carats;
    private double rarity;
    private String name;
    private final double WEIGHT_TO_CARATS = 0.2;
    private final String EMPTY_NAME_MSG = "Name of stone has not to be null or has less than 1 letter";

    public NobleMineral(String name, double weight, double hardness, double shine) throws MineralFactoryException, NobleMineralFactoryException {
        super(weight, hardness, shine);
        if(name == null || name.trim().length() == 0) throw new NobleMineralFactoryException(EMPTY_NAME_MSG);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getRarity() {
        this.rarity = getHardness() * getShine() / getWeight();
        return rarity;
    }

    public double getCarats() {
        this.carats = WEIGHT_TO_CARATS * getWeight();
        return this.carats;
    }
}