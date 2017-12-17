/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.services;

import ejb.business.NguoiMuaBusiness;
import ejb.entities.NguoiMua;
import ejb.sessions.NguoiMuaFacade;
import ejb.sessions.QuanHuyenFacade;
import ejb.sessions.ThanhPhoFacade;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.jasper.tagplugins.jstl.ForEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

/**
 *
 * @author DacTien
 */
@Component
public class NguoiMuaService {

    @Autowired
    MailerService mailerService;

    NguoiMuaFacade nguoiMuaFacade = lookupNguoiMuaFacadeBean();
    QuanHuyenFacade quanHuyenFacade = (QuanHuyenFacade) LookupFactory.lookupFacadeBean("QuanHuyenFacade");
    ThanhPhoFacade thanhPhoFacade = (ThanhPhoFacade) LookupFactory.lookupFacadeBean("ThanhPhoFacade");

    private NguoiMuaFacade lookupNguoiMuaFacadeBean() {
        try {
            Context c = new InitialContext();
            return (NguoiMuaFacade) c.lookup("java:global/ECommerceDienThoai/ECommerceDienThoai-ejb/NguoiMuaFacade!ejb.sessions.NguoiMuaFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    NguoiMuaBusiness nguoiMuaBusiness = lookupNguoiMuaBusinessBean();

    private NguoiMuaBusiness lookupNguoiMuaBusinessBean() {
        try {
            Context c = new InitialContext();
            return (NguoiMuaBusiness) c.lookup("java:global/ECommerceDienThoai/ECommerceDienThoai-ejb/NguoiMuaBusiness!ejb.business.NguoiMuaBusiness");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public String themNguoiMua(String hoTen, String email, String password, String diaChi, String soDienThoai,
            int thanhPho, int quanHuyen, HttpServletRequest request) {
//        List<NguoiMua> list = nguoiMuaFacade.findAll();
//        for (NguoiMua n : list) {
//            if (n.getId().equals(email)) {
//                return "Email này đã được sử dụng";
//            }
//            if (n.getSoDienThoai().equals(soDienThoai)) {
//                return "Số điện thoại này đã được sử dụng";
//            }
//        }
        if (nguoiMuaBusiness.kiemTraTonTaiEmail(email) == true) {
            return "Email này đã được sử dụng";
        }
        if (nguoiMuaBusiness.kiemTraTonTaiSDT(soDienThoai) == true) {
            return "Số điện thoại này đã được sử dụng";
        }
        try {
            NguoiMua customer = new NguoiMua();
            customer.setDiaChi(diaChi);
            customer.setEmail(email);
            customer.setHoTen(hoTen);
            customer.setMatKhau(maHoaMatKhau(password));
            customer.setSoDienThoai(soDienThoai);
            customer.setNgayDangKy(new Date());
            customer.setKichHoat(false);
            customer.setTrangThai(true);
            customer.setIdQuanHuyen(quanHuyenFacade.find(quanHuyen));
            customer.setIdThanhPho(thanhPhoFacade.find(thanhPho));
            nguoiMuaFacade.create(customer);
            try {
                String url = request.getRequestURL().toString().replace("register", "activate/" + customer.getId());
                String to = customer.getEmail();
                String subject = "Chào mừng bạn đã đến với DIGIWOLD";
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

    //Mã hóa mật khẩu MD5 (không có cách giải mã - nếu nhập đúng mật khẩu thì sẽ cho ra lại đúng mã đã được mã hóa)
    public String maHoaMatKhau(String password) {
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
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            generatedPassword = "";
            e.printStackTrace();
        }
        return generatedPassword;
    }

    public void kichHoatTaiKhoan(String id) {
        NguoiMua customer = nguoiMuaFacade.find(Integer.parseInt(id));
        customer.setKichHoat(true);
        nguoiMuaFacade.edit(customer);
    }

    public String dangNhap(String email, String password,
            HttpSession httpSession) {
        if (nguoiMuaBusiness.kiemTraTonTaiEmail(email) == true) {
            NguoiMua nguoiMua = nguoiMuaBusiness.layNguoiMuaTheoEmail(email);
            if (nguoiMua.getMatKhau().equals(maHoaMatKhau(password)) == true) {
                httpSession.setAttribute("nguoiMua", nguoiMua);
                return "Đăng nhập thành công";
            }
            return "Mật khẩu không chính xác";
        }
        return "Email không tồn tại";
    }

    public void capNhatNguoiMua(NguoiMua nguoiMua, ModelMap model, HttpSession httpSession) {
        NguoiMua nguoiMuaUpdate = nguoiMuaFacade.find(nguoiMua.getId());
        nguoiMuaUpdate.setEmail(nguoiMua.getEmail());
        nguoiMuaUpdate.setHoTen(nguoiMua.getHoTen());
        nguoiMuaUpdate.setSoDienThoai(nguoiMua.getSoDienThoai());
        try {
            nguoiMuaFacade.edit(nguoiMuaUpdate);
            model.addAttribute("message", "Cập nhật thành công");
            httpSession.setAttribute("nguoiMua", nguoiMua);
        } catch (Exception e) {
            // TODO: handle exception
            model.addAttribute("message", "Cập nhật thất bại");
        }
    }

    public void doiMatKhau(ModelMap model,
            String matKhau,
            String matKhau1,
            String matKhau2,
            HttpSession httpSession) {
        if (matKhau1.equals(matKhau2)) {
            NguoiMua user = (NguoiMua) httpSession.getAttribute("nguoiMua");
            if (maHoaMatKhau(matKhau).equals(user.getMatKhau())) {
                user.setMatKhau(maHoaMatKhau(matKhau1));
                nguoiMuaFacade.edit(user);
                model.addAttribute("message", "Đổi mật khẩu thành công");
                httpSession.setAttribute("user", user);
            } else {
                model.addAttribute("message", "Sai mật khẩu hiện tại");
            }
        } else {
            model.addAttribute("message", "Xác nhận mật khẩu không đúng");
        }
    }

    public void quenMatKhau(Model model, String email, String soDienThoai) {
        if (nguoiMuaBusiness.kiemTraTonTaiEmail(email)) {
            NguoiMua nguoiMua = nguoiMuaBusiness.layNguoiMuaTheoEmail(email);
            if (nguoiMua.getSoDienThoai().equals(soDienThoai)) {
                try {
                    String to = email;
                    String subject = "Quên mật khẩu";
                    String body = "Mật khẩu mới của bạn là 123456. Vui lòng đăng nhập và cập nhật lại mật khẩu mới";
                    mailerService.send(to, subject, body);
                    model.addAttribute("message", "Mật khẩu của bạn đã được reset. Vui lòng kiểm tra email");

                    nguoiMua.setMatKhau(maHoaMatKhau("123456"));
                    nguoiMuaFacade.edit(nguoiMua);
                } catch (Exception e) {
                    model.addAttribute("message", "Gửi mail thất bại");
                }
            } else {
                model.addAttribute("message", "Email và SĐT không trùng khớp, xin kiểm tra lại");
            }
        } else {
            model.addAttribute("message", "Email không tồn tại");
        }
    }
}
