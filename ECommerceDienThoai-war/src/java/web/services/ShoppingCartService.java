/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.services;

import ejb.entities.NguoiBan;
import ejb.entities.SanPham;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 *
 * @author DacTien
 */
@Component("cart")
// de ShoppingCart nay trong session: cho tung khach hang
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ShoppingCartService implements Serializable {

    @Autowired
    SanPhamService sanPhamService;
    Map<Integer, SanPham> map = new HashMap<Integer, SanPham>();

    /**
     * Them san pham vao gio hang
     *
     * @param id chua san pham duoc click
     */
    public void add(Integer id) {
        SanPham sanpham = map.get(id);
        // da co trong gio hang
        if (sanpham != null) {
            sanpham.setSoLuong(sanpham.getSoLuong() + 1);
        } // chua co trong gio hang
        else {
            sanpham = sanPhamService.sanPhamFacade.find(id);
            sanpham.setSoLuong(1);
            map.put(id, sanpham);
        }
    }

    /**
     * xoa san pham khoi gio hang
     *
     * @param id chua ma hang can xoa
     */
    public void remove(Integer id) {
        map.remove(id);
    }

    /**
     * lay tap hop cac mat hang trong gio
     *
     * @return tap mat hang
     */
    public Collection<SanPham> getItems() {
        return map.values();
    }

    /**
     * lay tong so luong san pham trong gio hang
     *
     * @return tong so luong
     */
    public int getCount() {
        int total = 0;
        for (SanPham p : getItems()) {
            total += p.getSoLuong();
        }
        return total;
    }

    /**
     * lay tong tien trong gio hang
     *
     * @return tong tien
     */
    public int getAmount() {
        int total = 0;
        for (SanPham p : getItems()) {
            total += p.getSoLuong() * p.getGiaBan();
        }
        return total;
    }

    /**
     * lay số lượng tồn của sp theo mã sphẩm
     *
     * @return số lượng tồn
     */
    public int getSoLuongTonTheoMaSanPham(int id) {
        return sanPhamService.getSoLuongTonTheoMaSanPham(id);
    }

    /**
     * cap nhat so luong cua mot san pham bat ki trong gio hang
     *
     * @param id : ma sp can cap nhat
     * @param newQuantity : so luong cap nhat moi
     */
    public void update(Integer ma, Integer newSoLuong) {
        SanPham sanpham = map.get(ma);
        sanpham.setSoLuong(newSoLuong);
    }

    public SanPham getItem(Integer ma) {
        return map.get(ma);
    }
    
    public Collection<NguoiBan> getNguoiBans() {
        Map<Integer, NguoiBan> listNguoiBan = new HashMap<Integer, NguoiBan>();
        for (SanPham sp : getItems()) {
            listNguoiBan.put(sp.getIdNguoiBan().getId(), sp.getIdNguoiBan());
        }
        return listNguoiBan.values();
    }
}
