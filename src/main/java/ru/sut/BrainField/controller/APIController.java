package ru.sut.BrainField.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import ru.sut.BrainField.model.dbo.QuestionDao;
import ru.sut.BrainField.model.dto.CellModelDto;
import ru.sut.BrainField.model.event.UIEventGamer;
import ru.sut.BrainField.model.event.UIPushGamer;
import ru.sut.BrainField.service.TeamService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

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

        CellModelDto ctls = TeamService.field.getCellByCssId(event.getTarget());

        if (ctls.getQuestionDao() != null){
            QuestionDao qdao = ctls.getQuestionDao();
            response.setColor("#ff0000");
            response.setAction(Boolean.TRUE);
            response.setActionData(qdao.getQuestText());
            response.setActionReq1(qdao.getAnswers().get(0).getAnsText());
            response.setActionReq2(qdao.getAnswers().get(1).getAnsText());
            response.setActionReq3(qdao.getAnswers().get(2).getAnsText());

        } else{
            response.setColor("#5a5a5a");
            response.setAction(Boolean.FALSE);
        }

        ctls.setCellPressed(Boolean.TRUE);
        return response;
    }
}
