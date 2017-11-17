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
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



/**
 *
 * @author XinKaChu
 */
@Controller
@RequestMapping("account")
public class AccountController {
    @RequestMapping(value="register", method = RequestMethod.POST)
    public String register(ModelMap model,
                            HttpServletRequest request) {
        NguoiMua customer = new NguoiMua();
        customer.setDiaChi(request.getParameter("diaChi"));
        customer.setEmail(request.getParameter("email"));
        customer.setHoTen(request.getParameter("hoTen"));
        customer.setMatKhau(request.getParameter("pasword"));
        customer.setSoDienThoai(request.getParameter("soDienThoai"));
        customer.setNgayDangKy(new Date());
        customer.setNgaySinh(new Date());
        customer.setKichHoat(false);
        customer.setTrangThai(true);
        return "";
    }
}
