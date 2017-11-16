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
@Table(name = "quanhuyen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Quanhuyen.findAll", query = "SELECT q FROM Quanhuyen q"),
    @NamedQuery(name = "Quanhuyen.findByMaQuanHuyen", query = "SELECT q FROM Quanhuyen q WHERE q.maQuanHuyen = :maQuanHuyen"),
    @NamedQuery(name = "Quanhuyen.findByTenQuanHuyen", query = "SELECT q FROM Quanhuyen q WHERE q.tenQuanHuyen = :tenQuanHuyen")})
public class Quanhuyen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaQuanHuyen")
    private Integer maQuanHuyen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "TenQuanHuyen")
    private String tenQuanHuyen;

    public Quanhuyen() {
    }

    public Quanhuyen(Integer maQuanHuyen) {
        this.maQuanHuyen = maQuanHuyen;
    }

    public Quanhuyen(Integer maQuanHuyen, String tenQuanHuyen) {
        this.maQuanHuyen = maQuanHuyen;
        this.tenQuanHuyen = tenQuanHuyen;
    }

    public Integer getMaQuanHuyen() {
        return maQuanHuyen;
    }

    public void setMaQuanHuyen(Integer maQuanHuyen) {
        this.maQuanHuyen = maQuanHuyen;
    }

    public String getTenQuanHuyen() {
        return tenQuanHuyen;
    }

    public void setTenQuanHuyen(String tenQuanHuyen) {
        this.tenQuanHuyen = tenQuanHuyen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maQuanHuyen != null ? maQuanHuyen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Quanhuyen)) {
            return false;
        }
        Quanhuyen other = (Quanhuyen) object;
        if ((this.maQuanHuyen == null && other.maQuanHuyen != null) || (this.maQuanHuyen != null && !this.maQuanHuyen.equals(other.maQuanHuyen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.entities.Quanhuyen[ maQuanHuyen=" + maQuanHuyen + " ]";
    }
    
}
