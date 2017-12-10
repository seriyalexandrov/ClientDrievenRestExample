package com.alexandrov.clientrest.model;

import com.alexandrov.clientrest.annotations.ClientRestEntity;
import lombok.ToString;

@ToString
@ClientRestEntity
public class Port {

    public Port(String id, String nodeId, String name) {
        this.id = id;
        this.nodeId = nodeId;
        this.name = name;
    }

    private String id;

    private String nodeId;

    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
