/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.controllers;

import ejb.entities.NguoiMua;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    /*
    * Đăng nhập
    */
    @ResponseBody
    @RequestMapping(value = "login", produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public String login(@RequestParam("nguoiMua_email") String email,
            @RequestParam("nguoiMua_password") String password,
            HttpSession httpSession) {
        String temp = nguoiMuaService.dangNhap(email, password, httpSession);
        return temp;
    }
    
    /**
     * Đăng xuất
     */
    @RequestMapping("logoff")
    public String logoff(HttpSession httpSession) {
        try {
            httpSession.removeAttribute("nguoiMua");
        } catch (Exception e) {
        }
        //Redirect to action
        return "redirect:/home/index.php";
    }
    
    /*
     * Đăng ký tài khoản
     */
    @ResponseBody
    @RequestMapping(value = "register", produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public String register(@RequestParam("hoTen") String hoTen,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("diaChi") String diaChi,
            @RequestParam("soDienThoai") String soDienThoai,
            HttpServletRequest request) {
        String temp = nguoiMuaService.themNguoiMua(hoTen, email, password, diaChi, soDienThoai, request);
        return temp;
    }
    
    /**
     * Kích hoạt tài khoản
     */
    @RequestMapping("activate/{id}")
    public String activate(@PathVariable("id") String id) {
        nguoiMuaService.kichHoatTaiKhoan(id);
        return "redirect:/home/index.php";
    }
    
    /*
    * Chỉnh sửa thông tin tài khoản
    */
    @RequestMapping("edit")
    public String edit(ModelMap model, HttpSession httpSession) {
        NguoiMua nguoiMua = (NguoiMua) httpSession.getAttribute("nguoiMua");
        model.addAttribute("nguoiMua", nguoiMua);
        return "customer/account/edit";
    }
    
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String edit(ModelMap model,
            HttpSession httpSession,
            @ModelAttribute("nguoiMua") NguoiMua user) {
        nguoiMuaService.capNhatNguoiMua(user, model, httpSession);
        return "customer/account/edit";
    }
    
    @RequestMapping("change")
    public String change() {
        return "customer/account/change";
    }
    
    @RequestMapping(value = "change", method = RequestMethod.POST)
    public String change(ModelMap model,
			@RequestParam("matKhau") String matKhau,
			@RequestParam("matKhau1") String matKhau1,
			@RequestParam("matKhau2") String matKhau2,
			HttpSession httpSession) {
        nguoiMuaService.doiMatKhau(model, matKhau, matKhau1, matKhau2, httpSession);
        return "customer/account/change";
    }
    
    @RequestMapping("forgot-password")
    public String forgot() {
        return "customer/account/forgot-password";
    }
    
    @RequestMapping(value = "forgot-password", method = RequestMethod.POST)
    public String forgot(Model model,
            @RequestParam("email") String email,
            @RequestParam("soDienThoai") String soDienThoai) {
        nguoiMuaService.quenMatKhau(model, email, soDienThoai);
        return "customer/account/forgot-password";
    }
    
    /*@ResponseBody
    @RequestMapping(value = "check-session", produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public String check(HttpServletRequest request) {
        String temp = nguoiMuaService.themNguoiMua(request);
        return temp;
    }*/
}
