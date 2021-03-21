package org.itstep.controller;

import org.itstep.domain.dto.CustomUserDto;
import org.itstep.domain.validator.CustomUserDtoValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @InitBinder
    public void init(WebDataBinder dataBinder) {
        dataBinder.addValidators(new CustomUserDtoValidator());
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("user", new CustomUserDto());
        return "index";
    }

    @PostMapping
    private String create(@Validated @ModelAttribute CustomUserDto user,
                          BindingResult bindingResult) {
        System.out.println("user = " + user);
        if (bindingResult.hasErrors()) {
            return "index";
        }
        return "redirect:/";
    }
}
