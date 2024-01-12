package dev.gifflet.springcloudmicroservices.cards.repository;

import dev.gifflet.springcloudmicroservices.cards.domain.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface CardRepository extends JpaRepository<Card, Long> {

    List<Card> findByIncomeLessThanEqual(BigDecimal bigDecimal);
}
