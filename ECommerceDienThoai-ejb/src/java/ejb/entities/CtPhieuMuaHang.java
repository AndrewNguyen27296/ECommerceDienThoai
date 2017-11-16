/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DacTien
 */
@Entity
@Table(name = "ct_phieu_mua_hang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CtPhieuMuaHang.findAll", query = "SELECT c FROM CtPhieuMuaHang c")
    , @NamedQuery(name = "CtPhieuMuaHang.findById", query = "SELECT c FROM CtPhieuMuaHang c WHERE c.id = :id")
    , @NamedQuery(name = "CtPhieuMuaHang.findByGiaBan", query = "SELECT c FROM CtPhieuMuaHang c WHERE c.giaBan = :giaBan")
    , @NamedQuery(name = "CtPhieuMuaHang.findBySoLuongBan", query = "SELECT c FROM CtPhieuMuaHang c WHERE c.soLuongBan = :soLuongBan")})
public class CtPhieuMuaHang implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gia_ban")
    private float giaBan;
    @Basic(optional = false)
    @NotNull
    @Column(name = "so_luong_ban")
    private int soLuongBan;
    @JoinColumn(name = "id_nguoi_ban", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private NguoiBan idNguoiBan;
    @JoinColumn(name = "id_phieu_mua_hang", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PhieuMuaHang idPhieuMuaHang;
    @JoinColumn(name = "id_san_pham", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SanPham idSanPham;
    @JoinColumn(name = "id_tinh_trang", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TinhTrang idTinhTrang;

    public CtPhieuMuaHang() {
    }

    public CtPhieuMuaHang(Integer id) {
        this.id = id;
    }

    public CtPhieuMuaHang(Integer id, float giaBan, int soLuongBan) {
        this.id = id;
        this.giaBan = giaBan;
        this.soLuongBan = soLuongBan;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(float giaBan) {
        this.giaBan = giaBan;
    }

    public int getSoLuongBan() {
        return soLuongBan;
    }

    public void setSoLuongBan(int soLuongBan) {
        this.soLuongBan = soLuongBan;
    }

    public NguoiBan getIdNguoiBan() {
        return idNguoiBan;
    }

    public void setIdNguoiBan(NguoiBan idNguoiBan) {
        this.idNguoiBan = idNguoiBan;
    }

    public PhieuMuaHang getIdPhieuMuaHang() {
        return idPhieuMuaHang;
    }

    public void setIdPhieuMuaHang(PhieuMuaHang idPhieuMuaHang) {
        this.idPhieuMuaHang = idPhieuMuaHang;
    }

    public SanPham getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(SanPham idSanPham) {
        this.idSanPham = idSanPham;
    }

    public TinhTrang getIdTinhTrang() {
        return idTinhTrang;
    }

    public void setIdTinhTrang(TinhTrang idTinhTrang) {
        this.idTinhTrang = idTinhTrang;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CtPhieuMuaHang)) {
            return false;
        }
        CtPhieuMuaHang other = (CtPhieuMuaHang) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.entities.CtPhieuMuaHang[ id=" + id + " ]";
    }
    
}
