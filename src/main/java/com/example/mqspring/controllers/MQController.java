package com.example.mqspring.controllers;

import javax.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.JmsException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.mqspring.constants.Channel;
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

    private Logger logger = LoggerFactory.getLogger(MQController.class);

    @ResponseBody
    @PostMapping (produces = "application/json")
    public ResponseEntity<Response> sendMessage(@RequestBody @NotNull Message message) {
        try {
            return new ResponseEntity<>(new Response(mqService.sendMessage(message).isPresent()), HttpStatus.CREATED);
        } catch (JmsException ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public void receiveMessage(@RequestHeader (value = "x-channel") final Channel channel) {
        logger.info(String.format("Channel is %s", channel.name()));
    }
}
