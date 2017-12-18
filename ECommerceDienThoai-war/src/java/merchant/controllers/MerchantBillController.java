/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package merchant.controllers;

import ejb.business.SanPhamBusiness;
import ejb.entities.CtPhieuMuaHang;
import ejb.entities.NguoiBan;
import ejb.entities.SanPham;
import ejb.sessions.CtPhieuMuaHangFacade;
import ejb.sessions.SanPhamFacade;
import ejb.sessions.TinhTrangFacade;
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
import web.services.CtPhieuMuaHangService;
import web.services.LookupFactory;

/**
 *
 * @author XinKaChu
 */
@Controller
@RequestMapping("merchant/bill")
public class MerchantBillController {
    @Autowired
    CtPhieuMuaHangService ctPhieuMuaHangService;
    
    CtPhieuMuaHangFacade ctPhieuMuaHangFacade = (CtPhieuMuaHangFacade) LookupFactory.lookupFacadeBean("CtPhieuMuaHangFacade");
    TinhTrangFacade tinhTrangFacade = (TinhTrangFacade) LookupFactory.lookupFacadeBean("TinhTrangFacade");
    SanPhamFacade sanPhamFacade = (SanPhamFacade) LookupFactory.lookupFacadeBean("SanPhamFacade");
    SanPhamBusiness sanPhamBusiness = (SanPhamBusiness) LookupFactory.lookupBusinessBean("SanPhamBusiness");
    
    @RequestMapping("history")
    public String bill(Model model, HttpSession httpSession){
        NguoiBan nguoiBan = (NguoiBan) httpSession.getAttribute("nguoiBan");
       // List<CtPhieuMuaHang> ctPhieuMuaHang =  ctPhieuMuaHangService.layDanhSachCtPhieuMuaHang();
        model.addAttribute("ctPhieuMuaHang", nguoiBan.getCtPhieuMuaHangList());
        return "merchant/home/bill-history";
    }
    
    @RequestMapping("detail/{id}")
    public String detail(@PathVariable("id") Integer id,
            Model model)
    {
        model.addAttribute("ctPhieuMuaHang", ctPhieuMuaHangFacade.find(id));
        return "merchant/home/purchase-detail";
    }
    
    @RequestMapping(value="detail/{id}", method = RequestMethod.POST)
    public String detail(@PathVariable("id") Integer id,
            @RequestParam("tinhTrang") String tinhTrang){
        CtPhieuMuaHang ct = ctPhieuMuaHangFacade.find(id);
        ct.setIdTinhTrang(tinhTrangFacade.find(tinhTrang));
        if (tinhTrang.equals("TC")) {
            ct.setNgayGiaoHang(new Date());
        }
        if (tinhTrang.equals("DH")) {
            int sl_moi = ct.getIdSanPham().getSoLuong() + ct.getSoLuongMua();
            sanPhamBusiness.capNhatSLKhiBiHuy(ct.getIdSanPham().getId(), sl_moi);
        }
        ctPhieuMuaHangFacade.edit(ct);
        return "redirect:/merchant/bill/history.php";
    }
}
