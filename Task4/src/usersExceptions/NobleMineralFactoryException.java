package usersExceptions;

public class NobleMineralFactoryException extends BaseUsersException {
    //Print error message when inputting data were invalid or incorrect for creating base stone, i.e. a noble mineral
    public NobleMineralFactoryException(String message) {
        super(message);
    }
}
