/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.services;

import ejb.business.AdminBusiness;
import ejb.entities.Admin;
import ejb.sessions.AdminFacade;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.springframework.stereotype.Component;

/**
 *
 * @author XinKaChu
 */
@Component
public class AdminService {

    AdminFacade adminFacade = lookupAdminFacadeBean();
    AdminBusiness adminBusiness = lookupAdminBusinessBean();

    private AdminBusiness lookupAdminBusinessBean() {
        try {
            Context c = new InitialContext();
            return (AdminBusiness) c.lookup("java:global/ECommerceDienThoai/ECommerceDienThoai-ejb/AdminBusiness!ejb.business.AdminBusiness");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    private AdminFacade lookupAdminFacadeBean() {
        try {
            Context c = new InitialContext();
            return (AdminFacade) c.lookup("java:global/ECommerceDienThoai/ECommerceDienThoai-ejb/AdminFacade!ejb.sessions.AdminFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }


    public List<Admin> layDanhSachAdmin() {
        return adminFacade.findAll();
    }
}
