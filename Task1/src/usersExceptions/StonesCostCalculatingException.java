package usersExceptions;

public class StonesCostCalculatingException extends BaseUsersException {
    //Print error message when inputting data were wrong for calculating cost of stones
    public StonesCostCalculatingException(String message) {
        super(message);
    }
}
