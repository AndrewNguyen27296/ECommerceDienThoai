/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package merchant.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import web.services.NguoiBanService;

/**
 *
 * @author XinKaChu
 */

@Controller
@RequestMapping("merchant/account")
public class MerchantAccountController {
    @Autowired
    NguoiBanService nguoiBanService;
    
    @RequestMapping("login")
    public String login(){
        return "merchant/account/login";
    }
    
    @ResponseBody
    @RequestMapping(value = "login", produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public String login(@RequestParam("nguoiBan_email") String email,
            @RequestParam("nguoiBan_password") String password,
            HttpSession httpSession) {
        String temp = nguoiBanService.dangNhap(email, password, httpSession);
        return temp;
    }
    
    @ResponseBody
    @RequestMapping(value = "register", produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public String register(@RequestParam("hoTen") String hoTen,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("cmnd") String cmnd,
            @RequestParam("diaChi") String diaChi,
            @RequestParam("soDienThoai") String soDienThoai,
            HttpServletRequest request) {
        String temp = nguoiBanService.themNguoiBan(hoTen, email, password, cmnd, diaChi, soDienThoai, request);
        return temp;
    }
    
    /**
     * Kích hoạt tài khoản
     */
    @RequestMapping("activate/{id}")
    public String activate(@PathVariable("id") String id) {
        nguoiBanService.kichHoatTaiKhoan(id);
        return "redirect:/home/index.php";
    }
}
