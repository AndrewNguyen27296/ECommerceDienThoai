/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.services;

import ejb.business.SoTinTonBusiness;
import ejb.entities.GoiTin;
import ejb.entities.NguoiBan;
import ejb.entities.SoTinTon;
import ejb.sessions.NguoiBanFacade;
import ejb.sessions.SoTinTonFacade;
import java.util.Date;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Component;

/**
 *
 * @author XinKaChu
 */
@Component
public class SoTinTonService {
    NguoiBanFacade nguoiBanFacade = (NguoiBanFacade) LookupFactory.lookupFacadeBean("NguoiBanFacade");
    SoTinTonBusiness soTinTonBusiness = (SoTinTonBusiness) LookupFactory.lookupBusinessBean("SoTinTonBusiness");
    SoTinTonFacade soTinTonFacade = (SoTinTonFacade) LookupFactory.lookupFacadeBean("SoTinTonFacade");

    public int laySoTinTheoNguoiBanVaThoiGian(NguoiBan nguoiBan, Date thoiGian) {
        return soTinTonBusiness.laySoTinTheoNguoiBanVaThoiGian(nguoiBan.getId(), thoiGian);
    }

    public void capNhatSoTinDang(GoiTin goiTin, HttpSession httpSession) {
        SoTinTon soTinTon = new SoTinTon();
        NguoiBan nguoiBan = (NguoiBan) httpSession.getAttribute("merchant");
        int soTinHienTai = laySoTinTheoNguoiBanVaThoiGian(nguoiBan, new Date());
                
        soTinTon.setIdNguoiBan(nguoiBan);
        soTinTon.setNgayCapNhat(new Date());        
        soTinTon.setSoTinTon(soTinHienTai);
        soTinTonFacade.create(soTinTon);
    }
}
