package jewelries;

import settings.SettingsValues;
import stones.Stone;
import stones.StoneFactory;
import texts.ErrorMessages;
import texts.TextsValues;
import usersExceptions.*;
import utils.FilesUtils;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JewelryFactory {

    public static BaseJewelry createJewelry(String name, int countOfStonesInJewelry, int minCountOfJewels) throws JewelryFactoryException, StonesFactoryException, MineralFactoryException, NobleMineralFactoryException, StonesCostCalculatingException {
        BaseJewelry jewelry = new BaseJewelry(name);
        if (name.trim().length() == 0 || countOfStonesInJewelry <= 0 || minCountOfJewels < 0)
            throw new JewelryFactoryException(String.format(ErrorMessages.INVALID_INPUT_DATA_MSG));
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
                throw new JewelryFactoryException(ErrorMessages.INCORRECT_CREATED_JEWELRY_MSG);
        } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
        return jewelry;
    }

    public static BaseJewelry createJewelryFromFileWithStones(String pathToFile) throws JewelryFactoryException, StonesFactoryException, NobleMineralFactoryException, StonesCostCalculatingException, MineralFactoryException {
        BaseJewelry jewelry = new BaseJewelry(FilesUtils.getFileNameWithoutExt(pathToFile));
        List<String[]> stonesFromFile = FilesUtils.readFromFile(pathToFile);
        if (stonesFromFile == null) throw new JewelryFactoryException(ErrorMessages.INVALID_INPUT_DATA_MSG);
        for (String[] row : stonesFromFile) {
            if (row.length - 1 < 4) throw new JewelryFactoryException(ErrorMessages.INVALID_INPUT_DATA_MSG);
            jewelry.addStone(StoneFactory.createStoneWithParameters(
                    Integer.parseInt(row[0]),
                    row[1],
                    Double.parseDouble(row[2]),
                    Double.parseDouble(row[3]),
                    Double.parseDouble(row[4])));
        }
        return jewelry;
    }

    public static String writeJewelryParametersInFile(BaseJewelry jewelry, String pathToFile) {
        pathToFile = String.format("%s%s%s", new File(pathToFile).getParent(), jewelry.getName() + SettingsValues.DEFAULT_POSTFIX_FOR_FILE, SettingsValues.DEFAULT_EXTENSION_OF_FILE);
        List<String> jewelryParams = new ArrayList<>();
        jewelryParams.add(String.format(TextsValues.COST_OF_JEWELRY, jewelry.getName(), jewelry.getCostOfJewelry(), TextsValues.CURRENCY));
        jewelryParams.add(String.format(TextsValues.WEIGHT_OF_JEWELRY, jewelry.getName(), jewelry.getWeightInCaratsOfJewelry()));
        FilesUtils.writeInFile(pathToFile, jewelryParams);
        return pathToFile;
    }
}
