package ru.sut.BrainField.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.sut.BrainField.model.dbo.CellContentDao;
import ru.sut.BrainField.model.event.UIEditCell;
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


    @GetMapping({"/", "/index"})
    public String root(Model model) {
        model.addAttribute("comName1", nameCmd1);
        model.addAttribute("comName2", nameCmd2);
        model.addAttribute("fieldCom1", teamService.getField1());
        model.addAttribute("fieldCom2", teamService.getField2());
        return "game"; //view
    }


    @GetMapping({"/mon{num}", "/index/mon{num}"})
    public String singleMonitor(Model model, @PathVariable int num) {
        if (num == 1) {
            model.addAttribute("comName", nameCmd1);
            model.addAttribute("fieldCom", teamService.getField1());
        } else if (num == 2){
            model.addAttribute("comName", nameCmd2);
            model.addAttribute("fieldCom", teamService.getField2());
        } else {
            return "redirect:/";
        }
        return "game-single"; //view
    }



    @GetMapping("/config")
    public String root2(Model model) {
        model.addAttribute("comName1", nameCmd1);
        model.addAttribute("comName2", nameCmd2);
        model.addAttribute("fieldCom1", teamService.getField1());
        model.addAttribute("fieldCom2", teamService.getField2());
        return "config"; //view
    }

    @GetMapping("/config/{cid}")
    public String editCell(Model model, @PathVariable String cid) {
        CellContentDao cellContent = teamService.getCellByCssId(cid);
        //model.addAttribute("cell", cellContent);
        model.addAttribute("images", teamService.getImageList());
        model.addAttribute("sounds", teamService.getSoundList());
        model.addAttribute("cellui", new UIEditCell(cid));
        return "config-cell" ;
    }

    @PostMapping("/config")
    public String saveCell(Model model, @ModelAttribute UIEditCell cellui) {
        model.addAttribute("cellui", cellui);
        teamService.setCellConfig(cellui);
        return "redirect:/config";
    }



    @GetMapping("/reset")
    public String reset(Model model) {
        teamService.configureField();
        return "redirect:/"; //view
    }
}
