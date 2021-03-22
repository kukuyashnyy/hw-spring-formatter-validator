package org.itstep.controller;

import org.itstep.domain.dto.CustomUserDto;
import org.itstep.domain.entity.CustomUser;
import org.itstep.domain.repository.CustomUserRepository;
import org.itstep.domain.validator.CustomUserDtoValidator;
import org.springframework.beans.factory.annotation.Autowired;
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

    private final CustomUserRepository repository;

    @Autowired
    public HomeController(CustomUserRepository repository) {
        this.repository = repository;
    }


    @InitBinder
    public void init(WebDataBinder dataBinder) {
        dataBinder.addValidators(new CustomUserDtoValidator(repository));
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("customUserDto", new CustomUserDto());
        return "index";
    }

    @PostMapping
    private String create(@Validated @ModelAttribute CustomUserDto customUserDto,
                          BindingResult bindingResult) {
        System.out.println("user = " + customUserDto);
        if (bindingResult.hasErrors()) {
            System.out.println("bindingResult = " + bindingResult);
            return "index";
        } else {
            repository.save(new CustomUser(customUserDto.getLogin(), customUserDto.getPassword()));
        }
        return "redirect:/";
    }
}
