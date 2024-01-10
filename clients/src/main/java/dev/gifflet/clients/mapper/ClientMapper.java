package dev.gifflet.clients.mapper;

import dev.gifflet.clients.domain.Client;
import dev.gifflet.clients.dto.ClientSaveRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper{

    Client toModel(ClientSaveRequest clientSaveRequest);

}
