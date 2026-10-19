package com.alex.apitvmaze.client;

import com.alex.apitvmaze.exception.ExternalServiceException;
import com.alex.apitvmaze.exception.ResourceNotFoundException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

import java.util.Map;

@Component
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
        } catch (HttpClientErrorException.NotFound e) {
            throw new ResourceNotFoundException("No se encontro el recurso solicitado: " + path);
        } catch (RestClientException e) {
            throw new ExternalServiceException("No se pudo realizar la consulta al servicio: " + path, e);
        }
    }
}
