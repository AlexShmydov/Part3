package minerals;

import settings.SettingsValues;
import texts.ErrorMessages;
import usersExceptions.MineralFactoryException;
import usersExceptions.NobleMineralFactoryException;

public class NobleMineral extends Mineral {
    private double carats;
    private double rarity;
    private String name;

    public NobleMineral(String name, double weight, double hardness, double shine) throws MineralFactoryException, NobleMineralFactoryException {
        super(weight, hardness, shine);
        if(name == null || name.trim().length() == 0) throw new NobleMineralFactoryException(ErrorMessages.EMPTY_NAME_MSG);
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
        this.carats = SettingsValues.WEIGHT_TO_CARATS * getWeight();
        return this.carats;
    }
}