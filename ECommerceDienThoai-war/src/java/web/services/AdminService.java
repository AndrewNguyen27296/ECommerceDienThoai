/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.services;

import ejb.business.AdminBusiness;
import ejb.business.NguoiBanBusiness;
import ejb.entities.Admin;
import ejb.entities.NguoiBan;
import ejb.entities.NguoiMua;
import ejb.sessions.AdminFacade;
import ejb.sessions.NguoiBanFacade;
import ejb.sessions.NguoiMuaFacade;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

/**
 *
 * @author XinKaChu
 */
@Component
public class AdminService {

    AdminFacade adminFacade = (AdminFacade) LookupFactory.lookupFacadeBean("AdminFacade");
    AdminBusiness adminBusiness = (AdminBusiness) LookupFactory.lookupBusinessBean("AdminBusiness");
    NguoiBanBusiness nguoiBanBusiness = lookupNguoiBanBusinessBean();
    
    private NguoiBanBusiness lookupNguoiBanBusinessBean() {
        try {
            Context c = new InitialContext();
            return (NguoiBanBusiness) c.lookup("java:global/ECommerceDienThoai/ECommerceDienThoai-ejb/NguoiBanBusiness!ejb.business.NguoiBanBusiness");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    NguoiMuaFacade nguoiMuaFacade = lookupNguoiMuaFacadeBean();
    
    private NguoiMuaFacade lookupNguoiMuaFacadeBean() {
        try {
            Context c = new InitialContext();
            return (NguoiMuaFacade) c.lookup("java:global/ECommerceDienThoai/ECommerceDienThoai-ejb/NguoiMuaFacade!ejb.sessions.NguoiMuaFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    

    NguoiBanFacade nguoiBanFacade = lookupNguoiBanFacadeBean();
    
    private NguoiBanFacade lookupNguoiBanFacadeBean() {
        try {
            Context c = new InitialContext();
            return (NguoiBanFacade) c.lookup("java:global/ECommerceDienThoai/ECommerceDienThoai-ejb/NguoiBanFacade!ejb.sessions.NguoiBanFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    
    
    public List<Admin> layDanhSachAdmin() {
        return adminFacade.findAll();
    }

    public List<NguoiBan> layDanhSachNguoiBan() {
        return nguoiBanFacade.findAll();
    } 
   
    public void kichHoatNguoiBan(int id, Model model) {
        try {
             NguoiBan nguoiBan = nguoiBanFacade.find(id);
             nguoiBan.setKichHoat(true);
             nguoiBanFacade.edit(nguoiBan);
             model.addAttribute("mess", "Tài khoản " + nguoiBan.getEmail() + " đã được kích hoạt thành công");
        } catch (Exception e) {
            model.addAttribute("mess", "Lỗi kích hoạt tài khoản");
        }
    }

    public String dangNhap(String email, String password, HttpSession httpSession) {
        if (adminBusiness.kiemTraTonTaiEmail(email) == true) {
            Admin admin = adminBusiness.layNguoiMuaTheoEmail(email);
            if (admin.getMatKhau().equals(password) == true) {
                httpSession.setAttribute("admin", admin);
                return "Đăng nhập thành công";
            }
            return "Mật khẩu không chính xác";
        }
        return "Email không tồn tại";
    }

    public List<NguoiMua> layDanhSachNguoiMua() {
        return nguoiMuaFacade.findAll();
    }

    public List<NguoiBan> timKiemNguoiBan(String cmnd) {
        return nguoiBanBusiness.timKiemNguoiMua(cmnd);
    }
}
