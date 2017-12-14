/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.services;

import ejb.business.CtPhieuMuaHangBusiness;
import ejb.entities.CtPhieuMuaHang;
import ejb.entities.PhieuMuaHang;
import ejb.sessions.CtPhieuMuaHangFacade;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author DacTien
 */
@Component
public class CtPhieuMuaHangService {
    CtPhieuMuaHangFacade ctPhieuMuaHangFacade = (CtPhieuMuaHangFacade) LookupFactory.lookupFacadeBean("CtPhieuMuaHangFacade");
    CtPhieuMuaHangBusiness ctPhieuMuaHangBusiness = (CtPhieuMuaHangBusiness) LookupFactory.lookupBusinessBean("CtPhieuMuaHangBusiness");
    
    public List<CtPhieuMuaHang> layChiTietTheoMaPhieuMuaHang(Integer id) {
        return ctPhieuMuaHangBusiness.layChiTietTheoMaPhieuMuaHang(id);
    }
}
