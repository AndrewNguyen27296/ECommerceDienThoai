/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controllers;

import ejb.business.CtPhieuMuaHangBusiness;
import ejb.entities.CauHinh;
import ejb.entities.CtPhieuMuaHang;
import ejb.entities.NguoiBan;
import ejb.entities.NguoiMua;
import ejb.entities.PhieuMuaHang;
import ejb.sessions.CauHinhFacade;
import ejb.sessions.PhieuMuaHangFacade;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import web.services.AdminService;
import web.services.LookupFactory;

/**
 *
 * @author DacTien
 */
@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    AdminService adminService;
    PhieuMuaHangFacade phieuMuaHangFacade = (PhieuMuaHangFacade) LookupFactory.lookupFacadeBean("PhieuMuaHangFacade");
    CtPhieuMuaHangBusiness ctPhieuMuaHangBusiness = (CtPhieuMuaHangBusiness) LookupFactory.lookupBusinessBean("CtPhieuMuaHangBusiness");
    CauHinhFacade cauHinhFacade = (CauHinhFacade) LookupFactory.lookupFacadeBean("CauHinhFacade");
    
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
    
    /*
    * Quản lý MERCHANT
    */
    //Kích hoạt tài khoản Merchant
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
    
    //SEARCH Merchant
    @RequestMapping(value="search-merchant", method = RequestMethod.POST)
    public String timKiemMerchant(Model model, 
            @RequestParam("cmnd") String cmnd) {
        List<NguoiBan> merchant = adminService.timKiemNguoiBan(cmnd);
        if (merchant.size() != 0) {
            model.addAttribute("list", merchant);
        }
        else model.addAttribute("mess", "Không tìm thấy kết quả");
        return "admin/account/active-account";
    }
    
    /*
    * Quản lý CUSTOMER
    */
    //QUản lý Customer
    @RequestMapping("manage-customer")
    public String quanLyCustomer(Model model) {
        List<NguoiMua> list = adminService.layDanhSachNguoiMua();
        model.addAttribute("list", list);
        return "admin/account/manage-customer";
    }
    
    //Cấu hình số lần block
    @RequestMapping("block")
    public String block(Model model) {
        CauHinh cauHinh = cauHinhFacade.find(1);
        model.addAttribute("cauHinh", cauHinh);
        return "admin/account/block";
    }
    
    /*
    * Quản lý PHIẾU MUA HÀNG
    */
    @RequestMapping("order")
    public String order(Model model) {
        List<PhieuMuaHang> list = phieuMuaHangFacade.findAll();
        model.addAttribute("phieuMuaHangs", list);
        return "admin/order/danhSachPhieuMuaHang";
    }
    
    @RequestMapping("order/detail/{id}")
    public String orderDetail(@PathVariable("id") Integer id, Model model) {
        PhieuMuaHang phieuMuaHang = phieuMuaHangFacade.find(id);
        model.addAttribute("phieuMuaHang", phieuMuaHang);
        List<CtPhieuMuaHang> list_ct = ctPhieuMuaHangBusiness.layChiTietTheoMaPhieuMuaHang(id);
        model.addAttribute("ctPhieuMuaHang", list_ct);

        //Group Các chi tiết PMH theo người bán
        List<NguoiBan> listNguoiBan = new ArrayList<>();
        for (CtPhieuMuaHang ctPhieuMuaHang : list_ct) {
            listNguoiBan.add(ctPhieuMuaHang.getIdNguoiBan());
        }
        model.addAttribute("listNguoiBan", listNguoiBan);
        return "admin/order/detail";
    }
}
