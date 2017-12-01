/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.services;

import ejb.business.SanPhamBusiness;
import ejb.entities.SanPham;
import ejb.sessions.SanPhamFacade;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.springframework.stereotype.Component;

/**
 *
 * @author DacTien
 */
@Component
public class SanPhamService {

    SanPhamFacade sanPhamFacade = lookupSanPhamFacadeBean();

    private SanPhamFacade lookupSanPhamFacadeBean() {
        try {
            Context c = new InitialContext();
            return (SanPhamFacade) c.lookup("java:global/ECommerceDienThoai/ECommerceDienThoai-ejb/SanPhamFacade!ejb.sessions.SanPhamFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    SanPhamBusiness sanPhamBusiness = lookupSanPhamBusinessBean();

    private SanPhamBusiness lookupSanPhamBusinessBean() {
        try {
            Context c = new InitialContext();
            return (SanPhamBusiness) c.lookup("java:global/ECommerceDienThoai/ECommerceDienThoai-ejb/SanPhamBusiness!ejb.business.SanPhamBusiness");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public List<SanPham> laySanPhamMoiNhat() {
        // TODO Auto-generated method stub
        List<SanPham> list = sanPhamBusiness.laySanPhamMoiNhat();
        return list;
    }

    public SanPham lay1SanPham(Integer id) {
        return sanPhamFacade.find(id);
    }

    

}
