package ru.sut.BrainField.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import ru.sut.BrainField.model.event.UIEventGamer;
import ru.sut.BrainField.model.event.UIPushGamer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Controller
public class APIController {

    static Logger log = LoggerFactory.getLogger(APIController.class);

    @MessageMapping("/event")
    @SendTo("/topic/messages")
    public UIPushGamer send(final UIEventGamer event) throws Exception {
        log.info("=====>>>> SEND to ChatController (/table)");
        final String time = new SimpleDateFormat("HH:mm:ss").format(new Date());

        UIPushGamer response = new UIPushGamer(event.getCommandName(), event.getTarget());
        if (new Random().nextInt(10) > 4){
            response.setColor("#ff0000");
            response.setAction(Boolean.TRUE);
            response.setActionData("Message1");
            response.setActionReq1("setActionReq1");
            response.setActionReq1("setActionReq2");
        } else{
            response.setColor("#ccc000");
            response.setAction(Boolean.TRUE);
        }

        return response;
    }
}
