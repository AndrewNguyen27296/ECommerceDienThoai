/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.business;

import ejb.entities.SanPham;
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
public class SanPhamBusiness {

    @PersistenceContext(unitName = "ECommerceDienThoai-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public List<SanPham> laySanPhamMoiNhat() {
        String hql = "SELECT s FROM SanPham s ORDER BY s.id DESC";
        Query query = em.createQuery(hql);
        List<SanPham> list = query.getResultList();
        return list;
    }

    public SanPham laySanPham(int id) {
        Query query = em.createQuery("SELECT s FROM SanPham s WHERE s.id=:id");
        query.setParameter("id", id);
        return (SanPham) query.getSingleResult();
    }

    public int getSoLuongTonTheoMaSanPham(int id) {
        Query query = em.createQuery("SELECT s.soLuong FROM SanPham s WHERE s.id=:id");
        query.setParameter("id", id);
        return (int) query.getSingleResult();
    }

    public void capNhatSoLuongSP(int id, int soluong) {
        Query query = em.createQuery("UPDATE SanPham s SET s.soLuong=s.soLuong - :s WHERE s.id=:id");
        query.setParameter("id", id);
        query.setParameter("s", soluong);
        query.executeUpdate();
    }

    public List<SanPham> search(String keywords) {
        Query qr = em.createQuery("SELECT sp FROM SanPham sp WHERE sp.tenMay LIKE :kw");
        qr.setParameter("kw", "%" + keywords + "%");
        return qr.getResultList();
    }
}
