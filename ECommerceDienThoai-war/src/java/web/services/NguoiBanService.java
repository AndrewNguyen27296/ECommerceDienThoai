/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.services;

import ejb.business.NguoiBanBusiness;
import ejb.entities.Admin;
import ejb.entities.NguoiBan;
import ejb.entities.PhieuNopPhat;
import ejb.sessions.NguoiBanFacade;
import ejb.sessions.PhieuNopPhatFacade;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

/**
 *
 * @author XinKaChu
 */
@Component
public class NguoiBanService {

    @Autowired
    MailerService mailerService;

    NguoiBanFacade nguoiBanFacade = (NguoiBanFacade) LookupFactory.lookupFacadeBean("NguoiBanFacade");
    NguoiBanBusiness nguoiBanBusiness = (NguoiBanBusiness) LookupFactory.lookupBusinessBean("NguoiBanBusiness");
    PhieuNopPhatFacade phieuNopPhatFacade = (PhieuNopPhatFacade) LookupFactory.lookupFacadeBean("PhieuNopPhatFacade");
    
    public String themNguoiBan(String email, String password, String hoTen, String cmnd, String soDienThoai, String diaChi,
            HttpServletRequest request) {
        if (nguoiBanBusiness.kiemTraTonTaiCMND(cmnd) == true) {
            return "CMND này đã được sử dụng";
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
            merchant.setSoLanCanhCao(0);
            merchant.setSoLanBiBlock(0);
            merchant.setKichHoat(false);
            merchant.setBiKhoa(false);
            merchant.setBiBlock(false);
            nguoiBanFacade.create(merchant);
            try {

                String to = merchant.getEmail();
                String subject = "Chào mừng bạn đã đến với DIGIWOLD-Kênh Người Bán \n";
                String body = "Cảm ơn bạn đã đăng ký kênh người bán - DigiWorld. \n"
                        + "Tài khoản của bạn vẫn chưa được kích hoạt \n"
                        + "Vui lòng đến trụ sở công ty chúng tôi để kích hoạt và mua gói tin \n";
                mailerService.send(to, subject, body);
                return "Đăng ký thành công, vui lòng đến trụ sở công ty chúng tôi để kích hoạt và mua gói tin";
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
        NguoiBan merchant = nguoiBanFacade.find(Integer.parseInt(id));
        merchant.setKichHoat(true);
        nguoiBanFacade.edit(merchant);
    }

    public String dangNhap(String email, String password,
            HttpSession httpSession) {
        if (nguoiBanBusiness.kiemTraTonTaiEmail(email) == true) {
            NguoiBan nguoiBan = nguoiBanBusiness.layNguoiBanTheoEmail(email);
            if (nguoiBan.getMatKhau().equals(maHoaMatKhau(password)) == true) {
                if (nguoiBan.getKichHoat() == false) {
                    return "Tài khoản của bạn vẫn chưa được kích hoạt. Vui lòng đến trụ sở công ty chúng tôi để kích hoạt và mua gói tin";
                } else if (nguoiBan.getBiBlock() == true) {
                    return "Tài khoản của bạn đã bị khóa vĩnh viễn vì vi phạm quá nhiều lần";
                } else {
                    httpSession.setAttribute("nguoiBan", nguoiBan);
                    return "Đăng nhập thành công";
                }
            }
            return "Mật khẩu không chính xác";
        }
        return "Email không tồn tại";
    }

    public void doiMatKhau(ModelMap model, String password, String password1, String password2, HttpSession httpSession) {
        if (password1.equals(password2)) {
            NguoiBan merchant = (NguoiBan) httpSession.getAttribute("nguoiBan");
            if (maHoaMatKhau(password).equals(merchant.getMatKhau())) {
                merchant.setMatKhau(maHoaMatKhau(password1));
                nguoiBanFacade.edit(merchant);
                model.addAttribute("message", "Chúc mừng bạn đã đổi mật khẩu thành công");
                httpSession.setAttribute("merchant", merchant);
            } else {
                model.addAttribute("message", "Bạn nhập sai mật khẩu hiện tại");
            }

        } else {
            model.addAttribute("message", "Mật khẩu mới và cũ không khớp");
        }

    }

    public void capNhatNguoiBan(NguoiBan nguoiBan, ModelMap model, HttpSession httpSession) {
        NguoiBan nguoiBanUpdate = nguoiBanFacade.find(nguoiBan.getId());
        nguoiBanUpdate.setEmail(nguoiBan.getEmail());
        nguoiBanUpdate.setMatKhau(nguoiBan.getMatKhau());
        nguoiBanUpdate.setHoTen(nguoiBan.getHoTen());
        nguoiBanUpdate.setCmnd(nguoiBan.getCmnd());
        nguoiBanUpdate.setSoDienThoai(nguoiBan.getSoDienThoai());
        nguoiBanUpdate.setDiaChi(nguoiBan.getDiaChi());
        try {
            nguoiBanFacade.edit(nguoiBanUpdate);
            model.addAttribute("message", "Cập nhật thành công");
            httpSession.setAttribute("nguoiBan", nguoiBan);
        } catch (Exception e) {
            model.addAttribute("message", "Cập nhật thất bại");
        }
        
        
    }

    public void quenMatKhau(ModelMap model, String email) {
        if (nguoiBanBusiness.kiemTraTonTaiEmail(email)) {
            
            
            //Gửi mail mật khẩu
            try {
                NguoiBan nguoiBan = nguoiBanBusiness.layNguoiBanTheoEmail(email);
                nguoiBan.setMatKhau(maHoaMatKhau("123456"));
                nguoiBanFacade.edit(nguoiBan);
                
                mailerService.send(email, "Forgot Password", "Password mới của bạn là: 123456. Vui lòng đăng nhập để đổi password");
                model.addAttribute("message", "Mật khẩu đã được gửi qua email");
               
                //Giả sử pass mới là 123456
                //Mình phải mã hóa 123456 và cập nhật lại trong csdl
                
            } catch (Exception e) {
                // TODO: handle exception
                model.addAttribute("message", "Mật khẩu đã được gửi qua email. Bạn vui lòng kiểm tra email để lấy mật khẩu mới");
            }
        } else {
            model.addAttribute("message", "Không tồn tại email");
        }
    }
    
    public void themPhieuNopPhat(Integer id, HttpSession httpSession) {
        PhieuNopPhat phieuNopPhat = new PhieuNopPhat();
        NguoiBan nguoiBan = nguoiBanFacade.find(id);
        phieuNopPhat.setIdAdmin((Admin) httpSession.getAttribute("admin"));
        phieuNopPhat.setIdNguoiBan(nguoiBan);
        phieuNopPhat.setNgayNopPhat(new Date());
        phieuNopPhat.setSoTien(200000);
        nguoiBan.setBiKhoa(false);
        try {
            phieuNopPhatFacade.create(phieuNopPhat);
            nguoiBanFacade.edit(nguoiBan);
        } catch (Exception e) {
            throw e;
        }
    }
}
