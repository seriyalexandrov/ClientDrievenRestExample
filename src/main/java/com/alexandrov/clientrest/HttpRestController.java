package com.alexandrov.clientrest;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api")
public class HttpRestController {

    @GetMapping
    public String check() {
        return "!";
    }

}
