package com.sorteioapp.sorteioapp.controllers;

import com.sorteioapp.sorteioapp.models.Sorteio;
import com.sorteioapp.sorteioapp.models.User;
import com.sorteioapp.sorteioapp.repository.SorteioRepository;
import com.sorteioapp.sorteioapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }




}
