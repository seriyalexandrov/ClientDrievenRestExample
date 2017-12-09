package com.alexandrov.clientrest.repo;

import com.alexandrov.clientrest.model.Node;
import com.alexandrov.clientrest.model.Port;
import com.alexandrov.clientrest.storage.SimpleMapStorage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;

@Component
public class GraphClientRest implements ClientRestRepository {

    private SimpleMapStorage storage;

    @Autowired
    public GraphClientRest(SimpleMapStorage storage) {
        this.storage = storage;
    }

    @Override
    public Collection getEntities(String entity, String include) {
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
    public Object getEntityById(String entity, String id, String include) {
        switch (entity) {
            case "node": {
                return storage.getNodeById(id);
            }
            case "port": {
                if (include != null && include.equalsIgnoreCase("node")) {
                    Port port = storage.getPortById(id);
                    Map<String, Object> portMap = new ObjectMapper().convertValue(port, Map.class);
                    Node node = storage.getNodeById(port.getNodeId());
                    portMap.put("nodeId", node);
                    return portMap;
                } else {
                    return storage.getPortById(id);
                }

            }
            case "link":
                return storage.getLinkById(id);
            default:
                throw new IllegalArgumentException("No entity: " + entity);
        }
    }
}
