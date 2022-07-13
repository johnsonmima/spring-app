package com.johnsonmima.school.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.johnsonmima.school.model.Holiday;

@Controller
public class HolidayController {
    
    @GetMapping(value = "/holidays")
    public String holidayIndexPage(@RequestParam(required = false) boolean festival, @RequestParam(required = false) boolean federal, Model model){

    
        model.addAttribute("festival", festival);
         model.addAttribute("federal", federal);
     

        List<Holiday> holidays = new ArrayList<Holiday>();

        holidays.add(new Holiday("Jan 1","Holiday reason", Holiday.Type.FESTIVAL));
         holidays.add(new Holiday("Oct 31","Holiday reason", Holiday.Type.FESTIVAL));
          holidays.add(new Holiday("Nov 11","Holiday reason", Holiday.Type.FESTIVAL));
            holidays.add(new Holiday("Nov 24","Holiday reason", Holiday.Type.FEDERAL));

          Holiday.Type[] types = Holiday.Type.values();

          for(Holiday.Type type: types){

            model.addAttribute(type.toString(), holidays.stream().filter(holiday -> holiday.getType().equals(type)).collect(Collectors.toList()));
          }

        return "holiday.html";
    }
}
