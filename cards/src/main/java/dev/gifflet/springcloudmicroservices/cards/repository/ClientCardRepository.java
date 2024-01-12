package dev.gifflet.springcloudmicroservices.cards.repository;

import dev.gifflet.springcloudmicroservices.cards.domain.ClientCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientCardRepository extends JpaRepository<ClientCard, Long> {

    List<ClientCard> findByCpf(String cpf);
}
