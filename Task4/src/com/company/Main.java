package com.company;

import jewelries.BaseJewelry;
import jewelries.JewelryFactory;
import texts.ErrorMessages;
import texts.TextsValues;
import usersExceptions.*;

public class Main {
    private static final String jewelry_1 = "Necklace";
    private static final String jewelry_2 = "Crown";
    private static final String jewelry_3 = "Unkonwn";

    public static void main(String[] args) {
        printMsg(TextsValues.WELCOME_MSG);
        BaseJewelry necklaceJewelry = null;
        BaseJewelry crownJewelry = null;
        BaseJewelry unknownJewelry = null;
        try {
            necklaceJewelry = JewelryFactory.getJewelry(jewelry_1);
            printMsg(String.format(TextsValues.SUCCESSFULLLY_CREATING_JEWELRY, necklaceJewelry.getName()));
            crownJewelry = JewelryFactory.getJewelry(jewelry_2);
            printMsg(String.format(TextsValues.SUCCESSFULLLY_CREATING_JEWELRY, crownJewelry.getName()));
            unknownJewelry = JewelryFactory.getJewelry(jewelry_3);
            printMsg(String.format(TextsValues.SUCCESSFULLLY_CREATING_JEWELRY, unknownJewelry.getName()));
        } catch (MineralFactoryException | NobleMineralFactoryException | StonesCostCalculatingException e) {
            printMsg(e.getMessage());
        } catch (JewelryFactoryException | StonesFactoryException e) {
            printMsg(e.getMessage());
            printMsg(ErrorMessages.JEWELLING_NULL_MSG);
        }
    }

    private static void printMsg(String message) {
        System.out.println(message);
    }
}