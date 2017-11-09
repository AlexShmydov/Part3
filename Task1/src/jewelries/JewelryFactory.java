package jewelries;

import stones.Stone;
import stones.StoneFactory;
import usersExceptions.*;

public class JewelryFactory {
    private static final String INVALID_INPUT_DATA_MSG = "Input parameter for Jewelry creation is not valid";
    private static final String INCORRECT_CREATED_JEWELRY_MSG = "Jewelry was not created correctly";

    public static BaseJewelry createJewelry(String name, int countOfStonesInJewelry, int minCountOfJewels) throws JewelryFactoryException, StonesFactoryException, MineralFactoryException, NobleMineralFactoryException, StonesCostCalculatingException {
        BaseJewelry jewelry = new BaseJewelry(name);
        if (name.trim().length() == 0 || countOfStonesInJewelry <= 0 || minCountOfJewels < 0)
            throw new JewelryFactoryException(String.format(INVALID_INPUT_DATA_MSG));
        try {
            for (int i = 0; i < countOfStonesInJewelry; i++) {
                Stone stone = StoneFactory.createStoneWithDefaultParameters();
                if (!stone.getIsJewelling() && minCountOfJewels != 0 && minCountOfJewels + i >= countOfStonesInJewelry) {
                    i--;
                } else {
                    try {
                        jewelry.addStone(stone);
                    } catch (ArrayStoreException e) {
                        throw new JewelryFactoryException(e.getMessage());
                    }
                }

                if (stone.getIsJewelling() && minCountOfJewels > 0) {
                    minCountOfJewels--;
                }
            }
            if (jewelry == null || jewelry.getCountOfStones() == 0 || jewelry.getCountOfStones() != countOfStonesInJewelry)
                throw new JewelryFactoryException(INCORRECT_CREATED_JEWELRY_MSG);
        }catch (ArrayIndexOutOfBoundsException | NullPointerException e){
            System.out.println(e.getMessage());
        }
        return jewelry;
    }
}
