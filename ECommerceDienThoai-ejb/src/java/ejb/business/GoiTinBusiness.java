/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.business;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
/**
 *
 * @author myly
 */
@Stateless
@LocalBean
public class GoiTinBusiness {

    @PersistenceContext(unitName = "ECommerceDienThoai-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public Object getGoiTinInfo(Integer id) {
        Query query = em.createQuery("SELECT g.soTin, g.giaBan FROM GoiTin g WHERE g.id=:e");
        query.setParameter("e", id);
        Object list = query.getSingleResult();
        return list;
    }
}
