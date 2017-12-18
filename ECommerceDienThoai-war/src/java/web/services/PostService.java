/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.services;

import ejb.business.DangTinBusiness;
import ejb.entities.HangSanXuat;
import ejb.entities.NguoiBan;
import ejb.entities.SanPham;
import ejb.sessions.AdminFacade;
import ejb.sessions.HangSanXuatFacade;
import ejb.sessions.SanPhamFacade;
import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import web.models.SanPhamViewModel;

/**
 *
 * @author XinKaChu
 */
@Component
public class PostService {

    HangSanXuatFacade hangSanXuatFacade = lookupHangSanXuatFacadeBean();
    SanPhamFacade sanPhamFacade = (SanPhamFacade) LookupFactory.lookupFacadeBean("SanPhamFacade");
    DangTinBusiness dangTinBusiness = lookupDangTinBusinessBean();
    
    @Autowired
    ServletContext app;
            
    private DangTinBusiness lookupDangTinBusinessBean() {
        try {
            Context c = new InitialContext();
            return (DangTinBusiness) c.lookup("java:global/ECommerceDienThoai/ECommerceDienThoai-ejb/DangTinBusiness!ejb.business.DangTinBusiness");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private HangSanXuatFacade lookupHangSanXuatFacadeBean() {
        try {
            Context c = new InitialContext();
            return (HangSanXuatFacade) c.lookup("java:global/ECommerceDienThoai/ECommerceDienThoai-ejb/HangSanXuatFacade!ejb.sessions.HangSanXuatFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public List<HangSanXuat> layDanhSachHangSanXuat() {
        return hangSanXuatFacade.findAll();
    }

    public String dangTin(Model model,SanPhamViewModel spVM, MultipartFile hinhAnh, 
            HttpServletRequest request, HttpSession httpSession) {
        SanPham sp = new SanPham();

            sp.setAnHien(true);
            sp.setBaoHanh(spVM.getBaoHanh());
            sp.setIdHangSanXuat(hangSanXuatFacade.find(spVM.getIdHangSanXuat()));
            sp.setIdNguoiBan((NguoiBan) httpSession.getAttribute("nguoiBan"));
            sp.setTenMay(spVM.getTenMay());
            sp.setGiaBan(spVM.getGiaBan());
            sp.setMoTa(spVM.getMoTa());
            sp.setKichThuocManHinh(spVM.getKichThuocManHinh());
            sp.setCpu(spVM.getCpu());
            sp.setTocDoCpu(spVM.getTocDoCPU());
            sp.setRam(spVM.getRam());
            sp.setBoNhoTrong(spVM.getBoNhoTrong());
            sp.setHeDieuHanh(spVM.getHeDieuHanh());
            sp.setCameraTruoc(spVM.getCameraTruoc());
            sp.setCameraSau(spVM.getCameraSau());
            sp.setDungLuongPin(spVM.getDungLuongPin());
            sp.setTonKho(spVM.getTonKho());
            sp.setNgayDang(new Date());
            sp.setSoLanXem(0);
            sp.setSoLanMua(0);
            sp.setTrangThai(true);
        try {
            //Kiểm tra xem ngta có upload hình ko
			if (hinhAnh.isEmpty()) {
				sp.setHinhAnh("assets/images/sorry-image-not-available.jpg");
			}
			else {
				//gán tên hình vào thuộc tinh
				sp.setHinhAnh(hinhAnh.getOriginalFilename());
				
				//Lưu file hình vào thư mục
				String path = app.getRealPath("assets/images/products/" + sp.getHinhAnh());
				hinhAnh.transferTo(new File(path));
			}
			sanPhamFacade.create(sp);
                        System.out.println("thanh cong");
			model.addAttribute("message", "Insert thanh cong");
			
                        return "redirect:/merchant/post/new.php";
                        
        } catch (Exception e) {
            System.out.println("that bai");
            model.addAttribute("message", "Insert that bai");
        }
        return "merchant/home/post";
    }

    public List<SanPham> layDanhSachSanPham() {
        return sanPhamFacade.findAll();
    }

}
