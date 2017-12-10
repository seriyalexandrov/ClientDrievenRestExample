package com.alexandrov.clientrest.engine;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DefaultClientRestConfiguration implements ClientRestConfiguration {

    private final List<String> entityClassNames;

    public DefaultClientRestConfiguration() {
        this.entityClassNames = new ArrayList<>();
    }


    @Override
    public List<String> getEntities() {
        return entityClassNames;
    }

    @Override
    public void addEntity(String entityClassName) {
        entityClassNames.add(entityClassName);
    }
}
