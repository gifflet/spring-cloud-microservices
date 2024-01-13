package dev.gifflet.springcloudmicroservices.creditassessments.client;

import dev.gifflet.springcloudmicroservices.creditassessments.dto.CustomerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "clients", path = "/clients")
public interface ClientResourceClient {

    @GetMapping(params = "cpf")
    ResponseEntity<CustomerDto> findByCpf(@RequestParam String cpf);
}
