/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.controllers;

import ejb.entities.SanPham;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @RequestMapping("view")
    public String view(Model model) {
        model.addAttribute("cart", cart);
        List<Integer> soLuongs = new ArrayList<>();
        for (SanPham s : cart.getItems()) {
            soLuongs.add(cart.getSoLuongTonTheoMaSanPham(s.getId()));
        }
        model.addAttribute("soLuongs", soLuongs);
        return "customer/shopping-cart/view";
    }

    @ResponseBody
    @RequestMapping("remove")
    public String remove(@RequestParam("id") Integer id) {
        cart.remove(id);
        String json = String.format("[%d, %d]", cart.getCount(), cart.getAmount());
        return json;
    }

    @ResponseBody
    @RequestMapping("update")
    public String update(@RequestParam("id") Integer id,
            @RequestParam("qty") Integer qty) {
        cart.update(id, qty);
        SanPham p = cart.getItem(id);
        long amount = (long) (p.getGiaBan()* p.getSoLuong());
        System.out.println(amount);
        String json = String.format("[%d, %d, %d]", cart.getCount(), cart.getAmount(), amount);
        return json;
    }
}
