/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.services;

import ejb.entities.DanhGia;
import ejb.entities.NguoiBan;
import ejb.entities.NguoiMua;
import ejb.sessions.DanhGiaFacade;
import org.springframework.stereotype.Component;

/**
 *
 * @author DacTien
 */
@Component
public class DanhGiaService {
    DanhGiaFacade danhGiaFacade = (DanhGiaFacade) LookupFactory.lookupFacadeBean("DanhGiaFacade");
    
    public String danhGia(NguoiMua nguoiMua, NguoiBan nguoiBan, int rating) {
        DanhGia danhGia = new DanhGia();
        danhGia.setIdNguoiBan(nguoiBan);
        danhGia.setIdNguoiMua(nguoiMua);
        danhGia.setSoDiem(rating);
        danhGia.setSuDung(true);
        try {
            danhGiaFacade.create(danhGia);
            return "Danh gia thanh cong";
        } catch (Exception e) {
            return "Danh gia that bai";
        }
    }
}
