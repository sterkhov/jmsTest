package org.example.controller;

import org.example.service.MessageReceiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/mq/")
public class MQController {

    @Autowired
    MessageReceiverService messageReceiverService;

    @GetMapping(value = "receive")
    public void findStatement() {

    }


}
