/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.services;

import ejb.business.NguoiBanBusiness;
import ejb.entities.NguoiBan;
import ejb.sessions.NguoiBanFacade;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author XinKaChu
 */
@Component
public class NguoiBanService {
    
    @Autowired
    MailerService mailerService;
    
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
    
    public String themNguoiBan(String email, String password,String hoTen, String cmnd, String soDienThoai, String diaChi,
                HttpServletRequest request) {
        if (nguoiBanBusiness.kiemTraTonTaiEmail(email) == true) {
            return "Email này đã được sử dụng";
        }
        if (nguoiBanBusiness.kiemTraTonTaiSDT(soDienThoai) == true) {
            return "Số điện thoại này đã được sử dụng";
        }
        try {
            NguoiBan merchant = new NguoiBan();
            merchant.setDiaChi(diaChi);
            merchant.setCmnd(cmnd);
            merchant.setEmail(email);
            merchant.setHoTen(hoTen);
            merchant.setMatKhau(maHoaMatKhau(password));
            merchant.setSoDienThoai(soDienThoai);
            merchant.setNgayDangKy(new Date());
            merchant.setKichHoat(false);
            merchant.setTrangThai(true);
            nguoiBanFacade.create(merchant);
            try {
                String url = request.getRequestURL().toString().replace("register", "activate/" + merchant.getId());
                String to = merchant.getEmail();
                String subject = "Chào mừng bạn đã đến với DIGIWOLD-Kênh Người Bán";
                String body = "Cảm ơn bạn đã tham gia cùng chúng tôi. "
                        + "Click vào đây liên kết sau đây để kích hoạt tài khoản<hr>"
                        + "<a href='" + url + "'>Kích hoạt tài khoản</a>";
                mailerService.send(to, subject, body);
                return "Đăng ký thành công, vui lòng kiểm tra email và kích hoạt tài khoản";
            } catch (Exception e) {
                return "Gửi mail thất bại";
            }
        } catch (Exception e) {
            return "Đăng ký thất bại";
        } 
    }

    private String maHoaMatKhau(String password) {
        String generatedPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(password.getBytes());
            //Get the hash's bytes
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            generatedPassword = "";
            e.printStackTrace();
        }
        return generatedPassword;
    }
    
    public void kichHoatTaiKhoan(String id) {
        NguoiBan merchant = nguoiBanFacade.find(Integer.parseInt(id));
        merchant.setKichHoat(true);
        nguoiBanFacade.edit(merchant);
    }
    
    public String dangNhap(String email, String password,
                HttpSession httpSession) {
        if (nguoiBanBusiness.kiemTraTonTaiEmail(email) == true) {
            NguoiBan nguoiBan = nguoiBanBusiness.layNguoiBanTheoEmail(email);
            if (nguoiBan.getMatKhau().equals(maHoaMatKhau(password)) == true) {
                httpSession.setAttribute("nguoiBan", nguoiBan);
                return "Đăng nhập thành công";
            }
            return "Mật khẩu không chính xác";
        }
        return "Email không tồn tại";
    }
}
