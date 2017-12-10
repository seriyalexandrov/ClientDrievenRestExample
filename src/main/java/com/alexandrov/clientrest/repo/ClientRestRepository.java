package com.alexandrov.clientrest.repo;

import java.util.Collection;

public interface ClientRestRepository<Entity> {

    Collection<Entity> getEntities();

    Entity getEntityById(String id);
}
