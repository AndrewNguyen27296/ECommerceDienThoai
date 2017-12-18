/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package merchant.controllers;

import ejb.business.ThongKeSanPhamMerchantBusiness;
import ejb.entities.NguoiBan;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import web.services.LookupFactory;

/**
 *
 * @author DacTien
 */
@Controller
@RequestMapping("merchant/statistic")
public class MerchantThongKeController {
    ThongKeSanPhamMerchantBusiness thongKeSanPhamMerchantBusiness = (ThongKeSanPhamMerchantBusiness) LookupFactory.lookupBusinessBean("ThongKeSanPhamMerchantBusiness");
    
    @RequestMapping("by-product")
    public String byProduct(Integer idNguoiBan, HttpSession httpSession, Model model) {
        NguoiBan nguoiBan = (NguoiBan) httpSession.getAttribute("nguoiBan");
        model.addAttribute("items", thongKeSanPhamMerchantBusiness.thongKeSanPham(nguoiBan.getId()));
        return "merchant/home/statistic-by-product";
    }
}
