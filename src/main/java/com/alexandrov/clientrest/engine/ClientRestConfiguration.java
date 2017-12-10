package com.alexandrov.clientrest.engine;

import java.util.List;

public interface ClientRestConfiguration {

    List<String> getEntities();

    void addEntity(String entityClassName);
}
