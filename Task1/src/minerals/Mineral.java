package minerals;

import usersExceptions.MineralFactoryException;

public abstract class Mineral {
    private double weight;
    private double hardness;
    private double shine;
    private final String MINERALS_CHARACTERS_MSG = "Parameters of mineral has not to be equals 0 or are not defined";

    public Mineral(Double weight, Double hardness, Double shine) throws MineralFactoryException {
        if(weight == 0.0 || weight == null || hardness == 0.0 || hardness == null || shine == 0.0 || shine == null) throw new MineralFactoryException(MINERALS_CHARACTERS_MSG);
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