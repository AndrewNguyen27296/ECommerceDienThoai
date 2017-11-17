/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.controllers;

import ejb.entities.NguoiMua;
import java.time.Instant;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import web.services.NguoiMuaService;



/**
 *
 * @author XinKaChu
 */
@Controller
@RequestMapping("account")
public class AccountController {
    @Autowired
    NguoiMuaService nguoiMuaService;
    
//    @RequestMapping(value="register", method = RequestMethod.POST)
//    public String register(ModelMap model,
//                            HttpServletRequest request) {
//        try {
//            nguoiMuaService.themNguoiMua(request);
//            model.addAttribute("mess", "Đăng ký tài khoản thành công, vui lòng kiểm tra email "
//                + "và kích hoạt tài khoản");
//        } catch (Exception e) {
//            model.addAttribute("mess", "Đăng ký tài khoản thất bại");
//        }
//        return "";
//    }
    
    @ResponseBody
    @RequestMapping(value = "register", produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public String register(@RequestParam("hoTen") String hoTen,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("diaChi") String diaChi,
            @RequestParam("soDienThoai") String soDienThoai,
            HttpServletResponse response) {
        String temp = nguoiMuaService.themNguoiMua(hoTen, email, password, diaChi, soDienThoai);
        return temp;
    }
}
