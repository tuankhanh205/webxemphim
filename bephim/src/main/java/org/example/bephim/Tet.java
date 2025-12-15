package org.example.bephim;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tet")
public class Tet {
    @GetMapping
    public String tet(){
        return "tet";
    }
}
