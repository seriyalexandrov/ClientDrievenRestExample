package com.alexandrov.clientrest.config.model;

import com.alexandrov.clientrest.repo.ClientRestRepository;

import java.util.*;

public class Config {

    public List<EntityConfig> entityConfigs = new ArrayList<>();
    public Map<String, ClientRestRepository> aliasRepoMapping = new HashMap<>();
    public Map<Pair, String> references = new HashMap<>();

    public static class Pair {

        public Pair(String base, String ref) {
            this.base = base;
            this.ref = ref;
        }

        public String base;
        public String ref;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return Objects.equals(base, pair.base) &&
                    Objects.equals(ref, pair.ref);
        }

        @Override
        public int hashCode() {
            return Objects.hash(base, ref);
        }
    }
}
