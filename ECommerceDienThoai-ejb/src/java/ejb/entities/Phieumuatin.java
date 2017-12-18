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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author HOME
 */
@Entity
@Table(name = "phieu_mua_tin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PhieuMuaTin.findAll", query = "SELECT p FROM PhieuMuaTin p")
    , @NamedQuery(name = "PhieuMuaTin.findById", query = "SELECT p FROM PhieuMuaTin p WHERE p.id = :id")
    , @NamedQuery(name = "PhieuMuaTin.findByGiaBan", query = "SELECT p FROM PhieuMuaTin p WHERE p.giaBan = :giaBan")
    , @NamedQuery(name = "PhieuMuaTin.findByNgayMua", query = "SELECT p FROM PhieuMuaTin p WHERE p.ngayMua = :ngayMua")
    , @NamedQuery(name = "PhieuMuaTin.findByPhuongThucThanhToan", query = "SELECT p FROM PhieuMuaTin p WHERE p.phuongThucThanhToan = :phuongThucThanhToan")
    , @NamedQuery(name = "PhieuMuaTin.findByTrangThai", query = "SELECT p FROM PhieuMuaTin p WHERE p.trangThai = :trangThai")
    , @NamedQuery(name = "PhieuMuaTin.findByPaymentId", query = "SELECT p FROM PhieuMuaTin p WHERE p.paymentId = :paymentId")
    , @NamedQuery(name = "PhieuMuaTin.findByPayerId", query = "SELECT p FROM PhieuMuaTin p WHERE p.payerId = :payerId")})
public class PhieuMuaTin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gia_ban")
    private long giaBan;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ngay_mua")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayMua;
    @Basic(optional = false)
    @NotNull
    @Column(name = "phuong_thuc_thanh_toan")
    private int phuongThucThanhToan;
    @Basic(optional = false)
    @NotNull
    @Column(name = "trang_thai")
    private boolean trangThai;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "payment_id")
    private String paymentId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "payer_id")
    private String payerId;
    @JoinColumn(name = "id_goi_tin", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GoiTin idGoiTin;
    @JoinColumn(name = "id_nguoi_ban", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private NguoiBan idNguoiBan;

    public PhieuMuaTin() {
    }

    public PhieuMuaTin(Integer id) {
        this.id = id;
    }

    public PhieuMuaTin(Integer id, long giaBan, Date ngayMua, int phuongThucThanhToan, boolean trangThai, String paymentId, String payerId) {
        this.id = id;
        this.giaBan = giaBan;
        this.ngayMua = ngayMua;
        this.phuongThucThanhToan = phuongThucThanhToan;
        this.trangThai = trangThai;
        this.paymentId = paymentId;
        this.payerId = payerId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(long giaBan) {
        this.giaBan = giaBan;
    }

    public Date getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(Date ngayMua) {
        this.ngayMua = ngayMua;
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

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getPayerId() {
        return payerId;
    }

    public void setPayerId(String payerId) {
        this.payerId = payerId;
    }

    public GoiTin getIdGoiTin() {
        return idGoiTin;
    }

    public void setIdGoiTin(GoiTin idGoiTin) {
        this.idGoiTin = idGoiTin;
    }

    public NguoiBan getIdNguoiBan() {
        return idNguoiBan;
    }

    public void setIdNguoiBan(NguoiBan idNguoiBan) {
        this.idNguoiBan = idNguoiBan;
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
        if (!(object instanceof PhieuMuaTin)) {
            return false;
        }
        PhieuMuaTin other = (PhieuMuaTin) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.entities.PhieuMuaTin[ id=" + id + " ]";
    }
    
}
