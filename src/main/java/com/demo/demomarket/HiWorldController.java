package com.demo.demomarket;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saludar")
public class HiWorldController {

    @GetMapping("/hola")
    public  String saludar() {
        return  "never stop learning";
    }
}
