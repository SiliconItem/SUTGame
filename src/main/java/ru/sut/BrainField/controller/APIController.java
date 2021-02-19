package ru.sut.BrainField.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import ru.sut.BrainField.model.dbo.QuestionDao;
import ru.sut.BrainField.model.event.UIEventGamer;
import ru.sut.BrainField.model.event.UIPushGamer;
import ru.sut.BrainField.service.TeamService;


@Controller
public class APIController {

    @Autowired
    private TeamService teamService;

    static Logger log = LoggerFactory.getLogger(APIController.class);


    @MessageMapping("/event")
    @SendTo("/topic/messages")
    public UIPushGamer send(final UIEventGamer event) throws Exception {
        log.debug(event.toString());
        String cidTarget = event.getTarget();
        UIPushGamer response = new UIPushGamer(event.getCommandName(), event.getTarget());
        response.setColor("red");
        return response;
    }
}
