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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author XinKaChu
 */
@Entity
@Table(name = "danhgia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Danhgia.findAll", query = "SELECT d FROM Danhgia d"),
    @NamedQuery(name = "Danhgia.findByMaDanhGia", query = "SELECT d FROM Danhgia d WHERE d.maDanhGia = :maDanhGia"),
    @NamedQuery(name = "Danhgia.findByMaPhieuMuaHang", query = "SELECT d FROM Danhgia d WHERE d.maPhieuMuaHang = :maPhieuMuaHang"),
    @NamedQuery(name = "Danhgia.findByMaNguoiMua", query = "SELECT d FROM Danhgia d WHERE d.maNguoiMua = :maNguoiMua"),
    @NamedQuery(name = "Danhgia.findBySoDiem", query = "SELECT d FROM Danhgia d WHERE d.soDiem = :soDiem"),
    @NamedQuery(name = "Danhgia.findBySuDung", query = "SELECT d FROM Danhgia d WHERE d.suDung = :suDung")})
public class Danhgia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaDanhGia")
    private Integer maDanhGia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MaPhieuMuaHang")
    private int maPhieuMuaHang;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MaNguoiMua")
    private int maNguoiMua;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SoDiem")
    private int soDiem;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SuDung")
    private boolean suDung;

    public Danhgia() {
    }

    public Danhgia(Integer maDanhGia) {
        this.maDanhGia = maDanhGia;
    }

    public Danhgia(Integer maDanhGia, int maPhieuMuaHang, int maNguoiMua, int soDiem, boolean suDung) {
        this.maDanhGia = maDanhGia;
        this.maPhieuMuaHang = maPhieuMuaHang;
        this.maNguoiMua = maNguoiMua;
        this.soDiem = soDiem;
        this.suDung = suDung;
    }

    public Integer getMaDanhGia() {
        return maDanhGia;
    }

    public void setMaDanhGia(Integer maDanhGia) {
        this.maDanhGia = maDanhGia;
    }

    public int getMaPhieuMuaHang() {
        return maPhieuMuaHang;
    }

    public void setMaPhieuMuaHang(int maPhieuMuaHang) {
        this.maPhieuMuaHang = maPhieuMuaHang;
    }

    public int getMaNguoiMua() {
        return maNguoiMua;
    }

    public void setMaNguoiMua(int maNguoiMua) {
        this.maNguoiMua = maNguoiMua;
    }

    public int getSoDiem() {
        return soDiem;
    }

    public void setSoDiem(int soDiem) {
        this.soDiem = soDiem;
    }

    public boolean getSuDung() {
        return suDung;
    }

    public void setSuDung(boolean suDung) {
        this.suDung = suDung;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maDanhGia != null ? maDanhGia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Danhgia)) {
            return false;
        }
        Danhgia other = (Danhgia) object;
        if ((this.maDanhGia == null && other.maDanhGia != null) || (this.maDanhGia != null && !this.maDanhGia.equals(other.maDanhGia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.entities.Danhgia[ maDanhGia=" + maDanhGia + " ]";
    }
    
}
