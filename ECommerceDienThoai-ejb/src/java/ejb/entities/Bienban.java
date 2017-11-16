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
@Table(name = "bienban")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bienban.findAll", query = "SELECT b FROM Bienban b"),
    @NamedQuery(name = "Bienban.findByMaBienBan", query = "SELECT b FROM Bienban b WHERE b.maBienBan = :maBienBan"),
    @NamedQuery(name = "Bienban.findByMaNguoiBan", query = "SELECT b FROM Bienban b WHERE b.maNguoiBan = :maNguoiBan"),
    @NamedQuery(name = "Bienban.findByNgay", query = "SELECT b FROM Bienban b WHERE b.ngay = :ngay"),
    @NamedQuery(name = "Bienban.findByLyDo", query = "SELECT b FROM Bienban b WHERE b.lyDo = :lyDo")})
public class Bienban implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaBienBan")
    private Integer maBienBan;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MaNguoiBan")
    private int maNguoiBan;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Ngay")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngay;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "LyDo")
    private String lyDo;

    public Bienban() {
    }

    public Bienban(Integer maBienBan) {
        this.maBienBan = maBienBan;
    }

    public Bienban(Integer maBienBan, int maNguoiBan, Date ngay, String lyDo) {
        this.maBienBan = maBienBan;
        this.maNguoiBan = maNguoiBan;
        this.ngay = ngay;
        this.lyDo = lyDo;
    }

    public Integer getMaBienBan() {
        return maBienBan;
    }

    public void setMaBienBan(Integer maBienBan) {
        this.maBienBan = maBienBan;
    }

    public int getMaNguoiBan() {
        return maNguoiBan;
    }

    public void setMaNguoiBan(int maNguoiBan) {
        this.maNguoiBan = maNguoiBan;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maBienBan != null ? maBienBan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bienban)) {
            return false;
        }
        Bienban other = (Bienban) object;
        if ((this.maBienBan == null && other.maBienBan != null) || (this.maBienBan != null && !this.maBienBan.equals(other.maBienBan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.entities.Bienban[ maBienBan=" + maBienBan + " ]";
    }
    
}
