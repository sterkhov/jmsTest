package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/mq/")
public class MQController {

    @GetMapping(value = "receive")
    public void findStatement() {

    }


}
