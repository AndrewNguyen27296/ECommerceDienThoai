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

    AdminFacade adminFacade = (AdminFacade) LookupFactory.lookupFacadeBean("AdminFacade");
    AdminBusiness adminBusiness = (AdminBusiness) LookupFactory.lookupBusinessBean("AdminBusiness");


    public List<Admin> layDanhSachAdmin() {
        return adminFacade.findAll();
    }
}
