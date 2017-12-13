package com.alexandrov.clientrest.config;

import com.alexandrov.clientrest.config.model.Config;
import com.alexandrov.clientrest.config.model.EntityConfig;
import com.alexandrov.clientrest.repo.ClientRestRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DefaultClientRestConfiguration implements ClientRestConfiguration {

    protected final Config config;

    public DefaultClientRestConfiguration() {

        config = parseClientRestConfig();
    }

    protected Config parseClientRestConfig() {

        Config config = new Config();

        EntityConfig nodeConfig = new EntityConfig();
        nodeConfig.className = "com.alexandrov.example.model.Node";
        nodeConfig.alias = "node";
        nodeConfig.repoClassName = "com.alexandrov.example.storage.NodeRepository";

        EntityConfig portConfig = new EntityConfig();
        portConfig.className = "com.alexandrov.example.model.Port";
        portConfig.alias = "port";
        portConfig.repoClassName = "com.alexandrov.example.storage.PortRepository";

        config.entityConfigs.add(nodeConfig);
        config.entityConfigs.add(portConfig);
        try {
            config.aliasRepoMapping.put(nodeConfig.alias, (ClientRestRepository) Class.forName(nodeConfig.repoClassName).newInstance());
            config.aliasRepoMapping.put(portConfig.alias, (ClientRestRepository) Class.forName(portConfig.repoClassName).newInstance());

        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }

        config.references.put(new Config.Pair("port", "node"), "nodeId");

        return config;
    }

    @Override
    public ClientRestRepository getRepository(String entity) {
        return Optional
                .ofNullable(config.aliasRepoMapping.get(entity))
                .orElseThrow(() -> new IllegalArgumentException("Unknown entity: " + entity));
    }

    @Override
    public String getReferenceField(Config.Pair pair) {
        return config.references.get(pair);
    }
}
