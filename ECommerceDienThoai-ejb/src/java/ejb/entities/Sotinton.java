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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author XinKaChu
 */
@Entity
@Table(name = "sotinton")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sotinton.findAll", query = "SELECT s FROM Sotinton s"),
    @NamedQuery(name = "Sotinton.findByMaTinTon", query = "SELECT s FROM Sotinton s WHERE s.maTinTon = :maTinTon"),
    @NamedQuery(name = "Sotinton.findByMaNguoiBan", query = "SELECT s FROM Sotinton s WHERE s.maNguoiBan = :maNguoiBan"),
    @NamedQuery(name = "Sotinton.findBySoTinTon", query = "SELECT s FROM Sotinton s WHERE s.soTinTon = :soTinTon"),
    @NamedQuery(name = "Sotinton.findBySoTinDaDung", query = "SELECT s FROM Sotinton s WHERE s.soTinDaDung = :soTinDaDung"),
    @NamedQuery(name = "Sotinton.findByNgayCapNhat", query = "SELECT s FROM Sotinton s WHERE s.ngayCapNhat = :ngayCapNhat")})
public class Sotinton implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaTinTon")
    private Integer maTinTon;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MaNguoiBan")
    private int maNguoiBan;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SoTinTon")
    private int soTinTon;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SoTinDaDung")
    private int soTinDaDung;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NgayCapNhat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayCapNhat;

    public Sotinton() {
    }

    public Sotinton(Integer maTinTon) {
        this.maTinTon = maTinTon;
    }

    public Sotinton(Integer maTinTon, int maNguoiBan, int soTinTon, int soTinDaDung, Date ngayCapNhat) {
        this.maTinTon = maTinTon;
        this.maNguoiBan = maNguoiBan;
        this.soTinTon = soTinTon;
        this.soTinDaDung = soTinDaDung;
        this.ngayCapNhat = ngayCapNhat;
    }

    public Integer getMaTinTon() {
        return maTinTon;
    }

    public void setMaTinTon(Integer maTinTon) {
        this.maTinTon = maTinTon;
    }

    public int getMaNguoiBan() {
        return maNguoiBan;
    }

    public void setMaNguoiBan(int maNguoiBan) {
        this.maNguoiBan = maNguoiBan;
    }

    public int getSoTinTon() {
        return soTinTon;
    }

    public void setSoTinTon(int soTinTon) {
        this.soTinTon = soTinTon;
    }

    public int getSoTinDaDung() {
        return soTinDaDung;
    }

    public void setSoTinDaDung(int soTinDaDung) {
        this.soTinDaDung = soTinDaDung;
    }

    public Date getNgayCapNhat() {
        return ngayCapNhat;
    }

    public void setNgayCapNhat(Date ngayCapNhat) {
        this.ngayCapNhat = ngayCapNhat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maTinTon != null ? maTinTon.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sotinton)) {
            return false;
        }
        Sotinton other = (Sotinton) object;
        if ((this.maTinTon == null && other.maTinTon != null) || (this.maTinTon != null && !this.maTinTon.equals(other.maTinTon))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.entities.Sotinton[ maTinTon=" + maTinTon + " ]";
    }
    
}
