package dev.gifflet.springcloudmicroservices.creditassessments.client;

import dev.gifflet.springcloudmicroservices.creditassessments.dto.CardDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "cards", path = "/cards")
public interface CardResourceClient {

    @GetMapping(params = "cpf")
    ResponseEntity<List<CardDto>> findByCpf(@RequestParam String cpf);
}
