/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import web.services.ShoppingCartService;

/**
 *
 * @author DacTien
 */
@Controller
@RequestMapping("shopping-cart")
public class ShoppingCartController {

    @Autowired
    ShoppingCartService cart;

    @ResponseBody
    @RequestMapping("add")
    public String add(@RequestParam("id") Integer id) {
        cart.add(id);
        return cart.getCount() + "";
    }
    
    @ResponseBody
    @RequestMapping("remove")
    public String remove(@RequestParam("id") Integer id) {
        cart.remove(id);
        return cart.getCount() + "";
    }
}
