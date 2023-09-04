package com.springproject.albumproject.controller;

import com.springproject.albumproject.model.*;
import com.springproject.albumproject.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class WelcomeController {

    @Autowired
   private AlbumService albumService;


    @RequestMapping("/")
    public String welcome(Model model) {

model.addAttribute("albums",albumService.getAllAlbum());

        return "index";
    }

}

