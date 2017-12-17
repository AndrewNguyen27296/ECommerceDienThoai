/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.services;

import ejb.entities.BienBanKhoa;
import ejb.entities.BienBanKhoaVinhVien;
import ejb.entities.CauHinh;
import ejb.entities.DanhGia;
import ejb.entities.NguoiBan;
import ejb.entities.NguoiMua;
import ejb.sessions.BienBanKhoaFacade;
import ejb.sessions.BienBanKhoaVinhVienFacade;
import ejb.sessions.CauHinhFacade;
import ejb.sessions.DanhGiaFacade;
import ejb.sessions.NguoiBanFacade;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author DacTien
 */
@Component
public class DanhGiaService {

    @Autowired
    MailerService mailerService;

    DanhGiaFacade danhGiaFacade = (DanhGiaFacade) LookupFactory.lookupFacadeBean("DanhGiaFacade");
    CauHinhFacade cauHinhFacade = (CauHinhFacade) LookupFactory.lookupFacadeBean("CauHinhFacade");
    NguoiBanFacade nguoiBanFacade = (NguoiBanFacade) LookupFactory.lookupFacadeBean("NguoiBanFacade");
    BienBanKhoaFacade bienBanKhoaFacade = (BienBanKhoaFacade) LookupFactory.lookupFacadeBean("BienBanKhoaFacade");
    BienBanKhoaVinhVienFacade bienBanKhoaVinhVienFacade = (BienBanKhoaVinhVienFacade) LookupFactory.lookupFacadeBean("BienBanKhoaVinhVienFacade");
    
    public String danhGia(NguoiMua nguoiMua, NguoiBan nguoiBan, int rating) {
        CauHinh cauHinh = cauHinhFacade.find(1);
        int quyDinhSoLanLock = cauHinh.getSoLanBlock();

        DanhGia danhGia = new DanhGia();
        danhGia.setIdNguoiBan(nguoiBan);
        danhGia.setIdNguoiMua(nguoiMua);
        danhGia.setSoDiem(rating);
        danhGia.setSuDung(true);
        try {
            danhGiaFacade.create(danhGia);
            if (rating == 1) {
                //Kiểm tra số lần bị lock của MERCHANT
                //Nếu số lần bị lock < (quy định - 2) vd: 4 thì là 2
                if (nguoiBan.getSoLanBiBlock() <= (quyDinhSoLanLock - 2)) {
                    if (nguoiBan.getSoLanCanhCao() < 2) {
                        //Tăng biến số lần cảnh cáo lên 1
                        nguoiBan.setSoLanCanhCao(nguoiBan.getSoLanCanhCao() + 1);
                        nguoiBanFacade.edit(nguoiBan);
                    } else if (nguoiBan.getSoLanCanhCao() == 2) {
                        //Reset biến số lần cảnh cáo
                        //Tăng biến số lần bị lock lên 1
                        //Khóa tài khoản => Vẫn được đăng nhập nhưng không thể đăng bài
                        nguoiBan.setSoLanCanhCao(0);
                        nguoiBan.setSoLanBiBlock(nguoiBan.getSoLanBiBlock() + 1);
                        nguoiBan.setBiKhoa(true);
                        nguoiBanFacade.edit(nguoiBan);
                        //Gửi mail thông báo TK đã bị khóa và lên trụ sở nộp phạt
                        String to = nguoiMua.getEmail();
                        String subject = "DIGIWOLD thông báo tạm khóa tài khoản";
                        String body = "Do bạn đã vi phạm chính sách công ty (3 lần bị đánh giá 1 sao) nên tài khoản của bạn đã bị tạm khóa <br>"
                                + "Nếu muốn tiếp tục hoạt động, vui lòng đến trụ sở công ty nộp phạt (200.000 VNĐ)";
                        mailerService.send(to, subject, body);
                        //Tạo biên bản khóa tài khoản
                        BienBanKhoa bienBanKhoa = new BienBanKhoa();
                        bienBanKhoa.setIdNguoiBan(nguoiBan);
                        bienBanKhoa.setNgayKhoa(new Date());
                        bienBanKhoa.setLyDo("3 lần bị đánh giá 1 sao");
                        bienBanKhoaFacade.create(bienBanKhoa);
                    }
                } else if (nguoiBan.getSoLanBiBlock() == (quyDinhSoLanLock - 1)) {
                    if (nguoiBan.getSoLanCanhCao() < 2) {
                        //Tăng biến số lần cảnh cáo lên 1
                        nguoiBan.setSoLanCanhCao(nguoiBan.getSoLanCanhCao() + 1);
                        nguoiBanFacade.edit(nguoiBan);
                    } else if (nguoiBan.getSoLanCanhCao() == 2) {
                        //Reset biến số lần cảnh cáo
                        //Reset biến số lần bị lock
                        //Lock tài khoản => không thể đăng nhập
                        nguoiBan.setSoLanCanhCao(0);
                        nguoiBan.setSoLanBiBlock(0);
                        nguoiBan.setBiBlock(true);
                        nguoiBanFacade.edit(nguoiBan);
                        //Gửi mail thông báo TK đã bị khóa vĩnh viễn
                        String to = nguoiMua.getEmail();
                        String subject = "DIGIWOLD thông báo khóa vĩnh viễn tài khoản";
                        String body = "Do bạn đã vi phạm chính sách công ty (3 lần bị khóa tài khoản) nên tài khoản của bạn đã bị khóa vĩnh viễn và không thể tiếp tục sử dụng";
                        mailerService.send(to, subject, body);
                        //Tạo biên bản khóa vĩnh viễn
                        BienBanKhoaVinhVien bienBanKhoaVinhVien = new BienBanKhoaVinhVien();
                        bienBanKhoaVinhVien.setIdNguoiBan(nguoiBan);
                        bienBanKhoaVinhVien.setNgayKhoaVinhVien(new Date());
                        bienBanKhoaVinhVien.setLyDo("3 cần bị tạm khóa tài khoản");
                        bienBanKhoaVinhVienFacade.create(bienBanKhoaVinhVien);
                    }
                }
            }
            return "Danh gia thanh cong";
        } catch (Exception e) {
            return "Danh gia that bai";
        }
    }
}
