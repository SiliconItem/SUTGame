package ru.sut.BrainField.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.sut.BrainField.service.TeamService;

@Controller
public class GameController {

    static Logger log = LoggerFactory.getLogger(GameController.class);

    @Autowired
    private TeamService teamService;
    @Value("${app.field.NameA}")
    private String nameCmd1;
    @Value("${app.field.NameB}")
    private String nameCmd2;


    @GetMapping("/")
    public String root(Model model) {
        if (TeamService.field == null){
            teamService.configureField();
        }
        model.addAttribute("comName1", nameCmd1);
        model.addAttribute("comName2", nameCmd2);
        model.addAttribute("field", TeamService.field);
        return "game"; //view
    }

    @GetMapping("/reset")
    public String reset(Model model) {
        teamService.configureField();
        return "/"; //view
    }
}
