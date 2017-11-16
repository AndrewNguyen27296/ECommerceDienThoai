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
@Table(name = "hedieuhanh")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hedieuhanh.findAll", query = "SELECT h FROM Hedieuhanh h"),
    @NamedQuery(name = "Hedieuhanh.findByMaHDH", query = "SELECT h FROM Hedieuhanh h WHERE h.maHDH = :maHDH"),
    @NamedQuery(name = "Hedieuhanh.findByHeDieuHanh", query = "SELECT h FROM Hedieuhanh h WHERE h.heDieuHanh = :heDieuHanh")})
public class Hedieuhanh implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaHDH")
    private Integer maHDH;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "HeDieuHanh")
    private String heDieuHanh;

    public Hedieuhanh() {
    }

    public Hedieuhanh(Integer maHDH) {
        this.maHDH = maHDH;
    }

    public Hedieuhanh(Integer maHDH, String heDieuHanh) {
        this.maHDH = maHDH;
        this.heDieuHanh = heDieuHanh;
    }

    public Integer getMaHDH() {
        return maHDH;
    }

    public void setMaHDH(Integer maHDH) {
        this.maHDH = maHDH;
    }

    public String getHeDieuHanh() {
        return heDieuHanh;
    }

    public void setHeDieuHanh(String heDieuHanh) {
        this.heDieuHanh = heDieuHanh;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maHDH != null ? maHDH.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hedieuhanh)) {
            return false;
        }
        Hedieuhanh other = (Hedieuhanh) object;
        if ((this.maHDH == null && other.maHDH != null) || (this.maHDH != null && !this.maHDH.equals(other.maHDH))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.entities.Hedieuhanh[ maHDH=" + maHDH + " ]";
    }
    
}
