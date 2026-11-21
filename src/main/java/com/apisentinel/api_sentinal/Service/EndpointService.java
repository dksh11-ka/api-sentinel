package com.apisentinel.api_sentinal.Service;

import com.apisentinel.api_sentinal.Dto.EndpointRequestDto;
import com.apisentinel.api_sentinal.Entity.Endpoint;
import com.apisentinel.api_sentinal.Repository.EndpointRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EndpointService {

    private final EndpointRepository endpointRepository;



    public EndpointService(EndpointRepository endpointRepository) {
        this.endpointRepository = endpointRepository;
    }

    public Endpoint createEndpoint(EndpointRequestDto endpointRequestDto){
        Endpoint endpoint = DtoToEntityEndpoint(endpointRequestDto);
        return endpointRepository.save(endpoint);

    }
    public Optional<Endpoint> getEndpointById(Long id){
            return endpointRepository.findById(id);
    }
    public boolean deleteEndpointById(Long id) {
        if (!endpointRepository.existsById(id)) {
            return false;
        }

        endpointRepository.deleteById(id);
        return true;
    }
    public Optional<Endpoint> updateEndpoint(EndpointRequestDto endpointRequestDto, Long id) {

        Optional<Endpoint> existing = endpointRepository.findById(id);

        if (existing.isEmpty()) {
            return Optional.empty();
        }

        Endpoint endpoint = DtoToEntityEndpoint(endpointRequestDto);


        Endpoint prev = existing.get();

        prev.setName(endpoint.getName());
        prev.setUrl(endpoint.getUrl());
        prev.setActive(endpoint.isActive());

        return Optional.of(endpointRepository.save(prev));
    }

    private Endpoint DtoToEntityEndpoint(EndpointRequestDto endpointRequestDto){
        Endpoint endpoint = new Endpoint();

        endpoint.setName(endpointRequestDto.getName());
        endpoint.setUrl(endpointRequestDto.getUrl());
        endpoint.setActive(true);

        return endpoint;
    }
}

