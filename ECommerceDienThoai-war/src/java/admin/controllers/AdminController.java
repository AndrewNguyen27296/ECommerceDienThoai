/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controllers;

import ejb.business.CtPhieuMuaHangBusiness;
import ejb.business.DanhGiaBusiness;
import ejb.business.SoTinTonBusiness;
import ejb.business.ThongKeBusiness;
import ejb.entities.Admin;
import ejb.entities.CauHinh;
import ejb.entities.CtPhieuMuaHang;
import ejb.entities.DanhGia;
import ejb.entities.GoiTin;
import ejb.entities.NguoiBan;
import ejb.entities.NguoiMua;
import ejb.entities.PhieuMuaHang;
import ejb.entities.PhieuMuaTinOffline;
import ejb.entities.PhieuNopPhat;
import ejb.entities.SoTinTon;
import ejb.sessions.CauHinhFacade;
import ejb.sessions.DanhGiaFacade;
import ejb.sessions.GoiTinFacade;
import ejb.sessions.NguoiBanFacade;
import ejb.sessions.PhieuMuaHangFacade;
import ejb.sessions.PhieuMuaTinOfflineFacade;
import ejb.sessions.PhieuNopPhatFacade;
import ejb.sessions.SoTinTonFacade;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import web.services.AdminService;
import web.services.LookupFactory;
import web.services.NguoiBanService;

/**
 *
 * @author DacTien
 */
@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    AdminService adminService;
    @Autowired 
    NguoiBanService nguoiBanService;
    
    PhieuMuaHangFacade phieuMuaHangFacade = (PhieuMuaHangFacade) LookupFactory.lookupFacadeBean("PhieuMuaHangFacade");
    CtPhieuMuaHangBusiness ctPhieuMuaHangBusiness = (CtPhieuMuaHangBusiness) LookupFactory.lookupBusinessBean("CtPhieuMuaHangBusiness");
    CauHinhFacade cauHinhFacade = (CauHinhFacade) LookupFactory.lookupFacadeBean("CauHinhFacade");
    NguoiBanFacade nguoiBanFacade = (NguoiBanFacade) LookupFactory.lookupFacadeBean("NguoiBanFacade");
    GoiTinFacade goiTinFacade = (GoiTinFacade) LookupFactory.lookupFacadeBean("GoiTinFacade");
    PhieuMuaTinOfflineFacade phieuMuaTinOfflineFacade = (PhieuMuaTinOfflineFacade) LookupFactory.lookupFacadeBean("PhieuMuaTinOfflineFacade");
    PhieuNopPhatFacade phieuNopPhatFacade = (PhieuNopPhatFacade) LookupFactory.lookupFacadeBean("PhieuNopPhatFacade");
    DanhGiaFacade danhGiaFacade = (DanhGiaFacade) LookupFactory.lookupFacadeBean("DanhGiaFacade");
    DanhGiaBusiness danhGiaBusiness = (DanhGiaBusiness) LookupFactory.lookupBusinessBean("DanhGiaBusiness");
    ThongKeBusiness thongKeBusiness = (ThongKeBusiness) LookupFactory.lookupBusinessBean("ThongKeBusiness");
    SoTinTonBusiness soTinTonBusiness = (SoTinTonBusiness) LookupFactory.lookupBusinessBean("SoTinTonBusiness");
    SoTinTonFacade soTinTonFacade = (SoTinTonFacade) LookupFactory.lookupFacadeBean("SoTinTonFacade");
    
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
    
    @RequestMapping(value="block", method = RequestMethod.POST)
    public String block(Model model, @RequestParam("soLan") int soLan) {
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
    
    @RequestMapping("locked-account")
    public String lockedAccount(Model model) {
        List<NguoiBan> temp = nguoiBanFacade.findAll();
        List<NguoiBan> list = new ArrayList<>();
        for (NguoiBan nguoiBan : temp) {
            if (nguoiBan.getBiKhoa() == true) {
                list.add(nguoiBan);
            }
        }
        model.addAttribute("list", list);
        return "admin/account/locked-account";
    }
    
    @RequestMapping("phieu-nop-phat/them-phieu-phat/{id}")
    public String themPhieuNopPhat(@PathVariable("id") Integer id, HttpSession httpSession) {
        nguoiBanService.themPhieuNopPhat(id, httpSession);
        return "redirect:/admin/locked-account.php";
    }
    
    @RequestMapping("phieu-mua-tin-offline/them-phieu-mua-tin-offline/{id}")
    public String themPhieuMuaTinOffline(Model model, @PathVariable("id") Integer id) {
        List<GoiTin> goiTins = goiTinFacade.findAll();
        model.addAttribute("listGoiTin", goiTins);
        NguoiBan nguoiBan = nguoiBanFacade.find(id);
        model.addAttribute("nguoiBan", nguoiBan);     
        return "admin/goi-tin/them-goi-tin-offline";
    }
    
    @ResponseBody
    @RequestMapping("getInfoGoiTin")
    public GoiTin getGoiTin(@RequestParam("id") Integer id)
    {
        return goiTinFacade.find(id);
    }
    
    @RequestMapping(value="phieu-mua-tin-offline/them-phieu-mua-tin-offline/{id}", method = RequestMethod.POST)
    public String themPhieuMuaTinOffline(@PathVariable("id") Integer id,
            @RequestParam("goiTin") Integer idGoiTin,
            HttpSession httpSession) {
        //Lưu thông tin phiếu mua tin tại trụ sở
        NguoiBan nguoiBan = nguoiBanFacade.find(id);   
        GoiTin goiTin = goiTinFacade.find(idGoiTin);
        PhieuMuaTinOffline phieuMuaTinOffline = new PhieuMuaTinOffline();
        phieuMuaTinOffline.setGiaBan(goiTin.getGiaBan());
        phieuMuaTinOffline.setIdAdmin((Admin) httpSession.getAttribute("admin"));
        phieuMuaTinOffline.setIdGoiTin(goiTin);
        phieuMuaTinOffline.setIdNguoiBan(nguoiBan);
        phieuMuaTinOffline.setNgayMua(new Date());
        try {
            phieuMuaTinOfflineFacade.create(phieuMuaTinOffline);
            //Cập nhật số lượng tin tồn của Merchant
            if (soTinTonBusiness.laySoTinTheoNguoiBanVaThoiGian(nguoiBan.getId(), new Date()) == 0) {
                SoTinTon soTinTon = new SoTinTon();
                soTinTon.setIdNguoiBan(nguoiBan);
                soTinTon.setNgayCapNhat(new Date());
                soTinTon.setSoTinTon(goiTin.getSoTin());
                soTinTon.setSoTinDaDung(0);
                soTinTon.setTangGiam(goiTin.getSoTin());
                soTinTonFacade.create(soTinTon);
            }
            else {
                SoTinTon soTinTon = soTinTonBusiness.laySoTinTonMoiNhatTheoNguoiBan(nguoiBan.getId(), new Date());
                SoTinTon new_soTinTon = new SoTinTon();
                new_soTinTon.setIdNguoiBan(nguoiBan);
                new_soTinTon.setNgayCapNhat(new Date());
                new_soTinTon.setSoTinTon(soTinTon.getSoTinTon() + goiTin.getSoTin());
                new_soTinTon.setSoTinDaDung(soTinTon.getSoTinDaDung());
                new_soTinTon.setTangGiam(goiTin.getSoTin());
                soTinTonFacade.create(new_soTinTon);
            }
        } catch (Exception e) {
            throw e;
        }
        return "redirect:/admin/active-account.php";
    }
    
    @RequestMapping("phieu-mua-tin-offline")
    public String quanLyPhieuMuaTinOffline(Model model) {
        List<PhieuMuaTinOffline> list = phieuMuaTinOfflineFacade.findAll();
        model.addAttribute("list", list);
        return "admin/goi-tin/quan-ly-phieu-mua-tin-offline";
    }
    
    @RequestMapping("phieu-nop-phat")
    public String quanLyPhieuNopPhat(Model model) {
        List<PhieuNopPhat> list = phieuNopPhatFacade.findAll();
        model.addAttribute("list", list);
        return "admin/phieu-nop-phat/quan-ly-phieu-nop-phat";
    }
    
    @RequestMapping("danh-gia")
    public String quanLyDanhGia(Model model) {
        List<DanhGia> list = danhGiaFacade.findAll();
        model.addAttribute("list", list);
        
        List<Object[]> items = danhGiaBusiness.thongKeDanhGia();
        model.addAttribute("items", items);
        return "admin/danh-gia/quan-ly-danh-gia";
    }
    
    @RequestMapping("thong-ke-danh-gia")
    public String thongKeDanhGia(Model model) {
        List<Object[]> list = danhGiaBusiness.thongKeDanhGia();
        model.addAttribute("items", list);
        return "";
    }
    
    @RequestMapping("thong-ke-doanh-thu")
    public String thongKeDoanhThu(Model model) {
        List<Long> list = thongKeBusiness.thongKeDoanhThu();
        model.addAttribute("items", list);
        return "admin/thong-ke/thong-ke-doanh-thu";
    }
}
