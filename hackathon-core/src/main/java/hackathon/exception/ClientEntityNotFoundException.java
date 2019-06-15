package hackathon.exception;

/**
 * client not found exception
 *
 * @author egorov
 * @since 03.06.2019
 */
public class ClientEntityNotFoundException extends NotFoundException {

    public ClientEntityNotFoundException(String message) {
        super(message);
    }
}
