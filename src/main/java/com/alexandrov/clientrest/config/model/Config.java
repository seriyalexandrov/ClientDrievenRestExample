package com.alexandrov.clientrest.config.model;

import com.alexandrov.clientrest.repo.ClientRestRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Config {

    public List<EntityConfig> entityConfigs = new ArrayList<>();
    public Map<String, ClientRestRepository> aliasRepoMapping = new HashMap<>();
}
