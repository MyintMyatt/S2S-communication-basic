package com.example.S2S_Communication.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface Service {
    <T> Mono<T> getAll();

   <T> T get(int id);

    Object post(Object object);

    <T> T put(String id, Object object);

    String delete(String id);
}
