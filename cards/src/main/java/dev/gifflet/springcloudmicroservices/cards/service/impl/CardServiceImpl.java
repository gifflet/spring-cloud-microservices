package dev.gifflet.springcloudmicroservices.cards.service.impl;

import dev.gifflet.springcloudmicroservices.cards.domain.Card;
import dev.gifflet.springcloudmicroservices.cards.repository.CardRepository;
import dev.gifflet.springcloudmicroservices.cards.service.CardService;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    @Getter(AccessLevel.PRIVATE)
    private final CardRepository cardRepository;
    @Override
    public Card saveCard(Card card) {
        return getCardRepository().save(card);
    }

    @Override
    public List<Card> getCardsWithIncomeLessThan(long incomeLimit) {
        return getCardRepository().findByIncomeLessThanEqual(BigDecimal.valueOf(incomeLimit));
    }
}
