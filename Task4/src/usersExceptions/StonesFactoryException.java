package usersExceptions;

public class StonesFactoryException extends BaseUsersException {
    //Print error message when inputting data were invalid or incorrect for creating stones
    public StonesFactoryException(String message){
        super(message);
    }

    public StonesFactoryException(String message, String[] data){
        super(String.format(message,data.length));
    }
}