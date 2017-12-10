package com.alexandrov.clientrest;

import com.alexandrov.clientrest.engine.ClientRest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api")
public class HttpRestController {

    private ClientRest clientRest = new ClientRest();


    @GetMapping(value = "{entity}")
    public Object getEntityById(@PathVariable() String entity, @RequestParam(required = false) String include) {
        return clientRest.getEntities(entity, include);
    }

    @GetMapping(value = "{entity}/{id}")
    public Object getEntityById(@PathVariable() String entity, @PathVariable String id, @RequestParam(required = false) String include) {
        return clientRest.getEntityById(entity, id, include);
    }
}
