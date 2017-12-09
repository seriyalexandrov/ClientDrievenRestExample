package com.alexandrov.clientrest;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api")
public class HttpRestController {

    @GetMapping(value = "{entity}/{id}")
    public Object getEntityById(@PathVariable() String entity, @PathVariable String id) {
        return entity + "/" + id;
    }

}
