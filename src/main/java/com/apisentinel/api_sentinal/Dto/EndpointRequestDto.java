package com.apisentinel.api_sentinal.Dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public class EndpointRequestDto {
    @NotBlank
    private String name;
    @NotBlank
    private String url;

    public EndpointRequestDto() {
    }

    public EndpointRequestDto(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
