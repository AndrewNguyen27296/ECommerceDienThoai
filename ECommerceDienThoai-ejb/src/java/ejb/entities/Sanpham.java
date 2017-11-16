/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author XinKaChu
 */
@Entity
@Table(name = "sanpham")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sanpham.findAll", query = "SELECT s FROM Sanpham s"),
    @NamedQuery(name = "Sanpham.findByMaSP", query = "SELECT s FROM Sanpham s WHERE s.maSP = :maSP"),
    @NamedQuery(name = "Sanpham.findByMaHang", query = "SELECT s FROM Sanpham s WHERE s.maHang = :maHang"),
    @NamedQuery(name = "Sanpham.findByTenSP", query = "SELECT s FROM Sanpham s WHERE s.tenSP = :tenSP"),
    @NamedQuery(name = "Sanpham.findByGia", query = "SELECT s FROM Sanpham s WHERE s.gia = :gia"),
    @NamedQuery(name = "Sanpham.findByHinhAnh", query = "SELECT s FROM Sanpham s WHERE s.hinhAnh = :hinhAnh"),
    @NamedQuery(name = "Sanpham.findByCameraTruoc", query = "SELECT s FROM Sanpham s WHERE s.cameraTruoc = :cameraTruoc"),
    @NamedQuery(name = "Sanpham.findByCameraSau", query = "SELECT s FROM Sanpham s WHERE s.cameraSau = :cameraSau"),
    @NamedQuery(name = "Sanpham.findByPin", query = "SELECT s FROM Sanpham s WHERE s.pin = :pin"),
    @NamedQuery(name = "Sanpham.findByTrongLuong", query = "SELECT s FROM Sanpham s WHERE s.trongLuong = :trongLuong"),
    @NamedQuery(name = "Sanpham.findByTocDoCPU", query = "SELECT s FROM Sanpham s WHERE s.tocDoCPU = :tocDoCPU"),
    @NamedQuery(name = "Sanpham.findByTheNhoNgoai", query = "SELECT s FROM Sanpham s WHERE s.theNhoNgoai = :theNhoNgoai"),
    @NamedQuery(name = "Sanpham.findByNgayDang", query = "SELECT s FROM Sanpham s WHERE s.ngayDang = :ngayDang"),
    @NamedQuery(name = "Sanpham.findBySoLanXem", query = "SELECT s FROM Sanpham s WHERE s.soLanXem = :soLanXem"),
    @NamedQuery(name = "Sanpham.findBySoLanMua", query = "SELECT s FROM Sanpham s WHERE s.soLanMua = :soLanMua"),
    @NamedQuery(name = "Sanpham.findByAnHien", query = "SELECT s FROM Sanpham s WHERE s.anHien = :anHien"),
    @NamedQuery(name = "Sanpham.findByTrangThai", query = "SELECT s FROM Sanpham s WHERE s.trangThai = :trangThai"),
    @NamedQuery(name = "Sanpham.findBySoLuongTon", query = "SELECT s FROM Sanpham s WHERE s.soLuongTon = :soLuongTon")})
public class Sanpham implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaSP")
    private Integer maSP;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "MaHang")
    private String maHang;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TenSP")
    private int tenSP;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Gia")
    private float gia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "HinhAnh")
    private String hinhAnh;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CameraTruoc")
    private int cameraTruoc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CameraSau")
    private int cameraSau;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "Pin")
    private String pin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TrongLuong")
    private int trongLuong;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "TocDoCPU")
    private String tocDoCPU;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TheNhoNgoai")
    private boolean theNhoNgoai;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NgayDang")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayDang;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SoLanXem")
    private int soLanXem;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SoLanMua")
    private int soLanMua;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AnHien")
    private boolean anHien;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TrangThai")
    private boolean trangThai;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SoLuongTon")
    private int soLuongTon;

    public Sanpham() {
    }

    public Sanpham(Integer maSP) {
        this.maSP = maSP;
    }

    public Sanpham(Integer maSP, String maHang, int tenSP, float gia, String hinhAnh, int cameraTruoc, int cameraSau, String pin, int trongLuong, String tocDoCPU, boolean theNhoNgoai, Date ngayDang, int soLanXem, int soLanMua, boolean anHien, boolean trangThai, int soLuongTon) {
        this.maSP = maSP;
        this.maHang = maHang;
        this.tenSP = tenSP;
        this.gia = gia;
        this.hinhAnh = hinhAnh;
        this.cameraTruoc = cameraTruoc;
        this.cameraSau = cameraSau;
        this.pin = pin;
        this.trongLuong = trongLuong;
        this.tocDoCPU = tocDoCPU;
        this.theNhoNgoai = theNhoNgoai;
        this.ngayDang = ngayDang;
        this.soLanXem = soLanXem;
        this.soLanMua = soLanMua;
        this.anHien = anHien;
        this.trangThai = trangThai;
        this.soLuongTon = soLuongTon;
    }

    public Integer getMaSP() {
        return maSP;
    }

    public void setMaSP(Integer maSP) {
        this.maSP = maSP;
    }

    public String getMaHang() {
        return maHang;
    }

    public void setMaHang(String maHang) {
        this.maHang = maHang;
    }

    public int getTenSP() {
        return tenSP;
    }

    public void setTenSP(int tenSP) {
        this.tenSP = tenSP;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public int getCameraTruoc() {
        return cameraTruoc;
    }

    public void setCameraTruoc(int cameraTruoc) {
        this.cameraTruoc = cameraTruoc;
    }

    public int getCameraSau() {
        return cameraSau;
    }

    public void setCameraSau(int cameraSau) {
        this.cameraSau = cameraSau;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public int getTrongLuong() {
        return trongLuong;
    }

    public void setTrongLuong(int trongLuong) {
        this.trongLuong = trongLuong;
    }

    public String getTocDoCPU() {
        return tocDoCPU;
    }

    public void setTocDoCPU(String tocDoCPU) {
        this.tocDoCPU = tocDoCPU;
    }

    public boolean getTheNhoNgoai() {
        return theNhoNgoai;
    }

    public void setTheNhoNgoai(boolean theNhoNgoai) {
        this.theNhoNgoai = theNhoNgoai;
    }

    public Date getNgayDang() {
        return ngayDang;
    }

    public void setNgayDang(Date ngayDang) {
        this.ngayDang = ngayDang;
    }

    public int getSoLanXem() {
        return soLanXem;
    }

    public void setSoLanXem(int soLanXem) {
        this.soLanXem = soLanXem;
    }

    public int getSoLanMua() {
        return soLanMua;
    }

    public void setSoLanMua(int soLanMua) {
        this.soLanMua = soLanMua;
    }

    public boolean getAnHien() {
        return anHien;
    }

    public void setAnHien(boolean anHien) {
        this.anHien = anHien;
    }

    public boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maSP != null ? maSP.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sanpham)) {
            return false;
        }
        Sanpham other = (Sanpham) object;
        if ((this.maSP == null && other.maSP != null) || (this.maSP != null && !this.maSP.equals(other.maSP))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.entities.Sanpham[ maSP=" + maSP + " ]";
    }
    
}
