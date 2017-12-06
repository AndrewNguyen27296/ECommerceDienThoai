/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.business;

import ejb.entities.Admin;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author DacTien
 */
@Stateless
@LocalBean
public class AdminBusiness {

    @PersistenceContext(unitName = "ECommerceDienThoai-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    
    public boolean kiemTraTonTaiEmail(String email) {
        Query query = em.createQuery("SELECT n FROM Admin n WHERE n.email=:e");
        query.setParameter("e", email);
        try {
            query.getSingleResult();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public Admin layNguoiMuaTheoEmail(String email) {
        Admin admin = new Admin();
        Query query = em.createQuery("SELECT n FROM Admin n WHERE n.email=:e");
        query.setParameter("e", email);
        try {
            admin = (Admin) query.getSingleResult();
        } catch (Exception e) {
            
        }
        return admin;
    }
    
}
