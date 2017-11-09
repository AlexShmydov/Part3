package stones;

import settings.SettingsValues;
import texts.ErrorMessages;
import usersExceptions.MineralFactoryException;
import usersExceptions.NobleMineralFactoryException;
import usersExceptions.StonesCostCalculatingException;
import usersExceptions.StonesFactoryException;

import java.util.Random;

public class StoneFactory {

    private static final String[] STONES_NAMES = SettingsValues.DEFAULT_STONES_NAMES;

    public static Stone createStoneWithDefaultParameters() throws StonesFactoryException, MineralFactoryException, NobleMineralFactoryException, StonesCostCalculatingException {
        Stone stone = createStoneWithParameters(
                SettingsValues.COST_PER_CARAT,
                STONES_NAMES[getRandomNumber(STONES_NAMES.length, 1) - 1],
                getRandomNumber(SettingsValues.MAX_WEIGHT, 1),
                getRandomNumber(SettingsValues.MAX_HARDNESS, 1),
                getRandomNumber(SettingsValues.MAX_SHINE, 1));
        return stone;
    }

    private static int getRandomNumber(int max, int min) {
        return new Random().nextInt((max - min) + 1) + min;
    }

    public static Stone createStoneWithParameters(int cost_per_carat, String stones_name, double stones_weight, double stones_hardnes, double stones_shine) throws StonesCostCalculatingException, NobleMineralFactoryException, MineralFactoryException, StonesFactoryException {
        if (STONES_NAMES.length == 0) throw new StonesFactoryException(ErrorMessages.INVALID_DATA_MSG, STONES_NAMES);
        Stone stone = new Stone(cost_per_carat, stones_name, stones_weight, stones_hardnes, stones_shine);
        if (stone == null)
            throw new StonesFactoryException(String.format(ErrorMessages.OBJECT_WAS_NOT_CREATED_MSG, stone.getClass().getName()));
        return stone;
    }
}
