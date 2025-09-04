package com.example.S2S_Communication.service.webclient;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service("web-client")
public class WebClientService implements com.example.S2S_Communication.service.Service {

    @Autowired
    private WebClient webClient;


    @Override
    public Mono<List<Post>> getAll() {
        return webClient.get()                
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Post>>() {});
    }


    @Override
    public Mono<String> get(int id) {
        return webClient.get()
                .uri(String.valueOf(id))
                .retrieve()
                .bodyToMono(String.class);
    }

    @Override
    public Mono<String> post(Object object) {
        return webClient.post()
                .bodyValue(object)
                .retrieve()
                .bodyToMono(String.class);
    }

    @Override
    public Mono<String> put(String id, Object object) {
        return webClient.put()
                .uri(String.valueOf(id))
                .bodyValue(object)
                .retrieve()
                .bodyToMono(String.class);
    }

    @Override
    public String delete(String id) {
        webClient.delete().uri(String.valueOf(id));
        return "deleted successfully";
    }
}
  class Post {
    private Integer id;
    private String title;
    private String body;

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
