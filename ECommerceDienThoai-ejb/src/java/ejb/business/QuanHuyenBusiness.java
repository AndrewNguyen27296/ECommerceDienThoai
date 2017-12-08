/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.business;

import ejb.entities.QuanHuyen;
import ejb.entities.ThanhPho;
import java.util.List;
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
public class QuanHuyenBusiness {

    @PersistenceContext(unitName = "ECommerceDienThoai-ejbPU")
    private EntityManager em;
    
    public void persist(Object object) {
        em.persist(object);
    }
        
    public List<QuanHuyen> getQuanHuyen(ThanhPho thanhPho) {
        Query query = em.createQuery("SELECT q FROM QuanHuyen q WHERE q.idThanhPho=:id");
        query.setParameter("id", thanhPho);
        return query.getResultList();
    }
}
