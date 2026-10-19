package com.alex.apitvmaze.client;

import com.alex.apitvmaze.exception.ExternalServiceException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

import java.util.Map;

public class ApiClient {
    private final RestClient restClient;

    public ApiClient(RestClient tvMazeRestClient) {
        this.restClient = tvMazeRestClient;
    }

    public <T> T get(String path, Map<String, Object> queryParams, ParameterizedTypeReference<T> responseType){
        try {
            return restClient.get()
                    .uri(uriBuilder -> {
                        uriBuilder.path(path);
                        queryParams.forEach((key, value) -> uriBuilder.queryParam(key, value));
                        return uriBuilder.build();
                    })
                    .retrieve()
                    .body(responseType);
        } catch (RestClientException e) {
            throw new ExternalServiceException("No se puedo realizar la consulta al servicio: " + path, e);
        }
    }
}
