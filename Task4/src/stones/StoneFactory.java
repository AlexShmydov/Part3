package stones;

import settings.SettingsValues;
import stones.stonesTypes.Amethyst;
import stones.stonesTypes.Diamond;
import stones.stonesTypes.Sapphire;
import texts.ErrorMessages;
import usersExceptions.MineralFactoryException;
import usersExceptions.NobleMineralFactoryException;
import usersExceptions.StonesCostCalculatingException;
import usersExceptions.StonesFactoryException;

public class StoneFactory {

    public static Stone getStone(String stoneName) throws StonesCostCalculatingException, NobleMineralFactoryException, MineralFactoryException, StonesFactoryException {

        if (stoneName.toUpperCase().equals(SettingsValues.STONE_AMETHYST_NAME.toUpperCase())) {
            return new Amethyst(Integer.parseInt(SettingsValues.AMETHYST_DEFAULT_PARAMETERS[0]),
                    SettingsValues.AMETHYST_DEFAULT_PARAMETERS[1],
                    Double.parseDouble(SettingsValues.AMETHYST_DEFAULT_PARAMETERS[2]),
                    Double.parseDouble(SettingsValues.AMETHYST_DEFAULT_PARAMETERS[3]),
                    Double.parseDouble(SettingsValues.AMETHYST_DEFAULT_PARAMETERS[4]));
        }

        if (stoneName.toUpperCase().equals(SettingsValues.STONE_DIAMOND_NAME.toUpperCase())) {
            return new Diamond(Integer.parseInt(SettingsValues.DIAMOND_DEFAULT_PARAMETERS[0]),
                    SettingsValues.DIAMOND_DEFAULT_PARAMETERS[1],
                    Double.parseDouble(SettingsValues.DIAMOND_DEFAULT_PARAMETERS[2]),
                    Double.parseDouble(SettingsValues.DIAMOND_DEFAULT_PARAMETERS[3]),
                    Double.parseDouble(SettingsValues.DIAMOND_DEFAULT_PARAMETERS[4]));
        }

        if (stoneName.toUpperCase().equals(SettingsValues.STONE_SAPPHIRE_NAME.toUpperCase())) {
            return new Sapphire(Integer.parseInt(SettingsValues.SAPPHIRE_DEFAULT_PARAMETERS[0]),
                    SettingsValues.SAPPHIRE_DEFAULT_PARAMETERS[1],
                    Double.parseDouble(SettingsValues.SAPPHIRE_DEFAULT_PARAMETERS[2]),
                    Double.parseDouble(SettingsValues.SAPPHIRE_DEFAULT_PARAMETERS[3]),
                    Double.parseDouble(SettingsValues.SAPPHIRE_DEFAULT_PARAMETERS[4]));
        }
        throw new StonesFactoryException(ErrorMessages.UNKNOWN_STONE_TYPE);
    }
}
