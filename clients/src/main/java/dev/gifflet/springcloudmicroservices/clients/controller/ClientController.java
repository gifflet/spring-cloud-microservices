package dev.gifflet.springcloudmicroservices.clients.controller;

import dev.gifflet.springcloudmicroservices.clients.domain.Client;
import dev.gifflet.springcloudmicroservices.clients.dto.ClientSaveRequest;
import dev.gifflet.springcloudmicroservices.clients.mapper.ClientMapper;
import dev.gifflet.springcloudmicroservices.clients.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("clients")
@RequiredArgsConstructor
@Slf4j
public class ClientController {

    private final ClientService clientService;

    private final ClientMapper clientMapper;

    @PostMapping
    public ResponseEntity save(@RequestBody ClientSaveRequest client) {
        if (clientService.existsByCpf(client.getCpf())) {
            log.warn("Client with cpf {} already exists", client.getCpf());
            return ResponseEntity.badRequest().build();
        }
        log.info("Saving client {}", client);
        Client entity = clientMapper.toModel(client);
        clientService.save(entity);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .query("cpf={cpf}")
                .buildAndExpand(entity.getCpf())
                .toUri();
        log.info("Client saved with id {}", entity.getId());
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<Client> findByCpf(@RequestParam String cpf) {
        log.info("Finding client with cpf {}", cpf);
        Client client = clientService.findByCpf(cpf);
        log.info("Client found {}", client);
        return ResponseEntity.ok(client);

    }
}
