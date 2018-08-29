package com.quare.webapps.openidwebsite.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.quare.webapps.openidwebsite.dao.jpa.UserRepository;
import com.quare.webapps.openidwebsite.entities.jpa.Album;
import com.quare.webapps.openidwebsite.entities.jpa.User;
import com.quare.webapps.openidwebsite.services.GetAlbumsOfUserService;

import exception.PermissionDeniedException;

@Controller
public class MainController {
	
	@Autowired
	GetAlbumsOfUserService getAlbumService;
	
	@Autowired
	UserRepository userRepository;

    private final Logger logger = LoggerFactory.getLogger(getClass());
    
    
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
    @GetMapping("/private/home")
    public final String privateHome(Model model) throws PermissionDeniedException {
        final String email = SecurityContextHolder.getContext().getAuthentication().getName();
        logger.info(email);
        
        User user = userRepository.findByEmail(email);
        
        if (user == null) {
        	throw new PermissionDeniedException("User not found");
        }
        
        model.addAttribute("email", email);
        model.addAttribute("firstname", user.getFirstName());
        model.addAttribute("lastname", user.getLastName());
        
        //List<Album> albums = getAlbumService.getAlbumOfUser(email);
        
        //model.addAttribute("albums", albums);
        
        
        return "albums";
    }


	    

	
}
