package com.apisentinel.api_sentinal.Repository;

import com.apisentinel.api_sentinal.Entity.Endpoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EndpointRepository extends JpaRepository<Endpoint,Long> {

}
