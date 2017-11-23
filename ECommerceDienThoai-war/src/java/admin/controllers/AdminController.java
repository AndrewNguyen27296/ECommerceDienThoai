/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controllers;

import ejb.entities.NguoiBan;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import web.services.AdminService;

/**
 *
 * @author DacTien
 */
@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    AdminService adminService;
    
    @RequestMapping("login")
    public String login() {
        return "admin/login/login";
    }
    
//    @ResponseBody
//    @RequestMapping(value = "login-check", produces = "application/x-www-form-urlencoded;charset=UTF-8")
//    public String login(@RequestParam("email") String email,
//            @RequestParam("password") String password,
//            HttpSession httpSession) {
//        String temp = adminService.dangNhap(email, password, httpSession);
//        return temp;
//    }
    
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(Model model,
            @RequestParam("Email") String email,
            @RequestParam("Password") String password,
            HttpSession httpSession) {
        String temp = adminService.dangNhap(email, password, httpSession);
        if (temp.equals("Đăng nhập thành công")) {
            return "redirect:/admin/index.php";
        }
        model.addAttribute("mess", temp);
        return "admin/login/login";
    }
    
    @RequestMapping("index")
    public String index() {
        return "admin/home/index";
    }
    
    @RequestMapping("active-account")
    public String kichHoatMerchant(Model model) {
        List<NguoiBan> list = adminService.layDanhSachNguoiBan();
        model.addAttribute("list", list);
        return "admin/account/active-account";
    }
    
    @RequestMapping("active-account/{id}")
    public String kichHoatMerchant(@PathVariable("id") Integer id,
            Model model) {
        adminService.kichHoatNguoiBan(id, model);
        return "redirect:/admin/active-account.php";
    }
}
