/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import web.services.ShoppingCartService;

/**
 *
 * @author DacTien
 */
@Controller
@RequestMapping("order")
public class OrderController {
    @Autowired
    ShoppingCartService cart;
    
    @RequestMapping("check-out")
    public String checkout(Model model) {
        model.addAttribute("cart", cart);
        model.addAttribute("listNguoiBan", cart.getNguoiBans());
        return "customer/order/checkout";
    }
}
