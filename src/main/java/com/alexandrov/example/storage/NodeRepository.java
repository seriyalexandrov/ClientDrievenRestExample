package com.alexandrov.example.storage;

import com.alexandrov.clientrest.repo.ClientRestRepository;
import com.alexandrov.example.model.Node;

import java.util.Collection;

public class NodeRepository implements ClientRestRepository<Node> {

    private SimpleMapStorage storage = new SimpleMapStorage();

    @Override
    public Collection<Node> getEntities() {
        return storage.getNodes();
    }

    @Override
    public Node getEntityById(String id) {
        return storage.getNodeById(id);
    }
}
