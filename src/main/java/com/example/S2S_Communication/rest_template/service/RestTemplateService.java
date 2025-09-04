package com.example.S2S_Communication.rest_template.service;


import com.example.S2S_Communication.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class RestTemplateService {

    @Autowired
    private RestTemplate restTemplate;

    private static final String url = "https://jsonplaceholder.typicode.com/posts/";


    public Object get(int id) {
       return restTemplate.getForObject(url+id, Object.class);
    }

    public Object post(Object object) {
        return restTemplate.postForObject(url, object, Object.class);
    }

    public String put(String id ,Object object) {
        restTemplate.put(url+id,object);
        return "successfully updated";
    }

    public String delete(String id) {
        restTemplate.delete(url+id);
        return "success fully deleted";
    }


}
