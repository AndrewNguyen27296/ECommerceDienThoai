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
 * @author HOME
 */
@Entity
@Table(name = "phieu_mua_tin_offline")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PhieuMuaTinOffline.findAll", query = "SELECT p FROM PhieuMuaTinOffline p")
    , @NamedQuery(name = "PhieuMuaTinOffline.findById", query = "SELECT p FROM PhieuMuaTinOffline p WHERE p.id = :id")
    , @NamedQuery(name = "PhieuMuaTinOffline.findByGiaBan", query = "SELECT p FROM PhieuMuaTinOffline p WHERE p.giaBan = :giaBan")
    , @NamedQuery(name = "PhieuMuaTinOffline.findByNgayMua", query = "SELECT p FROM PhieuMuaTinOffline p WHERE p.ngayMua = :ngayMua")})
public class PhieuMuaTinOffline implements Serializable {

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
    @JoinColumn(name = "id_admin", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Admin idAdmin;
    @JoinColumn(name = "id_goi_tin", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GoiTin idGoiTin;
    @JoinColumn(name = "id_nguoi_ban", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private NguoiBan idNguoiBan;

    public PhieuMuaTinOffline() {
    }

    public PhieuMuaTinOffline(Integer id) {
        this.id = id;
    }

    public PhieuMuaTinOffline(Integer id, long giaBan, Date ngayMua) {
        this.id = id;
        this.giaBan = giaBan;
        this.ngayMua = ngayMua;
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

    public Admin getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Admin idAdmin) {
        this.idAdmin = idAdmin;
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
        if (!(object instanceof PhieuMuaTinOffline)) {
            return false;
        }
        PhieuMuaTinOffline other = (PhieuMuaTinOffline) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.entities.PhieuMuaTinOffline[ id=" + id + " ]";
    }
    
}
