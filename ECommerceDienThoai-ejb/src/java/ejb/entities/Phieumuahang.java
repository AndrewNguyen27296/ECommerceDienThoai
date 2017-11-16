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
@Table(name = "phieumuahang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Phieumuahang.findAll", query = "SELECT p FROM Phieumuahang p"),
    @NamedQuery(name = "Phieumuahang.findByMaPhieuMuaHang", query = "SELECT p FROM Phieumuahang p WHERE p.maPhieuMuaHang = :maPhieuMuaHang"),
    @NamedQuery(name = "Phieumuahang.findByMaNguoiMua", query = "SELECT p FROM Phieumuahang p WHERE p.maNguoiMua = :maNguoiMua"),
    @NamedQuery(name = "Phieumuahang.findByEmailNguoiMua", query = "SELECT p FROM Phieumuahang p WHERE p.emailNguoiMua = :emailNguoiMua"),
    @NamedQuery(name = "Phieumuahang.findBySoDT", query = "SELECT p FROM Phieumuahang p WHERE p.soDT = :soDT"),
    @NamedQuery(name = "Phieumuahang.findByTenNguoiNhan", query = "SELECT p FROM Phieumuahang p WHERE p.tenNguoiNhan = :tenNguoiNhan"),
    @NamedQuery(name = "Phieumuahang.findByDiaChiGiao", query = "SELECT p FROM Phieumuahang p WHERE p.diaChiGiao = :diaChiGiao"),
    @NamedQuery(name = "Phieumuahang.findByMaQuanHuyen", query = "SELECT p FROM Phieumuahang p WHERE p.maQuanHuyen = :maQuanHuyen"),
    @NamedQuery(name = "Phieumuahang.findByMaKhuVuc", query = "SELECT p FROM Phieumuahang p WHERE p.maKhuVuc = :maKhuVuc"),
    @NamedQuery(name = "Phieumuahang.findByGhiChu", query = "SELECT p FROM Phieumuahang p WHERE p.ghiChu = :ghiChu"),
    @NamedQuery(name = "Phieumuahang.findByNgayDatHang", query = "SELECT p FROM Phieumuahang p WHERE p.ngayDatHang = :ngayDatHang"),
    @NamedQuery(name = "Phieumuahang.findByNgayGiaoHang", query = "SELECT p FROM Phieumuahang p WHERE p.ngayGiaoHang = :ngayGiaoHang"),
    @NamedQuery(name = "Phieumuahang.findByTrangThai", query = "SELECT p FROM Phieumuahang p WHERE p.trangThai = :trangThai")})
public class Phieumuahang implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaPhieuMuaHang")
    private Integer maPhieuMuaHang;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MaNguoiMua")
    private int maNguoiMua;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "EmailNguoiMua")
    private String emailNguoiMua;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SoDT")
    private int soDT;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "TenNguoiNhan")
    private String tenNguoiNhan;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "DiaChiGiao")
    private String diaChiGiao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MaQuanHuyen")
    private int maQuanHuyen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MaKhuVuc")
    private int maKhuVuc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "GhiChu")
    private String ghiChu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NgayDatHang")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayDatHang;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NgayGiaoHang")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayGiaoHang;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TrangThai")
    private boolean trangThai;

    public Phieumuahang() {
    }

    public Phieumuahang(Integer maPhieuMuaHang) {
        this.maPhieuMuaHang = maPhieuMuaHang;
    }

    public Phieumuahang(Integer maPhieuMuaHang, int maNguoiMua, String emailNguoiMua, int soDT, String tenNguoiNhan, String diaChiGiao, int maQuanHuyen, int maKhuVuc, String ghiChu, Date ngayDatHang, Date ngayGiaoHang, boolean trangThai) {
        this.maPhieuMuaHang = maPhieuMuaHang;
        this.maNguoiMua = maNguoiMua;
        this.emailNguoiMua = emailNguoiMua;
        this.soDT = soDT;
        this.tenNguoiNhan = tenNguoiNhan;
        this.diaChiGiao = diaChiGiao;
        this.maQuanHuyen = maQuanHuyen;
        this.maKhuVuc = maKhuVuc;
        this.ghiChu = ghiChu;
        this.ngayDatHang = ngayDatHang;
        this.ngayGiaoHang = ngayGiaoHang;
        this.trangThai = trangThai;
    }

    public Integer getMaPhieuMuaHang() {
        return maPhieuMuaHang;
    }

    public void setMaPhieuMuaHang(Integer maPhieuMuaHang) {
        this.maPhieuMuaHang = maPhieuMuaHang;
    }

    public int getMaNguoiMua() {
        return maNguoiMua;
    }

    public void setMaNguoiMua(int maNguoiMua) {
        this.maNguoiMua = maNguoiMua;
    }

    public String getEmailNguoiMua() {
        return emailNguoiMua;
    }

    public void setEmailNguoiMua(String emailNguoiMua) {
        this.emailNguoiMua = emailNguoiMua;
    }

    public int getSoDT() {
        return soDT;
    }

    public void setSoDT(int soDT) {
        this.soDT = soDT;
    }

    public String getTenNguoiNhan() {
        return tenNguoiNhan;
    }

    public void setTenNguoiNhan(String tenNguoiNhan) {
        this.tenNguoiNhan = tenNguoiNhan;
    }

    public String getDiaChiGiao() {
        return diaChiGiao;
    }

    public void setDiaChiGiao(String diaChiGiao) {
        this.diaChiGiao = diaChiGiao;
    }

    public int getMaQuanHuyen() {
        return maQuanHuyen;
    }

    public void setMaQuanHuyen(int maQuanHuyen) {
        this.maQuanHuyen = maQuanHuyen;
    }

    public int getMaKhuVuc() {
        return maKhuVuc;
    }

    public void setMaKhuVuc(int maKhuVuc) {
        this.maKhuVuc = maKhuVuc;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public Date getNgayDatHang() {
        return ngayDatHang;
    }

    public void setNgayDatHang(Date ngayDatHang) {
        this.ngayDatHang = ngayDatHang;
    }

    public Date getNgayGiaoHang() {
        return ngayGiaoHang;
    }

    public void setNgayGiaoHang(Date ngayGiaoHang) {
        this.ngayGiaoHang = ngayGiaoHang;
    }

    public boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maPhieuMuaHang != null ? maPhieuMuaHang.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Phieumuahang)) {
            return false;
        }
        Phieumuahang other = (Phieumuahang) object;
        if ((this.maPhieuMuaHang == null && other.maPhieuMuaHang != null) || (this.maPhieuMuaHang != null && !this.maPhieuMuaHang.equals(other.maPhieuMuaHang))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.entities.Phieumuahang[ maPhieuMuaHang=" + maPhieuMuaHang + " ]";
    }
    
}
