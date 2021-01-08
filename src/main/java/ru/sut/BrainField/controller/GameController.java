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
import ru.sut.BrainField.model.dto.FieldModel;
import ru.sut.BrainField.model.event.UIEventGamer;
import ru.sut.BrainField.model.event.UIPushGamer;
import ru.sut.BrainField.service.TeamService;

import java.text.SimpleDateFormat;
import java.util.Date;

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
        return "game"; //view
    }


}
