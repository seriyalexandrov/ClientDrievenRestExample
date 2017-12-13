package com.alexandrov.clientrest.engine;

import com.alexandrov.clientrest.config.ClientRestConfiguration;
import com.alexandrov.clientrest.config.DefaultClientRestConfiguration;
import com.alexandrov.clientrest.config.model.Config;
import com.alexandrov.clientrest.repo.ClientRestRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class ClientRest {

    private ClientRestConfiguration config;
    private ObjectMapper mapper = new ObjectMapper();

    public ClientRest() {
        this.config = new DefaultClientRestConfiguration();
    }

    public Collection getEntities(String entity, String include) {

        if (include != null) {
            ClientRestRepository includeRepo = config.getRepository(include);
            List<Map<String, Object>> classMap = new ArrayList<>();
            classMap = mapper.convertValue(config.getRepository(entity).getEntities(), classMap.getClass());
            String idFieldName = config.getReferenceField(new Config.Pair(entity, include));
            for (Map<String, Object> o : classMap) {
                o.put(idFieldName, includeRepo.getEntityById((String) o.get(idFieldName)));
            }
            return classMap;
        } else {
            return config.getRepository(entity).getEntities();
        }
    }

    public Object getEntityById(String entity, String id, String include) {
        return config.getRepository(entity).getEntityById(id);
    }
}
