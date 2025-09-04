package com.example.S2S_Communication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;

import java.util.Collections;

@Configuration
public class AppConfig {

    /*Rest Template*/

    @Bean
    public RestTemplate restTemplate() {
        /*optional*/
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setConnectTimeout(5000);
//        factory.setConnectionRequestTimeout(5000);
        factory.setReadTimeout(5000);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(factory);
        restTemplate.setInterceptors(Collections.singletonList(new CustomHttpRequestInterceptor()));

        return restTemplate;
    }

     class CustomHttpRequestInterceptor implements ClientHttpRequestInterceptor {
        @Override
        public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
            System.out.println("request =>" + request.getAttributes()+"-" + request.getURI() + "-" + request.getHeaders()+ "-" + request.getMethod());
            ClientHttpResponse response = execution.execute(request, body);
            System.out.println("response =>" + response.getHeaders() + "-" +  response.getBody());
            return response;
        }
    }

    /*WebClient*/
    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl("https://jsonplaceholder.typicode.com/posts/")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }


}
