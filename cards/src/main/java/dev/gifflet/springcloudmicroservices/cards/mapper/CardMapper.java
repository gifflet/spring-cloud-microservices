package dev.gifflet.springcloudmicroservices.cards.mapper;

import dev.gifflet.springcloudmicroservices.cards.domain.Card;
import dev.gifflet.springcloudmicroservices.cards.dto.CardSaveRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CardMapper {

    CardSaveRequest toRequest(Card card);

    Card toDomain(CardSaveRequest request);


}
