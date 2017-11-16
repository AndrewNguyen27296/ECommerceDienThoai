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
@Table(name = "manhinh")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Manhinh.findAll", query = "SELECT m FROM Manhinh m"),
    @NamedQuery(name = "Manhinh.findByMaManHinh", query = "SELECT m FROM Manhinh m WHERE m.maManHinh = :maManHinh"),
    @NamedQuery(name = "Manhinh.findByTenManHinh", query = "SELECT m FROM Manhinh m WHERE m.tenManHinh = :tenManHinh")})
public class Manhinh implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaManHinh")
    private Integer maManHinh;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "TenManHinh")
    private String tenManHinh;

    public Manhinh() {
    }

    public Manhinh(Integer maManHinh) {
        this.maManHinh = maManHinh;
    }

    public Manhinh(Integer maManHinh, String tenManHinh) {
        this.maManHinh = maManHinh;
        this.tenManHinh = tenManHinh;
    }

    public Integer getMaManHinh() {
        return maManHinh;
    }

    public void setMaManHinh(Integer maManHinh) {
        this.maManHinh = maManHinh;
    }

    public String getTenManHinh() {
        return tenManHinh;
    }

    public void setTenManHinh(String tenManHinh) {
        this.tenManHinh = tenManHinh;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maManHinh != null ? maManHinh.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Manhinh)) {
            return false;
        }
        Manhinh other = (Manhinh) object;
        if ((this.maManHinh == null && other.maManHinh != null) || (this.maManHinh != null && !this.maManHinh.equals(other.maManHinh))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.entities.Manhinh[ maManHinh=" + maManHinh + " ]";
    }
    
}
