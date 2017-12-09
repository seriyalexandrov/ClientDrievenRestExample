package com.alexandrov.clientrest.repo;

import com.alexandrov.clientrest.storage.SimpleMapStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class GraphClientRest implements ClientRestRepository {

    private SimpleMapStorage storage;

    @Autowired
    public GraphClientRest(SimpleMapStorage storage) {
        this.storage = storage;
    }

    @Override
    public Collection getEntities(String entity) {
        switch (entity) {
            case "node":
                return storage.getNodes();
            case "port":
                return storage.getPorts();
            case "link":
                return storage.getLinks();
            default:
                throw new IllegalArgumentException("No entity: " + entity);
        }
    }

    @Override
    public Object getEntityById(String entity, String id) {
        switch (entity) {
            case "node":
                return storage.getNodeById(id);
            case "port":
                return storage.getPortById(id);
            case "link":
                return storage.getLinkById(id);
            default:
                throw new IllegalArgumentException("No entity: " + entity);
        }
    }
}
