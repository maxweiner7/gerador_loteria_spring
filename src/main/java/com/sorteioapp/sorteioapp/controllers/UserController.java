package com.sorteioapp.sorteioapp.controllers;

import com.sorteioapp.sorteioapp.models.Sorteio;
import com.sorteioapp.sorteioapp.models.User;
import com.sorteioapp.sorteioapp.repository.SorteioRepository;
import com.sorteioapp.sorteioapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping(value = "/")
public class UserController {

    @Autowired
    private UserRepository ur;

    @Autowired
    private SorteioRepository sr;



    @RequestMapping(value = "/participarSorteio", method = RequestMethod.GET)
    public ModelAndView form(){
        ModelAndView mv = new ModelAndView("sorteio");
        return mv;

    }


    @RequestMapping(value = "/participarSorteio", method = RequestMethod.POST)
    public ModelAndView form(@Validated User user, Sorteio sorteio){
        User users = ur.findByEmail(user.getEmail());
        if(users != null){
            sorteio.setUser(users);
            sr.save(sorteio);
        }else{
            ur.save(user);
            sorteio.setUser(user);
            sr.save(sorteio);
        }

       ModelAndView mv = new ModelAndView("sorteio");
        mv.addObject("sorteio",sorteio);
        return mv;


    }

    @RequestMapping(value = "/numeros", method = RequestMethod.GET)
    public ModelAndView listaSorteio(){
        ModelAndView mv = new ModelAndView("busca");
        return mv;
    }

    @RequestMapping(value = "/numeros", method = RequestMethod.POST)
 /*   public ModelAndView formi(Sorteio sorteio){
        ModelAndView mv = new ModelAndView("busca");
        Iterable<Sorteio> sorteios = sr.findById(sorteio.getEmail());
        mv.addObject("gerados",users);
        return mv;
*/
        public ModelAndView formu(@Validated User user, Sorteio sorteio){
            User users = ur.findByEmail(user.getEmail());
                Long idUser = users.getId();

                ModelAndView mve = new ModelAndView("busca");

                Iterable<Sorteio> sorteios = sr.findByuser_id(idUser);
                mve.addObject("gerados",sorteios);
                return mve;

    }

}
