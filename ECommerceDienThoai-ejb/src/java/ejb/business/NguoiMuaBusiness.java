/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.business;

import ejb.entities.NguoiMua;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author DacTien
 */
@Stateless
@LocalBean
public class NguoiMuaBusiness {

    @PersistenceContext(unitName = "ECommerceDienThoai-ejbPU")
    private EntityManager em;
    
    //Kiểm tra xem sđt, email đăng ký đã tồn tại trong CSDL chưa
    //TRUE: chưa trùng
    //FALSE: đã trùng
    public boolean kiemTraTonTaiEmail(String email) {
        //String hql = "SELECT FROM NguoiMua WHERE email=:e";
      
        Query query = em.createQuery("SELECT n FROM NguoiMua n WHERE n.email = '" +email+"'");
//        query.setParameter("email", email);
        if(query.getSingleResult()==null){
            return true;
        }
        return false;
//        try {
//            em.createQuery(hql).setParameter("e", email).getSingleResult();
//            return false;
//        } catch (Exception e) {
//            return true;
//        }
    }
    
    //Kiểm tra xem sđt, email đăng ký đã tồn tại trong CSDL chưa
    //TRUE: chưa trùng
    //FALSE: đã trùng
    public boolean kiemTraTonTaiSDT(String sdt) {
        String hql = "FROM NguoiMua WHERE soDienThoai=:sdt";
        Query query = em.createQuery(hql);
        query.setParameter("sdt", sdt);
        NguoiMua customer = (NguoiMua) query.getSingleResult();
        if (customer == null) {
            return true;
        }
        return false;
    }

    public void persist(Object object) {
        em.persist(object);
    }

    public void persist1(Object object) {
        em.persist(object);
    }
    
}
