package com.alexandrov.clientrest.storage;

import com.alexandrov.clientrest.model.Link;
import com.alexandrov.clientrest.model.Node;
import com.alexandrov.clientrest.model.Port;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Component
public class SimpleMapStorage {

    private final ConcurrentMap<String, Node> nodes = new ConcurrentHashMap<>();
    private final ConcurrentMap<String, Port> ports = new ConcurrentHashMap<>();
    private final ConcurrentMap<String, Link> links = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        pushNode(new Node("1", "n1"));
        pushNode(new Node("2", "n2"));

        pushPort(new Port("1_1", "1", "p1_1"));
        pushPort(new Port("2_1", "2", "p2_11"));

        pushLink(new Link("1_1-2_1", "1", "2", "1_1", "2_1", "l1"));
    }

    public void pushNode(Node node) {
        nodes.put(node.getId(), node);
    }

    public void pushPort(Port port) {
        ports.put(port.getId(), port);
    }

    public void pushLink(Link link) {
        links.put(link.getId(), link);
    }

    public Node getNodeById(String nodeId) {
        return nodes.get(nodeId);
    }

    public Port getPortById(String portId) {
        return ports.get(portId);
    }

    public Link getLinkById(String linkId) {
        return links.get(linkId);
    }

    public Collection<Node> getNodes() {
        return nodes.values();
    }

    public Collection<Port> getPorts() {
        return ports.values();
    }

    public Collection<Link> getLinks() {
        return links.values();
    }
}
