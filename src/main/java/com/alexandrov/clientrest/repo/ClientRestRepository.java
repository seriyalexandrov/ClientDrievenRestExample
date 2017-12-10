package com.alexandrov.clientrest.repo;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collection;

public interface ClientRestRepository {

    Collection getEntities(String className, String include);

    Object getEntityById(String entity, String id, String include);
}
