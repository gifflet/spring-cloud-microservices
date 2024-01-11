package dev.gifflet.springcloudmicroservices.clients.repository;

import dev.gifflet.springcloudmicroservices.clients.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findByCpf(String cpf);

    Boolean existsByCpf(String cpf);
}
