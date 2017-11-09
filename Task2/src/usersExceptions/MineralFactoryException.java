package usersExceptions;

public class MineralFactoryException extends BaseUsersException {
    //Print error message when inputting data were invalid or incorrect for creating mineral
    public MineralFactoryException(String message) {
        super(message);
    }
}
