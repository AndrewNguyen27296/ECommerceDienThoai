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
public class ThongKeSanPhamMerchantBusiness {

    @PersistenceContext(unitName = "ECommerceDienThoai-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public List<Object[]> thongKeSanPham(Integer idNguoiBan) {
        Query query = em.createQuery("SELECT c.idSanPham.tenMay, SUM(c.thanhTien) FROM CtPhieuMuaHang c WHERE c.idNguoiBan.id=:e GROUP BY c.idSanPham.tenMay");
        query.setParameter("e", idNguoiBan);
        List<Object[]> list = query.getResultList();
        return list;
    }
}
