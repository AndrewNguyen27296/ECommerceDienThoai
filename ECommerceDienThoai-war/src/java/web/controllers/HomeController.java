/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.controllers;

import ejb.entities.SanPham;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import web.services.SanPhamService;



/**
 *
 * @author XinKaChu
 */
@Controller
@RequestMapping("home")
public class HomeController {
    @Autowired
    SanPhamService sanPhamService;
    
    @RequestMapping("index")
    public String index(Model model) {
        List<SanPham> sanPhamMoi = sanPhamService.laySanPhamMoiNhat();
        model.addAttribute("sanPhamMoi", sanPhamMoi);
        return "customer/home/index";
    }
    
//    @RequestMapping("test")
//    public String test(Model model) {
//        return "customer/home/product-detail";
//    }
//
//    @RequestMapping(value = "register", method = RequestMethod.POST)
//    public String register() {
//        return "";
//    }
}
