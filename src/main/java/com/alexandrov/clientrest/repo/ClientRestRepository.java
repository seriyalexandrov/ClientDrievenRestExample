package com.alexandrov.clientrest.repo;

import java.util.Collection;

public interface ClientRestRepository {

    Collection getEntities(String className);

    Object getEntityById(String entity, String id);
}
