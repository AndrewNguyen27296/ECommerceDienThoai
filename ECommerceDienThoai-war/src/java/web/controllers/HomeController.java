/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



/**
 *
 * @author XinKaChu
 */
@Controller
@RequestMapping("home")
public class HomeController {
    @RequestMapping("index")
    public String index() {
        return "customer/home/index";
    }
    
    @RequestMapping(value="register", method = RequestMethod.POST)
    public String register() {
        return "";
    }
}
