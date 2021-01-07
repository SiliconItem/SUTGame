package ru.sut.BrainField.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import ru.sut.BrainField.model.event.UIEventGamer;
import ru.sut.BrainField.model.event.UIPushGamer;

public class APIController {

    static Logger log = LoggerFactory.getLogger(APIController.class);

    @MessageMapping("/app")
    @SendTo("/topic/messages")
    public UIPushGamer notifyAll(final UIEventGamer event) throws Exception {
        log.info("=====>>>> SEND to ChatController (/app)");

        return null;
    }
}
