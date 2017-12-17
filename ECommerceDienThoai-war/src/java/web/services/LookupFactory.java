/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.services;

import ejb.business.AdminBusiness;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author XinKaChu
 */
public class LookupFactory {

    public static Object lookupBusinessBean(String beanName) {
        try {
            Context c = new InitialContext();
            return c.lookup("java:global/ECommerceDienThoai/ECommerceDienThoai-ejb/"+beanName+"!ejb.business."+beanName);
        } catch (NamingException ne) {
            Logger.getLogger(LookupFactory.class.getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    public static Object lookupFacadeBean(String beanName) {
        try {
            Context c = new InitialContext();
            return c.lookup("java:global/ECommerceDienThoai/ECommerceDienThoai-ejb/"+beanName+"!ejb.sessions."+beanName);
        } catch (NamingException ne) {
            Logger.getLogger(LookupFactory.class.getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
