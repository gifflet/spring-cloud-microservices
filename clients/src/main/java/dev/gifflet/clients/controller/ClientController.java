package dev.gifflet.clients.controller;

import dev.gifflet.clients.domain.Client;
import dev.gifflet.clients.dto.ClientSaveRequest;
import dev.gifflet.clients.mapper.ClientMapper;
import dev.gifflet.clients.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    private final ClientMapper clientMapper;

    @PostMapping
    public ResponseEntity save(@RequestBody ClientSaveRequest client) {
        Client entity = clientMapper.toModel(client);
        clientService.save(entity);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .query("cpf={cpf}")
                .buildAndExpand(entity.getCpf())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<Client> findByCpf(@RequestParam String cpf) {
        return ResponseEntity.ok(clientService.findByCpf(cpf));
    }
}
