/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.services;

import ejb.business.SoTinTonBusiness;
import ejb.entities.NguoiBan;
import ejb.entities.PhieuMuaTin;
import ejb.entities.SoTinTon;
import ejb.sessions.GoiTinFacade;
import ejb.sessions.PhieuMuaTinFacade;
import ejb.sessions.SoTinTonFacade;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

/**
 *
 * @author XinKaChu
 */
@Component
public class GoiTinService {

    SoTinTonBusiness soTinTonBusiness = lookupSoTinTonBusinessBean();

    private SoTinTonBusiness lookupSoTinTonBusinessBean() {
        try {
            Context c = new InitialContext();
            return (SoTinTonBusiness) c.lookup("java:global/ECommerceDienThoai/ECommerceDienThoai-ejb/SoTinTonBusiness!ejb.business.SoTinTonBusiness");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    GoiTinFacade goiTinFacade = (GoiTinFacade) LookupFactory.lookupFacadeBean("GoiTinFacade");
    SoTinTonFacade soTinTonFacade = (SoTinTonFacade) LookupFactory.lookupFacadeBean("SoTinTonFacade");
    PhieuMuaTinFacade phieuMuaTinFacade = (PhieuMuaTinFacade) LookupFactory.lookupFacadeBean("PhieuMuaTinFacade");
    
    public void laySoTinTon(Model model, HttpSession httpSession) {
        NguoiBan nguoiBan = (NguoiBan) httpSession.getAttribute("nguoiBan");
        SoTinTon soTinTon = soTinTonBusiness.laySoTinTheoIdNguoiBan(nguoiBan);
        model.addAttribute("soTinTon", soTinTon.getSoTinTon());
    }
    
    public List<PhieuMuaTin> layDanhSachPhieuMuaTin(HttpSession httpSession){
        NguoiBan nguoiBan = (NguoiBan) httpSession.getAttribute("nguoiBan");
        return nguoiBan.getPhieuMuaTinList();
    }
}
