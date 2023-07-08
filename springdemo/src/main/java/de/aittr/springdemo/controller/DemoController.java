package de.aittr.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DemoController {

    @RequestMapping(value="/test", method = RequestMethod.GET)
    public String getMap() {
        return "hello_view";
    }
    @RequestMapping(value="/hello", method = RequestMethod.GET)
    public String getMap1() {
        return "hello_view_1";
    }

   @RequestMapping(value="/goodbye", method = RequestMethod.GET)
    public String getMap2() {
        return "hello_view_2";}


}
