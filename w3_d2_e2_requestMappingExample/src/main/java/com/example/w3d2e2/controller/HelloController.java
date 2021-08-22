package com.example.w3d2e2.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {


    @GetMapping("/echo/[t]")
    Echo echo(@PathVariable("t") String input, @PathVariable("key") String key){
        Echo echoMessage = new Echo();
        echoMessage.setName(input);
        echoMessage.setSurname(key);
        return echoMessage;
    }

    @PostMapping("/echo/")
    String echo2(){
        return "as2";
    }


}
