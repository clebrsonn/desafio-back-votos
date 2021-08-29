package br.com.hytech.rhsouthsystem.service.associate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Service
public class CPFValidator {

    @Value("${external.validate.cpf}")
    private String url;


    public boolean validate(String cpf){
        try{

            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(List.of(MediaType.APPLICATION_JSON));

            HttpEntity<String> requestEntity = new HttpEntity<>(headers);
            RestTemplate restTemplate = new RestTemplate();
            var params = new HashMap<String, String>();
            params.put("cpf", cpf);
            ResponseEntity<String> responseEntity = restTemplate
                    .exchange(url, HttpMethod.GET, requestEntity,String.class, params);

            return Objects.requireNonNull(responseEntity.getBody()).equalsIgnoreCase("ABLE_TO_VOTE");
        }catch (HttpClientErrorException e){
            assert HttpStatus.NOT_FOUND.value() == e.getRawStatusCode();
            return false;
        }
    }
}
