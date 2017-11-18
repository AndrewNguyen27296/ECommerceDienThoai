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
    //TRUE: đã trùng
    //FALSE: chưa trùng
    public boolean kiemTraTonTaiEmail(String email) {
        Query query = em.createQuery("SELECT n FROM NguoiMua n WHERE n.email=:e");
        query.setParameter("e", email);
        try {
            query.getSingleResult();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    //Kiểm tra xem sđt, email đăng ký đã tồn tại trong CSDL chưa
    //TRUE: đã trùng
    //FALSE: chưa trùng
    public boolean kiemTraTonTaiSDT(String sdt) {
        Query query = em.createQuery("SELECT n FROM NguoiMua n WHERE n.soDienThoai=:sdt");
        query.setParameter("sdt", sdt);
        try {
            query.getSingleResult();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    //RETURN TRUE : đúng email và mật khẩu
    //RETURN FALSE : sai
    public boolean kiemTraPassword(String email, String password) {
        Query query = em.createQuery("SELECT n FROM NguoiMua n WHERE n.email=:e AND n.matKhau=:password");
        query.setParameter("e", email);
        query.setParameter("password", password);
        try {
            query.getSingleResult();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public NguoiMua layNguoiMuaTheoEmail(String email) {
        NguoiMua customer = new NguoiMua();
        Query query = em.createQuery("SELECT n FROM NguoiMua n WHERE n.email=:e");
        query.setParameter("e", email);
        try {
            customer = (NguoiMua) query.getSingleResult();
        } catch (Exception e) {
            
        }
        return customer;
    }
}
