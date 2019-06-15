package hackathon.controller.dictionaries;

import hackathon.exception.ClientEntityNotFoundException;
import hackathon.model.dictionaries.Client;
import hackathon.processor.dictionaries.ClientProcessor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static app.config.HackathonApplication.DICTIONARIES_PATH;

/**
 * controller for client
 *
 * @author Dmitriy
 * @since 15.06.2019
 */
@RestController
@RequestMapping("/dictionaries/clients")
public class ClientController {

    private final ClientProcessor clientProcessor;

    public ClientController(ClientProcessor clientProcessor) {
        this.clientProcessor = clientProcessor;
    }

    @GetMapping("/find")
    public ResponseEntity<Client> findByLoginAndPassword(
            @RequestParam(name = "login") String login,
            @RequestParam(name = "password") String password) {
        try {
            return ResponseEntity.ok(clientProcessor.findByLoginAndPassword(login, password));
        } catch (ClientEntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
