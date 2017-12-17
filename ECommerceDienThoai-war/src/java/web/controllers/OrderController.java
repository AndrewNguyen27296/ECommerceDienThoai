/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.controllers;

import com.google.gson.Gson;
import ejb.business.CtPhieuMuaHangBusiness;
import ejb.business.SanPhamBusiness;
import ejb.entities.CtPhieuMuaHang;
import ejb.entities.DanhGia;
import ejb.entities.NguoiBan;
import ejb.entities.NguoiMua;
import ejb.entities.PhieuMuaHang;
import ejb.entities.QuanHuyen;
import ejb.entities.SanPham;
import ejb.entities.ThanhPho;
import ejb.entities.TinhTrang;
import ejb.sessions.CtPhieuMuaHangFacade;
import ejb.sessions.NguoiBanFacade;
import ejb.sessions.PhieuMuaHangFacade;
import ejb.sessions.QuanHuyenFacade;
import ejb.sessions.SanPhamFacade;
import ejb.sessions.ThanhPhoFacade;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import web.services.CtPhieuMuaHangService;
import web.services.DanhGiaService;
import web.services.LookupFactory;
import web.services.QuanHuyenService;
import web.services.SanPhamService;
import web.services.ShoppingCartService;

/**
 *
 * @author DacTien
 */
@Controller
@RequestMapping("order")
public class OrderController {

    @Autowired
    ShoppingCartService cart;

    @Autowired
    QuanHuyenService quanHuyenService;

    @Autowired
    SanPhamService sanPhamService;

    @Autowired
    CtPhieuMuaHangService ctPhieuMuaHangService;
    
    @Autowired
    DanhGiaService danhGiaService;

    PhieuMuaHangFacade phieuMuaHangFacade = (PhieuMuaHangFacade) LookupFactory.lookupFacadeBean("PhieuMuaHangFacade");
    CtPhieuMuaHangFacade ctPhieuMuaHangFacade = (CtPhieuMuaHangFacade) LookupFactory.lookupFacadeBean("CtPhieuMuaHangFacade");
    QuanHuyenFacade quanHuyenFacade = (QuanHuyenFacade) LookupFactory.lookupFacadeBean("QuanHuyenFacade");
    ThanhPhoFacade thanhPhoFacade = (ThanhPhoFacade) LookupFactory.lookupFacadeBean("ThanhPhoFacade");
    //PhuongXaFacade phuongXaFacade = (PhuongXaFacade) LookupFactory.lookupFacadeBean("PhuongXaFacade");
    SanPhamFacade sanPhamFacade = (SanPhamFacade) LookupFactory.lookupFacadeBean("SanPhamFacade");
    SanPhamBusiness sanPhamBusiness = (SanPhamBusiness) LookupFactory.lookupBusinessBean("SanPhamBusiness");
    CtPhieuMuaHangBusiness ctPhieuMuaHangBusiness = (CtPhieuMuaHangBusiness) LookupFactory.lookupBusinessBean("CtPhieuMuaHangBusiness");
    NguoiBanFacade nguoiBanFacade = (NguoiBanFacade) LookupFactory.lookupFacadeBean("NguoiBanFacade");
    
    @RequestMapping("check-out")
    public String checkout(Model model) {
        model.addAttribute("cart", cart);
        model.addAttribute("listNguoiBan", cart.getNguoiBans());
        return "customer/order/checkout";
    }

    @RequestMapping(value = "check-out", method = RequestMethod.POST)
    public String checkout(Model model, HttpSession httpSession,
            @RequestParam("hoTen") String hoTen,
            @RequestParam("soDienThoai") String soDienThoai,
            @RequestParam("thanhPho") Integer thanhPho,
            @RequestParam("quanHuyen") Integer quanHuyen,
            @RequestParam("diaChi") String diaChi,
            @RequestParam("radioDiaChi") String radioDiaChi) {
        PhieuMuaHang phieuMuaHang = new PhieuMuaHang();
        NguoiMua nguoiMua = (NguoiMua) httpSession.getAttribute("nguoiMua");
        phieuMuaHang.setIdNguoiMua(nguoiMua);
        //Nếu người mua chọn địa chỉ hiện tại
        //thì lấy session để lưu đơn hàng
        if (radioDiaChi.equals("diaChiHienTai")) {
            System.out.println("Dia chi hien tai");
            phieuMuaHang.setEmail(nguoiMua.getEmail());
            phieuMuaHang.setTenNguoiNhan(nguoiMua.getHoTen());
            phieuMuaHang.setSoDienThoai(nguoiMua.getSoDienThoai());
            phieuMuaHang.setNgayDatHang(new Date());
            phieuMuaHang.setTongTien(cart.getAmount());
            phieuMuaHang.setDiaChiGiao(nguoiMua.getDiaChi());
            phieuMuaHang.setIdThanhPho(nguoiMua.getIdThanhPho());
            phieuMuaHang.setIdQuanHuyen(nguoiMua.getIdQuanHuyen());
            phieuMuaHang.setGhiChu("");
        } //Nếu người dùng chọn địa chỉ khác
        //thì lưu địa chỉ người dùng nhập vào đơn hàng
        else {
            System.out.println("Dia chi khac");
            phieuMuaHang.setEmail(nguoiMua.getEmail());
            phieuMuaHang.setTenNguoiNhan(hoTen);
            phieuMuaHang.setSoDienThoai(soDienThoai);
            phieuMuaHang.setNgayDatHang(new Date());
            phieuMuaHang.setTongTien(cart.getAmount());
            phieuMuaHang.setDiaChiGiao(diaChi);
            //phieuMuaHang.setIdPhuongXa(phuongXaFacade.find(phuongXa));
            phieuMuaHang.setIdThanhPho(thanhPhoFacade.find(thanhPho));
            phieuMuaHang.setIdQuanHuyen(quanHuyenFacade.find(quanHuyen));
            phieuMuaHang.setGhiChu("");
        }

        try {
            phieuMuaHangFacade.create(phieuMuaHang);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        //Lưu Chi tiết HĐ
        for (SanPham sp : cart.getItems()) {
            CtPhieuMuaHang ctPhieuMuaHang = new CtPhieuMuaHang();
            ctPhieuMuaHang.setIdNguoiBan(sp.getIdNguoiBan());
            ctPhieuMuaHang.setIdPhieuMuaHang(phieuMuaHang);
            ctPhieuMuaHang.setIdTinhTrang(new TinhTrang("XL"));
            ctPhieuMuaHang.setIdSanPham(sp);
            ctPhieuMuaHang.setGiaBan(sp.getGiaBan());
            ctPhieuMuaHang.setSoLuongMua(sp.getSoLuong());
            ctPhieuMuaHang.setThanhTien(sp.getGiaBan() * sp.getSoLuong());
            try {
                ctPhieuMuaHangFacade.create(ctPhieuMuaHang);

                //cập nhật tồn kho sản phẩm
                sanPhamBusiness.capNhatSoLuongSP(sp.getId(), ctPhieuMuaHang.getSoLuongMua());
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
        cart.clear();
        return "redirect:/order/detail/" + phieuMuaHang.getId() + ".php";
    }

    @RequestMapping("history")
    public String detail(Model model) {
        List<PhieuMuaHang> list = phieuMuaHangFacade.findAll();
        model.addAttribute("phieuMuaHangs", list);
        return "customer/order/history";
    }

    @RequestMapping("detail/{id}")
    public String detail(@PathVariable("id") Integer id, Model model) {
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
        return "customer/order/detail";
    }

    @ResponseBody
    @RequestMapping("get-quan-huyen")
    public String getQuanHuyen(@RequestParam("idThanhPho") Integer id) {
        if (id == -1) {
            return "";
        }
        ThanhPho thanhPho = thanhPhoFacade.find(id);
        List<QuanHuyen> list = quanHuyenService.getQuanHuyen(thanhPho);
        String temp = new Gson().toJson(list);
        return temp;
    }
    
    @RequestMapping("rating")
    public String rating(Model model, HttpSession session) {

        NguoiMua nguoiMua = (NguoiMua) session.getAttribute("nguoiMua");

        //List<SanPham> list = hoaDonBusiness.getRatingItems(user);
        //model.addAttribute("rating", list);
        List<CtPhieuMuaHang> listThanhCong = ctPhieuMuaHangBusiness.layChiTietDaHoanThanh(nguoiMua.getId());
        model.addAttribute("rating", listThanhCong);
        return "customer/order/rating";
    }
    
    @ResponseBody
    @RequestMapping("rated")
    public String rated(Model model, HttpSession httpSession,
            @RequestParam("idNguoiBan") Integer idNguoiBan,
            @RequestParam("rating") Integer rating,
            @RequestParam("idCT_PhieuMuaHang") Integer idCT_PhieuMuaHang) {
        NguoiMua user = (NguoiMua) httpSession.getAttribute("nguoiMua");
        NguoiBan nguoiBan = nguoiBanFacade.find(idNguoiBan);
        String temp = danhGiaService.danhGia(user, nguoiBan, rating);
        ctPhieuMuaHangBusiness.capNhatDaDanhGiaCT_PhieuMuaHang(idCT_PhieuMuaHang);
        return temp;
    }
}
