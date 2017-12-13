package com.alexandrov.clientrest.config;

import com.alexandrov.clientrest.config.model.Config;
import com.alexandrov.clientrest.repo.ClientRestRepository;

import java.util.List;

public interface ClientRestConfiguration {

    ClientRestRepository getRepository(String entity);

    String getReferenceField(Config.Pair pair);
}
