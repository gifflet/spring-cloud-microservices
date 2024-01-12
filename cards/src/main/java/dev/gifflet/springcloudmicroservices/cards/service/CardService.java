package dev.gifflet.springcloudmicroservices.cards.service;

import dev.gifflet.springcloudmicroservices.cards.domain.Card;

import java.math.BigDecimal;
import java.util.List;

public interface CardService {

    Card saveCard(Card card);

    List<Card> getCardsWithIncomeLessThan(long incomeLimit);
}
