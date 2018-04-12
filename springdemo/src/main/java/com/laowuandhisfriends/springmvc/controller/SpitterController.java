package com.laowuandhisfriends.springmvc.controller;

import com.laowuandhisfriends.springmvc.entity.Spitter;
import com.laowuandhisfriends.springmvc.service.SpitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
@RequestMapping("/spitter")
public class SpitterController {
    private final SpitterService spitterService;

    @Autowired
    public SpitterController(SpitterService spitterService) {
        this.spitterService = spitterService;
    }

    @RequestMapping(value = "/spittles", method = GET)
    public String listSpittlesForSpitter(@RequestParam("spitter") String username, Model model) {
        Spitter spitter = spitterService.getSpitter(username);
        model.addAttribute(spitter);
        model.addAttribute(spitterService.getSpittlesForSpitter(username));
        return "spittles/list";
    }

    @RequestMapping(method = GET, params = "new")
    public String createSpitterProfile(Model model) {
        model.addAttribute(new Spitter());
        return "spitters/edit";
    }

    @RequestMapping(method = POST)
    public String addSpitterForm(@Validated Spitter spitter, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "spitters/edit";
        }

        spitterService.saveSpitter(spitter);
        return "redirect:/spitters/" + spitter.getUsername();
    }
}
