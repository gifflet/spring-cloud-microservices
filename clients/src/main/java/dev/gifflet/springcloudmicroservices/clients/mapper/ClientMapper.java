package dev.gifflet.springcloudmicroservices.clients.mapper;

import dev.gifflet.springcloudmicroservices.clients.domain.Client;
import dev.gifflet.springcloudmicroservices.clients.dto.ClientSaveRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper{

    Client toModel(ClientSaveRequest clientSaveRequest);

}
