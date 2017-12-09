package com.alexandrov.clientrest;

import com.alexandrov.clientrest.repo.ClientRestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api")
public class HttpRestController {

    private ClientRestRepository clientRestRepo;

    @Autowired
    public HttpRestController(ClientRestRepository clientRestRepo) {
        this.clientRestRepo = clientRestRepo;
    }

    @GetMapping(value = "{entity}/{id}")
    public Object getEntityById(@PathVariable() String entity, @PathVariable String id) {
        return clientRestRepo.getEntityById(entity, id);
    }

    @GetMapping(value = "{entity}")
    public Object getEntityById(@PathVariable() String entity) {
        return clientRestRepo.getEntities(entity);
    }

}
