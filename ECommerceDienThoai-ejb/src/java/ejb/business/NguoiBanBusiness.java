/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.business;

import ejb.entities.NguoiBan;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author XinKaChu
 */

@Stateless
@LocalBean
public class NguoiBanBusiness {
    
    @PersistenceContext(unitName = "ECommerceDienThoai-ejbPU")
    private EntityManager em;
    
    /*Kiểm tra xem sđt, email đăng ký đã tồn tại trong CSDL chưa
    TRUE: đã trùng
    FALSE: chưa trùng
    */
    public boolean kiemTraTonTaiEmail(String email) {
        Query query = em.createQuery("SELECT n FROM NguoiBan n WHERE n.email=:e");
        query.setParameter("e", email);
        try {
            query.getSingleResult();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    /*Kiểm tra xem sđt, email đăng ký đã tồn tại trong CSDL chưa
    TRUE: đã trùng
    FALSE: chưa trùng
    */
    public boolean kiemTraTonTaiSDT(String sdt) {
        Query query = em.createQuery("SELECT n FROM NguoiBan n WHERE n.soDienThoai=:sdt");
        query.setParameter("sdt", sdt);
        try {
            query.getSingleResult();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    /*Kiểm tra xem cmnd đăng ký đã tồn tại trong CSDL chưa
    TRUE: đã trùng
    FALSE: chưa trùng
    */
    public boolean kiemTraTonTaiCMND(String cmnd) {
        Query query = em.createQuery("SELECT n FROM NguoiBan n WHERE n.cmnd=:cmnd");
        query.setParameter("cmnd", cmnd);
        try {
            query.getSingleResult();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    /*
    RETURN TRUE : đúng email và mật khẩu
    RETURN FALSE : sai
    */
    public boolean kiemTraPassword(String email, String password) {
        Query query = em.createQuery("SELECT n FROM NguoiBan n WHERE n.email=:e AND n.matKhau=:password");
        query.setParameter("e", email);
        query.setParameter("password", password);
        try {
            query.getSingleResult();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public NguoiBan layNguoiBanTheoEmail(String email) {
        NguoiBan merchant = new NguoiBan();
        Query query = em.createQuery("SELECT n FROM NguoiBan n WHERE n.email=:e");
        query.setParameter("e", email);
        try {
            merchant = (NguoiBan) query.getSingleResult();
        } catch (Exception e) {
            
        }
        return merchant;
    }
    
    public List<NguoiBan> timKiemNguoiMua(String cmnd) {
        List<NguoiBan> merchant = new ArrayList<NguoiBan>();
        Query query = em.createQuery("SELECT n FROM NguoiBan n WHERE n.cmnd=:cmnd");
        query.setParameter("cmnd", cmnd);
        try {
            merchant = query.getResultList();
        } catch (Exception e) {
            
        }
        return merchant;
    }
}
