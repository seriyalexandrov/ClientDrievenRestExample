package com.alexandrov.clientrest.config;

import com.alexandrov.clientrest.config.model.Config;
import com.alexandrov.clientrest.config.model.EntityConfig;
import com.alexandrov.clientrest.repo.ClientRestRepository;
import org.springframework.stereotype.Component;

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
        config.entityConfigs.add(nodeConfig);
        try {
            config.aliasRepoMapping.put(nodeConfig.alias, (ClientRestRepository) Class.forName(nodeConfig.repoClassName).newInstance());
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }

        return config;
    }

    @Override
    public ClientRestRepository getRepository(String entity) {
        return config.aliasRepoMapping.get(entity);
    }
}
