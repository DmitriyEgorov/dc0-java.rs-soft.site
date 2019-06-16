package hackathon.exception;

/**
 * @author Dmitriy
 * @since 15.06.2019
 */
public class ClientEntityExistException extends ExistException {

    public ClientEntityExistException(String message) {
        super(message);
    }

}
