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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author XinKaChu
 */
@Entity
@Table(name = "ct_phieumuahang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CtPhieumuahang.findAll", query = "SELECT c FROM CtPhieumuahang c"),
    @NamedQuery(name = "CtPhieumuahang.findByMaCTPhieuMuaHang", query = "SELECT c FROM CtPhieumuahang c WHERE c.maCTPhieuMuaHang = :maCTPhieuMuaHang"),
    @NamedQuery(name = "CtPhieumuahang.findByMaPhieuMuaHang", query = "SELECT c FROM CtPhieumuahang c WHERE c.maPhieuMuaHang = :maPhieuMuaHang"),
    @NamedQuery(name = "CtPhieumuahang.findByMaNguoiBan", query = "SELECT c FROM CtPhieumuahang c WHERE c.maNguoiBan = :maNguoiBan"),
    @NamedQuery(name = "CtPhieumuahang.findByMaSP", query = "SELECT c FROM CtPhieumuahang c WHERE c.maSP = :maSP"),
    @NamedQuery(name = "CtPhieumuahang.findBySoLuong", query = "SELECT c FROM CtPhieumuahang c WHERE c.soLuong = :soLuong"),
    @NamedQuery(name = "CtPhieumuahang.findByDonGia", query = "SELECT c FROM CtPhieumuahang c WHERE c.donGia = :donGia"),
    @NamedQuery(name = "CtPhieumuahang.findByThanhTien", query = "SELECT c FROM CtPhieumuahang c WHERE c.thanhTien = :thanhTien"),
    @NamedQuery(name = "CtPhieumuahang.findByMaTinhTrang", query = "SELECT c FROM CtPhieumuahang c WHERE c.maTinhTrang = :maTinhTrang")})
public class CtPhieumuahang implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaCT_PhieuMuaHang")
    private Integer maCTPhieuMuaHang;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MaPhieuMuaHang")
    private int maPhieuMuaHang;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MaNguoiBan")
    private int maNguoiBan;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MaSP")
    private int maSP;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SoLuong")
    private int soLuong;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DonGia")
    private float donGia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ThanhTien")
    private float thanhTien;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "MaTinhTrang")
    private String maTinhTrang;

    public CtPhieumuahang() {
    }

    public CtPhieumuahang(Integer maCTPhieuMuaHang) {
        this.maCTPhieuMuaHang = maCTPhieuMuaHang;
    }

    public CtPhieumuahang(Integer maCTPhieuMuaHang, int maPhieuMuaHang, int maNguoiBan, int maSP, int soLuong, float donGia, float thanhTien, String maTinhTrang) {
        this.maCTPhieuMuaHang = maCTPhieuMuaHang;
        this.maPhieuMuaHang = maPhieuMuaHang;
        this.maNguoiBan = maNguoiBan;
        this.maSP = maSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
        this.maTinhTrang = maTinhTrang;
    }

    public Integer getMaCTPhieuMuaHang() {
        return maCTPhieuMuaHang;
    }

    public void setMaCTPhieuMuaHang(Integer maCTPhieuMuaHang) {
        this.maCTPhieuMuaHang = maCTPhieuMuaHang;
    }

    public int getMaPhieuMuaHang() {
        return maPhieuMuaHang;
    }

    public void setMaPhieuMuaHang(int maPhieuMuaHang) {
        this.maPhieuMuaHang = maPhieuMuaHang;
    }

    public int getMaNguoiBan() {
        return maNguoiBan;
    }

    public void setMaNguoiBan(int maNguoiBan) {
        this.maNguoiBan = maNguoiBan;
    }

    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    public float getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(float thanhTien) {
        this.thanhTien = thanhTien;
    }

    public String getMaTinhTrang() {
        return maTinhTrang;
    }

    public void setMaTinhTrang(String maTinhTrang) {
        this.maTinhTrang = maTinhTrang;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maCTPhieuMuaHang != null ? maCTPhieuMuaHang.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CtPhieumuahang)) {
            return false;
        }
        CtPhieumuahang other = (CtPhieumuahang) object;
        if ((this.maCTPhieuMuaHang == null && other.maCTPhieuMuaHang != null) || (this.maCTPhieuMuaHang != null && !this.maCTPhieuMuaHang.equals(other.maCTPhieuMuaHang))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.entities.CtPhieumuahang[ maCTPhieuMuaHang=" + maCTPhieuMuaHang + " ]";
    }
    
}
