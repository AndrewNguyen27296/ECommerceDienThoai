/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.business;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import ejb.entities.CtPhieuMuaHang;
import ejb.entities.PhieuMuaHang;
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
public class CtPhieuMuaHangBusiness {

    @PersistenceContext(unitName = "ECommerceDienThoai-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    
    public List<CtPhieuMuaHang> layChiTietTheoMaPhieuMuaHang(Integer id) {
        //List<CtPhieuMuaHang> list = new VirtualFlow.ArrayLinkedList<>();
        Query query = em.createQuery("SELECT n FROM CtPhieuMuaHang n WHERE n.idPhieuMuaHang.id=:e");
        query.setParameter("e", id);
        //n.id, n.giaBan, n.idNguoiBan, n.idPhieuMuaHang, n.idSanPham, n.idTinhTrang, n.ngayGiaoHang, n.soLuongMua, n.thanhTien
        //list = (List<CtPhieuMuaHang>) query.getResultList();
        return query.getResultList();
    }
    
    /*
    * Lấy các CT_PMH đã hoàn thành nhưng chưa được đánh giá
    */
    public List<CtPhieuMuaHang> layChiTietDaHoanThanh(Integer id) {
        //List<CtPhieuMuaHang> list = new VirtualFlow.ArrayLinkedList<>();
        Query query = em.createQuery("SELECT DISTINCT ct FROM PhieuMuaHang pmh, CtPhieuMuaHang ct, NguoiMua n WHERE pmh.idNguoiMua.id=:e AND pmh.idNguoiMua.id=n.id AND pmh.id = ct.idPhieuMuaHang.id AND ct.idTinhTrang.id = 'TC' AND ct.danhGia = false OR pmh.idNguoiMua.id=:e AND pmh.idNguoiMua.id=n.id AND pmh.id = ct.idPhieuMuaHang.id AND ct.idTinhTrang.id = 'DH' AND ct.danhGia = false");
        query.setParameter("e", id);
        //n.id, n.giaBan, n.idNguoiBan, n.idPhieuMuaHang, n.idSanPham, n.idTinhTrang, n.ngayGiaoHang, n.soLuongMua, n.thanhTien
        //list = (List<CtPhieuMuaHang>) query.getResultList();
        return query.getResultList();
    }
    
    /*
    * Cập nhật CT_PMH đã được đánh giá và ko hiển thị lên cho ng dùng nữa
    */
    public void capNhatDaDanhGiaCT_PhieuMuaHang(Integer id) {
        Query query = em.createQuery("UPDATE CtPhieuMuaHang c SET c.danhGia=true WHERE c.id=:id");
        query.setParameter("id", id);
        try {
            query.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

}
