package org.moy.spring.service;

import org.moy.spring.pojo.Demo;
import org.springframework.web.bind.annotation.*;


public interface HelloService {

    @GetMapping("/hello")
    String index();


    @PostMapping("/demo")
    Demo demo(@RequestHeader("header") String header,
              @RequestParam("param") String param,
              @RequestBody Demo demo);
}
