package dev.gifflet.springcloudmicroservices.cards.controller;

import dev.gifflet.springcloudmicroservices.cards.domain.Card;
import dev.gifflet.springcloudmicroservices.cards.dto.CardSaveRequest;
import dev.gifflet.springcloudmicroservices.cards.dto.ClientCardResponse;
import dev.gifflet.springcloudmicroservices.cards.mapper.CardMapper;
import dev.gifflet.springcloudmicroservices.cards.mapper.ClientCardMapper;
import dev.gifflet.springcloudmicroservices.cards.service.CardService;
import dev.gifflet.springcloudmicroservices.cards.service.ClientCardService;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/cards")
@RequiredArgsConstructor
public class CardsController {

    @Getter(AccessLevel.PRIVATE)
    private final CardService cardService;

    @Getter(AccessLevel.PRIVATE)
    private final ClientCardService clientCardService;

    @Getter(AccessLevel.PRIVATE)
    private final CardMapper cardMapper;

    @Getter(AccessLevel.PRIVATE)
    private final ClientCardMapper clientCardMapper;

    @PostMapping
    public ResponseEntity saveCard(@RequestBody CardSaveRequest request) {
        Card card = cardMapper.toDomain(request);
        ResponseEntity.ok(cardService.saveCard(card));
        return ResponseEntity.status(CREATED).build();
    }

    @GetMapping(params = "income")
    public ResponseEntity<List<Card>> getCardsWithIncomeLowerThan(@RequestParam("income") long income) {
        return ResponseEntity.ok(getCardService().getCardsWithIncomeLessThan(income));
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<List<ClientCardResponse>> getCardsByCpf(@RequestParam("cpf") String cpf) {
        return ResponseEntity.ok(getClientCardService().getByCpf(cpf).stream()
                .map(getClientCardMapper()::toResponse)
                .toList());
    }

}
