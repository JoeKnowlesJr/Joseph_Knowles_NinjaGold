package com.joeknowles.NinjaGold.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.joeknowles.NinjaGold.models.LogEntry;
import com.joeknowles.NinjaGold.models.Ninja;

@Controller
public class NinjaGoldController {
	
	@RequestMapping("/")
	public String index(HttpSession session) {
        if(session.getAttribute("ninja") == null) {
            Ninja n = new Ninja("test");
            session.setAttribute("ninja", n);
        }
        return "Gold.jsp";
	}
	
    @PostMapping("/find")
    public String go(HttpSession session, @RequestParam(value = "location", required = true) String location) {
        final Ninja ninja = (Ninja) session.getAttribute("ninja");
        final String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMMM dd yyyy  hh:mm a"));
        int random = 0;
        
        switch (location) {
        case "farm":
            random = getRandomNumber(10, 20);
        	break;
        case "house":
            random = getRandomNumber(2,5);
        	break;
        case "cave":
            random = getRandomNumber(5,10);
        	break;
        case "casino":
            random = getRandomNumber(-50, 50);
        	break;
        case "reset":
        	ninja.reset();
        default:
        	return "redirect:/";
        }

        final boolean inTheBlack = (random >= 0);
        final String log = String.format("You went to the %s and %s %d gold. (%s)", 
        		location, inTheBlack ? "found" : "lost", random, timestamp);
        
        ninja.adjustGold(random);
        ninja.addLogEntry(new LogEntry((inTheBlack ? "green" : "red"), log));
        session.setAttribute("ninja", ninja);

        return "redirect:/";
    }
    
    private int getRandomNumber(int low, int high) {
        int num = (int)(Math.random() * (high - low) + low);
        return num;
    }
}
