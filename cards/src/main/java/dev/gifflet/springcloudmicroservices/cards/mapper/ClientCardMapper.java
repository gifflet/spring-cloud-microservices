package dev.gifflet.springcloudmicroservices.cards.mapper;

import dev.gifflet.springcloudmicroservices.cards.domain.ClientCard;
import dev.gifflet.springcloudmicroservices.cards.dto.ClientCardResponse;
import org.mapstruct.MapMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClientCardMapper {

    @Mapping(target = "name", source = "clientCard.card.name")
    @Mapping(target = "brand", source = "clientCard.card.brand")
    @Mapping(target = "creditLimit", source = "clientCard.card.creditLimit")
    ClientCardResponse toResponse(ClientCard clientCard);
}
