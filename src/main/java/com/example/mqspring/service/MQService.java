package com.example.mqspring.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import com.example.mqspring.domains.Message;

/**
 * @author shubhendu
 * @since 02/04/20
 */
@Service
public class MQService {
    @Autowired
    private JmsTemplate jmsTemplate;

    public Optional<String> sendMessage(final Message message) {
        try {
            jmsTemplate.convertAndSend(jmsTemplate.getDefaultDestination(), message.getText());
        } catch (final JmsException e) {
            return Optional.empty();
        }
        return Optional.of(message.getText());
    }
}
