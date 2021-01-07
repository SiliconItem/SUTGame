package ru.sut.BrainField.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.sut.BrainField.model.dto.FieldModel;
import ru.sut.BrainField.model.event.UIEventGamer;
import ru.sut.BrainField.model.event.UIPushGamer;
import ru.sut.BrainField.service.TeamService;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Controller
public class GameController {

    @Value("${app.field.size}")
    private int fieldSize;

    @Autowired

    private TeamService teamService;
    static Logger log = LoggerFactory.getLogger(GameController.class);
    private static FieldModel fma;
    private static FieldModel fmb;

    @GetMapping("/")
    public String main(Model model) {

        if (fma == null)
            fma = teamService.configureField("TRANZISTORI", 4);
        if (fmb == null)
            fmb = teamService.configureField("VARIKAPI", 4);
        model.addAttribute("fma", fma);
        model.addAttribute("fmb", fmb);
        return "game2"; //view
    }


    @MessageMapping("/event")
    @SendTo("/topic/messages")
    public UIPushGamer send(final UIEventGamer event) throws Exception {
        log.info("=====>>>> SEND to ChatController (/table)");
        final String time = new SimpleDateFormat("HH:mm:ss").format(new Date());
        return new UIPushGamer(event.getCommandName(), event.getTarget());
    }

}
