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

    @Autowired
    private UserRepository ur;

    @Autowired
    private SorteioRepository sr;

    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("sorteio");
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView form(@Validated User user, Sorteio sorteio) {
        User users = ur.findByEmail(user.getEmail());
        if (users != null) {
            sorteio.setUser(users);
            sr.save(sorteio);
        } else {
            ur.save(user);
            sorteio.setUser(user);
            sr.save(sorteio);

        }
        ModelAndView mv = new ModelAndView("sorteio");
        mv.addObject("sorteio", sorteio);
        return mv;


    }


}
