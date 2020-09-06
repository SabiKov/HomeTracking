package com.sabi11.hometracking.web;

import com.sabi11.hometracking.dao.MessageRepository;
import com.sabi11.hometracking.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    private MessageRepository messageRepository;

    @GetMapping
    public String home(Model model) {
        model.addAttribute("msgs", messageRepository.findAll());
        return "userHome";
    }

    @PostMapping
    public String saveMessage(Message message) {
        messageRepository.save(message);
        return "redirect:/home";
    }
}
