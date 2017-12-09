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


    @GetMapping(value = "{entity}")
    public Object getEntityById(@PathVariable() String entity, @RequestParam(required = false) String include) {
        return clientRestRepo.getEntities(entity, include);
    }

    @GetMapping(value = "{entity}/{id}")
    public Object getEntityById(@PathVariable() String entity, @PathVariable String id, @RequestParam(required = false) String include) {
        return clientRestRepo.getEntityById(entity, id, include);
    }
}
