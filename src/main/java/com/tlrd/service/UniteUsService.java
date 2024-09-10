package com.tlrd.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;


import com.tlrd.config.ApiProperties;
import com.tlrd.model.Category;

@Service
public class UniteUsService {

    @Autowired
    private ApiProperties apiProperties;
    
    private static final Logger logger = LoggerFactory.getLogger(HandlerInterceptor.class);


    private final RestTemplate restTemplate = new RestTemplate();

    public List<Category> getCategories() {
        String url = apiProperties.getBaseUrl() + "categories";  // Adjust "endpoint" as needed
       
        String apiKey = apiProperties.getApiKey();
        
        logger.info("Api key fetched from Config Server");

        // Set the required headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("Api-key", apiProperties.getApiKey()); 
        // Create the HTTP entity with headers
        HttpEntity<String> entity = new HttpEntity<>(headers);

        // Make the GET request to the vendor API
        ResponseEntity<List<Category>> response = restTemplate.exchange(url, HttpMethod.GET, entity,  new ParameterizedTypeReference<List<Category>>() {});
        logger.info("Receive response from UniteUS App"); 

        return response.getBody();
    }
    

}
