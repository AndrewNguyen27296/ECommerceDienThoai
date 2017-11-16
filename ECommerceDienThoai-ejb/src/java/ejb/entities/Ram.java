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
@Table(name = "ram")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ram.findAll", query = "SELECT r FROM Ram r"),
    @NamedQuery(name = "Ram.findByMaRam", query = "SELECT r FROM Ram r WHERE r.maRam = :maRam"),
    @NamedQuery(name = "Ram.findByRam", query = "SELECT r FROM Ram r WHERE r.ram = :ram")})
public class Ram implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaRam")
    private Integer maRam;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "Ram")
    private String ram;

    public Ram() {
    }

    public Ram(Integer maRam) {
        this.maRam = maRam;
    }

    public Ram(Integer maRam, String ram) {
        this.maRam = maRam;
        this.ram = ram;
    }

    public Integer getMaRam() {
        return maRam;
    }

    public void setMaRam(Integer maRam) {
        this.maRam = maRam;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maRam != null ? maRam.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ram)) {
            return false;
        }
        Ram other = (Ram) object;
        if ((this.maRam == null && other.maRam != null) || (this.maRam != null && !this.maRam.equals(other.maRam))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.entities.Ram[ maRam=" + maRam + " ]";
    }
    
}
