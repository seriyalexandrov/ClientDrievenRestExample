package com.alexandrov.clientrest.engine;

import com.alexandrov.clientrest.config.ClientRestConfiguration;
import com.alexandrov.clientrest.config.DefaultClientRestConfiguration;

import java.util.Collection;

public class ClientRest {

    private ClientRestConfiguration configuration;

    public ClientRest() {
        this.configuration = new DefaultClientRestConfiguration();
    }

    public Collection getEntities(String entity, String include) {

        return configuration.getRepository(entity).getEntities();
    }

    public Object getEntityById(String entity, String id, String include) {
        return configuration.getRepository(entity).getEntityById(id);
    }
}
