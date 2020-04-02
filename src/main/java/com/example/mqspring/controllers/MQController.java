package com.example.mqspring.controllers;

import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.JmsException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.mqspring.domains.Message;
import com.example.mqspring.domains.Response;
import com.example.mqspring.service.MQService;

/**
 * @author shubhendu
 * @since 02/04/20
 */
@Controller
@RequestMapping ("/v1/message")
public class MQController {
    @Autowired
    private MQService mqService;

    @ResponseBody
    @PostMapping (value = "/", produces = "application/json")
    public ResponseEntity<Response> sendMapping(@RequestBody @NotNull Message message) {
        try {
            return new ResponseEntity<>(new Response(mqService.sendMessage(message).isPresent()), HttpStatus.CREATED);
        } catch (JmsException ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
