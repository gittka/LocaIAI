package org.alxtek.locaiai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UtilController {
    @GetMapping("/")
    public String index() {
        return "index";
    }
}
