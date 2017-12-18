/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.business;

import java.util.ArrayList;
import java.util.List;
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
public class ThongKeBusiness {

    @PersistenceContext(unitName = "ECommerceDienThoai-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    
    public List<Long> thongKeDoanhThu() {
        long goi1 = 0;
        long goi2 = 0;
        long goi3 = 0;
        long goi1_o = 0;
        long goi2_o = 0;
        long goi3_o = 0;
        long phat = 0;
        
        Query query = em.createQuery("SELECT SUM(p.giaBan) FROM PhieuMuaTin p WHERE p.idGoiTin.id=1");
        try {
            goi1 = (long) query.getSingleResult();
        } catch (Exception e) {
        }
        Query query2 = em.createQuery("SELECT SUM(p.giaBan) FROM PhieuMuaTin p WHERE p.idGoiTin.id=2");
        try {
            goi2 = (long) query2.getSingleResult();
        } catch (Exception e) {
        }
        Query query3 = em.createQuery("SELECT SUM(p.giaBan) FROM PhieuMuaTin p WHERE p.idGoiTin.id=3");
        try {
            goi3 = (long) query3.getSingleResult();
        } catch (Exception e) {
        }
        
        Query query_o = em.createQuery("SELECT SUM(p.giaBan) FROM PhieuMuaTinOffline p WHERE p.idGoiTin.id=1");
        try {
            goi1_o = (long) query_o.getSingleResult();
        } catch (Exception e) {
        }
        Query query2_o = em.createQuery("SELECT SUM(p.giaBan) FROM PhieuMuaTinOffline p WHERE p.idGoiTin.id=2");
        try {
            goi2_o = (long) query2_o.getSingleResult();
        } catch (Exception e) {
        }
        Query query3_o = em.createQuery("SELECT SUM(p.giaBan) FROM PhieuMuaTinOffline p WHERE p.idGoiTin.id=3");
        try {
            goi3_o = (long) query3_o.getSingleResult();
        } catch (Exception e) {
        }
        
        Query query_phat = em.createQuery("SELECT SUM(p.soTien) FROM PhieuNopPhat p");
        try {
            phat = (long) query_phat.getSingleResult();
        } catch (Exception e) {
        }
        
        List<Long> list = new ArrayList<>();
        list.add(goi1 + goi1_o);
        list.add(goi2 + goi2_o);
        list.add(goi3 + goi3_o);
        list.add(phat);
        return list;
    }
    
     public List<Long> thongKeDoanhThuTheoThang(Integer thang) {
        long onl = 0;
        long off = 0;
        long phat = 0;
        
        Query query = em.createQuery("SELECT SUM(p.giaBan) FROM PhieuMuaTin p WHERE extract(month from p.ngayMua)=:e");
        query.setParameter("e", thang);
        try {
            onl = (long) query.getSingleResult();
        } catch (Exception e) {
        }
        
        Query query2 = em.createQuery("SELECT SUM(p.giaBan) FROM PhieuMuaTinOffline p WHERE extract(month from p.ngayMua)=:e");
        query2.setParameter("e", thang);
        try {
            off = (long) query2.getSingleResult();
        } catch (Exception e) {
        }
        
        Query query3 = em.createQuery("SELECT SUM(p.soTien) FROM PhieuNopPhat p WHERE extract(month from p.ngayNopPhat)=:e");
        query3.setParameter("e", thang);
        try {
            phat = (long) query3.getSingleResult();
        } catch (Exception e) {
        }
        
        List<Long> list = new ArrayList<>();
        list.add(onl);
        list.add(off);
        list.add(phat);
        return list;
     }
}
