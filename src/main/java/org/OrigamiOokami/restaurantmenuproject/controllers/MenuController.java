package org.OrigamiOokami.restaurantmenuproject.controllers;


import org.OrigamiOokami.restaurantmenuproject.models.Menu;
import org.OrigamiOokami.restaurantmenuproject.models.MenuItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.time.LocalDate;

/*
* add datetime input in form field
* id increments twice
* */

@Controller
@RequestMapping(value = "menu")
class MenuController {

    @RequestMapping(value = "")
    public String index(Model model){
        model.addAttribute("title", "My Menu");
        model.addAttribute("menuList", Menu.getAll());
        return "menu/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddForm(Model model) {
//        model.addAttribute("localDateTime", LocalDateTime.now());

        model.addAttribute("localDate", LocalDate.now());

        model.addAttribute("title", "Add Menu Item");

/* need to be able to discard id incrementation before it gets added to menuList if object isn't validated(currently updates id on page redirect)--which is what should be happening...must be calling abstract unintentionally each time?*/
        model.addAttribute(new MenuItem());
        return "menu/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddForm(@ModelAttribute @Valid MenuItem newItem, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Menu Item");
            return "menu/add";
        }
        Menu.add(newItem);
        return "redirect:";
    }

    @RequestMapping(value = "remove", method= RequestMethod.GET)
    public String displayRemoveForm(Model model){
        model.addAttribute("title", "Remove Menu Item");
        model.addAttribute("menuList", Menu.getAll());
        return "menu/remove";
    }


    //handler to process the form
    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveForm(@RequestParam(required=false) int[] itemIds, Model model) {
        if (itemIds == null){
            model.addAttribute("title", "Remove Menu Item");
            model.addAttribute("menuList", Menu.getAll());
            model.addAttribute("errors", "You can't delete NOTHIN, dummy!");
            return "menu/remove";
        }

        for (int aItemId : itemIds) {
            Menu.remove(aItemId);
        }
        return "redirect:";
    }

}
