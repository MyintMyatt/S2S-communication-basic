package com.example.S2S_Communication.service.rest_template;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service("rest-template")
public class RestTemplateService implements com.example.S2S_Communication.service.Service {

    @Autowired
    private RestTemplate restTemplate;

    private static final String url = "https://jsonplaceholder.typicode.com/posts/";


    @Override
    public Object get(int id) {
       return restTemplate.getForObject(url+id, Object.class);
    }


    @Override
    public <T> Mono<T> getAll() {
        return null;
    }

    @Override
    public Object post(Object object) {
        return restTemplate.postForObject(url, object, Object.class);
    }

    @Override
    public String put(String id, Object object) {
        restTemplate.put(url+id,object);
        return "successfully updated";
    }

    @Override
    public String delete(String id) {
        restTemplate.delete(url+id);
        return "success fully deleted";
    }


}
