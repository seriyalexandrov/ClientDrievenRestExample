package com.alexandrov.clientrest.model;

import lombok.ToString;

@ToString
public class Link {

    public Link(String id, String srcNodeId, String dstNodeId, String srcPortId, String dstPortId, String name) {
        this.id = id;
        this.srcNodeId = srcNodeId;
        this.dstNodeId = dstNodeId;
        this.srcPortId = srcPortId;
        this.dstPortId = dstPortId;
        this.name = name;
    }

    private String id;

    private String srcNodeId;

    private String dstNodeId;

    private String srcPortId;

    private String dstPortId;

    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSrcNodeId() {
        return srcNodeId;
    }

    public void setSrcNodeId(String srcNodeId) {
        this.srcNodeId = srcNodeId;
    }

    public String getDstNodeId() {
        return dstNodeId;
    }

    public void setDstNodeId(String dstNodeId) {
        this.dstNodeId = dstNodeId;
    }

    public String getSrcPortId() {
        return srcPortId;
    }

    public void setSrcPortId(String srcPortId) {
        this.srcPortId = srcPortId;
    }

    public String getDstPortId() {
        return dstPortId;
    }

    public void setDstPortId(String dstPortId) {
        this.dstPortId = dstPortId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
