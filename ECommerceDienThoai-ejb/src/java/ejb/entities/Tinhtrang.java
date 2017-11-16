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
@Table(name = "tinhtrang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tinhtrang.findAll", query = "SELECT t FROM Tinhtrang t"),
    @NamedQuery(name = "Tinhtrang.findByMaTinhTrang", query = "SELECT t FROM Tinhtrang t WHERE t.maTinhTrang = :maTinhTrang"),
    @NamedQuery(name = "Tinhtrang.findByTenMoTa", query = "SELECT t FROM Tinhtrang t WHERE t.tenMoTa = :tenMoTa")})
public class Tinhtrang implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaTinhTrang")
    private Integer maTinhTrang;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "TenMoTa")
    private String tenMoTa;

    public Tinhtrang() {
    }

    public Tinhtrang(Integer maTinhTrang) {
        this.maTinhTrang = maTinhTrang;
    }

    public Tinhtrang(Integer maTinhTrang, String tenMoTa) {
        this.maTinhTrang = maTinhTrang;
        this.tenMoTa = tenMoTa;
    }

    public Integer getMaTinhTrang() {
        return maTinhTrang;
    }

    public void setMaTinhTrang(Integer maTinhTrang) {
        this.maTinhTrang = maTinhTrang;
    }

    public String getTenMoTa() {
        return tenMoTa;
    }

    public void setTenMoTa(String tenMoTa) {
        this.tenMoTa = tenMoTa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maTinhTrang != null ? maTinhTrang.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tinhtrang)) {
            return false;
        }
        Tinhtrang other = (Tinhtrang) object;
        if ((this.maTinhTrang == null && other.maTinhTrang != null) || (this.maTinhTrang != null && !this.maTinhTrang.equals(other.maTinhTrang))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.entities.Tinhtrang[ maTinhTrang=" + maTinhTrang + " ]";
    }
    
}
