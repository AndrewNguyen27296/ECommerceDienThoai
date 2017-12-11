/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package merchant.controllers;

import ejb.entities.NguoiBan;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    
    @RequestMapping("index")
    public String login(){
        return "merchant/account/login";
    }
    
    /**
     * Đăng nhập
    */
    @ResponseBody
    @RequestMapping(value = "login", produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public String login(@RequestParam("nguoiBan_email") String email,
            @RequestParam("nguoiBan_password") String password,
            HttpSession httpSession) {
        String temp = nguoiBanService.dangNhap(email, password, httpSession);
        return temp;
    }
    
    /**
     *  Đăng ký
     */
    @ResponseBody
    @RequestMapping(value = "register", produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public String register(@RequestParam("hoTen") String hoTen,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("cmnd") String cmnd,
            @RequestParam("diaChi") String diaChi,
            @RequestParam("soDienThoai") String soDienThoai,
            HttpServletRequest request) {
        String temp = nguoiBanService.themNguoiBan(email, password, hoTen, cmnd, soDienThoai, diaChi, request);
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
    
    /**
     * Đổi mật khẩu
     */
    @RequestMapping("change")
    public String change(){
        return "merchant/home/change";
    }
    
    @RequestMapping(value="change", method=RequestMethod.POST)
	public String change(ModelMap model,
			@RequestParam("password") String password,
			@RequestParam("password1") String password1,
			@RequestParam("password2") String password2,
			HttpSession httpSession) {
		nguoiBanService.doiMatKhau(model, password, password1, password2, httpSession);
		return "merchant/home/change";
	}
    
    /**
     * Chỉnh sửa thông tin tài khoản
     */
    @RequestMapping("edit")
    public String edit(ModelMap model, HttpSession httpSession){
        NguoiBan nguoiBan = (NguoiBan) httpSession.getAttribute("nguoiBan");
        model.addAttribute("nguoiBan", nguoiBan);
        return "merchant/home/edit";
    }
    
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String edit(ModelMap model,
            HttpSession httpSession,
            @ModelAttribute("nguoiBan") NguoiBan nguoiBan) {
        nguoiBanService.capNhatNguoiBan(nguoiBan, model, httpSession);
        return "merchant/home/edit";
    }
    
    /**
     * Quên mật khẩu
     */
    @RequestMapping("forgot")
    public String forgot(){
        return "merchant/account/forgot";
    }
    
    @RequestMapping(value = "forgot", method = RequestMethod.POST)
    public String forgot(ModelMap model,
            @RequestParam("email") String email) {
        nguoiBanService.quenMatKhau(model, email);
        return "merchant/account/forgot";
    }
}
