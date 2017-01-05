package by.notebook.mail.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import by.notebook.mail.entity.ClientsEntity;
import by.notebook.mail.service.ClientsService;
import by.notebook.mail.utils.SmtpMailSendler;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

@Controller
public class ControllerMain {

    @Autowired
    SmtpMailSendler smtpMailSendler;

    @Autowired
    ClientsService clientsService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView indexadd(@RequestParam(value = "email", required = false) String mailTo,
                        @RequestParam(value = "name", required = false) String text,
                        ModelAndView model) throws MessagingException, IOException {
        clientsService.add(new ClientsEntity(text, mailTo));
        List<ClientsEntity> listClients = clientsService.getAll();
        model.addObject("list", listClients);
        model.setViewName("index");
        return model;
    }

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public ModelAndView index(@RequestParam(value = "email-send", required = false) String mailTo,
                        @RequestParam(value = "name-send", required = false) String text,
                        ModelAndView model) throws MessagingException, IOException {
        smtpMailSendler.setMailSender(mailTo, text);
        List<ClientsEntity> listClients = clientsService.getAll();
        model.addObject("list", listClients);
        model.setViewName("index");
        return model;
    }

    @GetMapping("/index")
    public ModelAndView indexGet() {
        ModelAndView model = new ModelAndView();
        List<ClientsEntity> listClients = clientsService.getAll();
        model.addObject("list", listClients);
        model.setViewName("index");
        return model;
    }
}


