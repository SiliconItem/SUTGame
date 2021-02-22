package ru.sut.BrainField.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import ru.sut.BrainField.configuration.AppConst;
import ru.sut.BrainField.model.dbo.CellContentDao;
import ru.sut.BrainField.model.event.UIEventGamer;
import ru.sut.BrainField.model.event.UIPushGamer;
import ru.sut.BrainField.service.TeamService;

@Controller
public class APIController {

    @Autowired
    private TeamService teamService;
    @Value("${app.data.path}")
    private String dataPath;
    @Value("${app.rel.data.path}")
    private String dataRelPath;

    static Logger log = LoggerFactory.getLogger(APIController.class);

    /*
    Репликатор UI -> Broker

     */

    @MessageMapping("/event")
    @SendTo("/topic/messages")
    public UIPushGamer consume(final UIEventGamer event) throws Exception {
        log.debug(event.toString());
        String cidTarget = event.getTarget();
        CellContentDao cell = teamService.getCellByCssId(cidTarget);
        UIPushGamer response = new UIPushGamer(cell);
        response.setImage(dataRelPath + AppConst.IMG_PTH_PART + "/" + response.getImage());
        response.setSound(dataRelPath + AppConst.SND_PTH_PART + "/" + response.getSound());
        return response;
    }
}
