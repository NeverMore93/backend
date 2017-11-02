package com.peini.backend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class BaseController {
    private static final Logger logger = LoggerFactory.getLogger(BaseController.class);

    //    test/id
    @RequestMapping(value = "/test/{id}",method = RequestMethod.GET)
    public String test(@PathVariable("id") Integer id){
        return id+"";
    }

    //test?id={id}
    @GetMapping("/test")
    public String test2(@RequestParam(value = "id",required = false,defaultValue = "0") Integer id){
        return "test"+id;
    }
}
