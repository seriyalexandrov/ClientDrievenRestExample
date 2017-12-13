package com.alexandrov.example.storage;

import com.alexandrov.clientrest.repo.ClientRestRepository;
import com.alexandrov.example.model.Port;

import java.util.Collection;

public class PortRepository implements ClientRestRepository<Port> {

    private SimpleMapStorage storage = new SimpleMapStorage();

    @Override
    public Collection<Port> getEntities() {
        return storage.getPorts();
    }

    @Override
    public Port getEntityById(String id) {
        return storage.getPortById(id);
    }
}
