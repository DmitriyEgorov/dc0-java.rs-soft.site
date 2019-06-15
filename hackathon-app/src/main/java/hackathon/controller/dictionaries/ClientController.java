package hackathon.controller.dictionaries;

import hackathon.exception.ClientEntityNotFoundException;
import hackathon.model.dictionaries.Client;
import hackathon.processor.dictionaries.ClientProcessor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Client> findClient(
            @RequestParam(name = "password") String password,
            @RequestParam(name = "OMS")String OMS) {
        try {
            return ResponseEntity.ok(clientProcessor.findClientByPasswordAndOMS(password, OMS));
        } catch (ClientEntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
