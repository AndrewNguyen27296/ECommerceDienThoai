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
@Table(name = "mausac")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mausac.findAll", query = "SELECT m FROM Mausac m"),
    @NamedQuery(name = "Mausac.findByMaMau", query = "SELECT m FROM Mausac m WHERE m.maMau = :maMau"),
    @NamedQuery(name = "Mausac.findByMaSP", query = "SELECT m FROM Mausac m WHERE m.maSP = :maSP"),
    @NamedQuery(name = "Mausac.findByMau", query = "SELECT m FROM Mausac m WHERE m.mau = :mau")})
public class Mausac implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaMau")
    private Integer maMau;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MaSP")
    private int maSP;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "Mau")
    private String mau;

    public Mausac() {
    }

    public Mausac(Integer maMau) {
        this.maMau = maMau;
    }

    public Mausac(Integer maMau, int maSP, String mau) {
        this.maMau = maMau;
        this.maSP = maSP;
        this.mau = mau;
    }

    public Integer getMaMau() {
        return maMau;
    }

    public void setMaMau(Integer maMau) {
        this.maMau = maMau;
    }

    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public String getMau() {
        return mau;
    }

    public void setMau(String mau) {
        this.mau = mau;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maMau != null ? maMau.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mausac)) {
            return false;
        }
        Mausac other = (Mausac) object;
        if ((this.maMau == null && other.maMau != null) || (this.maMau != null && !this.maMau.equals(other.maMau))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.entities.Mausac[ maMau=" + maMau + " ]";
    }
    
}
