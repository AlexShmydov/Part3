package jewelries;

import stones.Stone;
import usersExceptions.JewelryFactoryException;

import java.util.*;

public class BaseJewelry {
    private static final String EMPTY_ARRAY_TO_RETURN_MSG = "Nothing to return! Result of searching is null";
    private static final String IMPOSSIBLE_TO_DELETE_MSG = "Stone was not deleted!";
    private String name;
    private List<Stone> stones;
    private double cost;
    private double weightInCarats;

    public BaseJewelry(String name) {
        this.name = name;
        stones = new LinkedList<>();
    }

    public void addStone(Stone stone) {
        stones.add(stone);
    }

    public int getCountOfStones() {
        return stones.size();
    }

    public double getCostOfJewelry() {
        calculateCostOfJewelry();
        return cost;
    }

    private void calculateCostOfJewelry() {
        for (Stone stone : stones) {
            this.cost += stone.getCost();
        }
    }

    private void calculateWeightOfJewelry() {
        for (Stone stone : stones) {
            this.weightInCarats += stone.getCarats();
        }
    }

    public double getWeightInCaratsOfJewelry() {
        calculateWeightOfJewelry();
        return weightInCarats;
    }

    public String getName() {
        return name;
    }

    public void deleteStoneByObject(Stone stoneToDelete) throws JewelryFactoryException {
        int tempSize = stones.size();
        stones.remove(stoneToDelete);
        if (tempSize == stones.size()) throw new JewelryFactoryException(IMPOSSIBLE_TO_DELETE_MSG);
    }

    public void sortStonesByParameter(Comparator<Stone> stoneComparator) {
        Collections.sort(stones, stoneComparator);
    }

    public List<Stone> getStonesByWeight(double min, double max) throws JewelryFactoryException {
        List<Stone> tempArray = new ArrayList<>();
        for (Stone stone : stones) {
            if (stone.getWeight() >= min && stone.getWeight() <= max) {
                tempArray.add(stone);
            }
        }
        if (tempArray.size() == 0) throw new JewelryFactoryException(EMPTY_ARRAY_TO_RETURN_MSG);
        return tempArray;
    }

    public List<Stone> getStonesByCarats(double min, double max) throws JewelryFactoryException {
        List<Stone> tempArray = new ArrayList<>();
        for (Stone stone : stones) {
            if (stone.getCarats() >= min && stone.getCarats() <= max) {
                tempArray.add(stone);
            }
        }
        if (tempArray.size() == 0) throw new JewelryFactoryException(EMPTY_ARRAY_TO_RETURN_MSG);
        return tempArray;
    }

    public List<Stone> getStonesByIsJewel(boolean isJewelling) throws JewelryFactoryException {
        List<Stone> tempArray = new ArrayList<>();
        for (Stone stone : stones) {
            if (stone.getIsJewelling() == isJewelling) {
                tempArray.add(stone);
            }
        }
        if (tempArray.size() == 0) throw new JewelryFactoryException(EMPTY_ARRAY_TO_RETURN_MSG);
        return tempArray;
    }

    public List<Stone> getStonesByRarity(double min, double max) throws JewelryFactoryException {
        List<Stone> tempArray = new ArrayList<>();
        for (Stone stone : stones) {
            if (stone.getRarity() >= min && stone.getRarity() <= max) {
                tempArray.add(stone);
            }
        }
        if (tempArray.size() == 0) throw new JewelryFactoryException(EMPTY_ARRAY_TO_RETURN_MSG);
        return tempArray;
    }

    public List<Stone> getStonesByCost(double min, double max) throws JewelryFactoryException {
        List<Stone> tempArray = new ArrayList<>();
        for (Stone stone : stones) {
            if (stone.getCost() >= min && stone.getCost() <= max) {
                tempArray.add(stone);
            }
        }
        if (tempArray.size() == 0) throw new JewelryFactoryException(EMPTY_ARRAY_TO_RETURN_MSG);
        return tempArray;
    }
}
