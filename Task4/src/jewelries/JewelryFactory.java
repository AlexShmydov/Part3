package jewelries;

import jewelries.jewelriesTypes.Crown;
import jewelries.jewelriesTypes.Necklace;
import settings.SettingsValues;
import stones.StoneFactory;
import texts.ErrorMessages;
import usersExceptions.*;

public class JewelryFactory {

    public static BaseJewelry getJewelry(String jewelriesName) throws StonesCostCalculatingException, NobleMineralFactoryException, MineralFactoryException, JewelryFactoryException, StonesFactoryException {
        if (jewelriesName.toUpperCase().equals(SettingsValues.CROWN_JEWELRY_NAME.toUpperCase())) {
            return fillJewelryByStones(new Crown(SettingsValues.CROWN_JEWELRY_NAME), SettingsValues.CROWNS_STONES_COMPOSITIONS);
        } else if (jewelriesName.toUpperCase().equals(SettingsValues.NECKLACE_JEWELRY_NAME.toUpperCase())) {
            return fillJewelryByStones(new Necklace(SettingsValues.NECKLACE_JEWELRY_NAME), SettingsValues.NECKLACES_STONES_COMPOSITIONS);
        } else {
            throw new JewelryFactoryException(ErrorMessages.UNKNOWN_TYPE_JEWELRY_MSG);
        }
    }

    public static BaseJewelry fillJewelryByStones(BaseJewelry jewelry, String[] parameters) throws StonesCostCalculatingException, NobleMineralFactoryException, MineralFactoryException, StonesFactoryException {
        for (String parameter : parameters) {
            jewelry.addStone(StoneFactory.getStone(parameter));
        }
        return jewelry;
    }
}
