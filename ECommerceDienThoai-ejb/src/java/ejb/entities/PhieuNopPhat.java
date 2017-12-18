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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author myly
 */
@Entity
@Table(name = "phieu_nop_phat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PhieuNopPhat.findAll", query = "SELECT p FROM PhieuNopPhat p")
    , @NamedQuery(name = "PhieuNopPhat.findById", query = "SELECT p FROM PhieuNopPhat p WHERE p.id = :id")
    , @NamedQuery(name = "PhieuNopPhat.findByNgayNopPhat", query = "SELECT p FROM PhieuNopPhat p WHERE p.ngayNopPhat = :ngayNopPhat")
    , @NamedQuery(name = "PhieuNopPhat.findBySoTien", query = "SELECT p FROM PhieuNopPhat p WHERE p.soTien = :soTien")})
public class PhieuNopPhat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ngay_nop_phat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayNopPhat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "so_tien")
    private long soTien;
    @JoinColumn(name = "id_admin", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Admin idAdmin;
    @JoinColumn(name = "id_nguoi_ban", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private NguoiBan idNguoiBan;

    public PhieuNopPhat() {
    }

    public PhieuNopPhat(Integer id) {
        this.id = id;
    }

    public PhieuNopPhat(Integer id, Date ngayNopPhat, long soTien) {
        this.id = id;
        this.ngayNopPhat = ngayNopPhat;
        this.soTien = soTien;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getNgayNopPhat() {
        return ngayNopPhat;
    }

    public void setNgayNopPhat(Date ngayNopPhat) {
        this.ngayNopPhat = ngayNopPhat;
    }

    public long getSoTien() {
        return soTien;
    }

    public void setSoTien(long soTien) {
        this.soTien = soTien;
    }

    public Admin getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Admin idAdmin) {
        this.idAdmin = idAdmin;
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
        if (!(object instanceof PhieuNopPhat)) {
            return false;
        }
        PhieuNopPhat other = (PhieuNopPhat) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.entities.PhieuNopPhat[ id=" + id + " ]";
    }
    
}
