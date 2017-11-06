package com.example.easyboot;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.security.util.Resources_it;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String homePage(Model model)
    {
        LocalDateTime rightNow= LocalDateTime.now();
        DayOfWeek today = rightNow.getDayOfWeek();
        String todayName = today.getDisplayName(TextStyle.FULL, Locale.US);

        DateTimeFormatter longFormat = DateTimeFormatter.ofPattern("dd, MMMM, yyyy");

        String todayDate = rightNow.format(longFormat);

        model.addAttribute("todayname", todayName);
        model.addAttribute("todaydate", todayDate);

        return "intro";
    }
}
