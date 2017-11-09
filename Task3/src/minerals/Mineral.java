package minerals;

import texts.ErrorMessages;
import usersExceptions.MineralFactoryException;

public abstract class Mineral {
    private double weight;
    private double hardness;
    private double shine;

    public Mineral(Double weight, Double hardness, Double shine) throws MineralFactoryException {
        if(weight == 0.0 || weight == null || hardness == 0.0 || hardness == null || shine == 0.0 || shine == null) throw new MineralFactoryException(ErrorMessages.MINERALS_CHARACTERS_MSG);
        this.hardness = hardness;
        this.shine = shine;
        this.weight = weight;
    }

    public double getHardness() {
        return hardness;
    }

    public double getShine() {
        return shine;
    }

    public double getWeight() {
        return weight;
    }
}