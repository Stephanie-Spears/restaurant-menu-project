package org.OrigamiOokami.restaurantmenuproject.controllers;


import org.OrigamiOokami.restaurantmenuproject.models.Menu;
import org.OrigamiOokami.restaurantmenuproject.models.MenuItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "")
public class MenuController {

    @RequestMapping(value = "")
    public String index(Model model){
        model.addAttribute("title", "My Menu");
        model.addAttribute("menuList", Menu.getAll());
        return "index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddForm(Model model) {
        model.addAttribute("title", "Add Menu Item");
        model.addAttribute(new Menu());
        return "/add";
    }

}
