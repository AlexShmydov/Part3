package com.company;

import jewelries.BaseJewelry;
import jewelries.JewelryFactory;
import stones.Stone;
import texts.TextsValues;
import usersExceptions.*;
import utils.FilesUtils;

import java.util.Comparator;
import java.util.Scanner;

public class Main {
    private static final Comparator<Stone> DEFAULT_PARAMETER = Stone.Comparators.SHINE;

    public static void main(String[] args) {
        printMsg(TextsValues.WELCOME_MSG);
        BaseJewelry necklaceFromFile = null;
        Scanner scanner = new Scanner(System.in);
        try {
            String path = scanner.nextLine();
            while (!FilesUtils.checkPathIsCorrect(path)
                    && !FilesUtils.checkFilesExisting(path)
                    && !FilesUtils.isFile(path)) {
                printMsg(String.format(TextsValues.INCORRECT_PATH_TO_FILE_MSG, path));
                path = scanner.nextLine();
            }
            necklaceFromFile = JewelryFactory.createJewelryFromFileWithStones(scanner.nextLine());
            printMsg(String.format(TextsValues.COST_OF_JEWELRY, necklaceFromFile.getName(), necklaceFromFile.getCostOfJewelry(), TextsValues.CURRENCY));
            printMsg(String.format(TextsValues.WEIGHT_OF_JEWELRY, necklaceFromFile.getName(), necklaceFromFile.getWeightInCaratsOfJewelry()));
            necklaceFromFile.sortStonesByParameter(DEFAULT_PARAMETER);
            printMsg(String.format(TextsValues.OUTPUT_MSG, JewelryFactory.writeJewelryParametersInFile(necklaceFromFile, path)));
        } catch (JewelryFactoryException | StonesFactoryException | MineralFactoryException | NobleMineralFactoryException | StonesCostCalculatingException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printMsg(String message) {
        System.out.println(message);
    }
}