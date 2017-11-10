package settings;

public class SettingsValues {
    public static final double WEIGHT_TO_CARATS = 0.2;
    public static final double jewelsMultiplier = 2;

    public static final String STONE_SAPPHIRE_NAME = "Sapphire";
    public static final String[] SAPPHIRE_DEFAULT_PARAMETERS = new String[]{"1000", STONE_SAPPHIRE_NAME, "100", "2", "5"};
    public static final String STONE_DIAMOND_NAME = "Diamond";
    public static final String[] DIAMOND_DEFAULT_PARAMETERS = new String[]{"1500", STONE_DIAMOND_NAME, "10", "20", "53"};
    public static final String STONE_AMETHYST_NAME = "Amethyst";
    public static final String[] AMETHYST_DEFAULT_PARAMETERS = new String[]{"3000", STONE_AMETHYST_NAME, "30", "22", "15"};


    public static final String CROWN_JEWELRY_NAME = "Crown";
    public static final String[] CROWNS_STONES_COMPOSITIONS = new String[]{
            STONE_SAPPHIRE_NAME,
            STONE_SAPPHIRE_NAME,
            STONE_DIAMOND_NAME,
            STONE_AMETHYST_NAME};
    public static final String NECKLACE_JEWELRY_NAME = "Necklace";
    public static final String[] NECKLACES_STONES_COMPOSITIONS = new String[]{
            STONE_AMETHYST_NAME,
            STONE_AMETHYST_NAME,
            STONE_AMETHYST_NAME,
            STONE_AMETHYST_NAME,
            STONE_DIAMOND_NAME};

    public static final String SEPARATOR = ";";
    public static final String DEFAULT_CHARSET = "UTF-8";

    public static final String REG_EXP_LINE_FORMAT = "^([^ ;]+[;]){4}$";
    public static final String REG_EXP_VALUES_FORMAT = "^(([\\d]+|[\\d]+[.]+\\d+)+[;]+[\\D]+[;]+(([\\d]+|[\\d]+[.]+\\d+)+[;]){2})$";
}
