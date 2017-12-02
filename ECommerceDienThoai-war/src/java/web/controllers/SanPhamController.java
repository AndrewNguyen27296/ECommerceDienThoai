/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.controllers;

import ejb.entities.SanPham;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import web.services.SanPhamService;

/**
 *
 * @author DacTien
 */
@Controller
@RequestMapping("product/")
public class SanPhamController {
    @Autowired
    SanPhamService sanPhamService;
    
    @RequestMapping("detail/{id}")
    public String detail(@PathVariable("id") Integer id, Model model) {
        SanPham sanPham = sanPhamService.lay1SanPham(id);
        model.addAttribute("sanpham", sanPham);
        return "customer/product/product-detail";
    }
}
