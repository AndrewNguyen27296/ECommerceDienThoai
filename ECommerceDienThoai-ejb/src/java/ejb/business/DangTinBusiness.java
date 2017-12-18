/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.business;

import ejb.entities.HangSanXuat;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author XinKaChu
 */
@Stateless
@LocalBean
public class DangTinBusiness {
    @PersistenceContext(unitName = "ECommerceDienThoai-ejbPU")
    private EntityManager em;
    
    public void persist(Object object) {
        em.persist(object);
    }
    
    public List<HangSanXuat> listHangSanXuat() {
        HangSanXuat hangSanXuat = new HangSanXuat();
        Query query = em.createQuery("SELECT n FROM HangSanXuat n");
        query.setParameter("hangSanXuat", hangSanXuat);
        try {
            hangSanXuat = (HangSanXuat) query.getResultList();
        } catch (Exception e) {
            
        }
        return (List<HangSanXuat>) hangSanXuat;
    }
} 
