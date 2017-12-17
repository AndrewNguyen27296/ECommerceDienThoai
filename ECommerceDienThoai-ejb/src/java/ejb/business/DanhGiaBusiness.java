/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.business;

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
public class DanhGiaBusiness {

    @PersistenceContext(unitName = "ECommerceDienThoai-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    
    public double layRatingTrungBinhCuaNguoiMua(int id) {
        double rating = -1;
        Query query = em.createQuery("SELECT AVG(d.soDiem) FROM DanhGia d WHERE d.idNguoiBan.id=:e");
        query.setParameter("e", id);
        try {
            rating = (double) query.getSingleResult();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return rating;
    }
    
    public List<Object[]> thongKeDanhGia() {
        Query query = em.createQuery("SELECT d.soDiem, COUNT(d.soDiem) FROM DanhGia d GROUP BY d.soDiem");
        List<Object[]> list = query.getResultList();
        return list;
    }
}
