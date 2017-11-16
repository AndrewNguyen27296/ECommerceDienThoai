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
@Table(name = "phieumuatin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Phieumuatin.findAll", query = "SELECT p FROM Phieumuatin p"),
    @NamedQuery(name = "Phieumuatin.findByMaPhieuMuaTin", query = "SELECT p FROM Phieumuatin p WHERE p.maPhieuMuaTin = :maPhieuMuaTin"),
    @NamedQuery(name = "Phieumuatin.findByMaNguoiBan", query = "SELECT p FROM Phieumuatin p WHERE p.maNguoiBan = :maNguoiBan"),
    @NamedQuery(name = "Phieumuatin.findByMaGoi", query = "SELECT p FROM Phieumuatin p WHERE p.maGoi = :maGoi"),
    @NamedQuery(name = "Phieumuatin.findByGiaBan", query = "SELECT p FROM Phieumuatin p WHERE p.giaBan = :giaBan"),
    @NamedQuery(name = "Phieumuatin.findByNgayGiaoDich", query = "SELECT p FROM Phieumuatin p WHERE p.ngayGiaoDich = :ngayGiaoDich"),
    @NamedQuery(name = "Phieumuatin.findByPhuongThucThanhToan", query = "SELECT p FROM Phieumuatin p WHERE p.phuongThucThanhToan = :phuongThucThanhToan"),
    @NamedQuery(name = "Phieumuatin.findByTrangThai", query = "SELECT p FROM Phieumuatin p WHERE p.trangThai = :trangThai")})
public class Phieumuatin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaPhieuMuaTin")
    private Integer maPhieuMuaTin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MaNguoiBan")
    private int maNguoiBan;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "MaGoi")
    private String maGoi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GiaBan")
    private float giaBan;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NgayGiaoDich")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayGiaoDich;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PhuongThucThanhToan")
    private int phuongThucThanhToan;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TrangThai")
    private boolean trangThai;

    public Phieumuatin() {
    }

    public Phieumuatin(Integer maPhieuMuaTin) {
        this.maPhieuMuaTin = maPhieuMuaTin;
    }

    public Phieumuatin(Integer maPhieuMuaTin, int maNguoiBan, String maGoi, float giaBan, Date ngayGiaoDich, int phuongThucThanhToan, boolean trangThai) {
        this.maPhieuMuaTin = maPhieuMuaTin;
        this.maNguoiBan = maNguoiBan;
        this.maGoi = maGoi;
        this.giaBan = giaBan;
        this.ngayGiaoDich = ngayGiaoDich;
        this.phuongThucThanhToan = phuongThucThanhToan;
        this.trangThai = trangThai;
    }

    public Integer getMaPhieuMuaTin() {
        return maPhieuMuaTin;
    }

    public void setMaPhieuMuaTin(Integer maPhieuMuaTin) {
        this.maPhieuMuaTin = maPhieuMuaTin;
    }

    public int getMaNguoiBan() {
        return maNguoiBan;
    }

    public void setMaNguoiBan(int maNguoiBan) {
        this.maNguoiBan = maNguoiBan;
    }

    public String getMaGoi() {
        return maGoi;
    }

    public void setMaGoi(String maGoi) {
        this.maGoi = maGoi;
    }

    public float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(float giaBan) {
        this.giaBan = giaBan;
    }

    public Date getNgayGiaoDich() {
        return ngayGiaoDich;
    }

    public void setNgayGiaoDich(Date ngayGiaoDich) {
        this.ngayGiaoDich = ngayGiaoDich;
    }

    public int getPhuongThucThanhToan() {
        return phuongThucThanhToan;
    }

    public void setPhuongThucThanhToan(int phuongThucThanhToan) {
        this.phuongThucThanhToan = phuongThucThanhToan;
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
        hash += (maPhieuMuaTin != null ? maPhieuMuaTin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Phieumuatin)) {
            return false;
        }
        Phieumuatin other = (Phieumuatin) object;
        if ((this.maPhieuMuaTin == null && other.maPhieuMuaTin != null) || (this.maPhieuMuaTin != null && !this.maPhieuMuaTin.equals(other.maPhieuMuaTin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.entities.Phieumuatin[ maPhieuMuaTin=" + maPhieuMuaTin + " ]";
    }
    
}
