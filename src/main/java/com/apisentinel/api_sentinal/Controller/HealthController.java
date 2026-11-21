package com.apisentinel.api_sentinal.Controller;

import com.apisentinel.api_sentinal.Dto.HealthResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
    @GetMapping("/api/v1/health")
    public HealthResponseDto healthapi(){
        return new HealthResponseDto("up","API sentinel is running");
    }

}
