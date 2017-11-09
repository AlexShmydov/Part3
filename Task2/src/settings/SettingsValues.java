package settings;

public class SettingsValues {
    public static final double WEIGHT_TO_CARATS = 0.2;
    public static final int COUNT_OF_STONES_IN_JEWELRY = 10;
    public static final int minCountOfJewels = 4;
    public static final double jewelsMultiplier = 2;

    public static final int MAX_WEIGHT = 100;
    public static final int MAX_HARDNESS = 1000;
    public static final int MAX_SHINE = 100;
    public static final int COST_PER_CARAT = 1000;

    public static final String[] DEFAULT_STONES_NAMES = new String[]{
            "Diamond",
            "Sapphire",
            "Diamond",
            "Emerald",
            "Garnet",
            "Amethyst",
            "Malachite"};

    public static final String DEFAULT_POSTFIX_FOR_FILE = "_result";
    public static final String DEFAULT_EXTENSION_OF_FILE = ".txt";

    public static final String SEPARATOR = ";";
    public static final String DEFAULT_CHARSET = "UTF-8";
}
