package com.apisentinel.api_sentinal.Controller;

import com.apisentinel.api_sentinal.Dto.EndpointRequestDto;
import com.apisentinel.api_sentinal.Entity.Endpoint;
import com.apisentinel.api_sentinal.Service.EndpointService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class EndpointController {

    private final EndpointService endpointService;

    public EndpointController(EndpointService endpointService) {
        this.endpointService = endpointService;
    }

    @PostMapping("/api/v1/endpoints")
    public ResponseEntity<Endpoint> createEndpoint(@Valid @RequestBody EndpointRequestDto
                                                             endpointRequestDto){
        Endpoint endpoint = endpointService.createEndpoint(endpointRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(endpoint);

    }
    @GetMapping("/api/v1/endpoints/{id}")
    public ResponseEntity<Endpoint> getEndpointById(@PathVariable Long id) {

        Optional<Endpoint> endpoint = endpointService.getEndpointById(id);

        if (endpoint.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(endpoint.get());
        }
    }
}
