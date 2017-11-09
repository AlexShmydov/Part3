package stones;

import usersExceptions.MineralFactoryException;
import usersExceptions.NobleMineralFactoryException;
import usersExceptions.StonesCostCalculatingException;
import usersExceptions.StonesFactoryException;

import java.util.Random;

public class StoneFactory {

    private static final int MAX_WEIGHT = 100;
    private static final int MAX_HARDNESS = 1000;
    private static final int MAX_SHINE = 100;
    private static final int COST_PER_CARAT = 1000;
    private static final String INVALID_DATA_MSG = "Input data contains %s elements. There is has to contains more than 1";
    private static final String OBJECT_WAS_NOT_CREATED_MSG = "Object %s was not created!";

    private static final String[] STONES_NAMES = new String[]{
            "Diamond",
            "Sapphire",
            "Diamond",
            "Emerald",
            "Garnet",
            "Amethyst",
            "Malachite"};

    public static Stone createStoneWithDefaultParameters() throws StonesFactoryException, MineralFactoryException, NobleMineralFactoryException, StonesCostCalculatingException {
        if (STONES_NAMES.length == 0) throw new StonesFactoryException(INVALID_DATA_MSG, STONES_NAMES);
        Stone stone = new Stone(
                COST_PER_CARAT,
                STONES_NAMES[getRandomNumber(STONES_NAMES.length, 1) - 1],
                getRandomNumber(MAX_WEIGHT, 1),
                getRandomNumber(MAX_HARDNESS, 1),
                getRandomNumber(MAX_SHINE, 1));
        if(stone == null) throw new StonesFactoryException(String.format(OBJECT_WAS_NOT_CREATED_MSG,stone.getClass().getName()));
        return stone;
    }

    private static int getRandomNumber(int max, int min) {
        return new Random().nextInt((max - min) + 1) + min;
    }
}
